package algorithm;

/*
 * ��һ�������е����ֽ��еߵ������ߵ�����������ʱ������ 0 (���Ϊ 32 λ����)��
 */
public class ��ת���� {
	
	// �ж��Ƿ������ÿһ��ȡ���ʱ���жϺ�res��Ӧ��λ�Ƿ���ȼ���
    public static int reverseInteger(int n) {
        // write your code here
        int res = 0;
        while (n != 0) {
            res = res * 10 + n % 10;
            if (n % 10 != res % 10) return 0;
            n /= 10;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseInteger(123456));
	}

}
