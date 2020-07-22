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

    public void add(int index, int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        if (index == 0) {
            addAtStart(value);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }

    }

    public void addAtStart(int value) {
        Node node = head;
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = node;
        head = newNode;
    }

    public void print() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }

    public void delete(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            Node n1 = n.next;
            n.next = n1.next;
        }

    }

}
