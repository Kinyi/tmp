package kinyi.thread.restaurant;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Customer implements Runnable{
	Semaphore semaphore = new Semaphore(5);

	void dinner(){
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"号顾客来吃饭咯");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("-->"+Thread.currentThread().getName()+"号顾客走噜");
			TimeUnit.SECONDS.sleep(1);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		dinner();
	}
}