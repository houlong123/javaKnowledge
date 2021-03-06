package com.houlong.pattern.chain;

/**
 * 董事会类:具体处理者
 */
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事大会审批采购单");
    }
}
