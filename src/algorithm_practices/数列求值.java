package algorithm_practices;

/*
 * ��������1, 1, 1, 3, 5, 9, 17, �����ӵ�4 �ʼ��ÿ���ǰ3 ��ĺ͡���
 * ��20190324 ������4λ���֡��𰸵����ױ���������ֱ�Ӽ���
 */
public class ������ֵ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 1, c= 1, sum = 0;
		for (int i = 3; i < 20190324; i++) {
			// ֱ��ȡ����λ...
			sum = (a + b + c) % 10000;
			a = b;
			b = c;
			c = sum;
		}
		System.out.println(sum);
	}

}
