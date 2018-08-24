package com.ipnet.bl.patentbl;

import com.ipnet.vo.PatentVO;
import com.ipnet.blservice.PatentBLService;
import com.ipnet.enums.Patent_state;
import com.ipnet.utility.IDNotExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author lzb
 * @date 2018/7/22 21:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatentBLServiceImplTest {

    @Autowired
    private PatentBLService patentBLService;

    @Test
    public void createPatent() {
        PatentVO patentVO = new PatentVO();
        patentVO.setPatent_id(UUID.randomUUID().toString());
        PatentVO resultVO = this.patentBLService.createPatent(patentVO);
        PatentVO answerVO = this.patentBLService.searchPatentByID(patentVO.getPatent_id());
        System.out.println(answerVO);
        assert resultVO.equals(answerVO);
    }

    @Test
    public void searchPatentByID() {
        PatentVO vo = new PatentVO();
        String id = UUID.randomUUID().toString();
        vo.setPatent_id(id);
        this.patentBLService.createPatent(vo);

        PatentVO patentVO = this.patentBLService.searchPatentByID(id);
        System.out.println(patentVO);
        assert patentVO!=null;
    }

    @Test
    public void searchPatentByName() {
        PatentVO testNameVO = new PatentVO();
        testNameVO.setPatent_id(UUID.randomUUID().toString());
        testNameVO.setPatent_name("test name");
        this.patentBLService.createPatent(testNameVO);
        String name = "test name";
        List<PatentVO> voList = this.patentBLService.searchPatentByName(name);
        System.out.println(voList);
    }

    @Test
    public void deletePatent() {
        PatentVO toBeDelete = new PatentVO();
        String id = UUID.randomUUID().toString();
        toBeDelete.setPatent_id(id);
        this.patentBLService.createPatent(toBeDelete);


        PatentVO testIFExists = this.patentBLService.searchPatentByID(id);
        assert testIFExists!=null;

        this.patentBLService.deletePatent(id);
        PatentVO testIFSuccessful = this.patentBLService.searchPatentByID(id);
        assert testIFSuccessful== null;

    }

    @Test
    public void updatePatentState() throws IDNotExistsException {

        PatentVO vo  = new PatentVO();
        String id = UUID.randomUUID().toString();
        vo.setPatent_id(id);
        this.patentBLService.createPatent(vo);
        Patent_state state = Patent_state.to_be_check;

        this.patentBLService.updatePatentState(state , id);

    }
}