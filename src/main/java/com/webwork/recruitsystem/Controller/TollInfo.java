package com.webwork.recruitsystem.Controller;

import com.webwork.recruitsystem.Dao.TollDao;
import com.webwork.recruitsystem.Model.TollByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/toll")
public class TollInfo {
    @Autowired
    TollDao tollDao;

    @RequestMapping("/byUser")
    @ResponseBody
    public Object selectByUser(){
        return tollDao.selectAggregateByUesr();
    }
    @RequestMapping("/byToken")
    @ResponseBody
    public Object selectByToken(){
        return tollDao.selectAggregateByToken();
    }
}
