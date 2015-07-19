package kinyi.thread.windowSaleTicket;

public class Test {

	public static void main(String[] args) {
		
		for (int i = 1; i < 6; i++) {
			new Thread(new Window(),"窗口"+i).start();
		}
	}

}
