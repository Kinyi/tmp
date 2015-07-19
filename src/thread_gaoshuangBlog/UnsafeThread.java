package thread_gaoshuangBlog;

public class UnsafeThread {
	public static void main(String[] args) {  
        Runnable runnable = new Runnable() {  
        	Count count = new Count();  
            public void run() {  
                count.count();  
            }  
        };  
        for(int i = 0; i < 10; i++) {  
            new Thread(runnable).start();  
        }  
    }  
}

class Count {  
    private int num;  
    public void count() {  
        for(int i = 1; i <= 10; i++) {  
            num += i;  
        }  
        System.out.println(Thread.currentThread().getName() + "-" + num);  
    }  
}  

/*method1:将Count中num变成count方法的局部变量
public class Count {  
    public void count() {  
        int num = 0;  
        for(int i = 1; i <= 10; i++) {  
            num += i;  
        }  
        System.out.println(Thread.currentThread().getName() + "-" + num);  
    }  
}  

method2:将线程类成员变量拿到run方法中，这时count引用是线程内的局部变量
public class ThreadTest4 {  
    public static void main(String[] args) {  
        Runnable runnable = new Runnable() {  
            public void run() {  
                Count count = new Count();  
                count.count();  
            }  
        };  
        for(int i = 0; i < 10; i++) {  
            new Thread(runnable).start();  
        }  
    }  
}   

method3:将runnable放到for循环里面
public static void main(String[] args) {  
    for(int i = 0; i < 10; i++) {  
    	Runnable runnable = new Runnable() {  
    		Count count = new Count();  
    		public void run() {  
    			count.count();  
    		}  
    	};  
        new Thread(runnable).start();  
    }  
}  */