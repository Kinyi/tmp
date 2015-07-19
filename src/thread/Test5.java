package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		for (int j = 0; j < 5; j++) {
			MyThread5 myThread5 = new MyThread5(j);
			FutureTask<Integer> future = new FutureTask<Integer>(myThread5);
			new Thread(future).start();
			Thread.sleep(500);
			Integer result = future.get();
			System.out.println(result);
		}
	}
}

class MyThread5 implements Callable<Integer>{
	int i;
	
	public MyThread5(int i){
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("callable-"+Thread.currentThread().getId());
		return i;
	}
}
