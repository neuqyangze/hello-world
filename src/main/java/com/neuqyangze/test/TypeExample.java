package com.neuqyangze.test;

/**
 * JVM是如何实现泛型的？
 *
 * 在JVM中，采用了类型擦除Type erasure generics的方式来实现泛型，简单来说，就是泛型只存在.java源码文件中，一旦编译后就会把泛型擦除.
 *
 * 泛型类型擦除实现带来的缺陷
 *
 * 1、不支持基本类型
 * 2、运行期间无法获取泛型实际类型
 * @param <T>
 */
public class TypeExample<T> {
// public class TypeExample<T extends Number> {

    // ********************* 泛型通配符上边界 extends

    // private T t;
    //
    // public T getT() {
    //     return t;
    // }
    //
    // public void setT(T t) {
    //     this.t = t;
    // }
    //
    // public static void main(String[] args) {
    //     TypeExample<String> t=new TypeExample<>();
    // }

    // ********************* 泛型通配符下边界 super
    // private T t;
    //
    // public T getT() {
    //     return t;
    // }
    //
    // public void setT(T t) {
    //     this.t = t;
    // }
    //
    // public static void say(TypeExample<? super Number> te) {
    //     System.out.println("say: " + te.getT());
    // }
    //
    // public static void main(String[] args) {
    //     TypeExample<Number> te = new TypeExample<>();
    //     TypeExample<Integer> te2 = new TypeExample<>();
    //     say(te);
    //     say(te2);
    // }

    // ********************* 类型通配符 ?
    // private T t;
    //
    // public T getT() {
    //     return t;
    // }
    //
    // public void setT(T t) {
    //     this.t = t;
    // }
    //
    // public static void say(TypeExample<?> te) {
    //     System.out.println("say: " + te.getT());
    // }
    //
    // public static void main(String[] args) {
    //     TypeExample<Integer> te1 = new TypeExample<>();
    //     te1.setT(1111);
    //     TypeExample<String> te2 = new TypeExample<>();
    //     te2.setT("Hello World");
    //     say(te1);
    //     say(te2);
    // }

    // private T t;
    //
    // public T getT() {
    //     return t;
    // }
    //
    // public void setT(T t) {
    //     this.t = t;
    // }
    //
    // public static void say(TypeExample<? extends Number> te) { // 修改，增加 extends
    //     System.out.println("say: " + te.getT());
    // }
    //
    // public static void main(String[] args) {
    //     TypeExample<Integer> te1 = new TypeExample<>();
    //     te1.setT(1111);
    //     TypeExample<String> te2 = new TypeExample<>();
    //     te2.setT("Hello World");
    //     say(te1);
    //     say(te2);
    // }

}
