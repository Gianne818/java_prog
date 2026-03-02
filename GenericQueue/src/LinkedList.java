public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList(){
        head = tail = null;
        size = 0;
    }

    public void add(E elem){ //(push)
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
        if(pos>size || pos<0) throw new IllegalArgumentException("invalid position");
        Node<E> temp = head;

        for(int i = 1; i<pos; i++){
            temp = temp.next;
        }

        E oldVal = temp.elem;
        temp.elem = elem;
        return oldVal;
    }

    public E removeFirst(){ // dequeue
        if(head == null) throw new IllegalArgumentException("list is empty");
        Node<E> temp = head;
        if(head == tail){
            head = tail = null;
        }
        else {
            head = temp.next;
        }
        E num = temp.elem;
        temp = null;
        return num;
    }
}
