import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hearbeat {
   Map<String,Integer>alivetable;
//   int curtime;
   int kk;
   public Hearbeat(){
	   alivetable=new HashMap<>();
//	   curtime=0;
   }
   public void initialize(List<String>slaves_ip_list,int k){
	  for(String ip:slaves_ip_list){
		  alivetable.put(ip,0);
	  }
	  this.kk=k;
   }
   public void ping(int timestamp,String slave_ip){
	  if(alivetable.containsKey(slave_ip))
		  alivetable.put(slave_ip, timestamp);
	  else return;
   }
   public List<String> getdiedslaves(int timestamp){
	   //timestamp-alivetable.get(ip)>=2*k
	   List<String>re=new ArrayList<>();
	   for(String ip:alivetable.keySet()){
		   if(timestamp-alivetable.get(ip)>=2*kk)
			   re.add(ip);			   
	   }
	   return re;
	   
   }
}
