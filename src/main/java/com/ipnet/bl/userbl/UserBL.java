package com.ipnet.bl.userbl;

import com.ipnet.blservice.UserBLService;
import com.ipnet.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:zhangping
 * @Description:
 * @CreateData: 2018/7/21 10:37
 */
public class UserBL implements UserBLService{

    @Autowired
    private UserDao userDao;

    public boolean register(){
        return userDao.equals("");
    }
}
