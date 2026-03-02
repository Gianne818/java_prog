package SinglyLL.Classes;

public class SinglyLinkedList<E>{
    Node<E> head;
    Node<E> tail;
    int size;

    public SinglyLinkedList(){
        head = tail = null;
        size = 0;
    }

    public void add(E elem){
        Node<E> newNode = new Node<>(elem);
        if(head==null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E set(E elem, int pos){
        if(pos > size || pos < 0){
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> temp = head;
        for(int i = 1; i<pos; i++){
            temp = temp.next;
        }

        E oldVal = temp.elem;
        temp.elem = elem;
        return oldVal;
    }

    public void print(){
        Node<E> temp = head;
        int ctr = 1;
        while(temp!=null){
            System.out.println("Pos " + ctr + ": " + temp.elem);
            ctr++;
            temp = temp.next;
        }
    }
}
