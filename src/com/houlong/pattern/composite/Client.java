package com.houlong.pattern.composite;

/**
 * 组合模式，处理树状结构
 *   |
 *   ----安全组合模式（本例）
 *   |
 *   ----透明组合模式
 */
public class Client {

    public static void main(String[] args) {
        Organization rdDepartment, financeDepartment;
        Company company = new Company();
        rdDepartment = new RDDepartment();
        financeDepartment = new FinanceDepartment();
        company.add(rdDepartment);
        company.add(financeDepartment);
        company.notice();
    }
}
