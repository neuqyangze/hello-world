package com.neuqyangze.序列化;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    // private String school;
    private transient String sex;
    // private static String signature = "你眼中的世界就是你自己的样子";
    private static String signature = "我的眼里只有你";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // public String getSchool() {
    //     return school;
    // }
    //
    // public void setSchool(String school) {
    //     this.school = school;
    // }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static String getSignature() {
        return signature;
    }

    public static void setSignature(String signature) {
        User.signature = signature;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex +'\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
