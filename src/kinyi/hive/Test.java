package kinyi.hive;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tmp = "hello	you,hello me";
		StringTokenizer stringTokenizer = new StringTokenizer(tmp);
		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
	}

}
