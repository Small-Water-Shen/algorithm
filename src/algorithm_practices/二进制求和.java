package algorithm_practices;

/*
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 * ���룺
 * a = "11", b = "1"
 * �����
 * "100"
 */
public class ��������� {

	// ��������ӷ�����
    public static String addBinary(String a, String b) {
        // write your code here
        int len1 = a.length() - 1, len2 = b.length() - 1;
        String res = "";
        int sum = 0;
        while (len1 >= 0 || len2 >= 0) {
            if (len1 >= 0) {
                sum += a.charAt(len1) - '0';
                len1--;
            }
            if (len2 >= 0) {
                sum += b.charAt(len2) - '0';
                len2--;
            }
            if (sum > 1) {
                res = (sum - 2) + res;
                sum = 1;
            } else {
                res = sum + res;
                sum = 0;
            }
        }
        return (sum == 1) ? 1 + res : res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
	}

}
