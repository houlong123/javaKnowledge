package com.houlong.java.gc;

import com.houlong.pattern.simpleFactory.LineChat;
import com.sun.management.VMOption;
import sun.management.HotSpotDiagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * StackOverflowError异常测试
 */
public class StackOverFlowTest {
    private static int index = 1;
    private static String base = "string";

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {

        /*//模拟java.lang.StackOverflowError异常
        StackOverFlowTest test = new StackOverFlowTest();
        try {
            test.call();
        } catch (Throwable e) {
            System.out.println("stack deep: " + index);
            e.printStackTrace();
        }*/


        //模拟java.lang.OutOfMemoryError: Java heap space。说明JDK1.8将字符串常量由永久代转移到了堆中。
        // JDK1.8中，无永久代的概念，取而代之的是：元空间。元空间的本质和永久代类似，都是对JVM规范中方法区的实现。
        // 不过元空间与永久代之间最大的区别在于：元空间并不在虚拟机中，而是使用本地内存。


        HotSpotDiagnostic mxBean = new HotSpotDiagnostic();
        List<VMOption> diagnosticVMOptions = mxBean.getDiagnosticOptions();
        for (VMOption vmOption:diagnosticVMOptions){
            System.out.println(vmOption.getName() + " = " + vmOption.getValue());
        }

        List<String> list = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
while (true) {

}
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int index = 0; index < Integer.MAX_VALUE; index++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }*/
    }
}
