package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;
    private int target;

    // gatter
    public int getTarget() {
        return target;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public LL() {
        this.size = 0;
    }

    public void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.val + " -> ");
            t = t.next;
        }
        System.out.print("null\n");
    }

    public void insertFirst(int val) {
        Node nn = new Node(val);
        nn.next = head;
        head = nn;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        Node nn = new Node(val);
        tail.next = nn;
        tail = nn;

        if (tail == null) {
            insertFirst(val);
        }
        size++;
    }

    public void insertLastWithoutTail(int val) {
        Node nn = new Node(val);
        Node t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = nn;
        tail = nn;

        if (tail == null) {
            insertFirst(val);
        }
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            tail = null;
            System.out.println("No element prensent for deletion");
        }
        Node t = head;
        head = t.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("No element prensent for deletion");
        }
        Node t1 = head;
        Node prev = null;
        while (t1.next != null) {
            prev = t1;
            t1 = t1.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }

    static void reverseListRec(Node t) {
        if (t.next == null) {
            System.out.print(t.val + " -> ");
        } else {
            reverseListRec(t.next);
            System.out.print(t.val + " -> ");
        }
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        // uesd 3 pointer prev , curr, next
        Node prev = head;
        Node curr = prev.next;
        // update
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            // update the nodes          
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;

    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        LL singlyLinkedList = new LL();
        singlyLinkedList.insertFirst(10);
        singlyLinkedList.insertFirst(20);
        singlyLinkedList.insertFirst(30);
        singlyLinkedList.insertFirst(40);

        singlyLinkedList.insertLast(55);

        singlyLinkedList.insertLastWithoutTail(68);

        singlyLinkedList.insertFirst(45);

        System.out.println("\nLinkedList After insertion operation");

        singlyLinkedList.display();

        singlyLinkedList.deleteFirst();
        System.out.println("\nLinkedList After Deleting first node");
        singlyLinkedList.display();

        singlyLinkedList.deleteLast();
        System.out.println("\nLinkedList After Deleting last node");
        singlyLinkedList.display();

        // System.out.println("\nReverse LinkedList");
        // reverseListRec(singlyLinkedList.getHead());
        // System.out.print("null");

        System.out.println("\nReverse LinkedList");
        singlyLinkedList.reverseList();
        singlyLinkedList.display();
        //System.out.print("null");

    }

}
