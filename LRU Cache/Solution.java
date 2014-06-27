import java.util.*;

public class LRUCache {
    int capacity;
    int size;
    HashMap<Integer, DListNode> map = new HashMap<Integer, DListNode>();
    
    public class DListNode{
    	int val;
    	int key;
    	public DListNode prev;
    	public DListNode next;
    	
    	DListNode(int k, int v){
    		key = k;
    		val = v;
    	}
}

    DListNode head = new DListNode(0, 0);
    DListNode tail = new DListNode(0, 0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        size = 0;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
    	if(map.containsKey(key)){
    		DListNode p = map.get(key);
    		moveToHead(p);
    		return p.val;
    	}else{
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		DListNode p = map.get(key);
    		p.val = value;
    		moveToHead(p);
    	}else{
    		if(size == capacity){
    			DListNode t = tail.prev;
    			tail.prev = t.prev;
    			t.prev.next = tail; 
    			t.next = null;
    			t.prev = null;
    			map.remove(t.key);
    			size--;
    		}
    		DListNode node = new DListNode(key, value);
    		node.next = head.next;
    		head.next.prev = node;
    		head.next = node;
    		node.prev = head;

    		//insert into map
    		map.put(node.key, node);
    		size++;
    	}
    }

    public void moveToHead(DListNode p){
    	DListNode pre = p.prev;
    	DListNode fol = p.next;
    	pre.next = fol;
    	fol.prev = pre;
    	//insert p after head;
    	p.next = head.next;
    	head.next.prev = p;
    	head.next= p;
    	p.prev = head;
    }
    
    public static void main(String[] args) {
    	LRUCache c = new LRUCache(3);
    	c.set(1, 1);
    	c.set(2, 2);
    	c.set(1, 5);
    	c.set(3, 3);
    	c.get(1);
    	c.set(4, 4);
    }
}