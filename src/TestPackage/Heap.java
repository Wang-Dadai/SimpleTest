package TestPackage;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> {

	private List<E> list = new ArrayList<E>();
	
	public Heap(){
		
	}
	public Heap(E[] objects){
		
		for(E e : objects){
			add(e);
		}
	}
	
	public void add(E e) {
		// TODO Auto-generated method stub
		list.add(e);
		int currentIndex = list.size()-1;
		
		while(currentIndex>0){
			
			int parentIndex = (currentIndex-1)/2;
			if(list.get(parentIndex).compareTo(list.get(currentIndex))<0){
				
				E tmp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, tmp);
			}else{
				break;
			}
			
			currentIndex = parentIndex;
			
		}
	}
	
	public E remove(){
		if(list.size()==0){
			return null;
		}
		E result = list.get(0);
		
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int currentIndex = 0;
		
		while(currentIndex<list.size()){
			
			int leftChildIndex = currentIndex*2 + 1;
			int rightChildIndex = currentIndex*2 +2;
					
			if(leftChildIndex>=list.size()){
				break;
			}
			
			int maxIndex = leftChildIndex;
			if(rightChildIndex<list.size()){
				
				if(list.get(rightChildIndex).compareTo(list.get(leftChildIndex))>0){
					
					maxIndex = rightChildIndex;
				}
			}
			
			if(list.get(currentIndex).compareTo(list.get(maxIndex))<0){
				
				E tmp =list.get(currentIndex);
				list.set(currentIndex, list.get(maxIndex));
				list.set(maxIndex, tmp);
				currentIndex = maxIndex;
			}else{
				break;
			}
			
		}
		
		return result;
	}
	
	public int getSize(){
		return list.size();
	}
	
}
