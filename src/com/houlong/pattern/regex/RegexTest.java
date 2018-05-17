package com.houlong.pattern.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习
 */
public class RegexTest {

    public static void main(String[] args) {
        String regex = "[\\w\\-()\\u4e00-\\u9fa5]+";
        String e = "[\\w\\-]+";
        String input = "_d(-周一上班1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        System.out.println("是否匹配：" + matcher.matches());
    }
}
