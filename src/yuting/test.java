package yuting;

public class test {
	public static void main(String[] args) {
		/*if(Character.isDigit('1')){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		System.out.println(Character.digit('1',10));*/
		
		/*String str = "'Father,' she says, 'though in me you behold";
		String replaceAll = str.replaceAll("[(\t\n,.:;'|?!) ]+", " ");
		System.out.println(replaceAll);*/
		
		/*String str = " hello world  ";
		System.out.println(str);
		System.out.println(str.trim());*/
		
		/*String str = "a";
		String[] split = str.split(" ");
		System.out.println(split.length);*/
		
		/*String word = "HelLo";
		String change = word.toLowerCase();
		System.out.println(change);*/
		
		String lower = "hello";
		String upper = "HELLO";
		if (lower.equalsIgnoreCase(upper)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
}
