package com.example.springtest.parser.util;


import com.example.springtest.common.PeekIterator;
import com.example.springtest.lexer.Token;
import com.example.springtest.lexer.TokenType;

import java.util.stream.Stream;

public class PeekTokenIterator extends PeekIterator<Token> {

    public PeekTokenIterator(Stream<Token> stream) {
        super(stream);
    }

    public Token nextMatch(String value) throws ParseException {
        var token = this.next();
        if(!token.getValue().equals(value)) {
            throw new ParseException(token);
        }
        return token;
    }

    public Token nextMatch(TokenType type) throws ParseException {
        var token = this.next();
        if(!token.getType().equals(type)) {
            throw new ParseException(token);
        }
        return token;
    }
}
