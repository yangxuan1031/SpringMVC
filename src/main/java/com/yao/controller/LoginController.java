package com.yao.controller;

import com.sun.deploy.net.HttpResponse;
import com.yao.User.User;
import com.yao.service.UserService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private HttpSession session;
    @RequestMapping(value = "/index")
    public String Loginin(Model model,HttpServletRequest request){
      String error=request.getParameter("error");
if(error !=null){
   model.addAttribute("error","账号或密码错误");
}
return "login";
    }
    @RequestMapping(value = "/loginCheck")
    public String SubmitLogin(Model model,User user,HttpServletRequest request) {
       // boolean isUser = userService.hasMatchUser(user.getusername, user.getpwd);
        String name = request.getParameter("username");
        /*String pwd = request.getParameter("pwd");
        boolean isUser = userService.hasMatchUser(name, Integer.parseInt(pwd));*/
        String pwd = request.getParameter("pwd");
        boolean isUser = userService.hasMatchUser(name, pwd);
        System.out.println(name);
        if (isUser) {
           // request.getSession().setAttribute("User", user);
            return "main";
        } else if (name==""||pwd=="") {

            model.addAttribute("error","请输入账号或密码");
            return "login";
        } else {
            model.addAttribute("error","账号或密码错误");
            return "login";       //如果验证不成功则继续返回登录界面
        }
    }
  /*  @RequestMapping(value = "/Update")
    public User findPwd(String username,HttpServletRequest request) {
        username = request.getParameter("username");
        User user = new User();
        user = userService.findbyusername(username);
        return user;
    }
*/
  @RequestMapping(value = "/Up")
  public String Updatepwd(User user, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
      String name1 = request.getParameter("username");
      String pwd1 = request.getParameter("pwd");
      boolean isUser = userService.hasMatchUser(name1, pwd1);
      if(isUser) {

     /*  String name=user.getUsername();
         String  pwd = request.getParameter("pwd");
          userService.loginSuccess("username", "pwd");
*/return "Update";
      }
      else if (name1==""||pwd1=="") {

          model.addAttribute("error","请输入账号或密码");
          return "login";
      } else {
          model.addAttribute("error","账号或密码错误");
          return "login";
      }
  }
    @RequestMapping(params="method=add",method= RequestMethod.POST)
    public String editUser(User user){
userService.loginSuccess(user);
return "login";

    }


    }








