package com.ipnet.entity.communityentity;

import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Post {
    private String post_id;
    private String post_name;
    private Post_type post_type;
    private Post_tag post_tag;
    private String content_url;
    private Date publish_time;

}
