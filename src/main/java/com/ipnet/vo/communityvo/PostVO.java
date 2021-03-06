package com.ipnet.vo.communityvo;

import com.ipnet.entity.communityentity.Post;
import com.ipnet.entity.communityentity.Remark;
import com.ipnet.enums.communityenums.Post_tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class PostVO {
    private String post_id;
    private String author;
    private String post_name;
    private Post_tag post_tag;
    private String content_url;
    private Date publish_time;
    private long visits;
    private long remark_num;
    private List<Remark> remark_content;

    public PostVO(){}

    public PostVO(Post post){
        this.post_id=post.getPost_id();
        this.author=post.getAuthor();
        this.post_name=post.getPost_name();
        this.post_tag=post.getPost_tag();
        this.content_url=post.getContent_url();
        this.publish_time=post.getPublish_time();
        this.visits=post.getVisits();
        this.remark_num=post.getRemark_num();
        this.remark_content=post.getRemark_content();
    }



}
