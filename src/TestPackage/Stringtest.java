package TestPackage;

import TestModle.StackByListTest;

public class Stringtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String time="2016-11-26 18:02:45";
//		String datestr= time.replace("-", "");
//		datestr = datestr.replace(" ", "");
//		datestr= datestr.replace(":", "");
//		datestr = datestr.substring(2);
//		System.out.println(datestr);
		
		System.out.println("sub "+ time.substring(0, 19));
		StackByListTest<Integer> test = new StackByListTest<Integer>();
		test.push(2);
		System.out.println(gcd(70,35));
		
		System.out.println(test.isEmpty());
	}
	
	public static int gcd(int a, int b){
		if(b==0){ 
			return a;
			
		}
		int r = a%b;
		return gcd(b,r);
	}
	
	public static void twoString(){
		String str1 = "abc";
		
	}
	
	
}
