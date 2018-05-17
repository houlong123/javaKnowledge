package com.houlong.java.innnerclass;

/**
 * Created by houlong on 2017/7/7.
 */
public class InheritInner extends WithInner {

    public InheritInner() {
        insertYolk(new Inner());
    }
    //内部类
    class Inner extends WithInner.Inner {

        public Inner() {
            System.out.println("InheritInner.Inner");
        }
        public void deplay() {
            System.out.println("xixi");
        }
    }

    public static void main(String[] args) {
        new InheritInner();
    }
}
