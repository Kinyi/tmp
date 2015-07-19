package thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test7 {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub
		ArrayList<Future<Integer>> arrayList = new ArrayList<Future<Integer>>();
		// 无界的线程池
		//ExecutorService pool = Executors.newCachedThreadPool();
		// 创建线程数量固定的线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Future<Integer> future = pool.submit(new MyThread7());
			//Thread.sleep(1000); //若此注释打开，只会调用一个线程，因为线程池中只需调用一个线程即可执行该循环
			arrayList.add(future);
		}
		pool.shutdown();
		for (Future<Integer> future : arrayList) {
			System.out.println(future.get());
		}
	}
}

class MyThread7 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("thread-"+Thread.currentThread().getId());
		Thread.sleep(1000);
		return new Random().nextInt(100);
	}
}
