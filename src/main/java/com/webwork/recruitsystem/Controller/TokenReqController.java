package com.webwork.recruitsystem.Controller;


import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import com.webwork.recruitsystem.Service.TokenReqService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tokenReq")
public class TokenReqController {
    @Autowired
    TokenReqService tokenReqService;

    @RequestMapping("/allToken")
    @ResponseBody
    public Object AllToken(){
        System.out.println("get all current recruit tokens");
        List<Token> Tokens=tokenReqService.AllToken();
        Response resp = new Response();
        if(Tokens == null){
            resp.code=404;
            resp.message="query fail";
        }else{
            resp.code=200;
            resp.message="query success";
            resp.data=Tokens;
        }
        return resp;
    }

    @RequestMapping("/myReq")
    @ResponseBody
    public Object AllTokenReq(@RequestParam("req_username") String req_username){
        System.out.println("get all token req");

        TokenReq tokenReq = new TokenReq();
        tokenReq.setReq_username(req_username);

        List<TokenReq> tokenReqs = tokenReqService.AllTokenReq(tokenReq);

        //添加一个循环，然后对于每一个请求对应的召集令找出来
        //然后比较时间是否已经过期,用来判断请求是否timeout

        Response resp = new Response();
        if (tokenReqs == null){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Object CreateTokenReq(@RequestBody TokenReq tokenReq){
        System.out.println("Create tokenreq");

        boolean ok = tokenReqService.CreateTokenReq(tokenReq);

        Response resp = new Response();
        if (ok == false){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object UpdateTokenReq(@RequestBody TokenReq tokenReq){
        System.out.println("update tokenreq");

        boolean ok = tokenReqService.UpdateTokenReq(tokenReq);

        Response resp = new Response();
        if (ok == false){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object DeleteTokenReq(@RequestBody TokenReq tokenReq){
        System.out.println("delete");

        boolean ok = tokenReqService.DeleteTokenReq(tokenReq);

        Response resp = new Response();
        if (ok == false){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }
}
