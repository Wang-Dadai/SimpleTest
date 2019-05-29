package TestPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CommonUtil.CommonUtil;

public class Sort {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<5000;i++){
			list.add(i+1);
		}
		
		Collections.shuffle(list);
		Integer[] array = new Integer[list.size()];
		list.toArray(array);
		
		long start = System.currentTimeMillis();
		
//		selectSort(array);
//		insertSort(array);
//		bubbleSort(array);
//		mergeSort(array);
//		quickSort(array);
		heapSort(array);
		
		
		
		CommonUtil.printArray1(array);
		System.out.println(System.currentTimeMillis()-start);
		
	}

	/**
	 * @param array
	 * @author WangDadai
	 * 选择排序
	 */
	public static void selectSort(Integer[] array){
		
		for(int i=0;i<array.length;i++){
			
			int min = array[i];
			int minIndex = i;
			
			for(int j=i;j<array.length;j++){
				
				if(array[j]<min){
					
					min = array[j];
					minIndex = j;
				}
			}
			
			array[minIndex] = array[i];
			array[i] = min;
		}
		
	}
	
	/**
	 * @param array
	 * @author WangDadai
	 * 插入排序
	 */
	public static void insertSort(Integer[] array){
		
		for(int i=0;i<array.length;i++){
			
			int tmp = array[i];
			int j;
			
			for(j=i-1;j>=0;j--){
				
				if(array[j]>tmp){
				
					array[j+1] = array[j];
				}
			}
			array[j+1] = tmp;
		}
		
	}
	
	/**
	 * @param array
	 * @author WangDadai
	 * 冒泡排序
	 */
	public static void bubbleSort(Integer[] array){
		
		boolean needNext = true;
		for(int i=1;i<array.length && needNext;i++){
			
			needNext = false;
			
			for(int j=0;j<array.length-i;j++){
				
				if(array[j]>array[j+1]){
					
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					needNext = true;
				}
			}
		}
	}
	
	/**
	 * @param array
	 * @author WangDadai
	 * 归并排序
	 */
	public static void mergeSort(Integer[] array){
		if(array.length>1){
			Integer[] left = new Integer[array.length/2];
			System.arraycopy(array, 0, left, 0, array.length/2);
			mergeSort(left);
			
			int num = array.length-array.length/2;
			Integer[] right = new Integer[num];
			System.arraycopy(array, array.length/2, right, 0, num);
			mergeSort(right);
			
			mergeSort(left,right,array);
		}
	}
	
	public static void mergeSort(int[] array){
		if(array.length>1){
			int[] left = new int[array.length/2];
			System.arraycopy(array, 0, left, 0, array.length/2);
			mergeSort(left);
			
			int num = array.length-array.length/2;
			int[] right = new int[num];
			System.arraycopy(array, array.length/2, right, 0, num);
			mergeSort(right);
			
			mergeSort(left,right,array);
		}
	}

	public static void mergeSort(Integer[] left, Integer[] right, Integer[] array) {
		// TODO Auto-generated method stub
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		
		while(index1<left.length && index2<right.length){
			
			if(left[index1]<right[index2]){
				
				array[index3++] = left[index1++];
			}else{
				array[index3++] = right[index2++];
			}
		}
		
		while(index1<left.length){
			array[index3++] = left[index1++];
		}
		
		while(index2<right.length){
			
			array[index3++] = right[index2++];
		}
		
	}
	public static void mergeSort(int[] left, int[] right, int[] array) {
		// TODO Auto-generated method stub
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		
		while(index1<left.length && index2<right.length){
			
			if(left[index1]<right[index2]){
				
				array[index3++] = left[index1++];
			}else{
				array[index3++] = right[index2++];
			}
		}
		
		while(index1<left.length){
			array[index3++] = left[index1++];
		}
		
		while(index2<right.length){
			
			array[index3++] = right[index2++];
		}
		
	}
	
	/**
	 * @param array
	 * @author WangDadai
	 * 快速排序
	 */
	public static void quickSort(Integer[] array){
		
		quickSort(array,0,array.length-1);
	}

	private static void quickSort(Integer[] array, int first, int last) {
		// TODO Auto-generated method stub
		if(last>first){
			
			int pivotIndex = getPosition(array,first,last);
			quickSort(array,first,pivotIndex-1);
			quickSort(array,pivotIndex+1,last);
		}
		
	}

	private static int getPosition(Integer[] array, int first, int last) {
		// TODO Auto-generated method stub
		int pivot = array[first];
		int low = first +1;
		int high = last;
		
		while(low<high){
			
			while(low<high && array[low]<=pivot){
				
				low++;
			}
			while(low<high && array[high]>pivot){
				high--;
			}
			
			if(high>low){
				int tmp = array[high];
				array[high] = array[low];
				array[low] = tmp;
			}
			
		}
		
		while(high>first && array[high]>= pivot){
			high--;
		}
		
		if(pivot>array[high]){
			array[first] = array[high];
			array[high] = pivot;
			return high;
		}else{
			return first;
		}
		
	}
	
	/**
	 * @param array
	 * @author WangDadai
	 */
	public static void heapSort(Integer[] array){
		
		Heap<Integer> heap = new Heap<Integer>(array);
		
		System.out.println(heap.getSize());
		
		for(int i=array.length-1;i>=0;i--){
			
			array[i] = heap.remove();
		}
	}

	
	
}
