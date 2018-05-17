package com.houlong.pattern.facade;

/**
 * 外观模式,降低系统耦合度
 */
public class Client {

    public static void main(String[] args) {
        try{
            EncryptFacade facade = new EncryptFacade(new FileReader(),new FileWriter(), new CipherMachine());
            facade.fileEncrypt("/Users/houlong/加密/秘钥.txt", "/Users/houlong/哈哈.txt");
        } catch (Exception e) {
            System.out.println("错啦");
            System.out.println(e.toString());
        }
    }
}
