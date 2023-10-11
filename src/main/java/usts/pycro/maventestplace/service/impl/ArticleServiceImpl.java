package usts.pycro.maventestplace.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import usts.pycro.maventestplace.entity.Article;
import usts.pycro.maventestplace.mapper.ArticleMapper;
import usts.pycro.maventestplace.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author Pycro
 * @since 2023-10-11
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
