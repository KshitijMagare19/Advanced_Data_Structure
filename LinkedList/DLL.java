package LinkedList;

public class DLL {

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

    //constructor
    public DLL() {
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
        nn.prev = null;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        Node nn = new Node(val);
        nn.prev = tail;
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
        nn.prev = tail;
        tail.next = nn;       
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
            return;
        }
        Node t = head;
        t.next.prev = null;
        head = t.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("No element prensent for deletion");
        }
        Node t1 = tail.prev;
        tail.prev = null;
        t1.next = null;
        tail = t1;
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
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        DLL doublyLinkedList = new DLL();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);
        doublyLinkedList.insertFirst(30);
        doublyLinkedList.insertFirst(40);

        doublyLinkedList.insertLast(55);

        doublyLinkedList.insertLastWithoutTail(68);

        doublyLinkedList.insertFirst(45);

        System.out.println("\nLinkedList After insertion operation");

        doublyLinkedList.display();

        doublyLinkedList.deleteFirst();
        System.out.println("\nLinkedList After Deleting first node");
        doublyLinkedList.display();

        doublyLinkedList.deleteLast();
        System.out.println("\nLinkedList After Deleting last node");
        doublyLinkedList.display();

        // System.out.println("\nReverse LinkedList");
        // reverseListRec(doublyLinkedList.getHead());
        // System.out.print("null");

        System.out.println("\nReverse LinkedList");
        doublyLinkedList.reverseList();
        doublyLinkedList.display();
        //System.out.print("null");

    }

}

