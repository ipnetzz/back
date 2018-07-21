package com.ipnet.bl.patentpoolbl;

import com.ipnet.VO.PatentPoolVO;
import com.ipnet.VO.PatentVO;
import com.ipnet.blservice.PatentPoolBLService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzb
 * @date 2018/7/21 10:36
 */
@Service
public class PatentPoolBLServiceImpl implements PatentPoolBLService {
    @Override
    public Boolean createPatentPool(PatentPoolVO newPatentPool) {
        return null;
    }

    @Override
    public PatentPoolVO searchPatentPoolByID(String patentPoolID) {
        return null;
    }

    @Override
    public List<PatentVO> searchPatentPoolByName(String patentPoolName) {
        return null;
    }

    @Override
    public Boolean deletePatentPool(String patentPoolID) {
        return null;
    }
}
