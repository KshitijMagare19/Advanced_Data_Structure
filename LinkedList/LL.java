package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void display() {
        Node t = head;
        while(t!=null){
            System.out.print(t.val+ " -> ");
            t = t.next;
        }
        System.out.print("null\n");
    }
    public void insertFirst(int val) {
        Node nn = new Node(val);
        nn.next = head;
        head = nn;
        
        if(tail == null){
            tail = head;
        }
        size++;
    }
    public void insertLast(int val) {
        Node nn = new Node(val);
        tail.next = nn;
        tail = nn;
        
        if(tail == null){
            insertFirst(val);
        }
        size++;
    }

    public void insertLastWithoutTail(int val) {
        Node nn = new Node(val);
        Node t = head;
        while(t.next!=null){
            t = t.next;
        }
        t.next = nn;
        tail = nn;
        
        if(tail == null){
            insertFirst(val);
        }
        size++;
    }
    public void deleteFirst() {
        if(head == null){
            tail = null;
            System.out.println("No element prensent for deletion");
        }
        Node t = head;
        head = t.next;    
        size--;
    }
    public void deleteLast() {
        if(head == null){
            System.out.println("No element prensent for deletion");
        }
        Node t1 = head;
        Node prev = null;
        while(t1.next!=null){
            prev = t1;
            t1 = t1.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }
    private class Node {
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
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

        singlyLinkedList.display();

        singlyLinkedList.deleteFirst();
        singlyLinkedList.display();

        singlyLinkedList.deleteLast();
        singlyLinkedList.display();

    }

}
