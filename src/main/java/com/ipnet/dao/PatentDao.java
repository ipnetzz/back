package com.ipnet.dao;

import com.ipnet.entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * @author lzb
 * @date 2018/7/21 10:47
 */
@Repository
@Table(name = "patent")
public interface PatentDao extends JpaRepository<Patent,String>{

}
