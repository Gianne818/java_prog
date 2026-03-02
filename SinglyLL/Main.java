package SinglyLL;
import SinglyLL.Classes.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        System.out.println();
        list.set(67, 1);
        list.set(68, 2);
        list.print();
    }
}
