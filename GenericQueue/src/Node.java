public class Node<E> {
    Node<E> next;
    E elem;

    public Node(E elem){
        this.elem = elem;
        next = null;
    }
}
