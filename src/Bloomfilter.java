import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class HashFunc{
	int cap,seed;
	public HashFunc(int cap,int seed){
		this.cap=cap;
		this.seed=seed;
	}
	public int hash(String value){
		int n=value.length();
		int re=0;
		for(int i=0;i<n;i++){
			re+=re*seed+value.charAt(i);
			re%=cap;
		}
		return re;
	}
}
public class Bloomfilter {
	List<HashFunc>func;
	int k;
	BitSet bits;
	public Bloomfilter(int k){
		this.k=k;
		func=new ArrayList<HashFunc>();
		for(int i=0;i<k;i++){
			func.add(new HashFunc(10000+i,2*i+3));
		}
		bits=new BitSet(10000+k);
	}
	//对于每一个word有k种不同的hash方式
	public void add(String word){
		for(int i=0;i<k;i++){
			int position=func.get(i).hash(word);
			bits.set(position);
		}
	}
	public boolean contains(String word){
		for(int i=0;i<k;i++){
			int position=func.get(i).hash(word);
			if(!bits.get(position)) return false;
		}
		return true;
	}
	
}
