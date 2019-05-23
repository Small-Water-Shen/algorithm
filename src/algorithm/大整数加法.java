package algorithm;

/*
 * ���ַ�������ʽ���������Ǹ����� num1 �� num2������ num1 �� num2 �ĺ͡�
	num1 �� num2 �ĳ��ȶ�С��5100��
	num1 �� num2 ��ֻ�������� 0-9��
	num1 �� num2 ���������κ�ǰ���㡣
	������ʹ���κ����õ�BigInteger���ڵķ�����ֱ�ӽ�����ת��Ϊ������
	���� : num1 = "123", num2 = "45"
	��� : 168
 */
public class �������ӷ� {
	

	public static String addStrings(String num1, String num2) {
		int len1 = num1.length() - 1, len2 = num2.length() - 1;
		int sum = 0;
		String reString = "";
		while (len1 >= 0 || len2 >= 0) {
			if (len1 >= 0) {
				sum += (num1.charAt(len1) - '0');
				len1--;
			}
			if (len2 >= 0) {
				sum += (num2.charAt(len2) - '0');
				len2--;
			}
			// ��λ
			if (sum >= 10) {
				reString = "" + (sum - 10) + reString;
				sum = 1;
			}
			else {
				reString = "" + sum + reString;
				sum = 0;
			}
		}
		return (sum == 1) ? reString = "1" + reString : reString;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("9", "9"));
	}

	/* 
	 * ********�Լ�д��idiot����*******
	 * �����Ƚ�������reverse���з���ӷ�������reverse���¸����ʱ�临�Ӷȣ����Բ�ȡ���㷽��
	 */
	public static String MyaddStrings(String num1, String num2) {
		// write your code here
		int len1 = num1.length(), len2 = num2.length();
		int maxLen = (len1 < len2) ? len2 : len1;
		int minLen = (len1 < len2) ? len1 : len2;
		int diffLen = maxLen - minLen;
		char[] s1 = (len1 > len2) ? num1.toCharArray() : num2.toCharArray();
		char[] s2 = (len1 < len2) ? addZero(num1, diffLen) : addZero(num2, diffLen);
		char[] s3 = new char[maxLen];
		System.out.println(String.valueOf(s1));
		System.out.println(String.valueOf(s2));
		int addBit = 0;
		for (int i = maxLen - 1; i > 0; i--) {
			int a = s1[i] - '0', b = s2[i] - '0';
			int add = a + b + addBit;
			if (add <= 9) {
				s3[i] = (char) (add + '0'); 
				addBit = 0;
			}
			// ��λ
			else {
				s3[i] = (char) (add - 10 + '0');
				addBit = add / 10;
			}
		}
		// ���⴦����λ
		int add = ((s1[0] - '0') + (s2[0] - '0') + addBit);
		if (add > 9) {
			s3[0] = (char) (add - 10 + '0');
			return String.valueOf(add / 10) + String.valueOf(s3);
		} else {
			s3[0] = (char) (add + '0');
			return String.valueOf(s3);
		}
	}
	
	// ����
	public static char[] addZero(String num, int count) {
		char[] cs = new char[num.length() + count];
		for (int i = 0; i < count; i++) {
			cs[i] = '0';
		}
		for (int j = count, pos = 0; j < cs.length; j++, pos++) {
			cs[j] = num.charAt(pos); 
		}
		return cs;
	}


}
