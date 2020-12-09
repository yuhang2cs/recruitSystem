package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TokenReqDao {
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
