package com.neuqyangze.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java中Pattern.compile函数的用法
 * <p>
 * 除了Pattern Pattern.compile(String regex),
 * Pattern类的compile()方法还有另一个版本：
 * Pattern Pattern.complie(String regex,int flag)，它接受一个标记参数flag，以调整匹配的行为。
 * flag来自以下Pattern类中的常量
 */
public class PatternCompileTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        /*
         * 使用Pattern.CASE_INSENSITIVE（大小写不敏感的匹配）和Pattern.MULTILINE（多行模式）标记，忽略大小写地匹配所有以java开头的行
         */
        Matcher m = p.matcher("java has regex\nJava has regex\n"
                + "JAVA has pretty good regular expression\n"
                + "Regular expressions are in JavA");
        while (m.find()) {
            System.out.println(m.group());//输出已匹配的部分
        }
    }

    private static void test2() {
        /*
         * 不使用Pattern.COMMENTS(不启动注释)
         */
        String s = "123";
        Pattern p1 = Pattern.compile("(\\d+)+#test comments");
        Matcher m1 = p1.matcher(s);
        System.out.println(m1.matches());//false
        /*
         * 正则表达式中使用启动注释的标记
         */
        Pattern p2 = Pattern.compile("(?x) (\\d+)+#test comments");
        Matcher m2 = p2.matcher(s);
        System.out.println(m2.matches());//true
        /*
         * 参数中使用Pattern.COMMENTS以启动注释
         */
        Pattern p3 = Pattern.compile("(\\d+)+#test comments", Pattern.COMMENTS);
        Matcher m3 = p3.matcher(s);
        System.out.println(m3.matches());//true
    }
}
