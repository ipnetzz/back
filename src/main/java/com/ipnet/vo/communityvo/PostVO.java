package com.ipnet.vo.communityvo;

import com.ipnet.entity.communityentity.Post;
import com.ipnet.entity.communityentity.Remark;
import com.ipnet.enums.communityenums.Post_state;
import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class PostVO {
    private String post_id;
    private String author;
    private String post_name;
    private Post_type post_type;
    private Post_tag post_tag;
    private String content_url;
    private Date publish_time;
    private long visits;
    private long remark_num;
    private List<Remark> remark_content;
    private Post_state post_state;

    public PostVO(){}

    public PostVO(Post post){
        this.post_id=post.getPost_id();
        this.author=post.getAuthor();
        this.post_name=post.getPost_name();
        this.post_type=post.getPost_type();
        this.post_tag=post.getPost_tag();
        this.content_url=post.getContent_url();
        this.publish_time=post.getPublish_time();
        this.visits=post.getVisits();
        this.remark_num=post.getRemark_num();
        this.remark_content=post.getRemark_content();
        this.post_state=post.getPost_state();
    }



}
