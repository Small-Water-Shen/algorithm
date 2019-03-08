package dp;

/*
 * ��������Ϊn����������,��������n-1���������(��һ������)�г˻�����һ��
 * ע��! ������ָ�������,��n-1����Ϊһ��
 */
public class ����г˻�����һ�� {

	// �����ⷨ.ʱ�临�Ӷ�O(n^2)
	public static void violence(int[] arr) {
		int max = Integer.MIN_VALUE, cur;
		for (int i = 0; i < arr.length; i++) {
			cur = 1;
			for (int j = 0; j < arr.length; j++) {
				// ���ܳ˱���
				if (i != j) {
					cur *= arr[j];
				}
			}
			max = (max < cur) ? cur : max;
		}
		System.out.println(max);
	}
	
	// dfs. 
	public static void dfs(int[] arr, boolean[] vis, int n, int index) {
		// ѡ��n-1������,��ʼ����
		if (index >= n - 1) {
			int cur = 1;
			for (int i = 0; i < arr.length; i++) {
				if (vis[i]) {
					cur *= arr[i];
				}
			}
			max = (max < cur) ? cur : max;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				// dfs
				dfs(arr, vis, n, index + 1);
				// ����
				vis[i] = false;
			}
		}
	}
	
	/* ��̬�滮
	 * n-1����ϵ����˻���ת��Ϊn-2������������˻�.���ڵ�n-1����ѡ��ѡ
	 * dp[i]��ʾǰi���������˻�, ��ô��
	 * 1. n-1�����ĳ˻�������i����,���������:
	 * 		������i���������˻�: n-2���������˻� * ��i����
	 * 		������i��������С�˻�: n-2���������˻� * ��i����
	 * ΪʲôҪ������С�˻�,��Ϊ�и������������.���Կ�����С�˻�*��i�����������ֵ
	 * 2. n-1�����ĳ˻���������i����: n1 * n2 * ... * n-1
	 * ���� ������i���������˻�, ������i��������С�˻�, ��������i���������˻�  �������Ƚϴ�С 
	 * ��Ϊn-1�ĳ˻���Ҫn-2�ĳ˻�, �ݹ���ȥ���ǱȽ�n1 n2 n3�����˻�
	 */
	public static void DP1(int[] arr) {
		int max = arr[0], min = arr[1];
		int cur = arr[0];  // ��������i�����ĳ˻�
		for (int i = 2; i < arr.length; i++) {
			cur *= arr[i - 1]; // û�а�����i���ĳ˻�
			max *= arr[i];  // ������i�������ֵ�˻�
			min *= arr[i];  // ������i������Сֵ�˻�
			// �������,Сֵ
			if (min > max) {
				min ^= max;
				max ^= min;
				min ^= max;
			}
			max = (cur > max) ? cur : max;
			min = (cur < min) ? cur : min;
		}
		System.out.println(max);
		System.out.println(min);
	}
	
	/* �Կռ任ʱ��Ĳ���
	 * �趨����head[i]��ʾǰi������ĳ˻�, tail[i]��ʾ��n-i�����ĳ˻�
	 * ����: head[i] = head[i-1]*arr[i-1]
	 * 	    tail[i] = tail[i+1]*arr[i]
	 * ����s[i]Ϊ���˵�i��Ԫ������ĳ˻�
	 * ����: s[i] = head[i-1] * tail[i]
	 */
	public static void DP2(int[] arr, int n) {
		int[] head = new int[n];
		int[] tail = new int[n + 1];
		int[] s = new int[n + 1];
		head[0] = 1;
		tail[n] = 1;
		for (int i = 1; i < n; i++) {
			head[i] = head[i - 1] * arr[i - 1]; 
		}
		for (int i = n - 1; i >= 0 ; i--) {
			tail[i] = tail[i + 1] * arr[i]; 
		}
		for (int i = 1; i <= n; i++) {
			s[i] = head[i - 1] * tail[i]; 
		}
		int max = s[0];
		for (int i : s) {
			max = (max < i) ? i : max;
		}
		System.out.println(max);
	}
	
	/* ͨ������, ����n�����ĳ˻�ΪP,���P�������Խ��з���:
	 * PΪ0:
	 * 		n�����п϶���һ��0,����ȥ��.�õ�n-1�����ĳ˻�Q.��������Q��ֵ
	 * 		��QΪ0ʱ: �����п϶�������0,���Է���0
	 * 		��QΪ����ʱ: ����Q,�õ����ֵ
	 * 		��QΪ����ʱ: �����еĸ���Ϊ������,���Է���0������		
	 * PΪ����ʱ:
	 * 		ȥ����������С�������Ӷ��õ����ֵ
	 * PΪ����ʱ:
	 * 		�����еĸ���Ϊ������,���ݸ�������,ȥ��һ������ֵ��С�ĸ����Ӷ��õ����ֵ
	 */
	public static void analysis(int[] arr, int n) {
		int P = 1, zeroIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			P *= arr[i];
			// ��¼0���±�
			if (arr[i] == 0) {
				zeroIndex = i;
			}
		}
		// ȥ�����о���ֵ��С�ĸ���
		if (P < 0) {
			int negative = Integer.MIN_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0 && arr[i] > negative) {
					negative = arr[i];
				}
			}
			System.out.println(P * 1.0 / negative);
		} 
		// ȥ����������С������
		else if (P > 0) {
			int postive = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0 && arr[i] < postive) {
					postive = arr[i];
				}
			}
			System.out.println(P * 1.0 / postive);
		} 
		// PΪ0
		else {
			// ȥ�����е�0,�õ�n-1�ĳ˻�Q
			int Q = 1;
			for (int i = 0; i < arr.length; i++) {
				if (i != zeroIndex) {
					Q *= arr[i];
				}
			}
			// QΪ����ֱ�ӵõ����ֵ
			if (Q > 0) {
				System.out.println(Q);
			}
			// QΪ��������P��״̬(0)
			else if (Q < 0) {
				System.out.println(P);
			}
			// QΪ0ֻ��Ϊ0
			else {
				System.out.println(Q);
			}
		}
	}
	
	// *******************��չ****************************
	/* 
	 * ���޶���ϸ���.
	 * violence, �ӵ�һ������ʼ,���ÿ��������n-1�����ĳ˻�.
	 */
	public static void violence1(int[] arr) {
		int max = arr[0], cur;
		for (int i = 0; i < arr.length; i++) {
			cur = 1;
			for (int j = 0; j < arr.length; j++) {
				// ���ܳ˱���
				if (i != j) {
					cur *= arr[j];
					max = (max < cur) ? cur : max;
				}
			}
		}
		System.out.println(max);
	}
	/*
	 * ���޶���ϸ���.
	 * �ݹ�, ͬ������
	 */
	static int max = Integer.MIN_VALUE;

	public static void dfs1(int[] arr, boolean[] vis, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				// dfs
				dfs1(arr, vis, n);
				// ����
				vis[i] = false;
			}
		}
		// ѡ�������,��ʼ����
		int cur = 1;
		for (int i = 0; i < arr.length; i++) {
			if (vis[i]) {
				cur *= arr[i];
			}
		}
		max = (max < cur) ? cur : max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 6, -1, 5, -5 };
		// ���Բ��޶���ϸ���
//		int[] arr = { -4, 6, 0, 2, -7, 2 };
		// violence
		violence(arr);
		// dfs
		boolean[] vis = new boolean[arr.length];
		dfs(arr, vis, arr.length, 0);
//		dfs1(arr, vis, arr.length);
		System.out.println(max);
		// dp
		DP1(arr);
		// �ռ任ʱ��dp
		DP2(arr, arr.length);
		// ������
		analysis(arr, arr.length);
	}

}
