package array;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * ������������ n �� sum��������1��2��3.......n �� ����ȡ������,
 * ʹ��͵��� sum ,Ҫ���������еĿ�������г�����
*/
public class Ѱ�Һ�Ϊ��ֵ�Ķ���� {

	static int n, sum;
	static int[] arr;
	static LinkedList<Integer> result;

	public static void initialize() {
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		result = new LinkedList<>();
	}

	/*
	 * 01��������(��̬�滮) �����Ƿ�ȡ��n����: ��ȡ, ����ת��Ϊ"ȡǰn-1����,ʹ�����ǵĺ�Ϊsum-n" ����ȡ,
	 * ����ת��Ϊ"ȡǰn-1����,ʹ�����ǵĺ�Ϊsum"
	 */
	public static void sumOfNumber1(int cur_sum, int n) {
		if (cur_sum < 0 || n < 0) {
			return;
		}
		if (cur_sum == 0) {
			// ��ӡ����
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		// ȡ, ����ת��Ϊ"ȡǰn-1����,ʹ�����ǵĺ�Ϊsum-n"
		result.push(n);
		sumOfNumber1(cur_sum - n, n - 1);
		// ��ȡ, ����ת��Ϊ"ȡǰn-1����,ʹ�����ǵĺ�Ϊsum"
		result.pop();
		sumOfNumber1(cur_sum, n - 1);
	}

	public static void sumOfNumber2(int cur, int k, int sumOfn, boolean flag, boolean[] vis) {
		// ѡ��k����
		vis[k] = true; 
		// �ҵ���
		if (cur + k == sum) {
			flag = true;
			for (int i = 1; i <= k; i++) {
				if (vis[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		} else {
			// 
			if (cur + k + (k + 1) <= sum) {
				sumOfNumber2(cur + k, k + 1, sumOfn - k, flag, vis);
			}
			// 
			if ((cur + sumOfn - k >= sum) && (cur + (k + 1) <= sum)) {
				vis[k] = false; 
				sumOfNumber2(cur, k + 1, sumOfn - k, flag, vis);
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		sum = input.nextInt();
		initialize();
		// �ⷨһ
//		sumOfNumber1(sum, n);
		// �ⷨ��
		boolean flag = false;
		boolean[] vis = new boolean[n + 1];
		int sumOfn = (1 + n) * n / 2; // ����1~n֮��
		if (1 > sum || sumOfn < sum) {
			System.out.println("Not found");
			System.exit(0);
		}
		sumOfNumber2(0, 1, sumOfn, flag, vis);
		if (!flag) {
			System.out.println("Not found");
			System.exit(0);
		}
		input.close();
	}

}
