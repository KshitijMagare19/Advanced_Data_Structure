package LinkedList.Problems;

import LinkedList.LL;

public class Find_Length_of_a_Linked_List {
    private int size;
    private Node head;

    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public int length() {
        return size;
    }

    public void insertFirst(int val) {
        Node nn = new Node(val);
        nn.next = head;
        head = nn;
        size++;
    }

    public static void main(String[] args) {
        Find_Length_of_a_Linked_List singlyLinkedList = new Find_Length_of_a_Linked_List();
        singlyLinkedList.insertFirst(10);
        singlyLinkedList.insertFirst(20);
        singlyLinkedList.insertFirst(30);
        singlyLinkedList.insertFirst(40);

        System.out.println("Size of linkedList : " + singlyLinkedList.length());
    }
}
