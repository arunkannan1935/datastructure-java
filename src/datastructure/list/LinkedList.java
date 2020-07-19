package datastructure.list;

public class LinkedList {
    Node head;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void print() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.value);
            node=node.next;
        }
        System.out.println(node.value);
    }
}
