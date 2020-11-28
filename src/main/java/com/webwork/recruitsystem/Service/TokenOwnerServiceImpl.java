package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.TokenOwnerDao;
import com.webwork.recruitsystem.Model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenOwnerServiceImpl implements TokenOwnerService{
    @Autowired
    TokenOwnerDao tokenOwnerDao;

    @Override
    public boolean CreateToken(Token token) {
        return tokenOwnerDao.CreateToken(token);
    }

    @Override
    public boolean DeleteToken(Token token) {
        return tokenOwnerDao.DeleteToken(token);
    }

    @Override
    public boolean UpdateToken(Token token) {
        return tokenOwnerDao.UpdateToken(token);
    }

    @Override
    public Token QueryOneToken(Token token) {
        return tokenOwnerDao.QueryOneToken(token);
    }

    @Override
    public List<Token> QueryTokens(Token token) {
        return tokenOwnerDao.QueryTokens(token);
    }
}
