package thread;

public class Test9 {
	//线程安全的
	ThreadLocal<String> localMap = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		Test9 test9 = new Test9();
		test9.localMap.set("value");
		String result = test9.localMap.get();
		System.out.println(result);
	}
}
