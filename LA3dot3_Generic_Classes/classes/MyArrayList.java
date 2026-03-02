package LA3dot3_Generic_Classes.classes;
    
public class MyArrayList <T> {
    private T[] array;
    private int size, capacity;

    public MyArrayList() {
        capacity = 5;
        array = (T[]) new Object[capacity];
        size = 0;
    }


    public void insert(T num) {
        if (size == capacity) {
            T[] newArr = (T[])new Object[capacity*2];
            for (int i = 0; i < capacity; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
            capacity *= 2;
        }
        array[size++] = num;
    }
    public int remove(T num) {
        for (int i = 0; i < size; i++) {
            if (num.equals(array[i])) {
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j+1];
                }
                size--;
                return i;
            }
        }
        return -1;
    }
    public T get(int index) {
        if (size == 0) {
            throw new InvalidIndexException();
        }
        if (index < 0 || index >= size) {
            throw new InvalidIndexException(size-1);
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public void changeValAt(int res, T val){
        array[res] = val;
    }

    public void removeAtIndex(int index){
        for(int i = index; i<size; i++){
            array[i] = array[i+1];
        }
        size--;
    }

    public void print(){
        System.out.println("Size: " + size + "/" + capacity);
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}