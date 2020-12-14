package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Model.TollSummary;

import java.util.Date;

public interface TollSummaryService {
    TollSummary[] querySummaryByRangeDateWithTypeAndAddr(Date end_date, Date start_date, String token_type, String address);
}
