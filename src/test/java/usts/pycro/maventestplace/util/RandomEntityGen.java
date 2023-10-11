package usts.pycro.maventestplace.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.util.RandomUtil;

import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
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
            Field[] declaredFields = entityClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                /*Annotation[] annotations = declaredField.getAnnotations();
                // 跳过id的赋值
                boolean isSkip = false;
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().toString().contains("Id")) {
                        isSkip = true;
                        break;
                    }
                }
                if (isSkip) {
                    continue;
                }*/
                // 根据字段类型赋随机值
                Class<?> type = declaredField.getType();
                if (type == String.class) {
                    declaredField.set(entity, RandomUtil.randomString(5));
                } else if (type == Double.class || type == double.class) {
                    declaredField.set(entity, RandomUtil.randomDouble(1.0, 100.0, 2, RoundingMode.HALF_EVEN));
                } else if (type == Long.class || type == long.class) {
                    declaredField.set(entity, RandomUtil.randomLong(Long.MIN_VALUE, Long.MAX_VALUE));
                } else if (type == Integer.class || type == int.class) {
                    declaredField.set(entity, RandomUtil.randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
                } else if (type == Date.class) {
                    declaredField.set(entity, RandomUtil.randomDate(new Date(), DateField.MILLISECOND, Integer.MIN_VALUE, Integer.MAX_VALUE));
                } else {
                    declaredField.set(entity, generate(type));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entity;
    }
}
