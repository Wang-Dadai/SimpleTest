package TestPackage;

public class ZzzzzzTest {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		swap(x,y);
		System.out.println(x+" "+y);
	}
	
	public static void swap(Integer x,Integer y){
		int tmp = x;
		x=y;
		y = tmp;
	}
	
}
