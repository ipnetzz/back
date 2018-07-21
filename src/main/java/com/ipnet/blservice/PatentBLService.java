package com.ipnet.blservice;

import com.ipnet.VO.PatentVO;
import com.ipnet.enums.Patent_state;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @author lzb
 * @date 2018/7/21 10:12
 */
public interface PatentBLService {

    Boolean createPatent(PatentVO newPatent);

    PatentVO searchPatentByID(String patentID);

    List<PatentVO> searchPatentByName(String name);

    Boolean deletePatent(String patentID);

    Boolean updatePatentState(Patent_state newState);



}
