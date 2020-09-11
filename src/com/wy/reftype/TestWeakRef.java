package com.wy.reftype;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyang
 * @date 2020/9/11 12:22
 * @description:测试弱引用
 */
public class TestWeakRef {
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
        User u = new User(1,"wy");
        WeakReference<User> userWeakReference = new WeakReference<>(u);
        //断开强引用,只剩下弱引用
        u = null;
        System.out.println(userWeakReference.get());
        //本次user弱引用应该在GC的时候就会被回收
        System.gc();
        System.out.println("After GC");
        System.out.println(userWeakReference.get());
        List<byte[]> list = new LinkedList<>();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("===================================" + userWeakReference.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("===================================" + userWeakReference.get());
        }
    }
}
