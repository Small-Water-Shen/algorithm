package violence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * ��������һ���ǳ��ɰ���Ů�������ܶ��к�׷�����������һ�����⡣��ĩ���Լ����������������˺��ٵ�ʱ�䡣
 * �������ͨ����������������һ���ǳ���Ľ̿����а���������֪ʶ�㡣����������һ����
 * �ý̿�������߶���Щ�뷨�ǳ����ޣ����һЩ�뷨��ֹһ�α����ǡ�
 * ��������Ϊ������跨���ٶ���һ������뷨�����Ϳ���ͨ�����ԡ�
 * ������ֻ�Ķ������һ���������֣����а��������������ǵ�����֪ʶ�㡣��Ȼ������Ӧ�����ܱ���
 * һ���ǳ�Ŭ���������к��Ѿ��ֶ�Ϊ����ÿһҳ�������Ľ̿��������������
 * ÿ��ҳ�涼��ʲô֪ʶ�㣬��������������������������Ӧ���Ķ��ĸ������Ĳ��֡�
 * Ϊ���������ÿ��֪ʶ�㶼��ID���룬ID��һ���Ǹ�������
 */
public class ֪ʶ�����������ҳ {
	
	/* ��ȡ��
	 * �Ȱ�����֪ʶ����hashSet������������map�ж��Ƿ��Ķ��ظ�֪ʶ�㣬
	 * ���һ��������������֪ʶ�㣬�����˵����ƣ�����С���䣬�Ҷ˵��ѹ̶�������ֻ�ܴ�����˵�
	 */
	public static int solve() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			set.add(arr[i]);
			map.put(arr[i], 0);
		}
		// solve
		int l = 0, r = 0, sum = 0, size = set.size(), res = Integer.MAX_VALUE;
		while (true) {
			while (r < n && sum < size) { // Ѱ�Ұ�������֪ʶ��ĳ���
				if (map.get(arr[r]) == 0) ++sum;
				map.put(arr[r], map.get(arr[r]) + 1);
				++r;
			}
			if (sum < size) break; // ������
			res = Math.min(res, r - l);
			// ��˵������ƶ��Լ��ٳ���, ��֪ʶ�����ʱ��sum����Ҳ��Ҫ-1
			map.put(arr[l], map.get(arr[l]) - 1);
			if (map.get(arr[l++]) == 0) --sum;
		}
		input.close();
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve());
	}

}
