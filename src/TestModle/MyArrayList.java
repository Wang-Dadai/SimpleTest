package TestModle;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E>{

	public static final int INITIAL_CAPACITY = 16;
	private E[] array = (E[]) new Object[INITIAL_CAPACITY];
	
	public MyArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	public MyArrayList(E[] objects){
		for(int i=0;i<objects.length;i++){
			add(objects[i]);
		}
	}
	
	private void ensureCapacity(){
		if(size>= array.length){
			E[] newArray = (E[])new Object[size*2+1];
			System.arraycopy(array, 0, newArray, 0, size);
			array = newArray;
		}
		
	}
	
	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		ensureCapacity();
		
		if(index>size){
			add(size,e);
			return;		
		}
		
		for(int i=size-1;i>=index;i--){
			array[i+1] =array[i];
			
		}
		array[index] = e;
		
		size++;
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		array = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(e.equals(array[i])){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		return array[index];
	}

	private void checkIndex(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException("index:"+index+" out of bounds");
		}
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(e.equals(array[i])){
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		for(int i=size-1;i>=0;i--){
			if(e.equals(array[i])){
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		E e = array[index];
		for(int i=index;i<size;i++){
			array[i] = array[i+1];
		}
		array[size-1] = null;
		
		size--;
		
		return e;
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		checkIndex(index);
		E old = array[index];
		array[index] = e;
		
		return old;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 * 重写类的iterator
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new myIterator();
	}
	
	private class myIterator implements Iterator<E>{
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentIndex<size;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return array[currentIndex++];
		}
		
		@Override
		public void remove(){
			MyArrayList.this.remove(currentIndex);
		}
	}

	
}
