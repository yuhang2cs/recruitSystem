package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TokenReqDao;
import com.webwork.recruitsystem.Model.TokenReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TokenReqServiceImpl implements TokenReqService{
    @Autowired
    TokenReqDao tokenReqDao;



    @Override
    public List<TokenReq> AllTokenReq(TokenReq tokenReq) {
        return tokenReqDao.AllTokenReq(tokenReq);
    }

    @Override
    public int isExist(TokenReq tokenReq) {
        return tokenReqDao.isExist(tokenReq);
    }

    @Override
    public List<TokenReq> AllTokenReqByOwner(String owner_username,int token_id) {
        return tokenReqDao.AllTokenReqByOwner(owner_username,token_id);
    }

    @Override
    public List<TokenReq> AllReqNoLimit() {
        return tokenReqDao.AllReqNoLimit();
    }

    @Override
    public List<TokenReq> UnPcsReq(TokenReq tokenReq) {
        return tokenReqDao.UnPcsReq(tokenReq);
    }

    @Override
    public int CreateTokenReq(TokenReq tokenReq) {
        return tokenReqDao.CreateTokenReq(tokenReq);
    }

    @Override
    public List<TokenReq> MyWairProcReq(String req_username) {
        return tokenReqDao.MyWairProcReq(req_username);
    }

    @Override
    public List<TokenReq> MyAcceptedReq(String req_username) {
        return tokenReqDao.MyAcceptedReq(req_username);
    }

    @Override
    public TokenReq QueryOneReq(int req_id) {
        return tokenReqDao.QueryOneReq(req_id);
    }

    @Override
    public boolean UpdateTokenReq(TokenReq tokenReq) {
        return tokenReqDao.UpdateTokenReq(tokenReq);
    }

    @Override
    public boolean DeleteTokenReq(int req_id) {
        return tokenReqDao.DeleteTokenReq(req_id);
    }

    @Override
    public int SetState(TokenReq tokenReq) {return tokenReqDao.SetState(tokenReq); }
}
