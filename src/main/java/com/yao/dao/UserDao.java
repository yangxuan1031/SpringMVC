package com.yao.dao;

import com.yao.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDao {
    @Autowired
   private JdbcTemplate jdbcTemplate;
    public UserDao(){
        System.out.println("UserDao");
    }
    //查找人员记录
    public int getmatchCount(String username,String pwd){
        String hql="select count(*) from userinfo where username= ? and pwd= ?";
        return jdbcTemplate.queryForObject(hql,new Object[]{username,pwd},Integer.class);
    }
    //查找密码
    public User finduserbyUserName(final String username){
        String hql="select username,pwd from userinfo where username=?";
        final User user=new User();
        jdbcTemplate.query(hql,new Object[]{username},new RowCallbackHandler(){
                public void processRow(ResultSet rs)throws SQLException{
                    user.setUsername(username);
                    user.setPwd(rs.getString("pwd"));

            }

        });
          return user;

    }
    //修改密码
    public void updateLoginInfo(User user){

        String hql="update userinfo set pwd='"+user.getPwd()+"' where username=? ";
        jdbcTemplate.execute(hql);
    }
}
