package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.SysUser;
import usts.pycro.maventestplace.service.SysUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-07 15:49
 */
@SpringBootTest
public class SysUserTest {
    @Autowired
    private SysUserService service;

    @Test
    public void testInsert() {
        List<SysUser> users = new ArrayList<>();
        for (int i = 0; i < 10000_0000; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setName(RandomUtil.randomString(8));
            sysUser.setAge(10_0000 - i);
            users.add(sysUser);
        }
        System.out.println(users.size());
        // service.saveBatch(users);
    }

    @Test
    public void testSelect() {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(SysUser::getAge, 18);
        long start = System.currentTimeMillis();
        List<SysUser> list = service.list(wrapper);
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%dms%n", end - start);
        // list.forEach(System.out::println);
    }
}
