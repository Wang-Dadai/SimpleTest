package TestModle;

import java.util.ArrayList;

public class StackByListTest<E> {

	private ArrayList<E> list = new ArrayList<>();
	
	public boolean isEmpty(){
		return list.isEmpty();
	}

	public void push(E o){
		list.add(o);
	}
			
}
