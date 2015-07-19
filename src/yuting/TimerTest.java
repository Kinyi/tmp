package yuting;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	static class MyTimerTask1 extends TimerTask {
		int count = 1 ;
		public void run() {
			System.out.println("爆炸！！！");
			
			if(count++ == 2){
				this.cancel();
			}
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask1(), 1000 , 2000);// 两秒后启动任务
		
	}
}
