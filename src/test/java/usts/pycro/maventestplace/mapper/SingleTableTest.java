package usts.pycro.maventestplace.mapper;

import cn.hutool.core.util.RandomUtil;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.pycro.maventestplace.model.SingleTable;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-25 14:15
 */
@SpringBootTest
public class SingleTableTest {
    @Autowired
    private SingleTableMapper mapper;

    @Test
    public void testInsert() {
        for (int i = 0; i < 10000; i++) {
            SingleTable singleTable = new SingleTable();
            singleTable.setKey1(RandomUtil.randomString(5));
            singleTable.setKey2(i + 23306);
            singleTable.setKey3(RandomUtil.randomString(6));
            singleTable.setKeyPart1(RandomUtil.randomString(4));
            singleTable.setKeyPart2(RandomUtil.randomString(5));
            singleTable.setKeyPart3(RandomUtil.randomString(6));
            singleTable.setCommonFiled("常规字段" + (i + 1));
            mapper.insertSelective(singleTable);
        }
    }

    @Test
    public void testSelect() {
        QueryWrapper wrapper = QueryWrapper.create()
                .limit(20);
        List<SingleTable> singleTables = mapper.selectListByQuery(wrapper);
        singleTables.forEach(System.out::println);
    }
}
