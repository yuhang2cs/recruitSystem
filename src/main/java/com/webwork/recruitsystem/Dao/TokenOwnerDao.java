package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.Token;
import com.webwork.recruitsystem.Model.TokenReq;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TokenOwnerDao {
    boolean CreateToken(Token token);
    boolean DeleteToken(Token token);
    int UpdateToken(Token token);
    int TokenCruit(Token token);
    Token QueryOneToken(Token token);
    List<Token> QueryTokens (Token token);
    List<Token> QueryAllTokens ();
}
