package usts.pycro.maventestplace.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.SysUser;
import usts.pycro.maventestplace.service.SysUserService;

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
        SysUser sysUser = new SysUser();
        sysUser.setAge(18);
        sysUser.setName("Pycro");
        service.save(sysUser);
    }

    @Test
    public void testSelect() {
        long count = service.count();
        System.out.println(count);
    }
}
