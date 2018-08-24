package com.ipnet.bl.patentpoolbl;

import com.ipnet.vo.PatentPoolVO;
import com.ipnet.vo.PatentVO;
import com.ipnet.blservice.PatentBLService;
import com.ipnet.blservice.PatentPoolBLService;
import com.ipnet.entity.PatentPool;
import com.ipnet.utility.IDNotExistsException;
import com.ipnet.utility.MockProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lzb
 * @date 2018/7/22 23:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatentPoolBLServiceImplTest {

    @Autowired
    private PatentPoolBLService patentPoolBLService;

    @Autowired
    private PatentBLService patentBLService;

    @Autowired
    private MockProducer mockProducer;

    @Test
    public void createPatentPool() {
        PatentPoolVO toBeCreated = this.mockProducer.mockPatentPoolVO();
        PatentPoolVO returnedVO = this.patentPoolBLService.createPatentPool(toBeCreated);
        PatentPoolVO searchVO = this.patentPoolBLService.searchPatentPoolByID(returnedVO.getId());
        assert toBeCreated.equals(returnedVO);
        System.out.println(searchVO);
        System.out.println(returnedVO);

    }

    @Test
    public void searchPatentPoolByID() {
        PatentPoolVO toBeCreated = this.mockProducer.mockPatentPoolVO();
        PatentPoolVO returnedVO = this.patentPoolBLService.createPatentPool(toBeCreated);
        PatentPoolVO searchVO = this.patentPoolBLService.searchPatentPoolByID(returnedVO.getId());
        assert toBeCreated.equals(returnedVO);

    }

    @Test
    public void searchPatentPoolByName() {
        PatentPoolVO toBeCreated = this.mockProducer.mockPatentPoolVO();
        String name = "test name";
        toBeCreated.setName(name);
        PatentPoolVO returnedVO = this.patentPoolBLService.createPatentPool(toBeCreated);

        List<PatentPoolVO> poolVOList = this.patentPoolBLService.searchPatentPoolByName(name);
        assert poolVOList.size()!=0;

    }

    @Test
    public void deletePatentPool() {
        PatentPoolVO toBeCreated = this.mockProducer.mockPatentPoolVO();
        PatentPoolVO returnedVO = this.patentPoolBLService.createPatentPool(toBeCreated);
        PatentPoolVO searchVO = this.patentPoolBLService.searchPatentPoolByID(returnedVO.getId());

        assert searchVO!=null;

        this.patentPoolBLService.deletePatentPool(returnedVO.getId());

        searchVO = this.patentPoolBLService.searchPatentPoolByID(returnedVO.getId());
        assert searchVO==null;



    }

    @Test
    public void addPatentIntoPool() throws IDNotExistsException {

        PatentPoolVO toBeCreated = this.mockProducer.mockPatentPoolVO();
        PatentPoolVO returnedVO = this.patentPoolBLService.createPatentPool(toBeCreated);
        PatentPoolVO searchVO = this.patentPoolBLService.searchPatentPoolByID(returnedVO.getId());
        assert toBeCreated.equals(returnedVO);


        PatentVO patentVO = this.mockProducer.mockPatentVO();
        patentVO = this.patentBLService.createPatent(patentVO);
        Boolean flag = this.patentPoolBLService.addPatentIntoPool(returnedVO.getId() , patentVO.getPatent_id());
        assert  flag ;

    }
}