package com.houlong.java.innnerclass;

/**
 * 内部类之继承内部类
 */
class WithInner {

    private Inner inner;

    //内部类
    class Inner {
        public Inner() {
            System.out.println("WithInner.Inner");
        }
    }

    public void insertYolk(Inner yy) {  }
}