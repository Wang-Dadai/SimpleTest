package TestPackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import TestPackage.ThreadConditionTest.Account;

public class ThreadConditionTest {

	public static class Account {

		private static Lock lock = new ReentrantLock();
		private static Condition condition = lock.newCondition();
		
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}

		public void addBalance(){
			lock.lock();
			try {
				balance += 1;
				System.out.println("add balance: " + 1+"the balance is : "+balance);
				condition.signalAll();
			} finally{
				lock.unlock();
			}
		}
		
		public void reduceBalance(int money){
			lock.lock();
			try{
				while(balance<money){
					System.out.println("balance < " + money);
					condition.await();
				}
				balance-=money;
				System.out.println("reduced : "+money+" the balance is:"+balance);
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
	}

	private static Account account = new Account();
	
	public static class addTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true){
					account.addBalance();
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static class reduceTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while(true){
					account.reduceBalance(10);
				}
			}finally{
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService excutor = Executors.newFixedThreadPool(2);
		excutor.execute(new addTask());
		excutor.execute(new reduceTask());
		excutor.shutdown();
		System.out.println("execute over");
	}
	
}
