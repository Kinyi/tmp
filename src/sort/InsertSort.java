package sort;

public class InsertSort {

	public static void main(String[] listrgs) {
		int[] list = { 34, 3, 53, 2, 23, 7, 14, 10 };
		insert(list);
	}

	public static void insert(int[] list) {
		int length = list.length; // 数组长度
		int j; // 当前值的位置
		int i; // 指向j前的位置
		int key; // 当前要进行插入排序的值
		
		// 从数组的第二个位置开始遍历值
		for (j = 1; j < length; j++) {
			key = list[j];
			i = j - 1;
			// list[i]比当前值大时，list[i]后移一位,空出i的位置，好让下一次循环的值后移
			while (i >= 0 && list[i] > key) {
				list[i + 1] = list[i]; // 将list[i]值后移
				i--; // i前移
			}// 跳出循环(找到要插入的中间位置或已遍历到0下标)
			list[i + 1] = key; // 将当前值插入
		}
		
		System.out.print("result:");
		for (int x = 0; x < list.length; x++) {
			System.out.print(list[x] + " ");
		}
	}
}