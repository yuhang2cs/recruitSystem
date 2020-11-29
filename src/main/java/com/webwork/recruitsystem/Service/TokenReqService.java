package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TokenReqDao;
import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;

import java.util.List;

public interface TokenReqService {
    List<Token> AllToken();
    List<TokenReq> AllTokenReq(TokenReq tokenReq);
    List<TokenReq> UnPcsReq(TokenReq tokenReq);
    boolean CreateTokenReq(TokenReq tokenReq);
    boolean UpdateTokenReq(TokenReq tokenReq);
    boolean DeleteTokenReq(TokenReq tokenReq);
}
