package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.Token;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TokenOwnerDao {
    boolean CreateToken(Token token);
    boolean DeleteToken(Token token);
    boolean UpdateToken(Token token);
    //获取所有有关这个Token的waitprocess请求
    Token QueryOneToken(Token token);
    List<Token> QueryTokens (Token token);
}
