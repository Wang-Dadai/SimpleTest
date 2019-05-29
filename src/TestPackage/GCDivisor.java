package TestPackage;

public class GCDivisor {

	public static int bruteforce(int a,int b){
		
		int result = 1;
		
		int tmp = Math.min(a, b);
		
		for(int k=tmp;k>=1;k--){
			
			if(a%k==0 && b%k==0){
				return k;
			}
		}
		
		return result;
	}
	
	public static int euclid(int a,int b){
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		if(max%min == 0){
			
			return min;
		}else{
			
			return euclid(min,max%min);
		}
		
	}
	
}
