package array;

import java.util.Arrays;

/*
 * ���������Ϊ�����λ����(MSD)�����λ����(LSD)
 * ʱ�临�ӶȺͿռ临�Ӷȶ���O(n)
 */
public class �������� {
	
	/*
	 * ����������: 75, 87, 68, 92, 88, 61, 77, 96, 80, 72
	 * distribu 0 : 80       collection 0 : 1
	 *          1 : 61                  1 : 2
	 *          2 : 72 92               2 : 4
	 *          3 :                     3 : 4
	 *          4 :          =>         4 : 4
	 *          5 : 75                  5 : 5
	 *          6 : 96                  6 : 6
	 *          7 : 77 87               7 : 8
	 *          8 : 88                  8 : 9
	 *          9 :                     9 : 9
	 */
	public static void radixSort(int[] arr, int len) {
		// TODO Auto-generated method stub
		int max = getMax(arr); // �õ����ֵ��Ϊ�˻�����λ��
		// ��exp=1��ʾ����"��λ"������a��������10��ʾ����"ʮλ"������a��������100��ʾ����"��λ"������a��������
		int exp = 1; // MSD
		int[] temp = new int[len]; // �洢ÿ������������ʱ�ռ�
		int[] counter = new int[10]; // ʮ����һ��10λ������ʮ��������
		while (max / exp > 0) {
			Arrays.fill(counter, 0); // initialize
			// ���䣺����Ӧ�����ַŵ�Ͱ
			for (int i = 0; i < len; i++) {
				counter[reflect(arr[i], exp)]++;
			}
			// �ռ������㵱ǰ�������ڵĴ�Сλ��
			for (int i = 1; i < len; i++) {
				counter[i] += counter[i - 1]; 
			}
			/*  ���յ�ǰ������С����������ʱ�ռ䣬ΪʲôҪ-1?
			 *  ������80�����Ķ�Ӧ��������ֵΪ1,����0����С�ģ�
			 *  Ӧ���ڵ�һλ����Ҫ-1�����±�λ��
			 *  Ϊʲô�������? ��Ϊ��һ��������Ѿ���������ǰһλ�����������
			 *  ����6 : 61 68, counter[6]=2, �����˳������Ļ���
			 *  �Ȼ������61,��ʱ�±�Ϊ2-1=1,��ŵ��ڶ�С��λ�ã�����ɲ��ȶ��ԡ�
			 */
			for (int i = len - 1; i >= 0; --i) {
				temp[--counter[reflect(arr[i], exp)]] = arr[i];
			}
			// ������õĸ�ֵ��ԭ����
			for (int i = 0; i < len; i++) {
				arr[i] = temp[i]; 
			}
			System.err.println(Arrays.toString(arr));
			exp *= 10; // ȡ��һλ
		}
	}

	// ӳ�亯��
	public static int reflect(int number, int exp) {
		return (number / exp) % 10;
	}
	
	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int i : arr) max = (max < i) ? i : max; 			
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 75, 87, 68, 92, 88, 61, 77, 96, 80, 72 };
		radixSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
