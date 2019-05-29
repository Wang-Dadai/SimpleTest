package TestPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("d://file/JavaTest");
		if(!file.exists()){
			file.mkdirs();
			
		}
		File file1 = new File(file+"/testFile.txt");
		PrintWriter pWriter = new PrintWriter(file1);
		
		pWriter.print("the first name ");
		pWriter.print("the first age ");
		pWriter.println("the second name");
		pWriter.println("the second age");
		pWriter.close();
		
		Scanner input = new Scanner(file1);
		
		while(input.hasNext()){
			String first = input.next();
			String second = input.next();
//			String third = input.next();
//			String fourth = input.next();
			
			System.out.println(first);
			System.out.println(second);
//			System.out.println(third);
//			System.out.println(fourth);
		}
		
		
	}
	
}
