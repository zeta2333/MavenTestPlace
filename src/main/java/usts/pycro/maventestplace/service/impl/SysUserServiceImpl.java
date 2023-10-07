package usts.pycro.maventestplace.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.pycro.maventestplace.entity.SysUser;
import usts.pycro.maventestplace.mapper.SysUserMapper;
import usts.pycro.maventestplace.service.SysUserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-07 16:24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

}
