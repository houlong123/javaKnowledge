package com.houlong.pattern.simpleFactory;

/**
 * 工厂
 */
public class ChatFactory {

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
