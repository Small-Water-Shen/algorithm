package string;

/* 
 *  �ַ������������
 *  'ab' -> 'a' 'b' 'ab'
 *  'abc' -> 'a' 'b' 'c' 'ab' 'ac' 'bc' 'abc'
 *  �� 2^n-1 ��
 * */

public class All_combination {

	public static void my_sort(char[] s) {
		if (s == null) {
			return;
		}
		for (int i = 1; i <= s.length; ++i) {
			all_sort(s, "", 0, i);
			System.out.println();
		}
	}

	public static void all_sort(char[] s, String t, int index, int len) {
		if (len <= 0) {
			System.out.print(t + " ");
			return;
		}
		// ���ʹ��ȫ��Ԫ�ص����ֻ��һ��
		if (index >= s.length) {
			return;
		}
		all_sort(s, t + s[index], index + 1, len - 1);
		all_sort(s, t, index + 1, len);
	}

	// ʹ��λ�����Ż�
	// 'abc' �޷��Ƕ�Ӧ�Ķ����� : 111
	// ��, 100 -> a, 010 -> b, 001 -> c, 110 -> ab ...
	public static void binary_sort(char[] s) {
		int len = s.length;
		int count = (int) (Math.pow(s.length, 2) - 1);
		for (int i = 0; i < count; ++i) {
			String temp = "";
			// תΪ������
			String num = Integer.toBinaryString(i);
			// ��0λ
			while (num.length() < len) {
				num = "0" + num;
			}
			// �滻01Ϊ�ַ�
			for (int j = 0; j < len; ++j) {
				if (num.charAt(j) == '1') {
					temp += s[j];
				}
			}
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		my_sort("abcdef".toCharArray());
//		binary_sort("abc".toCharArray());
	}

}
