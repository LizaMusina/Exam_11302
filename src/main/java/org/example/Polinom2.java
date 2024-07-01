package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Polinom2 {
    private Node head;

    public Node getHead() {
        return head;
    }

    public Polinom2(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(" ");
                insert(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), Integer.parseInt(lines[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(int coef, int deg1, int deg2) {
        Node newNode = new Node(coef, deg1, deg2);
        Node current = head;
        Node prev = null;
        if (current == null) {
            head = newNode;
            tail = newNode;
        }
        while (current != null) {
            if (current.getCoef() == coef && current.getDeg1() == deg1 && current.getDeg2() == deg2) {
                current.setCoef(2 * coef);
                break;
            }
            prev = current;
            current = current.getNext();
        }
        prev.setNext(newNode);
        newNode.setPrev(prev);
        tail = newNode;
    }

    public void delete(int deg1, int deg2) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.getDeg1() == deg1 && current.getDeg2() == deg2) {
                if (current.getNext() != null) {
                    prev.setNext(current.getNext());
                    current.setPrev(prev);
                } else {
                    tail = prev;
                }
            }
            prev = current;
            current = current.getNext();
        }
    }

    public void mult(Polinom2 p) {
        Node current = head;
        int deg1 = p.getHead().getDeg1();
        int deg2 = p.getHead().getDeg2();
        while (current != null) {
            current.setCoef(p.getHead().getCoef() * current.getCoef());
            current.setDeg1(current.getDeg1()+deg1);
            current.setDeg2(current.getDeg2()+deg2);
            current = current.getNext();
        }
    }

    public void derivate2(int i) {
        Node current = head;
        while (current != null) {
            current.setCoef(current.getCoef() * current.getDeg1() * current.getDeg2());
            current.setDeg1(current.getDeg1() - 1);
            current.setDeg2(current.getDeg2() - 1);
            current = current.getNext();
        }
    }

    public int value(int x, int y) {
        int result = 0;
        Node current = head;
        while (current != null) {
            result = result + current.getCoef() * pow(x, current.getDeg1()) * pow(y, current.getDeg2());
        }
        return result;
    }
    public int pow(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++) {
            res = res * x;
        }
        return res;
    }
    public static void main(String[] args) {
    }

}
