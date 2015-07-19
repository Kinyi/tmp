package sort;

public class ChoiceSort {

	public static void main(String[] args) {
		int[] list = { 34, 3, 53, 2, 23, 7, 14, 10 };
		choice(list);
	}

	public static void choice(int[] list) {

		if (list == null || list.length <= 0) {
			return;
		}
		for (int i = 0; i < list.length-1; i++) {
			int min = i; /* 将当前下标定义为最小值下标 */

			for (int j = i + 1; j < list.length; j++) {
				if (list[min] > list[j]) { /* 如果有小于当前最小值的关键字 */
					min = j; /* 将此关键字的下标赋值给min */
				}
			}
			if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
				int tmp = list[min];
				list[min] = list[i];
				list[i] = tmp;
			}
		}
		System.out.print("result:");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}
