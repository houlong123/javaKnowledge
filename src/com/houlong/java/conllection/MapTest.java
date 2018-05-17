package com.houlong.java.conllection;

import java.util.Map;

/**
 * Created by houlong on 2017/8/14.
 */
public class MapTest<K, V> {
    private Object[][] pairs;
    private int index;

    public MapTest(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[] {key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < index; i++) {
            sb.append(pairs[i][0].toString()).append(" : ").append(pairs[i][1].toString());
            if (i < index - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MapTest<String, String> map = new MapTest<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
