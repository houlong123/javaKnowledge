package com.houlong.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件。公司
 */
public class Company extends Organization {

    List<Organization> list = new ArrayList<Organization>();

    @Override
    public void notice() {
        System.out.println("公司发送通知");
        System.out.println("===========");
        for (Organization or : list) {
            or.notice();
        }
    }

    public List<Organization> getList() {
        return list;
    }

    public void setList(List<Organization> list) {
        this.list = list;
    }

    public Organization get(int index) {
        return list.get(index);
    }

    public boolean add(Organization organization) {
        return list.add(organization);
    }

}
