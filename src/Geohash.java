public class Geohash {
  public String encode(double latitude,double longtitude,int precision){
	  String slat=setbit(latitude,-90,90);
	  String slng=setbit(longtitude,-180,180);
	  String base32="0123456789bcdefghjkmnpqrstuvwxyz";
	  StringBuilder re=new StringBuilder();
	  StringBuilder result=new StringBuilder();
	  for(int i=0;i<30;i++){
		  re.append(slat.charAt(i));
		  re.append(slng.charAt(i));
	  }
	  for(int i=0;i<60;i+=5){
		  int index=b2i(re.substring(i,i+5));
		  result.append(base32.charAt(index));
	  }
	  return result.substring(0,precision);
  }   
  public int b2i(String bin){
	  return Integer.parseInt(bin,2);
  }
  
  public String setbit(double num,double start,double end){
	  String re=""; 
	  for(int i=0;i<30;i++){
		  double mid=start+(end-start)/2;
		  if(mid<num) {
			  start=mid+1;
			  re+="1";
		      }
		  else { 
			  end=mid;
		      re+="0";
		  }
		  }
	  return re;
	  }
  }

