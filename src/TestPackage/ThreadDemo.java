package TestPackage;

public class ThreadDemo {

	public static void main(String[] args) {
		PrintChar printChar1 = new PrintChar('a', 100);
		PrintChar printChar2 = new PrintChar('b', 100);
		PrintNum printnum = new PrintNum(2, 100);
		
		Thread thread1 = new Thread(printChar1);
		Thread thread2 = new Thread(printChar2);
		Thread thread3 = new Thread(printnum);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
	public static class PrintChar implements Runnable{
		char ch;
		int time;
		
		public PrintChar(char ch,int time){
			this.ch = ch;
			this.time = time;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<time;i++){
				System.out.print(" "+ch);
			}
		}
	}
	
	public static class PrintNum implements Runnable{
		int num;
		int time;
		
		public PrintNum(int num,int time){
			this.num = num;
			this.time = time;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<time;i++){
				System.out.print(" "+num);
			}
		}
	}
	
	public void A(){
		
		//......
		
		B();//我要在A中调用B方法 但是此时B方法的逻辑还没有写     这个时候是先写完A中剩余的逻辑还是先把B写完呢
		
		//......
	}

	private void B() {
		// TODO Auto-generated method stub
		//......
		
	}
	
}
