package TestPackage;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {

	/**
	 * @param args
	 * @author WangDadai
	 */
	public static void main(String[] args) {
		
		final int SIZE = 7000000;
		
		int[] list1 = new int[SIZE];
		int[] list2 = new int[SIZE];
		
		for(int i =0 ; i<SIZE;i++){
			list1[i] = list2[i] = (int)(Math.random()*10000);
		}
		
		long start = System.currentTimeMillis();
		parallelMergeSort(list1);
		System.out.println("parallelMergeSort time: "+ (System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		Sort.mergeSort(list2);
		System.out.println("MergeSort time: " + (System.currentTimeMillis()-start));
		
	}

	private static void parallelMergeSort(int[] list) {
		// TODO Auto-generated method stub
		RecursiveAction mainTask = new SortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);
		
	}
	
	private static class SortTask extends RecursiveAction{

		private final int THRESHOLD = 500;
		private int[] list;
		
		SortTask(int [] list){
			this.list = list;
		}
		
		@Override
		protected void compute() {
			// TODO Auto-generated method stub
			if(list.length < THRESHOLD){
				Sort.mergeSort(list);
			}
			else{
				
				int[] firstHalf = new int[list.length/2];
				System.arraycopy(list, 0, firstHalf, 0, list.length/2);
				
				int secondLength = list.length - list.length/2;
				int[] secondHalf = new int[secondLength];
				System.arraycopy(list, list.length/2, secondHalf, 0, secondLength);
				invokeAll(new SortTask(firstHalf),new SortTask(secondHalf));
				
				Sort.mergeSort(firstHalf,secondHalf,list);
			}
		}
	}
	
}
