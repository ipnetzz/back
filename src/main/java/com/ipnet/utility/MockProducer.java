package com.ipnet.utility;

import com.ipnet.VO.PatentPoolVO;
import com.ipnet.VO.PatentVO;
import com.ipnet.entity.Patent;
import com.ipnet.entity.PatentPool;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author lzb
 * @date 2018/7/22 23:11
 */
@Service
public class MockProducer {

    public PatentPool mockPatentPool(){
        PatentPool pool = new PatentPool();
        pool.setId(UUID.randomUUID().toString());
        return pool;
    }

    public PatentPoolVO mockPatentPoolVO(){
        PatentPoolVO pool = new PatentPoolVO();
        pool.setId(UUID.randomUUID().toString());
        return pool;
    }

    public PatentVO mockPatentVO(){
        PatentVO patentVO = new PatentVO();
        patentVO.setPatent_id(UUID.randomUUID().toString());
        return patentVO;
    }

}
