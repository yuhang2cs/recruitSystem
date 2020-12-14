package com.webwork.recruitsystem.Controller;


import com.webwork.recruitsystem.Dao.UserDao;
import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import com.webwork.recruitsystem.Model.Toll;
import com.webwork.recruitsystem.Model.User;
import com.webwork.recruitsystem.Service.TokenOwnerService;
import com.webwork.recruitsystem.Service.TokenReqService;
import com.webwork.recruitsystem.Service.TollService;
import com.webwork.recruitsystem.Service.UserService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tokenReq")
public class TokenReqController {
    @Autowired
    TokenReqService tokenReqService;
    @Autowired
    TokenOwnerService tokenOwnerService;
    @Autowired
    TollService tollService;
    @Autowired
    UserService userService;

    @RequestMapping("/allReq")
    @ResponseBody
    public TokenReqResp AllReq(@RequestParam("username")String username,@RequestParam("token_id")int token_id){
        TokenReqResp tokenReqResp=new TokenReqResp();
        List<TokenReq> tokenReqs=tokenReqService.AllTokenReqByOwner(username,token_id);

        if(tokenReqs == null){
            tokenReqResp.message="fail";
        }else{
            tokenReqResp.message="success";
            tokenReqResp.setTokenReqs(tokenReqs);
        }
        return tokenReqResp;
    }

    @RequestMapping("/all")
    @ResponseBody
    public TokenReqResp AllReqNoLimit(){
        TokenReqResp tokenReqResp=new TokenReqResp();
        List<TokenReq> tokenReqs=tokenReqService.AllReqNoLimit();

        if(tokenReqs == null){
            tokenReqResp.message="fail";
        }else{
            tokenReqResp.message="success";
            tokenReqResp.setTokenReqs(tokenReqs);
        }
        return tokenReqResp;
    }

    @RequestMapping("/myAll")
    @ResponseBody
    public Object AllMyTokenReq(@RequestParam("req_username") String req_username){
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
            resp.setData(tokenReqs);
        }
        return resp;
    }

    @RequestMapping("/myWait")
    @ResponseBody
    public Object MyWaitTokenReq(@RequestParam("req_username") String req_username){
        System.out.println("get all token req");

        List<TokenReq> tokenReqs = tokenReqService.MyWairProcReq(req_username);
        //添加一个循环，然后对于每一个请求对应的召集令找出来
        //然后比较时间是否已经过期,用来判断请求是否timeout

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

    @RequestMapping("/myAccept")
    @ResponseBody
    public Object MyAcceptTokenReq(@RequestParam("req_username") String req_username){
        System.out.println("get all token req");

        List<TokenReq> tokenReqs = tokenReqService.MyAcceptedReq(req_username);
        //添加一个循环，然后对于每一个请求对应的召集令找出来
        //然后比较时间是否已经过期,用来判断请求是否timeout

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

    @RequestMapping("/create")
    @ResponseBody
    public Object CreateTokenReq(@RequestBody TokenReq tokenReq){
//        Token token=new Token();
//        token.setToken_id(tokenReq.getToken_id());
//        token=tokenOwnerService.QueryOneToken(token);
//        if(token.getUsername().equals(tokenReq.ge))
        Response resp = new Response();
        if(tokenReq.getowner_username().equals(tokenReq.getReq_username())){
            resp.message="禁止接自己发的令";
            return resp;
        }
        //一个人不能多次接受一个令
        int count=tokenReqService.isExist(tokenReq);
        if(count>0){
            resp.message="你已经接过此令";
            return resp;
        }

        tokenReq.setCreated_time(new Date());
        int row = tokenReqService.CreateTokenReq(tokenReq);
        if(row==0){
            resp.message="接令请求失败";
            return resp;
        }
        resp.code=200;
        resp.message="success";
        return resp;
    }

    @RequestMapping("/accpet")
    @ResponseBody
    public Object AcceptTokenReq(@RequestParam("req_id") int req_id){
        TokenReq tokenReq=new TokenReq();
        tokenReq.setReq_id(req_id);
        //获取要接受的token_id
        tokenReq=tokenReqService.QueryOneReq(req_id);

        //增加该token的人数
        Token token=new Token();
        token.setToken_id(tokenReq.getToken_id());
        token=tokenOwnerService.QueryOneToken(token);
        System.out.println(token);
        token.setCur_recruited_nums(token.getCur_recruited_nums()+1);
        System.out.println(token);
        if(token.getCur_recruited_nums()==token.getRecruit_nums()){
            token.setState("complete");
        }
        int row=tokenOwnerService.TokenCruit(token);
        Response resp = new Response();
        if(row==0){
            resp.code=404;
            resp.message="fail";
            return resp;
        }
        tokenReq.setState("accepted");
        tokenReq.setModified_time(new Date());
        row = tokenReqService.SetState(tokenReq);
        Toll toll=new Toll();
        toll.setDate(new Date());
        //todo 可以根据不同的用户类别设置不同的金额
        User owner=new User();
        owner.setUsername(tokenReq.getowner_username());
        User reqUser=new User();
        reqUser.setUsername(tokenReq.getReq_username());
        owner= userService.selectQuery(owner);
        reqUser=userService.selectQuery(reqUser);
        if(owner.getUser_level()==1){
            toll.setOwner_toll(3);
        }else if(owner.getUser_level()==2){
            toll.setOwner_toll(2);
        }else {
            toll.setOwner_toll(1);
        }
        toll.setReq_toll(1);
        toll.setOwner_username(token.getUsername());
        toll.setReq_username(tokenReq.getReq_username());
        toll.setReq_id(tokenReq.getReq_id());
        System.out.println(toll);
        tollService.insertToll(toll);


        if (row == 0){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/reject")
    @ResponseBody
    public Object RejectTokenReq(@RequestParam("req_id") int req_id){

        TokenReq tokenReq=new TokenReq();
        tokenReq.setReq_id(req_id);
        tokenReq.setState("discarded");
        tokenReq.setModified_time(new Date());
        int row = tokenReqService.SetState(tokenReq);

        Response resp = new Response();
        if (row == 0){
            resp.code=404;
            resp.message="fail";
        }else{
            resp.code=200;
            resp.message="success";
        }
        return resp;
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public Object CancelTokenReq(@RequestParam("req_id") int req_id){

        TokenReq tokenReq=new TokenReq();
        tokenReq.setReq_id(req_id);
        tokenReq.setState("cancel");
        tokenReq.setModified_time(new Date());
        System.out.println(tokenReq);
        int row = tokenReqService.SetState(tokenReq);

        Response resp = new Response();
        if (row == 0){
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

        tokenReq.setModified_time(new Date());
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
    public Object DeleteTokenReq(@RequestParam("req_id") int req_id){
        System.out.println("delete");


        boolean ok = tokenReqService.DeleteTokenReq(req_id);

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

class TokenReqResp{
    String message;
    List<TokenReq> tokenReqs;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TokenReq> getTokenReqs() {
        return tokenReqs;
    }

    public void setTokenReqs(List<TokenReq> tokenReqs) {
        this.tokenReqs = tokenReqs;
    }
}
