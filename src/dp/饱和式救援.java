package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * �ڡ����˵��򡷵�Ӱ�У���˵������ľ��֮���ƶ��˵����뿪ľ�ǣ����Ǵ�ը�ݻ��˵����ϴ󲿷ֵ����Ƿ�������
 * ������һ��չ��ȫ���Ծ�Ԯ����ʱ��MOSS�Ѿ����ջ٣����ڸ�����ÿֻ��Ԯ�ӵ�Ŀ�귢�����ı���Լ���ֻ��Ԯ���ڹ涨ʱ���ڳɹ���Ԯ�ĸ��ʣ�
 * ����������k�����Ƿ������ܹ��õ�����������Ϊ����ᱻ���ȡ��������һ�����򣬰����������������㡣
 * ��������:
 * ��һ�и���N��M��K��N���������ɳ��ľ�Ԯ��������M�����ݻٵ����Ƿ�������K����������Ҫ���������Ƿ�����������(1<=N<=1e5,K<=M<=2000)
 * ������N�У�ÿ�и���ai,pi���ֱ�����i֧��Ԯ�ӵ�Ŀ�귢�����ı����ai����Ԯ�ɹ��ĸ���Ϊpi��(1<=ai<=M,0<=pi<=1)
 * ֻҪ��һֻ��Ԯ��˳���ִ�����Ƿ�����������Ϊ�÷��������ɹ�������
 * �������: ������򱻾�Ԯ�ɹ��ĸ��ʣ����ϸ���3λС����
 * ����
 * 3 2 2
 * 1 1
 * 1 1
 * 2 0.5
 * ��� 0.500
 */
public class ����ʽ��Ԯ {
	
	static int n, k, m;
	static pair[] teams = new pair[100005];

	public static class pair {
		int num;
		float odd;
		public pair(int num, float odd) {
			this.num = num;
			this.odd = odd;
		}
	}
	
	public static void solve() {
		if (k == 0) {
			System.out.println("1.000");
			return;
		}
		Arrays.sort(teams, 1, n + 1, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				if (o2.odd > o1.odd) return 1;
				return -1;
			}
		});
		for (int i = 1; i <= n; i++) System.out.println(teams[i].num + " " + teams[i].odd);
		Map<Integer, Float> map = new HashMap<Integer, Float>();
		for (int i = 1; i <= n; i++) {
			pair cur = teams[i];
			if (!map.containsKey(cur.num) ||
					map.containsKey(cur.num) && map.get(cur.num) < cur.odd) {
				map.put(cur.num, cur.odd);
			}
			if (map.size() >= k) break;
		}
		System.out.println(map.toString());
		if (map.size() < k) System.out.println("0.000");
		else {
			float res = 1;
			for (float v : map.values()) res *= v;				
			System.out.println(String.format("%.3f", res));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		for (int i = 1; i <= n; i++) teams[i] = new pair(input.nextInt(), input.nextFloat()); 
		solve();
		input.close();
	}

}
