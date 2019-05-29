package TestPackage;

import java.math.BigInteger;

public class Complexity {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println(calculate1(new BigInteger("3"), 100));
//		System.out.println(calculate2(2, 50));
//		System.out.println(calculate3(2, 50));
		arrayCalculate(3, 100);
//		array();
		
		System.out.println("\nThe time cost:"+(System.currentTimeMillis()-start));
		
	}

	public static BigInteger calculate1(BigInteger a,int n){
		
		BigInteger result =a;
		
		for(int i=1;i<n;i++){
			result = result.multiply(a);
		}
		
		return result;
	}
	
	public static long calculate2(int a,int n){
		
		long result = a;
		
		int i = 2;
		
		while(i<=n){
			result = result*result;
			i = i*2;
		}
		
		for(int j=i/2+1;j<=n;j++){
			result = result*a;
		}
		
		return result;
	}
	
	public static long calculate3(int a,int n){
		
		long result = a;
		
		if(n==1){
			
		}else{
			
			long temp = calculate3(a, n/2);
			
			if(n%2 == 0){
				result = temp*temp;
				
			}else{
				
				result = temp*temp*a;
			}
			
		}
		
		return result;
	}
	
	public static void arrayCalculate(int p,int n){
		
		int a[] = new int[1];
		a[0] = 1;
		
		for(int i=0;i<n;i++){
			
			for(int j=0;j<a.length;j++){
				
				a[j] = a[j]*p;
			}
			
			for(int k=0;k<a.length-1;k++){
				
				if(a[k]>=10){
					
					a[k+1] += a[k]/10;
					a[k] = a[k]%10;
				}
			}
			
			if(a[a.length-1]>=10){
				int add = a[a.length-1]/10;
				a[a.length-1]%=10;
				int[] temp = new int[a.length+1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a=temp;
				a[a.length-1] = add;
				
			}
		}
		
		for(int i=a.length-1;0<=i;i--){
			
			System.out.print(a[i]);
		}
		
	}
	public static void array(){
		
		int a[] = new int[1];
		a[0] = 1;
		
		for(int i=0;i<100;i++){
			
			for(int j=0;j<a.length;j++){
				
				a[j] = a[j]*2;
			}
			
			for(int k=0;k<a.length-1;k++){
				
				if(a[k]>=10){
					
					a[k] = a[k]%10;
					a[k+1] +=1;
				}
			}
			
			if(a[a.length-1]>=10){
				a[a.length-1]%=10;
				int[] temp = new int[a.length+1];
				System.arraycopy(a, 0, temp, 0, a.length);
				a=temp;
				a[a.length-1]=1;
				
			}
		}
		
		for(int i=a.length-1;0<=i;i--){
			
			System.out.print(a[i]);
		}
		
	}
	
}
