package violence;

/*
 * ��ȡ�� (��Ч��ö��)
 * ��������Ϊn����������a0,a1,a2,a3 ..... an-1�Լ�����S��
 * ����ۺϲ�С��S�����������еĳ��ȵ���Сֵ������ⲻ���ڣ������0��
 */
public class ��С��S�����������е���С���� {

	/*
	 * ����ǰ����ĺ�С��S,���Ҷ˵������ƶ���Ѱ�Ҹ����ĳ���
	 * �����ڵ���S, ����˵������ƶ��Լ��ٳ���,
	 * ���⻹��ҪԤ��ͳ��ǰ׺��
	 */
	public static int solve(int[] arr, int S) {
		int l = 0, r = 0, sum = 0, res = Integer.MAX_VALUE, n = arr.length;
		while (true) {
			while (r < n && sum < S) sum += arr[r++]; // ����ǰ����ĺ�С��S,���Ҷ˵������ƶ���Ѱ�Ҹ����ĳ���
			if (sum < S) break; // ��������
			res = Math.min(res, r - l); // ȡ����
			sum -= arr[l++]; // ��˵������ƶ��Լ��ٳ���
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
		int S = 15;
		System.out.println(solve(arr, S));
	}


}
