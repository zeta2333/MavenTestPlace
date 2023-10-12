package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateChain;
import com.mybatisflex.core.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.Account;
import usts.pycro.maventestplace.service.AccountService;
import usts.pycro.maventestplace.util.RandomEntityGen;
import usts.pycro.maventestplace.vo.AccountVo;

import java.util.List;
import java.util.stream.Collectors;

import static usts.pycro.maventestplace.entity.table.AccountTableDef.ACCOUNT;
import static usts.pycro.maventestplace.entity.table.ArticleTableDef.ARTICLE;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:38
 */
@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountMapper mapper;
    @Autowired
    private AccountService service;

    @Test
    public void testInsert() {
        Account account = UpdateWrapper.of(Account.class).setRaw(ACCOUNT.ACCOUNT_NAME, "now()").toEntity();
        System.out.println(account);
        mapper.insert(account);
    }

    @Test
    public void testBatchInsert() {
        List<Account> accounts = RandomEntityGen.generate(Account.class, 100).stream().peek(account -> {
            account.setId(null);
            account.setAge(RandomUtil.randomInt(10, 120));
        }).collect(Collectors.toList());
        // service.saveBatch(accounts); // for循环一条条插入，不推荐
        mapper.insertBatch(accounts); // 真正的批量插入
    }

    @Test
    public void testCount() {
        int count = mapper.count("copy1", 1L);
    }

    @Test
    public void testSelect() {
        List<Account> accounts = mapper.selectListByQuery(new QueryWrapper().limit(10));
        System.out.println(accounts.size());
    }

    @Test
    public void testDelete() {
        mapper.deleteByCondition(new QueryCondition());
    }

    @Test
    public void testUpdate() {
       /* Account account = UpdateEntity.of(Account.class, 233);
        account.setAccountName(null);
        UpdateWrapper.of(account).set(ACCOUNT_COPY1.AGE,
                select(count(ACCOUNT_COPY1.ID))
                        .from(ACCOUNT_COPY1)
                        .limit(10));
        mapper.update(account);*/
        UpdateChain.of(Account.class)
                .set(ACCOUNT.AGE, null)
                .setRaw(ACCOUNT.AGE, ACCOUNT.AGE.add(1))
                .where(ACCOUNT.ID.eq(200))
                .update();
    }

    @Test
    public void testSelectAccountVo() {
        List<AccountVo> accountVos = QueryChain.of(mapper)
                .select(ACCOUNT.DEFAULT_COLUMNS,ARTICLE.DEFAULT_COLUMNS)
                .from(ACCOUNT).leftJoin(ARTICLE).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.gt(198))
                .listAs(AccountVo.class);
        System.out.println(accountVos.get(0));
    }
}
