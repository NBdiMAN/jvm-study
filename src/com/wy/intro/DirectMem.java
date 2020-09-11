package com.wy.intro;

import java.nio.ByteBuffer;

/**
 * @author wangyang
 * @date 2020/9/11 11:38
 * @description: -Xmx10m -XX:MaxDirectMemorySize=10m
 */
public class DirectMem {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 14);
        //结果Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    }
}
