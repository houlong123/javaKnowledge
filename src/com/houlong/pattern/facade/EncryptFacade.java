package com.houlong.pattern.facade;

/**
 * 外观模式，外观类
 */
public class EncryptFacade {

    private FileReader reader;
    private FileWriter writer;
    private CipherMachine cipher;

    public EncryptFacade(FileReader reader, FileWriter writer, CipherMachine cipher) {
        this.reader = reader;
        this.writer = writer;
        this.cipher = cipher;
    }

    public void fileEncrypt(String fileSrc, String fileDes) throws Exception {
        String plainText = reader.read(fileSrc);
        String encryptText = cipher.encrypt(plainText);
        writer.write(encryptText,fileDes);
    }
}
