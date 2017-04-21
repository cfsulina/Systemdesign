import java.util.HashMap;
import java.util.List;

class Column{
	public int key;
	public String value;
	public Column(int key,String value){
		this.key=key;
		this.value=value;
	}
}
public class Minicassandra {
   HashMap<String,Column>map;
	public Minicassandra(){
	   map=new HashMap<>();
   }
  
   public void insert(String raw_key, int column_key, String column_value){
	 Column column=new Column(column_key,column_value);
	   if(map.containsKey(raw_key))
		  map.put(raw_key,map.get(raw_key));
	   else
		   map.put(raw_key, column);
   }
   public List<Column> query(String raw_key, int column_start, int column_end){
	   
   }
   
}
