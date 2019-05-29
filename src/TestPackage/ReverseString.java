package TestPackage;

import CommonUtil.CommonUtil;

public class ReverseString {

	public static void main(String[] args) {
		
		Character[] s = new Character[]{'a','b','c','d','e','f','g'};
//		char chars[] = Array.chars;
//		char cha[] = {'a','b','c','d','e','f','g'};
		/*char[] chas = new char[7];
		chas[0] = 'a';
		...*/
		long startTime = System.currentTimeMillis();
		CommonUtil.<Character>printArray(s);
		
//		leftRotateString(s, 7, 3);
		threePage(s, 3, 7);
		
		CommonUtil.<Character>printArray(s);
		System.out.println(System.currentTimeMillis()-startTime);
		
	}
	
	/**
	 * 蛮力求解
	 * @param s
	 * @param n
	 */
	public static void leftShiftIne(Character[] s,int n){
		
		
		char first = s[0];
		for(int i=1;i<n;i++){
			s[i-1] = s[i];
			
		}
		s[n-1] = first;
	}
	
	public static void leftRotateString(Character[] s,int n,int m){
		
		while (m-->0){
			leftShiftIne(s, n);
		}
	}
	
	/**
	 * 三步反转
	 */
	public static void reverseString(Character[] s,int from,int to){
		
		while(from<to){
			
			char t = s[to];
			s[to--] = s[from];
			s[from++] = t;
			
		}
	}
	
	public static void threePage(Character[] s,int m,int n){
		
		m = m%n;
		reverseString(s, 0, m-1);
		reverseString(s, m, n-1);
		reverseString(s, 0, n-1);
	}
	
}
