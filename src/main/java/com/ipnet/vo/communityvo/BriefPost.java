package com.ipnet.vo.communityvo;

import com.ipnet.entity.communityentity.Remark;
import com.ipnet.enums.communityenums.Post_state;
import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefPost {
    private String post_id;
    private String author;
    private String post_name;
    private Post_type post_type;
    private Post_tag post_tag;
    private String content_url;
    private Date publish_time;
    private long visits;
    private long remark_num;
}
