package usts.pycro.maventestplace.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import usts.pycro.maventestplace.entity.Account;
import usts.pycro.maventestplace.mapper.AccountMapper;
import usts.pycro.maventestplace.service.AccountService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author Pycro
 * @since 2023-10-11
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
