package com.houlong.pattern.chain;

/**
 * 责任链模式
 */
public class Client {

    public static void main(String[] args) {

        PurchaseRequest request = new PurchaseRequest(40030, 10, "孝敬老人");
        PurchaseRequest request2 = new PurchaseRequest(60000, 10, "葵花宝典");
        PurchaseRequest request3 = new PurchaseRequest(403204, 10, "葵花宝典");
        PurchaseRequest request4 = new PurchaseRequest(4030204, 10, "葵花宝典");



        Approver wjzhang, gyang, jguo, meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        meeting = new Congress("董事会");

        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);

       /* wjzhang.processRequest(request);
        wjzhang.processRequest(request2);
        wjzhang.processRequest(request3);
        wjzhang.processRequest(request4);
*/
        //System.out.println(Long.valueOf("FFFF", 2).toString());
        int i = -1;
        i >>>= 10;
        System.out.println(i);
    }
}
