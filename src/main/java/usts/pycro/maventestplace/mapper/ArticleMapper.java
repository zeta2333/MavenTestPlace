package usts.pycro.maventestplace.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import usts.pycro.maventestplace.entity.Article;

/**
 *  映射层。
 *
 * @author Pycro
 * @since 2023-10-11
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
