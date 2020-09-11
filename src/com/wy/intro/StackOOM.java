package com.wy.intro;

/**
 * @author wangyang
 * @date 2020/9/10 23:28
 * @description:
 */
public class StackOOM {
    private static int i = 0;
    private static void recursion(){
        i++;
        recursion();
    }
    public static void main(String[] args) {
        try{
            recursion();
        }catch(Throwable e){
            System.out.println("栈深度:" + i);
            //java.lang.StackOverflowError
            e.printStackTrace();
        }
    }
}
