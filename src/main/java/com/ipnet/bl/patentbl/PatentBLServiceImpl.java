package com.ipnet.bl.patentbl;

import com.ipnet.VO.PatentVO;
import com.ipnet.blservice.PatentBLService;
import com.ipnet.dao.PatentDao;
import com.ipnet.dao.UserDao;
import com.ipnet.entity.Patent;
import com.ipnet.enums.Patent_state;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lzb
 * @date 2018/7/21 10:35
 */
@Service
public class PatentBLServiceImpl implements PatentBLService {

    @Autowired
    private PatentDao patentDao;


    @Override
    public Boolean createPatent(PatentVO newPatent) {
        Patent patent = null;
        Patent realPatent = this.patentDao.saveAndFlush(patent);
        return null;
    }

    @Override
    public PatentVO searchPatentByID(String patentID) {
        return null;
    }

    @Override
    public List<PatentVO> searchPatentByName(String name) {
        return null;
    }

    @Override
    public Boolean deletePatent(String patentID) {
        return null;
    }

    @Override
    public Boolean updatePatentState(Patent_state newState) {
        return null;
    }
}
