package com.ipnet.blservice;

import com.ipnet.VO.PatentPoolVO;
import com.ipnet.VO.PatentVO;
import com.ipnet.enums.Patent_state;

import java.util.List;

/**
 * @author lzb
 * @date 2018/7/21 10:26
 */
public interface PatentPoolBLService {

    Boolean createPatentPool(PatentPoolVO newPatentPool);

    PatentPoolVO searchPatentPoolByID(String patentPoolID);

    List<PatentVO> searchPatentPoolByName(String patentPoolName);

    Boolean deletePatentPool(String patentPoolID);



}
