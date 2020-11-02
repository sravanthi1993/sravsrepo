package chinni;
//import java.lang.Math;
public class squareroot {
	
	
	static int mySqrt(int x) {
      
        if(x==0 || x==1){
            return x;}
        int start=1;
        int end=x;
        int result=1;
            while(start<=end){
                int mid=(start+end)/2;
                if(mid==(x/mid))
                  return mid;
                if(mid<(x/mid))
                {start=mid+1;
                result=mid;
                }
                else
                end=mid-1;
            
            }
            return result; 
           /*   int i=1;
        		int value=1;
             while(value<=x){
            	i++;
               value=i*i;
               System.out.print(value);
                
            }
            return i-1; */
        }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y=mySqrt(2147395600);
		System.out.print(y);
		
	}

}
