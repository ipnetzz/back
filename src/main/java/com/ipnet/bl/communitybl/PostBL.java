package com.ipnet.bl.communitybl;

import com.ipnet.blservice.communityservice.PostBLService;
import com.ipnet.dao.communitydao.PostDao;
import com.ipnet.entity.communityentity.Post;
import com.ipnet.entity.communityentity.Remark;
import com.ipnet.enums.ResultMessage;
import com.ipnet.enums.communityenums.Post_state;
import com.ipnet.enums.communityenums.Post_tag;
import com.ipnet.enums.communityenums.Post_type;
import com.ipnet.vo.communityvo.BriefPost;
import com.ipnet.vo.communityvo.PostVO;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostBL implements PostBLService {
    @Autowired
    private PostDao postDao;

    @Override
    public String createID(String author) {
        Post post=new Post(author);
        postDao.save(post);
        return post.getPost_id();
    }

    @Override
    public ResultMessage saveDraft(String post_id,String author, String post_name, Post_type post_type, Post_tag post_tag, String content_url) {
        Post post=new Post(post_id,author,post_name,post_type,post_tag,content_url);
        post.setPost_state(Post_state.Draft);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage publishArticle(String post_id,String author, String post_name, Post_type post_type, Post_tag post_tag, String content_url) {
        Post post=new Post(post_id,author,post_name,post_type,post_tag,content_url);
        post.setPublish_time(new Date());
        post.setVisits(0);
        post.setRemark_num(0);
        post.setRemark_content(new ArrayList<Remark>());
        post.setPost_state(Post_state.Published);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage clickEdit(String post_id) {
        Post post=postDao.getOne(post_id);
        post.setPost_state(Post_state.Draft);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage clickCancel(String post_id) {
        Post post=postDao.getOne(post_id);
        post.setPost_state(Post_state.Published);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage editDraft(String post_id, String post_name, Post_type post_type, Post_tag post_tag, String content_url) {
        Post post=postDao.getOne(post_id);
        post.setPost_name(post_name);
        post.setPost_type(post_type);
        post.setPost_tag(post_tag);
        post.setContent_url(content_url);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage remark(String post_id, String reviewer, String remark_content) {
        Remark remark=new Remark(post_id,reviewer,remark_content);
        Post post=postDao.getOne(post_id);
        post.setRemark_num(post.getRemark_num()+1);
        ArrayList<Remark> remarks=post.getRemark_content();
        remarks.add(remark);
        post.setRemark_content(remarks);
        postDao.save(post);
        return ResultMessage.Success;
    }

    @Override
    public PostVO readArticle(String author, String post_name) {
        return null;
    }

    @Override
    public ArrayList<BriefPost> readArticleList(String author) {
        return null;
    }
}
