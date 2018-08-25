package com.ipnet.dao.communitydao;

import com.ipnet.entity.communityentity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;

@Repository
@Table(name = "post")
public interface PostDao extends JpaRepository<Post,String>{

}
