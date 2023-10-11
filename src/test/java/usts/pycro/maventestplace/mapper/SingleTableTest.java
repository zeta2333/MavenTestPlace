package usts.pycro.maventestplace.mapper;

import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.entity.SingleTable;
import usts.pycro.maventestplace.service.SingleTableService;
import usts.pycro.maventestplace.util.RandomEntityGen;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-25 14:15
 */
@SpringBootTest
public class SingleTableTest {
    @Autowired
    private SingleTableService service;
    @Autowired
    private SingleTableMapper mapper;

    @Test
    public void testInsert() {
        // for (int i = 0; i < 10000; i++) {
        //     SingleTable singleTable = new SingleTable();
        //     singleTable.setKey1(RandomUtil.randomString(1));
        //     singleTable.setKey2(i + 12345);
        //     singleTable.setKey3(RandomUtil.randomString(3));
        //     singleTable.setKeyPart1(RandomUtil.randomString(7));
        //     singleTable.setKeyPart2(RandomUtil.randomString(8));
        //     singleTable.setKeyPart3(RandomUtil.randomString(9));
        //     singleTable.setCommonFiled("常规字段" + (i + 1));
        //     service.save(singleTable);
        // }

        List<SingleTable> singleTables = RandomEntityGen.generate(SingleTable.class, 10000)
                .stream()
                .peek(singleTable -> {
                    singleTable.setId(null);
                    // singleTable.setKey2(null);
                })
                .collect(Collectors.toList());
        mapper.insertBatch(singleTables);
    }

    @Test
    public void testSelect() {
        QueryWrapper wrapper = QueryWrapper.create()
                .limit(20);
        List<SingleTable> singleTables = service.list(wrapper);
        singleTables.forEach(System.out::println);
    }
}
