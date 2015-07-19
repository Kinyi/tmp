package sort;

import java.util.Date;

//very important
public class DoubleBubble {

	// 一般的冒泡排序
	static void bubbleSort(int a[], int n) {
		int i, j, k;
		int temp;

		for (i = 0; i < n; i++) { // 最多做n-1趟排序
			for (j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) { // 把大的值交换到后面
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.print("第" + (i + 1) + "次排序结果：");
			for (k = 0; k < n; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
		System.out.print("最终排序结果： ");
		for (k = 0; k < n; k++) {
			System.out.print(a[k] + " ");
		}
	}

	// 改进版的冒泡排序(双向冒泡)
	static void bidBubbleSort(int a[], int n) {
		int left, right, t, l, r, j, i = 0;

		left = 0;
		right = n - 1;

		// 双向冒泡算法，极大的减少了循环排序的次数
		while (left < right) {
			// 必须要给l和r赋值，否则若数组一开始就有序，则right=r中的r未赋值，即报错
			l = left + 1;
			r = right - 1;

			// 第一次循环将最大的值放到末尾
			for (j = left; j < right; j++) {
				if (a[j] > a[j + 1]) {
					t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					r = j;
				}
			}
			right = r;

			// 第二次循环将最小的值放到了开头
			for (j = right; j > left; j--) {
				if (a[j] < a[j - 1]) {
					t = a[j];
					a[j] = a[j - 1];
					a[j - 1] = t;
					l = j;
				}
			}
			left = l;

			i++;
			System.out.print("第" + i + "次排序结果：");
			for (j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		System.out.print("最终排序结果： ");
		for (j = 0; j < n; j++) {
			System.out.print(a[j] + " ");
		}
	}

	public static void main(String[] args) {

//		System.out.println(new Date().getTime());
//		int score1[] = { 98, 69, 75, 47, 89, 90, 100, 70 };  //用时3毫秒
//		bubbleSort(score1, 8);
//		System.out.println("\n");
		System.out.println(new Date().getTime());
		int score2[] = { 98, 69, 75, 47, 89, 90, 100, 70 };  //用时1毫秒
		bidBubbleSort(score2, 8);
		System.out.println(new Date().getTime());

	}
}
