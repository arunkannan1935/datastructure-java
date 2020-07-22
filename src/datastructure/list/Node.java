package datastructure.list;

public class Node {
    int value;
    Node next;
    public boolean hasNext(){
        if(next == null){
            return false;
        }
        return true;
    }
}
