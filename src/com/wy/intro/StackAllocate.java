package com.wy.intro;

/**
 * @author wangyang
 * @date 2020/9/10 17:46
 * @description: 对象在栈上分配空间,便于回收 -server(jvm运行模式,有server(服务器模式,只有在当前模式才能做逃逸分析)/client(桌面模式)/mix(混合模式,根据系统判定))
 *  -Xmx10m -Xms10m -XX:+DoEscapeAnalysis(逃逸分析,判断对象的作用域是否逃出函数体外) -XX:+PrintGC(打印GC情况)
 *  -XX:+EliminateAllocations(标量替换,是否允许将对象打散分配到栈上,比如一个对象有两个变量,被视为两个独立的局部变量,分配到栈上)   逃逸分析和标量替换关闭任何一个都不能使用栈上分配
 *  -XX:-UseTLAB(线程本地分配缓存,事先在堆中为每个线程分配内存(避免创建对象时加锁竞争同一内存),使用完了原子的申请内存)
 */
public class StackAllocate {
    public static class User{
        public int id = 0;
        public String name = "";
    }
    public static void alloc(){
        User user = new User();
        user.id = 5;
        user.name = "wy";
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();

        System.out.println("创建1亿个对象需要的时间:" + (end - begin));
    }
}
