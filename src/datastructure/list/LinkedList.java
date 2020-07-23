package datastructure.list;

public class LinkedList<E> {
    Node<E> first;

    public LinkedList clone() {
        LinkedList clone = new LinkedList();
        Node n = first;
        for (; n.next != null; n = n.next) {
            clone.add(n.value);
        }
        clone.add(n.value);
        return clone;
    }

    public void add(Object value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (first == null) {
            first = node;
        } else {
            Node n = first;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void add(int index, Object value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        if (index == 0) {
            addAtStart(value);
        } else {
            Node n = first;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }

    }

    public void addAtStart(Object value) {
        Node node = first;
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = node;
        first = newNode;
    }

    public void getAll() {
        Node node = first;
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }

    public void getFirst() {
        System.out.println(first.value);
    }

    public void getLast() {
        Node node = first;
        while (node.next != null) {
            node = node.next;
        }
        System.out.println(node.value);
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node n = first;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            Node n1 = n.next;
            n.next = n1.next;
        }
    }

    public void removeFirst() {
        if (first != null && first.next != null) {
            first = first.next;
        }
    }

    public void removeLast() {
        Node node = first;
        Node previousNode = null;
        while (node.next != null) {
            previousNode = node;
            node = node.next;
        }
        previousNode.next = null;
    }

    public int contains(Object key) {
        Node node = first;
        boolean flag = true;
        while (node.next != null) {
            if (node.value == key) {
                return 1;
            }
            node=node.next;
        }
        if(node.value == key){
            return 1;
        }
        return 0;
    }

}
