package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.*;
import com.webwork.recruitsystem.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TollServiceImpl implements TollService {
    @Autowired
    TollDao tollDao;

    @Autowired
    TollSummaryDao tollSummaryDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TokenOwnerDao tokenOwnerDao;

    @Autowired
    TokenReqDao tokenReqDao;


    @Override
    public int insertToll(Toll toll) {
        //获取address
        User owner=new User();
        owner.setUsername(toll.getOwner_username());
        owner=userDao.selectQuery(owner);
        String address=owner.getAddress();
        //获取token type
        TokenReq tokenReq=tokenReqDao.QueryOneReq(toll.getReq_id());
        Token token=new Token();
        token.setToken_id(tokenReq.getToken_id());
        token=tokenOwnerDao.QueryOneToken(token);
        String token_type=token.getToken_type();
        //查找是否已经存在TollSummary

        //insert toll的时候还需要修改统计信息
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        TollSummary tollSummaries=tollSummaryDao.querySummaryByDateAndTypeAndAddr(sdf.format(toll.getDate()),token_type,address);
        if(tollSummaries==null){
            TollSummary tollSummary=new TollSummary();
            tollSummary.setDate(toll.getDate());
            tollSummary.setFinish_num(1);
            tollSummary.setToken_type(token_type);
            tollSummary.setAddress(address);
            tollSummary.setTotal(toll.getOwner_toll()+toll.getReq_toll());
            tollSummaryDao.insertSummary(tollSummary);
        }
        else{
            tollSummaries.setFinish_num(tollSummaries.getFinish_num()+1);
            tollSummaries.setTotal(tollSummaries.getTotal()+toll.getOwner_toll()+toll.getReq_toll());

            tollSummaryDao.modifySummary(tollSummaries);
        }
        return tollDao.insertToll(toll);
    }

    @Override
    public TollByUser[] selectAggregateByUesr() {
        return tollDao.selectAggregateByUesr();
    }

    @Override
    public TollByToken[] selectAggregateByToken() {
        return tollDao.selectAggregateByToken();
    }
}
