import java.util.HashMap;
import java.util.Map;

class BaseGFSClient {
      private Map<String, String> chunk_list;
      public BaseGFSClient() {}
      public String readChunk(String filename, int chunkIndex) {
          // Read a chunk from GFS
    	  return "";
      }
      public void writeChunk(String filename, int chunkIndex,
                             String content) {
          // Write a chunk to GFS
      }
  }

public class GFSclient extends BaseGFSClient {
   Map<String,Integer>map;
   int chunkSize;
	public GFSclient(int chunkSize){
	   this.chunkSize=chunkSize;
	   this.map=new HashMap<>();
   }
	public String read(String filename){
		if(!map.containsKey(filename)) return null;
		StringBuffer content=new StringBuffer();
		for(int i=0;i<map.get(filename);i++){
			String subcontent=readChunk(filename,i);
			if(subcontent!=null){
				content.append(subcontent);
			}
		}
		return content.toString();
	}
	public void write(String filename,String content){
		int length=content.length();
		int num=(length-1)/chunkSize+1;
		map.put(filename,num);
		for(int i=0;i<num;i++){
			int start=i*chunkSize;
			int end=i==num-1?length:(i+1)*chunkSize;
			String sub=content.substring(start,end);
		    writeChunk(filename,i,sub);
		}
	}
}
