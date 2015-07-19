package kinyi;

public class ClassicalTest {

	public static void main(String[] args) {
		Singleton.getInstance();
		System.out.println(Singleton.x);
		System.out.println(Singleton.y);
	}
}

class Singleton{
	private static Singleton instance= new Singleton();
	public static int x;
	public static int y = 0;
	
	private Singleton(){
		x++;
		y++;
	}
	
	public static Singleton getInstance(){
		return instance;
	}
}