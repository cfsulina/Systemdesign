import java.util.HashMap;

class Resource{
	int val;int expire;
	public Resource(int val,int expire){
		this.val=expire;
		this.expire=expire;
	}
}

public class Memcache {
    HashMap<Integer,Resource>map;
	public Memcache(){
		map=new HashMap<>();
	}
	public int get(int cur,int key){
		if(!map.containsKey(key)) return Integer.MAX_VALUE;
		Resource re=map.get(key);
		if(re.expire<cur) return Integer.MAX_VALUE;
		else return re.val;
		
	}
	public void set(int cur,int key,int value,int ttl){
		int expired;
		if(ttl==0) expired=-1;
		else expired=cur+ttl-1;
		map.put(key,new Resource(value,expired));		
	}
	public void delete(int cur,int key){
		if(!map.containsKey(key)) return;
		map.remove(key);
	}
	public int increase(int cur,int key,int delta){
		if(!map.containsKey(key)) return Integer.MAX_VALUE;
		map.get(key).val+=delta;
		return get(cur,key);
	}
    public int decrease(int cur,int key,int delta){
		if(!map.containsKey(key)) return Integer.MIN_VALUE;
		map.get(key).val-=delta;
		return get(cur,key);
	}
        
}


