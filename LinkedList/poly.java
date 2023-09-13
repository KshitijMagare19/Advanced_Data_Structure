package LinkedList;

import java.util.Scanner;

public class poly {
    private class Node {
        int pow;
        int coeff;
        Node next;

        Node(int p, int c) {
            pow = p;
            coeff = c;
            next = null;
        }
    }

    Node head;

    poly() {
        head = null;
    }

    void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.coeff + "x^" + t.pow + " + ");
            t = t.next;
        }
    }

    void insertAtEnd(int p, int c) {
        Node nn = new Node(p, c);
        nn.next = null;

        if (head == null)
            head = nn;
        else {
            Node t = head;
            while (t.next != null)
                t = t.next;
            t.next = nn;
        }
    }

    void add(poly obj2, poly result) {
        Node t1 = this.head;
        Node t2 = obj2.head;
        while (t1 != null && t2 != null) {
            if (t1.pow == t2.pow) {
                result.insertAtEnd(t1.pow, t1.coeff + t2.coeff);
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.pow > t2.pow) {
                result.insertAtEnd(t1.pow, t1.coeff);
                t1 = t1.next;
            } else if (t2.pow > t1.pow) {
                result.insertAtEnd(t2.pow, t2.coeff);
                t2 = t2.next;
            }
        }
        while (t1 != null) {
            result.insertAtEnd(t1.pow, t1.coeff);
            t1 = t1.next;
        }
        while (t2 != null) {
            result.insertAtEnd(t2.pow, t2.coeff);
            t2 = t2.next;
        }
    }
    public static void main(String[] args) {
        poly obj1 = new poly();
        poly obj2 = new poly();
        poly result = new poly();

        Scanner sc = new Scanner(System.in);

        System.out.print("How many terms in poly 1?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int coeff = sc.nextInt();
            int pow = sc.nextInt();
            obj1.insertAtEnd(pow, coeff);
        }

        System.out.print("How many terms in poly 2?");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int coeff = sc.nextInt();
            int pow = sc.nextInt();
            obj2.insertAtEnd(pow, coeff);
        }
        sc.close();

        obj1.display();
        System.out.println();
        obj2.display();
        System.out.println();
        obj1.add(obj2, result);
        System.out.println("Result:");
        result.display();
        System.out.println();
    }
}
