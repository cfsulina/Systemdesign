import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Document {
      public int id;
      public String content;
}
 
public class Invertedindex {
	public Map<String,List<Integer>>invertedIndex(List<Document>docs){
		Map<String,List<Integer>>map=new HashMap<>();
		for(Document doc:docs){
			String[]words=doc.content.split(" ");
			Set<String>appeared=new HashSet<>();
			for(String word:words){
				if(!map.containsKey(word))
					map.put(word, new ArrayList<Integer>());
				else{
					if(!appeared.contains(word))
					   {
						map.get(word).add(doc.id);
						appeared.add(word);
					   }
				}
			}
		}
		return map;
	}
}
