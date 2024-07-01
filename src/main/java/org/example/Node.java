package org.example;

public class Node {
    private int coef;
    private int deg1;
    private int deg2;
    private Node next;
    private Node prev;

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setDeg1(int deg1) {
        this.deg1 = deg1;
    }

    public void setDeg2(int deg2) {
        this.deg2 = deg2;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public int getCoef() {
        return coef;
    }

    public int getDeg1() {
        return deg1;
    }

    public int getDeg2() {
        return deg2;
    }

    public Node(int coef, int deg1, int deg2) {
        this.coef = coef;
        this.deg1 = deg1;
        this.deg2 = deg2;
    }
}
