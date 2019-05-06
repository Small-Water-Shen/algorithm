package violence;

import java.util.Scanner;

/*
 * ����һ������Ϊ n �� 01 ��S�������ִ����� m �β�����
 * ����ÿ�β����������ѡ��һ��λ�� i ���� 1��i��n����ת��һλ��ֵ��0���1��1���0��
 * ����һ�� 01 ���ļ�ֵΪ���������0�ĸ����������1�ĸ����Ľϴ�ֵ����S�ھ������m�β����������ֵ��
 * ��������:
 * ��һ��һ������ T ����ʾ�������� T ��������
 * ��������n,m����ʾS���ĳ���n�Ͳ�������m������1<=n<=100000��0<=m<=1000��
 * ����������һ������Ϊn���ַ���S��
 * �������:
 * һ����������ʾ����������������ֵ��
 */
public class ��01������ֵ {
	
	public static void violence() {
        Scanner input = new Scanner(System.in);
        int T, n, m, p, l, r, lm, rm, cnt, max;
        T = input.nextInt();
        while (T-- > 0) {
        	n = input.nextInt();
        	m = input.nextInt();
        	char[] cs = input.next().toCharArray();
        	p = 0; max = 0;
        	while (p < n) {
				l = p; lm = m; cnt = 1;
				while (--l >= 0) {
					if (cs[p] != cs[l] && lm == 0) break;
					if (cs[p] != cs[l] && lm > 0) --lm;
					++cnt;
				}
				max = (cnt > max) ? cnt : max;
				r = p; rm = m; cnt = 1;
				while (++r < n) {
					if (cs[p] != cs[r] && rm == 0) break;
					if (cs[p] != cs[r] && rm > 0) --rm;
					++cnt;
				}
				max = (cnt > max) ? cnt : max;
				++p;
			}
        	System.out.println(max);
        }
		input.close();
	}
	
	public static void prefix() {
        Scanner input = new Scanner(System.in);
        int T, n, m;
        T = input.nextInt();
        while (T-- > 0) {
        	n = input.nextInt(); m = input.nextInt();
        	char[] t = input.next().toCharArray();
        	// �±��1��ʼ
        	char[] cs = new char[n + 1];
        	for (int i = 1; i <= n; i++) cs[i] = t[i - 1]; 				
        	int[] pre0 = new int[n + 1];
        	int[] pre1 = new int[n + 1];
        	for (int i = 1; i <= n; i++) {
        		if (cs[i] == '0') {
					pre0[i] = pre0[i - 1] + 1;
					pre1[i] = pre1[i - 1]; 
				} else {
					pre0[i] = pre0[i - 1];
					pre1[i] = pre1[i - 1] + 1;
				}
			}
//        	System.out.println(Arrays.toString(pre0) + "\n" + Arrays.toString(pre1));
        	System.out.println(binaryFind(pre0, pre1, 0, n, n, m));
        }
		input.close();
	}
	
	// ���ֲ���
	public static int binaryFind(int[] pre0, int[] pre1, int l, int r, int n, int m) {
    	int res = 0, mid;
    	while (l <= r) {
			mid = (l + r) >> 1;
    		if (judge(pre0, pre1, mid, n, m)) {
				res = mid; // �õ���ǰ���������ļ�ֵ����
				l = mid + 1; // �ɼ������������չ
			} else {
				r = mid - 1; // ��С����
			}
		}
    	return res;
	}
	
	// split windows with length of len (��ȡ��)
	public static boolean judge(int[] pre0, int[] pre1, int len, int n, int m) {
		// 
		int l = 0;
		while (len <= n) {
			if (pre0[len] - pre0[l] <= m || pre1[len] - pre1[l] <= m) return true;
			++len;
			++l;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		violence();
		prefix();
	}

}
