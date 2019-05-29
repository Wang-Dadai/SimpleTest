package TestPackage;

public class FiBonacci {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
//		System.out.println(trandition(47));
		System.out.println(newone(100));
		
		System.out.println(System.currentTimeMillis()-start);
	}

	/**
	 * @param index
	 * @return
	 * @author WangDadai
	 */
	public static long trandition(long index){
		
		long result = 0;
		
		if(index==0){
			result = 0;
		}else if(index==1){
			result = 1;
		}else {
			result = trandition(index-1)+trandition(index-2);
		}
		
		return result;
	}
	
	/**
	 * @param index
	 * @return
	 * @author WangDadai
	 */
	public static long newone(long index){
		
		long result =0;
		
		long first = 0;
		long second = 1;
		
		if(index==0){
			return 0;
		}else if(index==1){
			return 1;
		}
		
		for(long i=2;i<index;i++){
			
			long tmp = second;
			second = first + second;
			first = tmp;
			
		}
		
		result = first + second;
		
		return result;
		
	}
	
}
