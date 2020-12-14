package com.webwork.recruitsystem.Controller;

import com.webwork.recruitsystem.Model.Toll;
import com.webwork.recruitsystem.Model.TollSummary;
import com.webwork.recruitsystem.Service.TollSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/tollsummary")
public class TollSummaryController {
    @Autowired
    private TollSummaryService tollSummaryService;

    @RequestMapping("/rangedate")
    @ResponseBody
    public Object rangeDate(@RequestBody TollSummaryReq tollSummaryReq){
        TollSummaryResp tollSummaryResp=new TollSummaryResp();
        HashMap<String,HashMap<String,TollSummary>> result=new HashMap<>();
        String[] types={"tech","academic","social","volunteer","play"};
        for(String s:types){
            TollSummary[] temp=tollSummaryService.querySummaryByRangeDateWithTypeAndAddr(tollSummaryReq.end_date, tollSummaryReq.start_date,s, tollSummaryReq.address);
            result.put(s,typeCover(temp));
        }
        tollSummaryResp.tollSummaries=result;
        tollSummaryResp.message="success";
//        if(!result.isEmpty()){
//            tollSummaryResp.tollSummaries=result;
//            tollSummaryResp.message="success";
//        }else{
//            tollSummaryResp.message="fail";
//        }
        return tollSummaryResp;
    }
    private HashMap<String, TollSummary> typeCover(TollSummary[] tollSummaries){
        HashMap<String, TollSummary> res=new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        for(TollSummary t:tollSummaries){
            res.put(sdf.format(t.getDate()),t);
        }
        return res;
    }
}
class TollSummaryReq{
    Date end_date;
    Date start_date;
    String token_type;
    String address;

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
class TollSummaryResp{
    public HashMap<String, HashMap<String, TollSummary>> getTollSummaries() {
        return tollSummaries;
    }

    public void setTollSummaries(HashMap<String, HashMap<String, TollSummary>> tollSummaries) {
        this.tollSummaries = tollSummaries;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    HashMap<String,HashMap<String,TollSummary>>  tollSummaries;
    String message;
}
