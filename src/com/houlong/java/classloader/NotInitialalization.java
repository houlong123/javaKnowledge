package com.houlong.java.classloader;

/**
 * 类初始化的五种情况：
 * 1.遇到new, getstatic, setstatic, invokestatic4条字节码指令时，如果类还没有进行初始化，则会触发其初始化。对应java代码场景为：
 *      使用new关键字实例化对象的时候；读取或者设置一个类的静态字段的时候（final修饰的则不会触发初始化）；调用一个类的静态方法的时候。
 * 2. 使用反射技术对类进行反射调用的时候
 * 3. 当初始化一个类的时候，如果发现其父类还没有被初始化，则需要先触发父类的初始化
 * 4. 当虚拟机启动的时候，用户需要指定一个要执行的主类（包含main方法的类），虚拟机会先初始化主类
 * 5. 当使用JDK1.7的动态语言支持的时候，如果一个MethodHandle实例最后的解析结果为REF_getStatic,REF_setStatic,REF_invokeStatic
 *      的方法句柄，并且这个方法句柄所对应的类还没有初始化，则进行初始化
 *
 */
public class NotInitialalization {

    public static void main(String[] args) {
        /**
         * 通过子类引用父类的静态字段，不会导致子类初始化
         */
        System.out.println(SubClass.value);

        /**
         * 通过数组定义来引用类，不会触发此类的初始化
         */
        SuperClass[] classes = new SuperClass[10];

        /**
         * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
         * 下例中，不会导致ConstClass的初始化
         */
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
