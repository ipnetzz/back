package com.ipnet.bl.patentbl;

import com.ipnet.VO.PatentVO;
import com.ipnet.blservice.PatentBLService;
import com.ipnet.enums.Patent_state;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzb
 * @date 2018/7/21 10:35
 */
@Service
public class PatentBLServiceImpl implements PatentBLService {
    @Override
    public Boolean createPatent(PatentVO newPatent) {
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
