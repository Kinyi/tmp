package kinyi;

public class Test {
	
	/*public void Test(){
		System.out.println("hello world");
	}*/

	public static void main(String[] args) {
		/*String tmp = "hello	you	hello	me";
		String[] split = tmp.split("\t", 2);
		System.out.println(split[1]);*/
		
		//求素数
		for (int i = 1; i <=100 ; i++) {
			int k = 0;
			for (int j = 2; j < i; j++) {
				if (i%j == 0) {
					break;
				}else {
					k++;
				}
			}
			if (k==(i-2)) {
				System.out.println(i);
			}
		}
		
		//效率更高的求素数
		for (int i = 2; i <= 100; i++) {  
            int temp = (int) Math.sqrt(i);  
            // 我把那个aqrt单独提出来,这样速度稍微快一点,虽然在100内变化不大,但如果是10000000内的素数呢?  
            if (i <= 3) {  
                System.out.println(i + " is a prime");  
            } else {  
                for (int j = 2; j <= temp; j++) {// 把Math.sqrt(i)转换为int类形  
                    if (i % j == 0) {  
                        break;  
                    }  
                    if (j >= temp) {  
                        System.out.println(i + " is a prime");  
                    }  
                }  
  
            }  
        }  
	}

}
