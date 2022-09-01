package com.example.springtest.parser.ast;


import com.example.springtest.lexer.Token;

public class Scalar extends Factor{
    public Scalar(Token token) {
        super(token);
        this.type = ASTNodeTypes.SCALAR;
    }
}
