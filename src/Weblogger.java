
import java.util.LinkedList;



public class Weblogger {
   LinkedList<Integer>list=new LinkedList<>();
   public void hit(int timestamp){
	   list.add(timestamp);
   }
   public int gethitcount(int timestamp){
	   while(!list.isEmpty()&&list.getFirst()+300<=timestamp)
		   list.removeFirst();
	   return list.size();
   }
}
