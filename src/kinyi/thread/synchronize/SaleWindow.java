package kinyi.thread.synchronize;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaleWindow implements Runnable{

	private List<Food> table;
	
	public SaleWindow() {
		super();
	}

	public SaleWindow(List<Food> table) {
		super();
		this.table = table;
	}

	void sale(){
		while (true) {
			synchronized (SaleWindow.class) {
				if (table.size() > 0) {
					Food food = table.get(0);
					System.out.println(Thread.currentThread().getName()
							+ "窗口已卖" + food.getId() + "号饭");
					table.remove(0);
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					SaleWindow.class.notifyAll();
				} else {
					System.out.println(Thread.currentThread().getName()
							+ "窗口没饭了，我休息了，赶紧做！");
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
		sale();
	}
	
}
