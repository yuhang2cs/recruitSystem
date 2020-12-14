package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.Toll;
import com.webwork.recruitsystem.Model.TollByToken;
import com.webwork.recruitsystem.Model.TollByUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TollDao {
    int insertToll(Toll toll);
    TollByUser[] selectAggregateByUesr();
    TollByToken[] selectAggregateByToken();
}
