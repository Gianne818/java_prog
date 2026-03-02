package SinglyLL.Classes;

public class Node<E> {
    Node<E> next;
    E elem;

    public Node(E elem){
        next = null;
        this.elem = elem;
    }
}
