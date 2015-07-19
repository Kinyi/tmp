package kinyi;

import java.util.HashMap;
import java.util.Map;

public class StringPractice {
	Map<Character, Integer> map = new HashMap<Character, Integer>();

	public Character findFirSameChar(String str){
		int length = str.length();
		for (int i = 0; i < length; i++) {
			char charAt = str.charAt(i);
			Integer num = map.get(charAt);
			if (num == null) {
				map.put(charAt, 1);
			}else {
				return charAt;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		char firSameChar = new StringPractice().findFirSameChar("qywyer23tdd");
		System.out.println(firSameChar);
	}
	
}
