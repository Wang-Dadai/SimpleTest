package TestModle;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {

	class Node<T>{
		T element;
		Node<T> next;
		
		public Node(T e){
			element = e;
		}
		
	}
	
	private Node<E> head,tail;
	
	public MyLinkedList(){
		
	}
	
	public MyLinkedList(E[] objects){
		for(E e:objects){
			addLast(e);
		}
	}
	
	public void addFirst(E e){
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++;
		if(tail==null){
			tail = newNode;
		}
		
	}
	
	public void addLast(E e){
		
		Node<E> newNode = new Node<E>(e);
		if(tail==null){
			head = tail = newNode;
		}else{
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(e);
		if(index==0){
			addFirst(e);
		}else if(index>=size){
			addLast(e);
		}else{
			Node<E> current = head;
			for(int i=0;i<index;i++){
				current = current.next;
			}
			
			Node<E> tmp = current.next;
			current.next = newNode;
			newNode.next = tmp;
			size++;
		}
		
	}
	
	 public E removeFirst(){
		 
		 if(head==null){
			 return null;
		 }else{
			 Node<E> tmp = head;
			 head = head.next;
			 if(head==null){
				 tail = null;
			 }
			 size--;
			 return tmp.element;
		 }
	 }

	 public E removeLast(){
		 
		 if(size==0){
			 return null;
		 }else if(size==1){
			 Node<E> tmp = head;
			 head = tail = null;
			 size=0;
			 return tmp.element;
		 }else{
			 
			 Node<E> current = head;
			 for(int i=0;i<size-2;i++){
				 
				 current = current.next;
			 }
			 Node<E> tmp = current.next;
			 current.next=null;
			 tail = current;
			 size--;
			 return tmp.element;
		 }
	 }
	 
	 public E getFirst(){
		 if(size==0){
			 return null;
		 }
		 return head.element;
	 }
	 
	 public E getLast(){
		 if(size==0){
			 return null;
		 }
		 return tail.element;
	 }
	 
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = tail =null;
		size =0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(size==0){
			return false;
		}
		
		Node<E> current = head;
		for(int i=0;i<size;i++){
			if(e.equals(current.element)){
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(size==0 || index>=size){
			return null;
		}
		if(index==0){
			return getFirst();
		}else if(index==size-1){
			return getLast();
		}
		
		Node<E> current = head;
		for(int i=0;i<index;i++){
			current = current.next;
		}
		
		return current.element;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		if(size==0){
			return -1;
		}else{
			Node<E> current = head;
			for(int i=0;i<size;i++){
				if(e.equals(current.element)){
					return i;
				}
				current = current.next;
			}
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		if(size==0){
			return -1;
		}else{
			
			Node<E> current = head;
			int lastIndex = -1;
			for(int i=0;i<size;i++){
				if(e.equals(current.element)){
					lastIndex = i;
				}
				current = current.next;
			}
			return lastIndex;
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=size){
			return null;
		}else if(index==0){
			return removeFirst();
		}else if(index==size-1){
			return removeLast();
		}else{
			
			Node<E> previous = head;
			for(int i=0;i<index-1;i++){
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		Node<E> current = head;
		for(int i=0;i<index;i++){
			current = current.next;
		}
		E old = current.element;
		current.element = e;
		
		return old;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return (new MyIterator());
	}
	
	private class MyIterator implements Iterator<E>{

		Node<E> current = head;
		int removeIndex = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E tmp = current.element;
			current = current.next;
			removeIndex++;
			return tmp;
		}
		
		@Override
		public void remove(){
			MyLinkedList.this.remove(removeIndex);
		}
		
	}
	
}
