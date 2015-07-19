package thread;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test1-"+Thread.currentThread().getId());
		for (int i = 0; i < 10; i++) {			
			MyThread2 myThread2 = new MyThread2(i);
			//启动线程使用start()
			new Thread(myThread2).start();
		}
		//myThread.run();    不要在代码中显式调用，该调用是错误的
	}
}

class MyThread2 implements Runnable{
	public MyThread2(int i){
		System.out.println("构造线程-"+i+"-"+Thread.currentThread().getId());
	}
	
	//run()的调用不是程序员控制的，而是jdk控制的
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("运行线程-"+Thread.currentThread().getId());
	}
}
