package array;

import java.util.Arrays;

/*
 * ����һ����n�����󣨰���k�ֲ�ͬ����ɫ��������1��k���б�ţ������飬
 * ��������з���ʹ��ͬ��ɫ�Ķ������ڣ�������1,2��...k��˳���������
 * ����ʹ�ô�����е�������������������, k <= n
 * ����colors=[3, 2, 2, 1, 4]��k=4, ��Ĵ���Ӧ����ԭ�ز���ʹ��������[1, 2, 2, 3, 4]
 */
public class ����ɫ2 {

	public static void sortColors2(int[] colors, int k) {
		// write your code here
//    	countSort(colors, k);
		quickSort(colors, 0, colors.length - 1, 1, k);
	}

	// ���ţ�����Ϊ��ǰk���м���
	public static void quickSort(int[] colors, int low, int high, int start, int end) {
		if (low >= high || start >= end) return;
		int i = low, j = high, midColor = (start + end) >> 1;
		while (i < j) {
			while (i < j && midColor >= colors[i]) ++i;
			while (i < j && midColor < colors[j]) --j;
			if (i < j) {
				int t = colors[i];
				colors[i++] = colors[j];
				colors[j--] = t;
			}
		}
		quickSort(colors, low, i, start, midColor);
		quickSort(colors, i, high, midColor + 1, end); // mid��Ҫ+1
	}

	// countSort
	public static void countSort(int[] colors, int k) {
		// find counts of 1..k
		int[] counter = new int[k + 1];
		for (int i = 0; i < colors.length; i++) counter[colors[i]]++;
		// covering the colors
		int pos = 0;
		for (int i = 1; i <= k; i++) {
			for (int j = counter[i]; j > 0; --j) {
				colors[pos++] = i;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] colors = new int[] { 4,2,1,4,4,4,1,4,2,1,2,4,4,5,3,2,5,5,5,3,2,1,4,2,3,2,4,3,2,5 };
		sortColors2(colors, 5);
		System.out.println(Arrays.toString(colors));
	}

}
