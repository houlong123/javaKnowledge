package com.houlong.java.conllection;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by houlong on 2018/4/14.
 */
public class ConcurrentLinkTest {

    Node head;
    Node tail;

    static class Node {
        volatile Object item;
        volatile Node next;

        Node(Object item) {
            this.item = item;
        }

        private boolean casNext(Node cmp, Node val) {
            while (next == cmp) {
                next = val;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return item == null ? "kong" : item.toString();
        }
    }

    ConcurrentLinkTest() {
        head = tail = new ConcurrentLinkTest.Node(null);
    }

    public void put(Object value) {
        Node node = new Node(value);
        for (Node t = tail, p = t;;) {
            Node next = p.next;
            while (next == null) {
                if (p.casNext(null, node)) {
                    tail = node;
                    return;
                }
            }
        }
    }

    public boolean hasNext() {
        for (Node h = head, p = h;;){
            if (p == null) {
                return false;
            }
            Node q = p.next;
            if (p != null) {
                return true;
            }
        }
    }

    public Node next() {
        Node h = head;
        head = h.next;
        return h;
    }

    public static void main(String[] args) {
        ConcurrentLinkTest test = new ConcurrentLinkTest();
        for (int index = 0; index < 20; index++) {
            test.put(index);
        }

        while (test.hasNext()) {
            System.out.println(test.next());
        }
    }
}
