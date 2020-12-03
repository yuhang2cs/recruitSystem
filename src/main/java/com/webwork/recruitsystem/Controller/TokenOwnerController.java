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
    public Object QueryTokens(@RequestParam("username") String username,
                              HttpServletResponse response){
        System.out.println("querytokens: "+username);
        Token token = new Token();
        token.setUsername(username);
        List<Token> tokens = tokenOwnerService.QueryTokens(token);
        Response resp = new Response();
        response.setHeader("author","track");
        if (tokens == null){
            resp.code=404;
            resp.message="TokenList are empty";
        }else{
            resp.code=200;
            resp.message="success";
            resp.data=tokens;
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
        boolean ok = tokenOwnerService.DeleteToken(token);
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
    public Object UpdateToken(@RequestBody Token token){
        System.out.println("update");
        token.setModified_time(new Date());
        boolean ok = tokenOwnerService.UpdateToken(token);
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
    @RequestMapping("/create")
    @ResponseBody
    public Object CreateToken(@RequestBody Token token){
        System.out.println("create");
        token.setCreated_time(new Date());
        token.setRecruit_end(new Date());
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
        }
        return resp;
    }

    @RequestMapping("/discardReq")
    @ResponseBody
    public Object DiscardReq(@RequestBody TokenReq tokenReq){
        System.out.println("discard request");

        //直接将
        tokenReq.setState("discarded");
        boolean ok = tokenReqService.SetState(tokenReq);

        Response resp = new Response();
        if (ok == false){
            resp.code=500;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/acceptReq")
    @ResponseBody
    public Object AcceptReq(@RequestBody TokenReq tokenReq){
        System.out.println("accept request");
        //获取当前令的召集人数  看是否还有位置
        Response resp = new Response();
        resp.code=500;
        resp.message="fail";
        boolean ok1=false,ok2=false,ok3=false;

        Token queryToken= new Token();
        queryToken.setToken_id(tokenReq.getToken_id());

        // 1 查询当前的token,查看当前的人数和总人数
        Token token = tokenOwnerService.QueryOneToken(queryToken);
        if(token.getCur_recruited_nums()<token.getRecruit_nums())
            ok1=true;
        // 2 设置当场请求状态为accepted
        if(ok1) {
            tokenReq.setState("accepted");
            ok2 = tokenReqService.SetState(tokenReq);
        }
        // 3更新token里面的人数+1
        if(ok1&&ok2){
            token.setCur_recruited_nums(token.getCur_recruited_nums()+1);
            tokenOwnerService.UpdateToken(token);
        }

        if (ok1&&ok2&&ok3){
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