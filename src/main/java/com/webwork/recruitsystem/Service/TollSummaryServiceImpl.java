package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TollSummaryDao;
import com.webwork.recruitsystem.Model.TollSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TollSummaryServiceImpl implements TollSummaryService {
    @Autowired
    TollSummaryDao tollSummaryDao;
    @Override
    public TollSummary[] querySummaryByRangeDateWithTypeAndAddr(Date end_date, Date start_date, String token_type, String address) {
        return tollSummaryDao.querySummaryByRangeDateWithTypeAndAddr(end_date,start_date,token_type,address);
    }
}
