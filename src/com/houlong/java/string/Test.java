package com.houlong.java.string;

/**
 * Created by houlong on 2018/4/23.
 */
public class Test {

    public static boolean isSymmetry(String source) {
        char[] sourceChar = source.toCharArray();

        for (int low = 0, high = sourceChar.length - 1; low < high ; low++, high--) {
            if (sourceChar[low] != sourceChar[high]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String source = "abba";
        System.out.println(isSymmetry(source));
        float a = 3.4f;
        double b = 3.4;

        short s1 = 1;

        s1+=1;

        //s1 = s1 + 1; //报错
    }


}
