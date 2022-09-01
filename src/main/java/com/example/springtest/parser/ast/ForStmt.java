package com.example.springtest.parser.ast;

public class ForStmt extends Stmt {
    public ForStmt() {
        super(ASTNodeTypes.FOR_STMT, "for");
    }
}
