package TestPackage;

import java.util.List;
import java.util.Scanner;

import TestModle.NineTailModel;

public class NineTail {

	public static void main(String[] args) {
		
		System.out.println("enter you nine coins:");
		Scanner input = new Scanner(System.in);
		String s= input.nextLine();
		char[] initialNode = s.toCharArray();
		
		NineTailModel model = new NineTailModel();
		List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));
		System.out.println("the steps :");
		for(int i=0;i<path.size();i++){
			NineTailModel.printNode(NineTailModel.getNode(path.get(i).intValue()));
		}
		input.close();
	}
	
}
