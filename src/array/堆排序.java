package array;

import java.util.Arrays;

public class ������ {
	
	/*
	 * ˼·������ÿ�ν������Ѻ���Ԫ�������ģ������Ԫ�طŵ�arr�����һ��λ�ã�����˴�������ֵ����
	 */
	public static void HeapSort(int[] arr, int len) {
		for (int i = len; i > 1; --i) {
			createHeap1(arr, 0, i); // ��������
			swap(arr, 0, i - 1); // �����Ԫ�طŵ����һ��λ��
		}
	}
	
	/* �������ѣ�
	 * �����һ����Ҷ�ӽڵ㿪ʼ
	 * ���ʼ��Ϊ: 47 20 30 40 50
	 * ���ѽṹΪ:     47            50
	 *               20   30  =>   47    30
 	 *             40  50        40  20   
	 * �������һ����Ҷ�ӽڵ�Ϊ: n/2-1
	 * */
	public static void createHeap(int[] arr, int root, int len) {
		int j, i = len / 2 - 1; // ���һ����Ҷ�ӽڵ�
		// �����һ����Ҷ�ӽڵ㵽root�ڵ�
		for (int k = i; k >= root; --k) {
			i = k;
			j = 2 * i + 1; // left child of root
			// ����ǰ���ڵ��µ����нڵ�
			while (j < len) {
				if (j + 1 < len && arr[j] < arr[j + 1]) ++j; // the biggest child
				// root compare with the biggest child
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
					// ����������ӽڵ��˳���С�ᱻ�ƻ����������±���
					i = j;
					j = 2 * i + 1;
				} else break;
			}
		}
	}
	
	/* Do not use swap function
	 * ����:(temp=2)
	 *       2         5         5         5
	 *     5  1  =>  5  1  =>  4  1  =>  4   1
	 *    3 4       3 4       3 4      3   2
	 */
	public static void createHeap1(int[] arr, int root, int len) {
		int j, i = len / 2 - 1; // ���һ����Ҷ�ӽڵ�
		// �����һ����Ҷ�ӽڵ㵽root�ڵ�
		for (int k = i; k >= root; --k) {
			i = k;
			int temp = arr[k]; // record the value of current root
			j = 2 * i + 1; // left child of root
			// ����ǰ���ڵ��µ����нڵ�
			while (j < len) {
				if (j + 1 < len && arr[j] < arr[j + 1]) ++j; // the biggest child
				// root compare with the biggest child
				if (temp < arr[j]) {
					arr[i] = arr[j]; // ����ӽڵ��Ƶ�˫�׽ڵ��� 
					// ����������ӽڵ��˳���С�ᱻ�ƻ����������±���
					i = j;
					j = 2 * i + 1;
				} else break;
			}
			arr[i] = temp; 
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j]; 
		arr[j] = t; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 47, 20, 30, 40, 50 };
		HeapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
