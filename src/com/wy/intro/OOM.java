package com.wy.intro;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyang
 * @date 2020/9/10 23:02
 * @description: 测试内存溢出-Xms5m -Xmx5m -XX:+PrintGC
 */
public class OOM {
    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true){
            i++;
            if(i%10000==0){
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }
        //上面的结果:"main" java.lang.OutOfMemoryError: GC overhead limit exceeded
//        String[] strings = new String[100000000];
        //上面的结果是:"main" java.lang.OutOfMemoryError: java heap space
    }
}
