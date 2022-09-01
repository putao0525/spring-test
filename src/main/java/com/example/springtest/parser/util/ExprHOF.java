package com.example.springtest.parser.util;


import com.example.springtest.parser.ast.ASTNode;

// HOF: High order function
@FunctionalInterface
public interface ExprHOF {

    ASTNode hoc() throws ParseException;

}
