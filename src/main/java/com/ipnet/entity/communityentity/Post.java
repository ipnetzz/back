package com.ipnet.entity.communityentity;

import com.ipnet.enums.communityenums.Post_state;
import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "post")
@AllArgsConstructor

public class Post {
    @Id
    private String post_id;
    private String author;
    private String post_name;
    private Post_type post_type;
    private Post_tag post_tag;
    private String content_url;
    private Date publish_time;
    private long visits;
    private long remark_num;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Remark> remark_content;
    private Post_state post_state;

    public Post(){}
    public Post(String author){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String currentTime=df.format(new Date());// new Date()为获取当前系统时间
        this.post_id=currentTime+author;
        this.author=author;
        this.post_state=Post_state.Draft;
    }

    public Post(String post_id,String author, String post_name, Post_type post_type, Post_tag post_tag, String content_url){
        this.post_id=post_id;
        this.author=author;
        this.post_name=post_name;
        this.post_type=post_type;
        this.post_tag=post_tag;
        this.content_url=content_url;
    }

}
