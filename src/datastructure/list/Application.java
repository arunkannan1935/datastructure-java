package datastructure.list;

public class Application {
    public static void main(String args[]){
//        java.util.LinkedList linkedList = new java.util.LinkedList();


        LinkedList list = new LinkedList();
        list.add(12);
        list.add(15);
        list.add(20);
        list.addAtStart(55);
        list.add(2, 17);

        list.delete(0);

        list.print();
    }
}
