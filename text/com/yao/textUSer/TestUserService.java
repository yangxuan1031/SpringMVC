package com.yao.textUSer;

import com.yao.User.User;
import com.yao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestUserService {
    @Autowired
    private UserService userService;
    @Test
    public void hasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        //boolean b2=userService.hasMatchUser("admin",1111);
       assertTrue(b1);
      // assertTrue(b2);
    }
    @Test
    public void testfindbyuserName(){
User user=userService.findbyusername("admin");
assertEquals(user.getUsername(),"admin");
String a =user.getPwd();
System.out.println(a);
    }

}
