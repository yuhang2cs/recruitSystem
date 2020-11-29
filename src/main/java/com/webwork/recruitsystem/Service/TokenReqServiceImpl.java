package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TokenReqDao;
import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TokenReqServiceImpl implements TokenReqService{
    @Autowired
    TokenReqDao tokenReqDao;


    @Override
    public List<Token> AllToken() {
        return tokenReqDao.AllToken();
    }

    @Override
    public List<TokenReq> AllTokenReq(TokenReq tokenReq) {
        return tokenReqDao.AllTokenReq(tokenReq);
    }

    @Override
    public List<TokenReq> UnPcsReq(TokenReq tokenReq) {
        return tokenReqDao.UnPcsReq(tokenReq);
    }

    @Override
    public boolean CreateTokenReq(TokenReq tokenReq) {
        return tokenReqDao.CreateTokenReq(tokenReq);
    }

    @Override
    public boolean UpdateTokenReq(TokenReq tokenReq) {
        return tokenReqDao.UpdateTokenReq(tokenReq);
    }

    @Override
    public boolean DeleteTokenReq(TokenReq tokenReq) {
        return tokenReqDao.DeleteTokenReq(tokenReq);
    }

    @Override
    public boolean SetState(TokenReq tokenReq) {return tokenReqDao.SetState(tokenReq); }
}
