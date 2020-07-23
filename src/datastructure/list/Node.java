package datastructure.list;

public class Node<T> {
    T value;
    Node next;
    public boolean hasNext(){
        if(next == null){
            return false;
        }
        return true;
    }
}
