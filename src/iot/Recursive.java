package iot;

public class Recursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Recursive().calc(8));
	}
	
	public int calc(int num){
		if(num == 1){
			return 10;
		}
		return calc(num-1)+2;
	}

}
