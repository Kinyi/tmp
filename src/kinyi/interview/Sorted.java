package kinyi.interview;

import sun.tools.jar.resources.jar;

public class Sorted {

	public static void bidBubbleSorted(int[] array,int n){
		
		int left,right,l,r,t,j,i = 0;
		
		left = 0;
		right = n-1;
		
		while (left < right) {
			l = left + 1;
			r = right - 1;
			
			for (j = left; j < right; j++) {
				if (array[j] > array[j+1]) {
					t = array[j];
					array[j] = array[j+1];
					array[j+1] = t;
					r = j;
				}
			}
			right = r;
			
			for (j = right; j > left; j--) {
				if (array[j] < array[j-1]) {
					t = array[j];
					array[j] = array[j-1];
					array[j-1] = t;
					l = j;
				}
			}
			left = l;
			
			i++;
			System.out.print("第"+i+"次排序后的结果:");
			for (j = 0; j < n; j++) {
				System.out.print(array[j]+" ");
			}
			System.out.println();
		}
		System.out.print("排序后的结果:");
		for (j = 0; j < n; j++) {
			System.out.print(array[j]+" ");
		}
	}
	
	public static void choiceSorted(int[] a){
		
		for (int i = 0; i < a.length-1; i++) {
			
			int min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			if (min != i) {
				int t = a[min];
				a[min] = a[i];
				a[i] = t;
			}
		}
		System.out.print("排序后的结果:");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]+" ");
		}
	}
	
	public static void main(String[] args) {
		int score2[] = { 98, 69, 75, 47, 89, 90, 100, 70 };  //用时1毫秒
//		bidBubbleSorted(score2, 8);
		choiceSorted(score2);
	}
}
