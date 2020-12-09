package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TokenReqDao;
import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;

import java.util.List;

public interface TokenReqService {
    List<TokenReq> AllTokenReq(TokenReq tokenReq);
    List<TokenReq> AllTokenReqByOwner(String owner_username,int token_id);
    List<TokenReq> MyWairProcReq(String req_username);
    List<TokenReq> MyAcceptedReq(String req_username);
    List<TokenReq> UnPcsReq(TokenReq tokenReq);
    TokenReq QueryOneReq(int req_id);
    int isExist(TokenReq tokenReq);
    int CreateTokenReq(TokenReq tokenReq);
    boolean UpdateTokenReq(TokenReq tokenReq);
    boolean DeleteTokenReq(int req_id);
    int SetState(TokenReq tokenReq);
}
