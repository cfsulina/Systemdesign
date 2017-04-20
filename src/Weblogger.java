import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
