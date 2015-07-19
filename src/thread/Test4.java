package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//自己瞎写的东西，没有任何意义
public class Test4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		MyThread4 myThread4 = new MyThread4(callable());
		new Thread(myThread4).start();
		FutureTask<Integer> future = new FutureTask<Integer>(callable());
		new Thread(future).start();
		Integer result = future.get();
		System.out.println("my result is "+result);
	}

	private static Callable<Integer> callable() {
		return new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println("call "+Thread.currentThread().getName());
				return 1;
			}
		};
	}

}

class MyThread4 extends FutureTask<Integer>{

	public MyThread4(Callable<Integer> callable) {
		super(callable);
		
	}
	
	@Override
	public void run() {
		System.out.println("run "+Thread.currentThread().getName());
	}
	
}