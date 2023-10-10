package usts.pycro.maventestplace.util;

import cn.hutool.core.util.RandomUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-10 17:30
 */
public class RandomEntityGen {

    public static void main(String[] args) throws Exception {
        // usts.pycro.maventestplace.entity.T accountCopy1 = generate();
        // System.out.println(accountCopy1);
    }

    public static <T> List<T> generate(Class<T> entityClass, int count) {
        List<T> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T entity = generate(entityClass);
            entities.add(entity);
        }
        return entities;
    }

    // 随机生成单个对象
    public static <T> T generate(Class<T> entityClass) {
        T entity;
        try {
            entity = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Field[] declaredFields = entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Annotation[] annotations = declaredField.getAnnotations();
            // 跳过id的赋值
            boolean isSkip = false;
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().toString().contains("Id")) {
                    isSkip = true;
                }
            }
            if (isSkip) {
                continue;
            }
            Class<?> type = declaredField.getType();
            if (type == Long.class) {
                try {
                    declaredField.set(entity, RandomUtil.randomLong(100));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (type == Integer.class) {
                try {
                    declaredField.set(entity, RandomUtil.randomInt(100));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (type == String.class) {
                try {
                    declaredField.set(entity, RandomUtil.randomString(5));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return entity;
    }
}
