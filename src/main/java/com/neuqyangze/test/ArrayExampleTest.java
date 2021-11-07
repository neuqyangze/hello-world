package com.neuqyangze.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class ArrayExampleTest implements InvocationHandler {

    // 泛型方法

    /**
     * 关于泛型方法的定义规则，简单总结如下：
     * <p>
     * 1、所有泛型方法的定义，都有一个用<>表示的类型参数声明，这个类型参数声明部分在方法返回类型之前。
     * <p>
     * 2、每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
     * <p>
     * 3、类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符
     * <p>
     * 4、泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像 int、double、char 等）。##
     *
     *
     * 深入理解Java泛型是程序员最基础的必备技能，虽然面试很卷，但是实力仍然很重要。
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getProxy(Class<T> clazz) {
        // clazz 不是接口不能使用JDK动态代理
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, ArrayExampleTest.this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "Hello World";
    }

    public static void main(String[] args) {
        IHelloWord hw = new ArrayExampleTest().getProxy(IHelloWord.class);
        System.out.println(hw.say());

        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Float> lf = new ArrayList<>();
        if (li.getClass() == lf.getClass()) { // 泛型擦除，两个 List 类型是一样的
            System.out.println("类型相同");
        }
    }

    // 运行期间无法获取泛型实际类型，泛型的缺点
    // public <T> void say(T a){
    //     if(a instanceof T){
    //
    //     }
    //     T t=new T();
    // }
}
