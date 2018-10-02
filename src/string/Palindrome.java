package string;

/*
 * aba baab
 * ��������ַ���
 * */
public class Palindrome {

	public static int huiwen(char[] s) {
		int max = 0;
		for (int i = 0, len = s.length; i < len; ++i) {
			// ����
			for (int j = 0; (i - j) >= 0 && (i + j) < len; ++j) {
				if (s[i - j] != s[i + j]) {
					break;
				}
				int l = 2 * j + 1;
				max = (max < l) ? l : max;
			}
			// ż��
			for (int j = 0; (i - j) >= 0 && (i + j + 1) < len; ++j) {
				if (s[i - j] != s[i + j + 1]) {
					break;
				}
				int l = 2 * j + 2;
				max = (max < l) ? l : max;
			}
		}
		return max;
	}

	// manacher �㷨
	// ��ż�����ַ���ת��Ϊ����, �������
	// ��ÿ���ַ������Ҳ��������ַ�����
	public static int manacher(char[] s) {
		// �Ȳ����ַ�'#'
		int len = s.length;
		int max_len = len << 2 + 1;
		char[] s_new = new char[max_len];
		s_new[0] = '@';
		for (int i = 1; i <= 2 * len; i += 2) {
			s_new[i] = '#';
			s_new[i + 1] = s[i / 2];
		}
		s_new[2 * len + 1] = '#';
		s_new[2 * len + 2] = '$';
		// idΪ����Ĵ���λ��, mxΪ����Ĵ����Ҷ�λ��
		int max = 0, id = 0, mx = 0;
//		int index = 0, in_max = 0;
		int[] p = new int[max_len]; // ��¼ÿ���ַ�����Ҷ˾���
		for (int i = 1; i <= 2 * len + 1; ++i) {
			// i������Ĵ���,�ɸ���i�ĶԳƵ�j(�ѱ�����)���ж�i�Ļ��ĳ���
			// i����id�ĶԳƵ�j: j=id-(i-id) => j=2*id-i
			if (i < mx) {
				p[i] = Math.min(p[2 * id - i], mx - i);
			}
			// ����i��mx���,����ѭ���ж�
			else {
				p[i] = 1;
			}
			// ������iΪ���ĵ���Ҷ˾���
			while (s_new[i - p[i]] == s_new[i + p[i]]) {
				++p[i];
			}
			// ����id, mx, max
			if ((p[i] + i) > mx) {
				id = i;
				mx = p[i] + i;
			}
			max = p[i] > max ? p[i] : max;
//			if (p[i] > max) {
//				max = p[i];
//				index = id;
//				in_max = p[i] + i;
//			}
		}
//		String ss = "";
//		for (index = 2 * index - in_max + 1; index < in_max; ++index) {
//			if (s_new[index] != '#') {
//				ss += s_new[index];
//			}
//		}
//		System.out.println(ss);
		return max - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(huiwen("abba".toCharArray()));
		System.out.println(manacher(
				"bsnetpqmwhqjunkooftuosgkmkxpmvuehtlpwpktltwlvpdaycnhewdbdrhluyjldecezujgxixehsmjjuyerpllrvzqskizkulqzowzfvqcdsllvgupndbaiuzihcxklvxbodpnrymwobhlvllybdlfabfvnizjpriapuzszdhohfgezayokrivbgbgingspoxsridokhwekawchjdcpylvefubulvxneuizglrjktfcdirwnpqztdpsicslzaeiaibrepifxpxfkczwoumkkuaqkbjhxvasxflmrctponwwenvmtdaqaavubyrzbqjbjxpejmucwunanxwpomqyondyjuzxmzpevxqmbkrwcpdiiph"
						.toCharArray()));
	}

}
