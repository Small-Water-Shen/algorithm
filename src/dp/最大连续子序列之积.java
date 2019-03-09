package dp;

/**
 * ����K��������������{ N1, N2, ..., NK }�����������������пɱ�ʾΪ{ Ni, Ni+1, ..., Nj }��
 * 
 * ���� 1 <= i <= j <= K�������������������������������Ԫ�ػ�����һ����
 * 
 * �����������{ -2.5, 4, 0, 3, 0.5, 8, -1 }�����������������Ϊ{ 3, 0.5, 8 }�����Ϊ12��
 *
 */

public class �������������֮�� {

	// 2��forѭ��ɨ��
	public static void violenct(double[] arr, int n) {
		double max = arr[0], cur;
		for (int i = 0; i < n; i++) {
			cur = 1;
			for (int j = i; j < n; j++) {
				cur *= arr[j];
				max = Max(max, cur);
			}
		}
		System.out.println(max);
	}
	
	/*
	 * dp[i]��ʾ��i��β��������֮��
	 * i�ȿ�����Ϊ��һ�����е�����,Ҳ������Ϊ�����еĿ�ʼ
	 * ��̬ת�Ʒ���: dp[i] = max(dp[i-1]*arr[i], arr[i])
	 */
	public static void DP1(double[] arr) {
		double max = arr[0], cur = 1;
		int start = 0, end = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cur > 0) {
				cur *= arr[i];
			} else {
				cur = arr[i];
				start = i;
			}
			if (max < cur) {
				max = cur;
				end = i;
			}
		}
		System.out.println(max);
		System.out.println("start with index: " + (start + 1) + "\t" + "end with index: " + (end + 1));
	}
	
	public static double Max(double a, double b) {
		return (a > b) ? a : b;
	}

	public static double Min(double a, double b) {
		return (a < b) ? a : b;
	}
	
	/* 
	 * dp ͬʱ�������, ��С������
	 * ��maxEnd,minEnd�����i��β�������С��
	 */
	public static void DP2(double[] arr) {
		double maxEnd = arr[0], minEnd = arr[0];
		double max = arr[0], min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			double end1 = maxEnd * arr[i];
			double end2 = minEnd * arr[i];
			maxEnd = Max(arr[i], Max(end1, end2));
			minEnd = Min(arr[i], Min(end1, end2));
			max = Max(max, maxEnd);
			min = Min(min, minEnd);
		}
		System.out.println(max);
		System.out.println(min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
		violenct(arr, arr.length);
		DP1(arr);
		DP2(arr);
	}

}
