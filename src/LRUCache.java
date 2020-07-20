import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LRUCache {
    int capacity;
    HashMap<Integer,Integer> map;
    List<Integer> list;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        list=new LinkedList<>();
    }
    
    public int get(int key) {
        //System.out.println("Get:"+key);
        Integer value=map.get(key);
        
        if(value!=null){
            int index=getIndex(list,key);
            list.remove(index);
            list.add(0,key);
            
//             System.out.println("Get:");
//             System.out.println(map);
//             System.out.println(list);
//             System.out.println();
            
            return value;
        }
        // System.out.println("Get:");
        // System.out.println("-1");
        return -1;
    }
    
    public int getIndex(List<Integer> list,int value){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==value){
                return i;
            }
        }
        
        return -1;

    }
    
    public void put(int key, int value) {
        //System.out.println("Put:"+key+" "+value);
        //updating old values
        
        if(map.get(key)!=null){
           // System.out.println("Updating:");
            map.put(key,value);
            get(key);
            return;
        }
        
        
        //inserting new values
        if(map.size()<capacity){
            map.put(key,value);
            list.add(0,key);
        }else{
            int oldKey=list.get(capacity-1);
            map.remove(oldKey);
            map.put(key,value);
            list.add(0,key);
            list.remove(capacity);
        }
        // System.out.println("Put:");
        // System.out.println(map);
        // System.out.println(list);
        // System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */