package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TokenReqDao {
    List<Token> AllToken();
    List<TokenReq> AllTokenReq(TokenReq tokenReq);
    List<TokenReq> UnPcsReq(TokenReq tokenReq);
    boolean CreateTokenReq(TokenReq tokenReq);
    boolean UpdateTokenReq(TokenReq tokenReq);
    boolean DeleteTokenReq(TokenReq tokenReq);
}
