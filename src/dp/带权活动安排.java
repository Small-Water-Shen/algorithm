package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * (extends �����)
 * �����ɸ������i����Ŀ�ʼ�����ʱ��ֱ���si,fi���֮�䲻�ܽ������ٰ�һ������Եõ�������Ϊwi
 * ���ܵõ����������
 * sample��
 * 3
 * 1 2 50
 * 0 4 60
 * 3 5 20
 * 70
 */
public class ��Ȩ����� {
	
	public static class campign {
		int start;
		int end;
		int value;
	}
	
	// sorted by value
	public static class mySort implements Comparator<campign>{

		@Override
		public int compare(campign o1, campign o2) {
			// TODO Auto-generated method stub
			return (o1.end > o2.end) ? 1 : -1 ;
		}
		
	}
	
	/*
	 * dp[i]��ʾ���һ��������iʱ����������
	 * c[i]��ʾ�뵱ǰ�i����������Ļ
	 * dp[i] = max(dp[c[i]]+w[i], dp[i-1])��j<i��fj<=si
	 */
	public static int DP(campign[] campigns, int n) {
		int[] dp = new int[n + 1];
		int[] c = new int[n + 1];
		// �Ȱ��ս���ʱ����������
		Arrays.sort(campigns, 1, n, new mySort());
		// ��ʼ��c����
		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j > 0; --j) {
				// �жϵ�ǰ��Ŀ�ʼʱ���Ƿ�����һ��Ľ���ʱ�佻��
				if (campigns[i].start >= campigns[j].end) {
					c[i] = j;
					break;
				}
				// c[i]=0����û�����ݵĻ
			}
		}
		for (int i = 1; i <= n; i++) {
			// ��һ�����ݵĻ������+��ǰ���������һ״̬�Ƚ�
			dp[i] = Math.max(dp[c[i]] + campigns[i].value, dp[i - 1]); 
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		campign[] campigns = new campign[n + 1];
		for (int i = 1; i <= n; i++) {
			campigns[i] = new campign();  // initialize
			campigns[i].start = input.nextInt();
			campigns[i].end = input.nextInt();
			campigns[i].value = input.nextInt(); 
		}
		System.out.println(DP(campigns, n));
		input.close();
	}

}
