package algorithm;

/*
 * ���һ���㷨�������n�׳���β����ĸ���
 * ����: 11
 * ���: 2
 * ��������: 
 * 11! = 39916800, ��β��0��2����
 */
public class β������ {
	
	/*
	 * �ٸ����ӣ�
	 * 26��=1*2*3*...25*26
	 * 5�ı����У� ...5...10...15...20...25
	 * ��5������� 5*��1..2..3..4..5��
	 * �ɷ�����������5�ı���
	 */
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
    	long sum = 0;
    	while (n != 0) {
			sum += n / 5;
			n /= 5; // ��ȡ5�ı���
		}
    	return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeros(101));
	}
}
