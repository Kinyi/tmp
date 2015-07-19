package thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
//只能单例运行
public class Test10 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Future<Integer>> arrayList = new ArrayList<Future<Integer>>();
		ExecutorService pool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			MyThread10 myThread10 = new MyThread10();
			Future<Integer> future = pool.submit(myThread10);
			arrayList.add(future);
		}
		pool.shutdown();
		for (Future<Integer> future : arrayList) {
			System.out.println(future.get());
		}
	}
}

class MyThread10 implements Callable<Integer>{
	static AtomicInteger num = new AtomicInteger(0);
	
	public MyThread10(){
		if(num.addAndGet(1)>1){
			throw new RuntimeException("只能运行单例");
		}
	}
	
	@Override
	public Integer call() throws Exception {
		System.out.println("thread-"+Thread.currentThread().getId());
		return new Random().nextInt(100);
	}
}