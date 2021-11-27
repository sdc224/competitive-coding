package geeksforgeeks.data_structures.linked_list;

public class LinkedList {
    Node head;

    private void init(int data) {
        this.head = new Node(data);
    }

    public LinkedList() {}

    public LinkedList(int data) {
        init(data);
    }

    public Node getHead() {
        return this.head;
    }

    public void insertEnd(int data) {
        if (this.head == null) {
            init(data);
        } else {
            Node curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new Node(data);
        }
    }

    public void insertBegin(int data) {
        if (this.head == null) {
            init(data);
        } else {
            Node curr = head;
            this.head = new Node(data);
            this.head.next = curr;
        }
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
