package divide_and_conquer;

import java.util.*;

public class �����С���� {

	/*
	 * ��ҵ�ϰ���һ����飬��Ҫ������ѡ���ص�һ����������Ա���� ��ѡ�����һ���һλ��ͨԱ�����������ʵ���Ǵ�n��Ԫ���в������ֵ����Сֵ��
	 */

	// ��ͨ����
	public static void genate(int[] arr) {
		int max = arr[0], min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		System.out.println("max: " + max + "\nmin: " + min);
	}

	// ���η�
	static class MaxMin{
		
		private int max;
		private int min;
		
		public MaxMin(int max, int min) {
			this.max = max;
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}
	}

	public static MaxMin dc(int[] arr, int low, int high) {
		// �ѳɹ��ֳ�����Ԫ�ص�һ��
		if (high - low <= 1) {
			int max, min;
			if (arr[high] > arr[low]) {
				max = arr[high];
				min = arr[low];
			} else {
				min = arr[high];
				max = arr[low];
			}
			return new MaxMin(max, min);
		} 
		// ���Էֳɶ���
		else {
			int mid = (low + high) / 2;
			MaxMin left = dc(arr, low, mid);
			MaxMin right = dc(arr, mid+1, high);
			// �����еĸ��Ե������Сֵ�Ƚ�
			int max = (left.getMax() < right.getMax()) ? right.getMax(): left.getMax();
			int min = (left.getMin() < right.getMin()) ? left.getMin() : right.getMin();
			return new MaxMin(max, min);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100000;
		int[] arr = new int[n];
		// random for values
		Random random = new Random();
		for(int i=0;i<n;i++) {
			arr[i] = random.nextInt(n);
		}
//		genate(arr);
		MaxMin mm = dc(arr, 0, n-1);
		System.out.println(mm.getMax());
		System.out.println(mm.getMin());
	}

}
