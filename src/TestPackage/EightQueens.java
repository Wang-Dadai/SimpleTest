package TestPackage;

public class EightQueens {

	private static final int size = 8;
	private static int[] queens = {-1,-1,-1,-1,-1,-1,-1,-1};
	
	public static void main(String[] args) {
		
		if(search()){
			printQueens(queens);
		}
		
		System.out.println("over");
		
	}
	
	public static boolean search(){
		
		int k = 0;
		
		for(;k<queens.length;){
			
			int j = findPosition(k);
			
			if(j>=0){
				queens[k]=j;
				k++;
				System.out.println("第："+k+"： "+j);
			}else if(j<0){
				queens[k] = -1;
				k--;
				System.out.println("回退到："+k);
			}
		}
		
		if(k<0){
			System.out.println("There is not solution");
			return false;
		}else {
			return true;
		}
		
	}

	private static int findPosition(int k) {
		// TODO Auto-generated method stub
		
		for(int i=queens[k]+1;i<size;i++){
			
			if(isvalid(k,i)){
				return i;
			}
		}
		
		return -1;
	}

	private static boolean isvalid(int k, int i) {
		// TODO Auto-generated method stub
		for(int j=0;j<k;j++){
			
			if(queens[j] == i
					||queens[j]+k==i+j
					||queens[j]+j==k+i){
				return false;
			}
		}
		
		return true;
	}
	
	public static void printQueens(int[] queens1){
		
		for(int i=0;i<size;i++){
			
			for(int j=0;j<size;j++){
				
				if(queens1[i]==j){
					System.out.print(" X");
				}else{
					System.out.print(" O");
				}
			}
			System.out.println("");
		}
	}
	
}
