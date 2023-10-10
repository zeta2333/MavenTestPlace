package usts.pycro.maventestplace.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.AccountCopy1;
import usts.pycro.maventestplace.service.AccountCopy1Service;
import usts.pycro.maventestplace.util.RandomEntityGen;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-10 16:42
 */
@SpringBootTest
public class AccountCopy1Test {
    @Autowired
    private AccountCopy1Service service;
    @Autowired
    private AccountCopy1Mapper mapper;


    @Test
    public void testPrintInfo() {
        System.out.println(mapper.getClass());
    }

    @Test
    public void testInsert() {
        AccountCopy1 kight = AccountCopy1.builder()
                .accountName("Kight")
                .age(18)
                .email("kight@123.com")
                .password("123456")
                .build();
        service.save(kight);
    }

    @Test
    public void testGenerate() {
        List<AccountCopy1> accountCopy1s = RandomEntityGen.generate(AccountCopy1.class, 10000);
        service.saveBatch(accountCopy1s);


    }
}
