package com.wy.reftype;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyang
 * @date 2020/9/11 12:08
 * @description: 测试软引用 -Xms100m -Xmx100m -XX:+PrintGC
 */
public class TestSoftRef {
    public static class User{
        public int id = 0;
        public String name = "";

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //强引用
        User u = new User(1,"12");
        //软引用
        SoftReference<User> userSoftReference = new SoftReference<>(u);
        //断开强引用,只剩下软引用
        u = null;
        System.out.println(userSoftReference.get());
        //本次user软引用应该不会被回收,因为内存很充裕
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());
        List<byte[]> list = new LinkedList<>();
        //在即将发生OOM的时候,软引用的对象会被回收
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("===================================" + userSoftReference.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("===================================" + userSoftReference.get());
        }

    }
}
