package com.houlong.pattern.simpleFactory;

/**
 * 产品抽象类
 */
interface Chat {
    void display();
    public static Chat createChat(String type) {
        Chat chart = null;
        if ("line".equalsIgnoreCase(type)) {
            chart = new LineChat();
        }
        if ("pie".equalsIgnoreCase(type)) {
            chart = new PieChart();
        }
        if ("histogram".equalsIgnoreCase(type)) {
            chart = new HistogramChat();
        }
        return chart;
    }
}
