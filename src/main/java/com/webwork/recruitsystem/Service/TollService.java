package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Model.Toll;
import com.webwork.recruitsystem.Model.TollByToken;
import com.webwork.recruitsystem.Model.TollByUser;

public interface TollService {
    int insertToll(Toll toll);
    TollByUser[] selectAggregateByUesr();
    TollByToken[] selectAggregateByToken();
}
