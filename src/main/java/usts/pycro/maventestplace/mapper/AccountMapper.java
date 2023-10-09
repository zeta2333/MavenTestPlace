package usts.pycro.maventestplace.mapper;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import usts.pycro.maventestplace.entity.Account;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:36
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    int count(@Param("copy") String copy, @Param("id") String id);

    void insertOne(@Param("account") Account account);
}
