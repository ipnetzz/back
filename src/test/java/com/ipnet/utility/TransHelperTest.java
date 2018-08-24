package com.ipnet.utility;

import com.ipnet.VO.PatentVO;
import com.ipnet.entity.Patent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author lzb
 * @date 2018/7/21 11:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransHelperTest {

    @Autowired
    private TransHelper transHelper;

    @Test
    public void transTO() {
        Patent patent = new Patent();
        patent.setPatent_id("hello world");
        PatentVO vo = (PatentVO) this.transHelper.transTO(patent,PatentVO.class);
        System.out.println(vo);
    }
}