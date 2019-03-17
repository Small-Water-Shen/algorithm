package algorithm_practices;

/*
 * ʵ�� int sqrt(int x) ���������㲢���� x ��ƽ������
 * ����:  0
 * ���: 0
 * ����: 3
 * ���: 1
 * �������ͣ�
 * ���ض�x�����ź�����ȡ���Ľ����
 * ����: 4
 * ���: 2
 * Challenge
 * O(log(x))
 */

public class X��ƽ���� {
	
    public static int sqrt(int x) {
    	int y = 0;
    	double dist = x;
    	for (int i = 0; i <= x / 2; i++) {
    		double diff = Math.abs((1.0 * x) / i - x);
			y = (diff < dist) ? i : y;
		}
    	return y;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(17));
	}

}
