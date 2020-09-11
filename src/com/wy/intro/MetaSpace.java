package com.wy.intro;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyang
 * @date 2020/9/10 23:20
 * @description:
 */
public class MetaSpace {
    public static void main(String[] args) {
//        String[] strings = new String[100000000];
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true){
            i++;
            if(i%10000==0){
                System.out.println("i=" + i);
            }
            list.add(new Object());
        }
    }
}
