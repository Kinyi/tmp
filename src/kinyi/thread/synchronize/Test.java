package kinyi.thread.synchronize;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Food> table  = new ArrayList<Food>();
		
		for (int i = 1; i < 4; i++) {
			new Thread(new Cook(table),i+"").start();
		}
		
		for (int i = 1; i < 4; i++) {
			new Thread(new SaleWindow(table),i+"").start();
		}
	}

}
