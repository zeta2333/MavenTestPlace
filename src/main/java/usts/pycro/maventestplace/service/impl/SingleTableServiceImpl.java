package usts.pycro.maventestplace.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.pycro.maventestplace.entity.SingleTable;
import usts.pycro.maventestplace.mapper.SingleTableMapper;
import usts.pycro.maventestplace.service.SingleTableService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-08 17:53
 */
@Service
public class SingleTableServiceImpl extends ServiceImpl<SingleTableMapper, SingleTable>
        implements SingleTableService {
}
