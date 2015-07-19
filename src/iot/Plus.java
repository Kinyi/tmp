package iot;

public class Plus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 5;
		int m = 0;
		//m=(j++)+(j++)+(j++);
		m=(++j)+(++j)+(++j);
		System.out.println(m);
	}

}
