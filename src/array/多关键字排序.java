package array;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ���� n ��ѧ����ѧ��(�� 1 �� n ���)�Լ����ǵĿ��Գɼ�����ʾΪ(ѧ�ţ����Գɼ�)���뽫��Щѧ�������Գɼ��������������Գɼ���ͬ����ѧ����������
 * ����: array = [[2,50],[1,50],[3,100]]
 * ���: [[3,100],[1,50],[2,50]]
 */
public class ��ؼ������� {

	public static int[][] multiSort(int[][] array) {
		// Write your code here
//		sort(array, 0, array.length - 1);
		// rewrite comparator
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] != o2[1]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		return array;
	}

	// ����,�Ȱ��ɼ�����,�ɼ�����ٰ�ѧ������
	public static void sort(int[][] array, int left, int right) {
		// TODO Auto-generated method stub
		if (left >= right)
			return;
		int i = left, j = right;
		int[] r = array[left];
		while (i < j) {
			while (i < j) {
				// �Ȱ��ɼ�����
				if (r[1] > array[j][1]) {
					--j;
				} 
				// �ɼ���Ȱ�ѧ������
				else if (r[1] == array[j][1] && r[0] < array[j][0]) {
					--j;
				} else {
					break;
				}
			}
			if (i < j)
				array[i++] = array[j];
			while (i < j) {
				if (r[1] < array[i][1]) {
					++i;
				} else if (r[1] == array[i][1] && r[0] > array[i][0]) {
					++i;
				} else {
					break;
				}
			}
			if (i < j)
				array[j--] = array[i];
		}
		array[i] = r;
		sort(array, left, i - 1);
		sort(array, i + 1, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] { { 2, 50 }, { 1, 50 }, { 3, 100 } };
		multiSort(arr);
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

}
