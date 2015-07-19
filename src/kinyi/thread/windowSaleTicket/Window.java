package kinyi.thread.windowSaleTicket;

import java.util.concurrent.TimeUnit;

public class Window implements Runnable{

	private static int tickets = 100;
	
	void sale(){
		while (true) {
			synchronized (Window.class) {
				if (tickets > 0) {
					try {
						TimeUnit.MILLISECONDS.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "已卖出"
							+ tickets + "号票了");
					tickets--;
				} else {
					break;
				}
			}
		}
	}

	@Override
	public void run() {
		sale();
	}
}
