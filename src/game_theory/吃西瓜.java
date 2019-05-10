package game_theory;

import java.util.Scanner;

/*
 * ��ACM����ټ�ѵ��ĳһ�죬ʵ��������n���ˡ���Ϊ�������ȣ���Ҷ���������ϡ�
 * ����Eric����m�������õ���ʵ���ҡ�Eric����n���˷ֱ���Ϊ1,2,3...n,��ϣ����n����ѭ�������������ϡ�
 * Ҳ����˵��1�ſ�ʼ��Ȼ��2�ţ�3��...n�����γ����ϣ�n�ų�������ֵ�1�����ԣ�ֱ����m�����ϱ����ꡣ 
 * ����n����ÿ������һ������ֵ����i���˵Ķ���ֵΪai�� 
 * lililalala����n���˶���ֵ�����ˣ�������ˣ������ǳ�̰�ԣ�ÿ���ֵ���������ʱ������ֱ�ӳԵ���ͬ�����Ķ���ֵ���������ϡ�
 * ���ʣ��������Ѿ��������ˣ���ô�������������ֱ�ӳ��ꡣ(�ǵ������ܳ�) 
 * ����lililalala�����������,���ڵ�i��ÿ�γ����Ͽ���ѡ��Ե�[1,ai]�������������������ϡ�
 * ��Ȼ�����ܳ�����ǰʣ�������������Ϊ��ʹ�����ϸ�����˼һЩ��Eric�涨������ֵ�ĳ���˳�����ʱû�������ˣ�
 * ��ô��������ɨһ��ʵ���ҡ�(�ǵĴ�Ҷ����ܳ�)�����˶�����lililalala�Ե�̫����Ӧ����������ɨ������
 * �����������˴�ͨ�õ�������ܷ������ÿ���˵��ж�ʹ�ó������Ϻ���lililalala����ɨ����?
 * ��֤���������ж���������ֻ��һ�����������lililalala�� 
 */
public class ������ {
	
	static long n, m, maximum;
	static long[] arr;
	
	/* ��Ŀֻ��Ҫ�����ͨ�õ�������ܷ������ÿ���˵�ʹ��lililalala��ɨ������Ҫ������巽����
	 * ��"����lililalala�����������,���ڵ�i��ÿ�γ����Ͽ���ѡ��Ե�[1,ai]��������������������"���֣�
	 * ���������˶������Ķ��������ϣ������lililalala��ʱ��û��ʣ���ˣ�˵���Ϳ��Ժϻ�㶨����
	 * ���������˶���1�Ķ��������ϣ�����û��lililalala���Ѿ�������˵�����ܸ㶨����
	 * ���������[L,R]�ڴ������еİ��ţ���ʼL=R=m, L��ʾ����1�Ķ��������ϣ�R�������Ķ���������
	 * ���ڷǶ��������ˣ�Lÿ�μ���1, Rÿ�μ���ai�����ڶ��������ˣ�L��Rÿ�ζ�����max
	 */
	public static boolean reasoning() {
        if (n == 1) return true;
        int p = 0;
        long L = m, R = m;
        boolean canDraw = false;
        while (true) {
            if (arr[p] == maximum) {
                if (R <= 0) {
                    canDraw = true;
                    break;
                }
                L -= maximum;
                R -= maximum;
            } else {
                if (L <= 0) break;
                --L;
                R -= arr[p];
            }
            p = (p + 1 >= n) ? 0 : p + 1;
        }
        return canDraw;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			n = input.nextLong();
			m = input.nextLong();
			arr = new long[(int) n];
			maximum = arr[0];
			for (int i = 0; i < n; i++) {
				arr[i] = input.nextLong();
				maximum = Math.max(arr[i], maximum);
			}
			System.out.println(reasoning() ? "YES" : "NO");
		}
		input.close();
	}

}
