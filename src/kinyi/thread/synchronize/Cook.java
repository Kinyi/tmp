package kinyi.thread.synchronize;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cook implements Runnable{
	private List<Food> table;
	private final int MAXVALUE = 10;
	private static int id = 1;
	
	public Cook() {
		super();
	}

	public Cook(List<Food> table) {
		super();
		this.table = table;
	}

	void produce(){
		while (true) {
			synchronized (SaleWindow.class) {
				if (table.size() < MAXVALUE) {
					Food food = new Food(id++);
					table.add(food);
					System.out.println(Thread.currentThread().getName()
							+ "号厨师做好了" + food.getId() + "号饭了");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					SaleWindow.class.notifyAll();
				} else {
					System.out.println("饭桌已满，赶紧卖，我休息了！");
					try {
						SaleWindow.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void run() {
		produce();
	}
}
