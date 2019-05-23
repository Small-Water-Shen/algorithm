package algorithm;

/*
 * ���һ���������ӣ� ��12: 1, 2, 3, 4, 6, 12
 */
public class ���� {

	/*
	 * �����κ�һ����Ȼ��n�������Էֽ������ӵõ�������ʽ�� 
	 * => f(n) = p1^a1 * p2^a2 * .. * pn^an 
	 * => f(n) = (a1+1)*(a2+1)* .. *(an+1)
	 */
	public static long factor(long num) {
		long ant = 1;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				long cnt = 0;
				while (num % i == 0) {
					num /= i;
					++cnt;
				}
				ant *= (cnt + 1);
			}
		}
		if (num > 1)
			ant *= (1 + 1);
		return ant;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(factor(12));
	}

}
