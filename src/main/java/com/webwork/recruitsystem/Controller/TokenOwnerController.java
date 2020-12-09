package com.webwork.recruitsystem.Controller;

import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import com.webwork.recruitsystem.Service.TokenOwnerService;
import com.webwork.recruitsystem.Service.TokenReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
* 这边在这里定义对应的一些request + response
* 然后调用service层
* 根据回传的信息来发送对应的resp
* */
@Controller
@RequestMapping("/tokensOwner")
public class TokenOwnerController {
    @Autowired
    TokenOwnerService tokenOwnerService;
    @Autowired
    TokenReqService tokenReqService;

    @RequestMapping("/all")
    @ResponseBody
    public Object QueryTokens(@RequestParam(value = "username",required = false) String username){
        List<Token> tokens=null;
        if(username!=null){
            System.out.println("querytokens: "+username);
            Token token = new Token();
            token.setUsername(username);
            tokens = tokenOwnerService.QueryTokens(token);
        }else {
            tokens=tokenOwnerService.QueryAllTokens();
        }

        System.out.println("");
        Response resp = new Response();
        if (tokens == null){
            resp.code=404;
            resp.message="TokenList are empty";
        }else{
            resp.code=200;
            resp.message="success";
            resp.setData(tokens);
        }
        return resp;
    }

    @RequestMapping("/oneToken")
    @ResponseBody
    public Object QueryOneToken(@RequestParam("token_id") int token_id){
        System.out.println("querytoken: "+token_id);
        Token token = new Token();
        token.setToken_id(token_id);
        Token oneToken = tokenOwnerService.QueryOneToken(token);
        Response resp = new Response();
        if (oneToken == null){
            resp.code=404;
            resp.message="TokenList are empty";
        }else{
            resp.code=200;
            resp.message="success";
            resp.data=oneToken;
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object DeleteToken(@RequestParam("token_id") int token_id){
        System.out.println("delete: "+token_id);
        Token token = new Token();
        token.setToken_id(token_id);
        Token tobeDeleteToken = tokenOwnerService.QueryOneToken(token);
        boolean ok = tokenOwnerService.DeleteToken(token);
        System.out.println(ok);
        Response resp = new Response();
        if(tobeDeleteToken.getCur_recruited_nums()>0){
            resp.code=403;
            resp.message="不可以删除";
            return resp;
        }
        if (!ok){
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
    public Object UpdateToken(@RequestBody Token token){
        System.out.println("update");
        token.setModified_time(new Date());
        int row = tokenOwnerService.UpdateToken(token);
        Response resp = new Response();
        if (row == 1){
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
    public Object CreateToken(@RequestBody Token token){
        System.out.println("create");
        token.setCreated_time(new Date());
        token.setPhoto("123123");
        System.out.println(token.toString());
        boolean ok = tokenOwnerService.CreateToken(token);
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

    @RequestMapping("/processReq")
    @ResponseBody
    public Object GetUnProcessReq(@RequestParam("token_id") int token_id){
        System.out.println("get unprocess request");

        TokenReq tokenReq=new TokenReq();
        tokenReq.setToken_id(token_id);
        List<TokenReq> tokenReqs = tokenReqService.UnPcsReq(tokenReq);

        Response resp = new Response();
        if (tokenReqs == null){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
            resp.setData(tokenReqs);
        }
        return resp;
    }

    @RequestMapping("/discardReq")
    @ResponseBody
    public Object DiscardReq(@RequestBody TokenReq tokenReq){
        System.out.println("discard request"+tokenReq.getReq_id());
        tokenReq.setState("discarded");
        int row = tokenReqService.SetState(tokenReq);

        Response resp = new Response();
        if (row == 0){
            resp.code=500;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }


}

class Response{
    int code;
    String message;
    Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}