package kinyi.thread.restaurant;

public class Restaurant {

	public static void main(String[] args) {
		Customer runnable = new Customer();
		for (int i = 1; i < 51; i++) {
			new Thread(runnable,i+"").start();
		}
	}
}
