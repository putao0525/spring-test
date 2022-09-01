package com.example.springtest.common;

import com.alibaba.fastjson2.JSONPath;
import com.alibaba.fastjson2.JSONReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AlphabetHelperTests {

    private static int num = 1;

    private static void readJSONPathContent(String jsonStr, String jsonPathStr) {
        JSONReader parser = JSONReader.of(jsonStr);
        Object obj = JSONPath.of(jsonPathStr).extract(parser);
        System.out.println(String.format("第%s次,jsonPath: %s, \n结果是:%s\n==================",
                num,jsonPathStr, obj));
        num++;
    }

    @Test
    public void test(){

//        assertEquals(true, AlphabetHelper.isLetter('a'));
//        assertEquals(false, AlphabetHelper.isLetter('*'));
//        assertEquals(true, AlphabetHelper.isLiteral('a'));
//        assertEquals(true, AlphabetHelper.isLiteral('_'));
//        assertEquals(true, AlphabetHelper.isLiteral('9'));
//        assertEquals(false, AlphabetHelper.isLiteral('*'));
//        assertEquals(false, AlphabetHelper.isLetter('*'));
//        assertEquals(true, AlphabetHelper.isNumber('1'));
//        assertEquals(true, AlphabetHelper.isNumber('9'));
//        assertEquals(false, AlphabetHelper.isNumber('x'));
//        assertEquals(true, AlphabetHelper.isOperator('&'));
//        assertEquals(true, AlphabetHelper.isOperator('*'));
//        assertEquals(true, AlphabetHelper.isOperator('+'));
//        assertEquals(true, AlphabetHelper.isOperator('/'));
//        assertEquals(true, AlphabetHelper.isOperator('='));
//        assertEquals(true, AlphabetHelper.isOperator(','));
//        assertEquals(false, AlphabetHelper.isOperator('a'));


        String jsonStr = "{ \"store\": {\n" +
                "    \"book\": [\n" +
                "      { \"category\": \"reference\",\n" +
                "        \"author\": \"雨果\",\n" +
                "        \"title\": \"悲惨世界\",\n" +
                "        \"price\": 8.95\n" +
                "      },\n" +
                "      { \"category\": \"fiction\",\n" +
                "        \"author\": \"海明威\",\n" +
                "        \"title\": \"老人与海\",\n" +
                "        \"price\": 12.99,\n" +
                "        \"isbn\": \"0-553-21311-3\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";

        //输出book[0]的author值
        readJSONPathContent(jsonStr, "$.store.book[0].author");

        //输出全部author的值
        readJSONPathContent(jsonStr, "$.store.book[*].author");

        //输出book[*]中category == 'reference'的book
        readJSONPathContent(jsonStr, "$.store.book[?(@.category == 'reference')]");

        //输出book[*]中category == 'reference' 或者 price >10的book
        readJSONPathContent(jsonStr, "$.store.book[?(@.category == 'reference' || @.price>10)]");

        //输出book[*]中category == 'reference'的book的author
        readJSONPathContent(jsonStr, "$.store.book[?(@.category == 'reference')].author");

        //输出book[*]中price>10的book
        readJSONPathContent(jsonStr, "$.store.book[?(@.price>10)]");

        //输出book[*]中含有isbn元素的book
        readJSONPathContent(jsonStr, "$.store.book[?(@.isbn)]");

        //输出该json中所有price的值
        readJSONPathContent(jsonStr, "$..price");

        //输出该json中所有title的值
        readJSONPathContent(jsonStr, "$..title");

        //输出该json中book 0,1的值
        readJSONPathContent(jsonStr, "$..book[0,1]");

        //输出该json中book 0,1的值
        readJSONPathContent(jsonStr, "$..book[-2:]");

        //可以提前编辑一个路径，并多次使用它
        readJSONPathContent(jsonStr, "$.store.book[*]");
    }
}
