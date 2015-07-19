package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test8 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			Future<Integer> future = pool.submit(new MyThread8());
			//Thread.sleep(500);  若此注释打开，只会调用一个线程，因为线程池中只需调用一个线程即可执行该循环
			System.out.println(future.get()); //调用future.get()时会造成线程阻塞
		}
		pool.shutdown();
		
	}
}

class MyThread8 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("thread-"+Thread.currentThread().getId());
		Thread.sleep(1000);
		return new Random().nextInt(100);
	}
}
