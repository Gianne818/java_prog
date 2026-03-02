// TODO implement your MyMap here
package LA3dot3_Generic_Classes.classes;


public class MyMap <K, V>{
    private MyArrayList<K> keys;
    private MyArrayList<V> values;
    
    //finder helper
    private int find(K key){
        for(int i = 0; i<keys.size(); i++){
            if(keys.get(i).equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    
    public MyMap(){
        keys = new MyArrayList();
        values = new MyArrayList();
    }
    
    public V put(K key, V value){
        int res = find(key);
        
        if(res == -1){
            keys.insert(key);
            values.insert(value);
            return value;
        }
         
        //get value at res
        V oldVal = values.get(res); //get old value
        
        //keys.remove(keys.get(res));
        values.changeValAt(res, value);
        return oldVal;
    }
    
    public V get(K key){
        int res = find(key);
        if(res == -1){
            return null;
        }
        
        return values.get(res);
    }
    
    public int len(){
        return values.size();
    }
    
    public V delete(K key){
        int res = find(key);
        if(res == -1){
            return null;
        }
        
        V oldVal = values.get(res);
        values.removeAtIndex(res);
        keys.removeAtIndex(res);
        return oldVal;
    }
    
    public void print(){
        System.out.print("KEYS ");
        keys.print();
        System.out.print("VALUES ");
        values.print();
    }
    
}