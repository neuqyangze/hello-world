package com.neuqyangze.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 为什么foreach中不允许对元素进行add和remove
 */
public class ForeachTest {

    public static void main(String[] args) {

        /*List<Integer> list = new ArrayList<>();
        //把元素放到list里面去
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 5) {
                list.remove(integer);   //注意这个地方
            }
        }*/

        List<Integer> list = new ArrayList<>();
        // 把元素放到list里面去
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.err.println("没有删除元素前" + list.toString());
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 5) {
                iterator.remove();   //注意这个地方
            }
        }
        System.err.println("删除元素后" + list.toString());
    }
}
