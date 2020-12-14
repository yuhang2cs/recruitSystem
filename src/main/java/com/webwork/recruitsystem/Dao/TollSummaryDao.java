package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.TollSummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface TollSummaryDao {
    int insertSummary(TollSummary tollSummary);
    int modifySummary(TollSummary tollSummary);
    TollSummary[] querySummaryByDate(Date date);
    TollSummary[] querySummaryByRangeDateWithTypeAndAddr(Date end_date,Date start_date,String token_type,String address);
    TollSummary[] querySummaryByAddr(String address);
    TollSummary[] querySummaryByType(String token_type);
    TollSummary querySummaryByDateAndTypeAndAddr(String date,String token_type,String address);
}
