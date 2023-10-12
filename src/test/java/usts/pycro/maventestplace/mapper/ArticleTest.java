package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.mybatisflex.core.query.QueryChain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.dto.ArticleDTO;
import usts.pycro.maventestplace.entity.Account;
import usts.pycro.maventestplace.entity.Article;
import usts.pycro.maventestplace.util.RandomEntityGen;

import java.util.List;
import java.util.stream.Collectors;

import static usts.pycro.maventestplace.entity.table.AccountTableDef.ACCOUNT;
import static usts.pycro.maventestplace.entity.table.ArticleTableDef.ARTICLE;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-11 17:34
 */
@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testInsert() {
        List<Account> accounts = accountMapper.selectAll();
        List<Article> articles = RandomEntityGen.generate(Article.class, 1000)
                .stream()
                .peek(article -> {
                    article.setId(null);
                    article.setAccountId(accounts.get(RandomUtil.randomInt(accounts.size())).getId());
                }).collect(Collectors.toList());
        mapper.insertBatch(articles);
    }

    @Test
    public void testSelectDTO() {
        /*QueryWrapper wrapper = QueryWrapper.create()
                .select(
                        ARTICLE.ID,
                        max(ACCOUNT.AGE).as(ArticleDTO::getMaxAge),
                        min(ACCOUNT.AGE).as(ArticleDTO::getMinAge)
                )
                .select(
                        ACCOUNT.ID
                        // ACCOUNT.ACCOUNT_NAME, ACCOUNT.AGE, ACCOUNT.EMAIL, ACCOUNT.PASSWORD.as(ArticleDTO::getPasswd),
                )
                .from(ACCOUNT)
                .leftJoin(ARTICLE).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.gt(198))
                .groupBy(Account::getId);
        List<ArticleDTO> results = mapper.selectListByQueryAs(wrapper, ArticleDTO.class);
        results.forEach(System.out::println);*/
        // Page<ArticleDTO> articleDTOPage = mapper.paginateAs(new Page<>(1, 10), wrapper, ArticleDTO.class);
        // System.out.println(articleDTOPage.getRecords().get(0));
        List<ArticleDTO> dtos = QueryChain.of(mapper)
                .select(ARTICLE.DEFAULT_COLUMNS, ACCOUNT.DEFAULT_COLUMNS)
                .from(ARTICLE)
                .leftJoin(ACCOUNT).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.gt(198))
                .listAs(ArticleDTO.class);
        System.out.println(dtos.get(0));
    }
}
