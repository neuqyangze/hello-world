package com.neuqyangze.test;

import java.io.UnsupportedEncodingException;

/**
 * 测试java中char的长度
 *
 * 1：“字节”是byte，“位”是bit；
 * 2：1 byte = 8 bit；
 * char 在java中是2个字节。java采用unicode，2个字节（16位）来表示一个字符。
 */
public class CharTest {

    /**
     * java是用unicode来表示字符，"中"这个中文字符的unicode就是2个字节。
     *
     * String.getBytes(encoding)方法是获取指定编码的byte数组表示，
     *
     * 通常gbk/gb2312是2个字节，utf-8是3个字节。
     *
     * 如果不指定encoding则取系统默认的encoding。
     *
     * @param args args
     */
    public static void main(String[] args) {
        String str = "中";
        char x = '中';
        byte[] bytes = null;
        byte[] bytes1 = null;
        try {
            bytes = str.getBytes("utf-8");
            bytes1 = charToByte(x);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("bytes 大小：" + bytes.length);
        System.out.println("bytes1大小：" + bytes1.length);
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
}
