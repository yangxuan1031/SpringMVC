package com.yao.service;

import com.yao.User.User;
import com.yao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //查找人员记录
    public Boolean hasMatchUser(String username,String pwd){
        int count=userDao.getmatchCount(username,pwd);
        return  count>0;
    }
    //查找密码
public User findbyusername(String username){
        return userDao.finduserbyUserName(username);
}

//修改
    public void loginSuccess(User user) {

        userDao.updateLoginInfo(user);

    }
}
