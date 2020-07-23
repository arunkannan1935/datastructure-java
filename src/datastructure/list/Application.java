package datastructure.list;

public class Application {
    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.add(12);
        list.add(15);
        list.add(20);
        list.add(250);
        list.addAtStart(55);
        list.add(2, 17);

        list.remove(0);

        System.out.println("*******First Element*******");
        list.getFirst();
        System.out.println("*******Last Element*******");
        list.getLast();
        System.out.println("*******All Elements*******");
        list.getAll();

        list.removeFirst();
        System.out.println("*******All Elements*******");
        list.getAll();

        list.removeLast();
        System.out.println("*******All Elements*******");
        list.getAll();

        LinkedList newList = list.clone();
        System.out.println("*******All Elements*******");
        newList.getAll();

        LinkedList secondList = new LinkedList<String>();
        secondList.add("Arun");
        secondList.addAtStart("Hello");
        secondList.add(2, "Welcome");

        System.out.println("*******First Element*******");
        secondList.getFirst();
        System.out.println("*******Last Element*******");
        secondList.getLast();
        System.out.println("*******All Elements*******");
        secondList.getAll();
        System.out.println("search content : "+secondList.contains("Welcome"));
    }
}
