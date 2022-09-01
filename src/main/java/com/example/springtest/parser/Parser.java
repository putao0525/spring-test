package com.example.springtest.parser;

import com.example.springtest.common.PeekIterator;
import com.example.springtest.lexer.Lexer;
import com.example.springtest.lexer.LexicalException;
import com.example.springtest.parser.ast.ASTNode;
import com.example.springtest.parser.ast.Program;
import com.example.springtest.parser.util.ParseException;
import com.example.springtest.parser.util.PeekTokenIterator;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Parser {

    public static ASTNode parse(String source) throws LexicalException, ParseException {
        var lexer = new Lexer();
        var tokens = lexer.analyse(new PeekIterator<>(source.chars().mapToObj(x ->(char)x), '\0'));
        return Program.parse(new PeekTokenIterator(tokens.stream()));
    }

    public static ASTNode fromFile(String file) throws FileNotFoundException, UnsupportedEncodingException, LexicalException, ParseException {
        var tokens = Lexer.fromFile(file);
        return Program.parse(new PeekTokenIterator(tokens.stream()));
    }
}
