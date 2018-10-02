package string;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * �����ַ���a, b , �ж�a�Ƿ����b
 * ��: a="abcd" b="dcb" True
 *     a="abcd" b="edc" False
 *     a="abcd" b="aa" True
 * */
public class String_Contain {

	// ����, ʱ�临�Ӷ� O(mn)
	public static boolean contain1(String a, String b) {
		for (int i = 0; i < b.length(); i++) {
			for (int j = 0, len = a.length(); (j < len) && (b.charAt(i) != a.charAt(j)); j++) {
				if (j >= len) {
					return false;
				}
			}
		}
		return true;
	}

	// �ȶ��ַ�������, �ٱȽ�, ʱ�临�Ӷ�: ����+O(m+n)
	public static boolean contain2(String a, String b) {
		// ����
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		// �Ƚ�
		for (int pa = 0, pb = 0, len1 = c1.length, len2 = c2.length; pb < len2;) {
			// ʹ pa == pb
			while (pa < len1 && c1[pa] < c2[pb]) {
				++pa;
			}
			// ��ֹ���
			if (pa >= len1 || c1[pa] > c2[pb]) {
				return false;
			}
			// pb����,�����Ƚ�
			++pb;
		}
		return true;
	}

	// ������, ��a�е�ÿ����ĸ���϶�Ӧ������, bͬ��,
	// Ȼ��a��˵õ�����������b����ĸ��Ӧ������, ��������false
	// ������ĸ̫�Ի���ɳ�����Χ
	public static boolean contain3(String a, String b) {
		int[] table = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101 };
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		// a���
		int sum = 1;
		for (int i = 0; i < c1.length; i++) {
			int index = c1[i] - 'a';
			sum *= table[index];
		}
		// b�е���ĸ��Ӧ��������sum, ������˵��������
		for (int j = 0; j < c2.length; j++) {
			if (sum % (table[c2[j] - 'a']) != 0) {
				return false;
			}
		}
		return true;
	}

	// λ����, ��������a����ĸ��ȥ'a'�õ�������t, ��h��¼a��ר��ǩ��, �� h |= t
	// ���õ���h, ��b��ÿ����ĸ��ȥ'a'�õ�������q, �� h & q, ������Ϊ0��false
	public static boolean contain4(String a, String b) {
		int hash = 0;
		for (int i = 0; i < a.length(); i++) {
			hash |= (1 << (a.charAt(i) - 'a'));
		}
		for (int j = 0; j < b.length(); j++) {
			if ((hash & (1 << (b.charAt(j) - 'a'))) == 0) {
				return false;
			}
		}
		return true;
	}

	// ���ֵ��в���Ŀ����ֵ��ַ���
	// ��: gcc -> cgc
	public static ArrayList<String> judge_brother(String[] a, String b) {
		ArrayList<String> result = new ArrayList<>();
		int len_b = b.length();
		for (int i = 0; i < a.length; ++i) {
			// ��֦, �ų����Ȳ�һ���ַ���
			if(len_b == (a[i].length())) {
				// ����
				char[] c1 = a[i].toCharArray();
				char[] c2 = b.toCharArray();
				Arrays.sort(c1);
				Arrays.sort(c2);
				if(String.valueOf(c1).equals(String.valueOf(c2))) {
					result.add(a[i]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		System.out.println(contain4("bbc", "a"));
		System.out.println(judge_brother(new String[] { "abcd", "ccg", "cgc" }, "gcc"));
	}
}
