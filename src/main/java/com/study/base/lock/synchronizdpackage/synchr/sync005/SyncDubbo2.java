package com.study.base.lock.synchronizdpackage.synchr.sync005;
/**
 * synchronized的重入
 * @author kaimin
 *
 */
public class SyncDubbo2 {

	static class Main {
		public int i = 10;
		public  void operationSup(){
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sub extends Main {
		public  void operationSub(){
			try {
				while(i > 0) {
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);		
					this.operationSup();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Sub sub = new Sub();
				sub.operationSub();
			}
		});
		
		t1.start();
	}
	
	
}
