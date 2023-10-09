package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.Account;

import java.util.ArrayList;
import java.util.List;

import static usts.pycro.maventestplace.entity.table.AccountTableDef.ACCOUNT;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:38
 */
@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setAccountName("张三");
        account.setAge(6);
        account.setPassword("zhangsan123");
        account.setEmail("zhangsan@lisi");
        System.out.println(account);
        accountMapper.insert(account);
    }

    @Test
    public void testBatchInsert() {
        List<Account> accounts = new ArrayList<>(100000);
        for (int i = 0; i < 1000000; i++) {
            Account account = new Account();
            account.setAccountName(RandomUtil.randomString(5));
            account.setAge(RandomUtil.randomInt(1, 100));
            account.setEmail(account.getAccountName() + "@" + RandomUtil.randomString(3));
            account.setPassword(RandomUtil.randomString(18));
            accounts.add(account);
        }
        // accountMapper.insertBatch(accounts, 1000);
    }

    @Test
    public void testCount() {
        QueryWrapper wrapper = QueryWrapper.create()
                .from(ACCOUNT)
                .where(ACCOUNT.ACCOUNT_NAME.like("a"))
                .limit(10);
        List<Account> accounts = accountMapper.selectListByQuery(wrapper);
        accounts.forEach(System.out::println);
    }
}
