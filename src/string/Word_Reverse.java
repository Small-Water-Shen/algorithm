package string;

public class Word_Reverse {
	// ******************��ϰ1****************************
	// abc -> cba
	public static void reverse_test(char[] s, int start, int end) {
		while (start < end) {
			char c = s[start];
			s[start++] = s[end];
			s[end--] = c;
		}
	}

	// abcdef -> defabc
	// �Ƚ�abcdef��Ϊabc,def������,�Ը������ֽ��з�ת,�ٺϲ�����һ�η�ת
	public static void test() {
		char[] s = { 'a', 'b', 'c', 'd', 'e', 'f' };
		reverse_test(s, 0, 2);
		reverse_test(s, 3, 5);
		reverse_test(s, 0, 5);
		System.out.println(s);
	}

	// ******************��ϰ2****************************
	// ����һ��Ӣ�ľ���,Ҫ��ת�����еĵ���˳��,�ַ�������ĸ����
	// ��: i am a student. -> student. a am i
	// ����˼·ͬ��.
	public static void reverse_practice() {
		char[] s = "I am a student.".toCharArray();
		int start = 0;
		int len  = s.length - 1;
		for (int i = 0; i <= len; ++i) {
			if (s[i] == ' ' || i == len) {
				if ((i - start) > 1) {
					reverse_test(s, start, i - 1);
				}
				start = i + 1;
			}
		}
		reverse_test(s, 0, len);
		System.out.println(s);
	}

	public static void main(String[] args) {
//		test();
		reverse_practice();
	}
}
