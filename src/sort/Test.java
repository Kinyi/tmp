package sort;

public class Test {

	public static void bidBubbleSort(int[] a, int n) {

		/*
		 * int left, right, t, l, r, j, i = 0; left = 0; right = n - 1; while
		 * (left < right) { l = left + 1; r = right - 1; for (j = left; j <
		 * right; j++) { if (a[j] > a[j + 1]) { t = a[j]; a[j] = a[j + 1]; a[j +
		 * 1] = t; r = j; } } right = r; for (j = right; j > left; j--) { if
		 * (a[j] < a[j - 1]) { t = a[j]; a[j] = a[j - 1]; a[j - 1] = t; l = j; }
		 * } left = l; i++; System.out.print("第" + i + "次排序后的結果是:"); for (j = 0;
		 * j < n; j++) { System.out.print(a[j] + " "); } System.out.println(); }
		 * System.out.print("排序后的結果是:"); for (j = 0; j < n; j++) {
		 * System.out.print(a[j] + " "); }
		 */

		/*
		 * int left,right,t,l,r,j,i=0; left = 0; right = n-1; while (left <
		 * right) { l = left +1; r = right -1; for (j = left; j < right; j++) {
		 * if (a[j] > a[j+1]) { t = a[j]; a[j] = a[j+1]; a[j+1] = t; r = j; } }
		 * right = r; for (j = right; j >left ; j--) { if (a[j] < a[j-1]) { t =
		 * a[j]; a[j] = a[j-1]; a[j-1] = t; l = j; } } left = l; i++;
		 * System.out.print("第"+i+"次排序后的结果为:"); for (j = 0; j < n; j++) {
		 * System.out.print(a[j]+" "); } System.out.println(); }
		 * System.out.print("排序后的结果为:   "); for (j = 0; j < n; j++) {
		 * System.out.print(a[j]+" "); }
		 */

		/*
		 * for (int i = 0; i < n-1; i++) { for (int j = 0; j < n-i-1; j++) { if
		 * (a[j]>a[j+1]) { int t = a[j]; a[j] = a[j+1]; a[j+1] = t; } }
		 * System.out.print("第"+(i+1)+"次排序后的结果为:"); for (int j = 0; j < n; j++)
		 * { System.out.print(a[j]+" "); } System.out.println(); }
		 */

		int left, right, l, r, t, j, i = 0;

		left = 0;
		right = n - 1;

		while (left < right) {
			l = left + 1;
			r = right - 1;

			for (j = left; j < right; j++) {
				if (a[j] > a[j + 1]) {
					t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					r = j;
				}
			}
			right = r;

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
			System.out.print("第" + i + "次排序后的结果:");
			for (j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}

		System.out.print("排序后的结果:");
		for (j = 0; j < n; j++) {
			System.out.print(a[j] + " ");
		}

	}

	public static void main(String[] args) {
		int score2[] = { 98, 69, 75, 47, 89, 90, 100, 70 };
		bidBubbleSort(score2, 8);
	}

}
