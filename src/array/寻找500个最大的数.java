package array;

import java.util.Arrays;

/*
 * ��20������,ÿ����������500����,��������,���10000��������500��
 * */

public class Ѱ��500�������� {
	
	// �򻯰�: 5������,ÿ��������10����,�ҳ�����10����
	static int[][] data = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 45, 47 },
			{ 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
			{ 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
			{ 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
			{ 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 }
			};
	static int len = data[0].length - 1, pos = 0;
	static int[] label = {len, len, len, len, len};
	static int[] temp = new int[5];
	static int[] result = new int[10];
	
	// swap
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j]; 
		arr[j] = t; 
	}
	
	// ������СΪ5������,��ά��
	public static void CreateHeap(int[] arr, int n) {
		/* �����һ����Ҷ�ӽڵ㿪ʼ
		 * ���ʼ��Ϊ: 47 20 30 40 50
		 * ���ѽṹΪ:      47
		 *               20    30
		 *            40   50
		 * �������һ����Ҷ�ӽڵ�Ϊ: n/2-1
		 * */
		int i = n / 2 - 1, j;
		// �����һ����Ҷ�ӽڵ㵽���ڵ�
		for (int k = i; k >= 0; k--) {
			i = k;
			// ��ǰ�ڵ�����ӽڵ�
			j = 2 * i + 1;
			while (j < n) {
				// �ӵ�ǰ�ڵ�����������ӽڵ���ѡһ������
				if (j + 1 < n && arr[j] < arr[j + 1]) {
					j++;
				}
				// ���ڵ�������ӽڵ�Ƚ�
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
					i = j;
					j = 2 * i + 1;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = (max < arr[i]) ? arr[i]: max; 
		}
		return max;
	}
	
	/*
	 * ����,�������ÿ�������������,���Դ�ÿ��������ѡȡ���Ե����ֵ,�õ�����arr,arr������10��Ԫ��
	 * ���arr��������ֵ,���ҳ������ֵ��Դ����,�õ�Դ����Ĵ����ֵ,����arr���������������ֵ
	 * arr�����ֵ������ð��,ѡ��,��������,���ǻ����������������,ʱ�临�Ӷ�O(n^2),
	 * ������ֻ��Ҫ���arr�����ֵ,��������,����뵽������,�������ѿ���������ֵ,ʱ�临�Ӷ�O(logn)
	 * ���ǵ�Ҳ������getMax�������arr�����ֵ,ʱ�临�Ӷ�O(n),���������ѵķ����ȽϿ�
	 * �Ƚ�ÿ����������ֵ(����)��������,Ҫ��Ǹ������ֵ�����Ǹ�����,
	 * ȡ�����ѵĶѶ�Ԫ��(��ʱ��������������,�����жѶ����ֵ),����result�����,���ҵ����ֵԪ�ص�Դ����,Ѱ��������ֵ��������
	 * �ظ�10�μȿ������,��ˣ�ʱ�临�Ӷ��ǣ�O(500logn)
	 * */
	public static void findMax() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				// ȡ��ÿ����������ֵ
				temp[j] = data[j][label[j]]; 
			}
			CreateHeap(temp, 5);
			// ȡ���ѵ����ֵ��������
			int max = temp[0];
//			int max = getMax(temp);
			result[pos++] = max;
			// Ѱ�����ֵ���ڵ�����Ĵ����ֵ
			for (int k = 0; k < 5; k++) {
				int p = label[k];
				// �ҵ������ֵ
				if (max == data[k][p]) {
					// ����label
					label[k]--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMax();
	}

}
