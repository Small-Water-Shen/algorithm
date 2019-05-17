package algorithm;

/*
 * ���ַ�������ʽ���������Ǹ����� num1 �� num2������ num1 �� num2 �ĳ˻���
	num1 �� num2 �ĳ��ȶ�С��110��
	num1 �� num2 ��ֻ�������� 0 - 9��
	num1 �� num2 ������������ǰ���㡣
	������ʹ���κ����õ�BigInteger���ڷ�����ֱ�ӽ�����ת��Ϊ����
	
	���룺
	"123"
	"45"
	�����
	"5535"
	���ͣ�
	123 x 45 = 5535
	
	���룺
	"0"
	"0"
	�����
	"0"
 */
public class �������˷� {

	// ��123*45�� ��5*123=615, ��4*123=192,Ȼ��0=1920,����615+1920
    public static String multiply(String num1, String num2) {
        // 0
    	if (num1.equals("0") || num2.equals("0")) {
    		return "0";
		}
    	String res = "";
    	// num1��ÿ�����ֳ���num2=num2���num1��(45*2=45+45)
    	for (int i = num1.length() - 1; i >= 0 ; i--) {
			String tmp = "";
			int a = num1.charAt(i) - '0';
			// �˷�ת��Ϊ�ӷ�
			for (int j = 0; j < a; j++) {
				tmp = addStrings(tmp, num2);
			}
			if (i < num1.length() - 1) {
				for (int k = 0; k < num1.length() - i - 1; k++) {
					tmp += "0";
				}
			}
			res = addStrings(res, tmp);
		}
    	return res;
    }
    
    // �������ӷ�
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
		System.out.println(multiply("156465456", "156485649810000"));
	}

}
