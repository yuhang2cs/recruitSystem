package com.webwork.recruitsystem.Service;
import com.webwork.recruitsystem.Model.Token;
import java.util.List;

public interface TokenOwnerService {
    public boolean CreateToken(Token token);
    public boolean DeleteToken(Token token);
    public int UpdateToken(Token token);
    int TokenCruit(Token token);
    public Token QueryOneToken(Token token);
    public List<Token> QueryTokens (Token token);
    public List<Token> QueryAllTokens ();
}
