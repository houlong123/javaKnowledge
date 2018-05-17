package com.houlong.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 原先类，实现标记接口Cloneable
 */
public class WeeklyLog implements Cloneable ,Serializable {

    private String name;
    private String date;
    private String content;
    private List<String> devices = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    //克隆方法clone()，此处使用Java语言提供的克隆机制（浅克隆）
    @Override
    protected WeeklyLog clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return (WeeklyLog) object;
    }

    /**
     * 对象深克隆
     * 实现方式：通过序列化的方式实现对象深克隆，
     * 因此需要对象实现Serializable标记接口，然后通过流的方式实现对象深克隆
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    protected WeeklyLog deepClone()  throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }

    @Override
    public String toString() {
        return this.date + "这一天在"+this.content+"学习" +  this.name ;
    }
}
