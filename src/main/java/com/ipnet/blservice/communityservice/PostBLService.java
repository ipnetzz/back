package com.ipnet.blservice.communityservice;

import com.ipnet.enums.ResultMessage;
import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import com.ipnet.vo.communityvo.BriefPost;
import com.ipnet.vo.communityvo.PostVO;

import java.util.ArrayList;


public interface PostBLService {
    String createID(String author);
    ResultMessage saveDraft(String post_id,String author,String post_name, Post_type post_type, Post_tag post_tag,String content_url);
    ResultMessage publishArticle(String post_id,String author,String post_name,Post_type post_type,Post_tag post_tag,String content_url);
    ResultMessage clickEdit(String post_id);
    ResultMessage clickCancel(String post_id);
    ResultMessage editDraft(String post_id,String post_name,Post_type post_type,Post_tag post_tag,String content_url);
    ResultMessage remark(String post_id,String reviewer,String remark_content);
    PostVO readArticle(String author, String post_name);
    ArrayList<BriefPost> readArticleList(String author);
}
