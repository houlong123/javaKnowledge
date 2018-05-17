package com.houlong.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houlong on 2017/7/11.
 */
public class InfiniteRecursion {

    public String toString() {
        //此时会报错。因为编译器看到字符串后跟了一个+ 和一个非字符串对象，那么编译器会去把this转换成String，要转换成String，就要去调用toString()方法，因此造成循环调用。
        return " InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v =
                new ArrayList<InfiniteRecursion>();
        for(int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }
}
