package com.example.springtest.translator;

import com.example.springtest.lexer.LexicalException;
import com.example.springtest.parser.Parser;
import com.example.springtest.parser.util.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticTableTests {


    @Test
    public void staticTest() throws LexicalException, ParseException {
        var source = "if(a) { a = 1 } else { b = a + 1 * 5 }";
        var astNode = Parser.parse(source);
        var translator = new Translator();
        var program =  translator.translate(astNode);

        assertEquals(2, program.getStaticSymbolTable().size());
    }
}
