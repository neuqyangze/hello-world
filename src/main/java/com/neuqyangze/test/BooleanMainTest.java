package com.neuqyangze.test;

import java.util.StringJoiner;

/**
 * 测试 POJO 类中属性定义用包装数据类型和基本数据类型
 */
public class BooleanMainTest {

    public static void main(String[] args) {
        Model model1 = new Model();
        System.out.println("default model : " + model1);
    }
}

class Model {

    /**
     * 定一个Boolean类型的success成员变量
     */
    private Boolean success;
    /**
     * 定一个boolean类型的failure成员变量
     */
    private boolean failure;
    private float value;
    /**
     * 覆盖toString方法，使用Java 8的StringJoiner
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]")
                .add("success=" + success)
                .add("failure=" + failure)
                .add("value=" + value)
                .toString();
    }
}