package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
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
        QueryWrapper wrapper = QueryWrapper.create()
                .select(ARTICLE.DEFAULT_COLUMNS)
                .select(ACCOUNT.ACCOUNT_NAME, ACCOUNT.AGE, ACCOUNT.EMAIL, ACCOUNT.PASSWORD.as(ArticleDTO::getPasswd))
                .from(ARTICLE)
                .leftJoin(ACCOUNT).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.gt(198));
        List<ArticleDTO> results = mapper.selectListByQueryAs(wrapper, ArticleDTO.class);
        // results.forEach(System.out::println);
        Page<ArticleDTO> resultPage = new Page<>();
        Page<ArticleDTO> articleDTOPage = mapper.paginateAs(resultPage, wrapper, ArticleDTO.class);
        System.out.println(articleDTOPage.getRecords().size());
    }
}
