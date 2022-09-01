package com.example.springtest.parser.ast;


import com.example.springtest.lexer.Token;
import com.example.springtest.lexer.TokenType;
import com.example.springtest.parser.util.PeekTokenIterator;

public class Factor extends ASTNode {
    public Factor(Token token) {
        super();
        this.lexeme = token;
        this.label = token.getValue();
    }

    public static ASTNode parse(PeekTokenIterator it) {
        var token = it.peek();
        var type = token.getType();

        if(type == TokenType.VARIABLE) {
            it.next();
            return new Variable(token);
        } else if(token.isScalar()){
            it.next();
            return new Scalar(token);
        }
        return null;
    }
}
