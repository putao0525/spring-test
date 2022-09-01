package com.example.springtest.parser.ast;


import com.example.springtest.lexer.Token;

public class Variable extends Factor {

    private Token typeLexeme = null;

    public Variable(Token token) {
        super(token);
        this.type = ASTNodeTypes.VARIABLE;
    }

    public void setTypeLexeme(Token token) {
        this.typeLexeme = token;
    }
    public Token getTypeLexeme(){
        return this.typeLexeme;
    }
}
