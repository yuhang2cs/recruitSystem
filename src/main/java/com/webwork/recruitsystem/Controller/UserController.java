package com.webwork.recruitsystem.Controller;


import com.webwork.recruitsystem.Config.Audience;
import com.webwork.recruitsystem.Model.User;
import com.webwork.recruitsystem.Service.UserService;
import com.webwork.recruitsystem.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    Audience audience;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,HttpServletResponse response){
        LoginResp resp= new LoginResp();
        User users = userService.loginQuery(new User(username,password));
        if(users != null) {
            //todo 换成log
            System.out.println(users);

            //设置为已经登录
            session.setAttribute("loginUser",username);
            resp.token= TokenUtils.createJWT(Integer.toString(users.getUser_id()),username,audience);
            session.setAttribute("token","test");
            System.out.println(session.getId());
            resp.isSuccess="success";
            resp.kind=users.getUser_type();
        }else{
            resp.isSuccess="fail";
        }
        return resp;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(@RequestBody String token, HttpSession session, HttpServletRequest request){
//        String userToken= (String) session.getAttribute("token");
        System.out.println(session.getId());
//        System.out.println(userToken);
        System.out.println(token);
//        if(token.equals(userToken)){
//            session.removeAttribute("loginUser");
//            return "success";
//        }
        return "fail";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Object allQuery() {
        allResp resp=new allResp();
        resp.isSuccess="success";
        resp.user=userService.allQuery();
        return resp;
    }

//    @RequestMapping("/register")
//    @ResponseBody
//    public Object insertQuery(@RequestParam("user") User user, @RequestParam("file") MultipartFile multipartFile) {
//        user.setRegister_time(new Date());
//        System.out.println(user);
//        int count = userService.insertQuery(user);
//        if(count == 1) {
//            return "success";
//        }else {
//            return "fail";
//        }
//
//    }

    @RequestMapping("/register")
    @ResponseBody
    public Object insertQuery(@RequestBody User user) {
        System.out.println("register!!!");
        user.setRegister_time(new Date());
        System.out.println(user);
        int count = userService.insertQuery(user);
        if(count == 1) {
            return "success";
        }else {
            return "fail";
        }

    }
    @RequestMapping("/modify")
    @ResponseBody
    public Object updateQuery(@RequestBody updateReq req) {
        User user=req.user;
        user.setModify_time(new Date());
        System.out.println(user);
        int count = userService.updateQuery(user);
        if(count == 1) {
            return "success";
        }else {
            return "fail";
        }

    }
    @RequestMapping("/info")
    @ResponseBody
    public Object userInfo(@RequestParam String username){
        selectResp resp= new selectResp();
        User users = userService.selectQuery(new User(username,null));
        if(users != null) {
            //todo 换成log
            System.out.println(users);
            resp.isSuccess="success";
            resp.user=users;
        }else{
            resp.isSuccess="fail";
        }
        return resp;
    }
}

class updateReq{
    User user;
    String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

class allResp{
    String isSuccess;
    User[] user;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public User[] getUser() {
        return user;
    }

    public void setUser(User[] user) {
        this.user = user;
    }
}

class selectResp{
    String isSuccess;
    User user;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class LoginResp{
    String isSuccess;
    int kind;
    String token;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResp() {
        this.isSuccess = "fail";
    }
}

