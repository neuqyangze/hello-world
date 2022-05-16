package com.neuqyangze.序列化;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

public class SerializableTest {

    private static void serialize(User user) throws Exception {
        URL url = SerializableTest.class.getClassLoader().getResource("file/111.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(url.getFile()));
        oos.writeObject(user);
        oos.close();
    }

    private static User deserialize() throws Exception{
        URL url = SerializableTest.class.getClassLoader().getResource("file/111.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url.getFile()));
        return (User) ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("tyshawn");
        user.setAge(18);
        user.setSex("man");
        System.out.println("序列化前的结果: " + user);

        serialize(user);

        User dUser = deserialize();

        System.out.println("反序列化后的结果: "+ dUser);
    }
}
