package algorithm;
/*
 * ����
	����һ��������N�������ж�����Щ������N�ı�ʾǡ����2λ��1������λ����0��
	
	����
	һ��������N��  3 <= N <= 1000000000
	
	���
	��С�������ÿһ������Ҫ��Ľ��ƣ�ÿ��һ�С�
	
	��������
	10
	�������
	2  
	3  
	9
 * */
import java.util.Scanner;

public class һ�����ļ��ֽ��� {

	private static void check(int n) {
		// TODO Auto-generated method stub
		// �Ӷ����ƿ�ʼ
		for (int r = 2; r < n; r++) {
			int t = n;
			int count = 0;
			while (t != 0) {
				int rad = t % r;
				if(rad == 1) count++;
				t /= r;
			}
			if(count == 2) {
				System.out.println(r);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		check(n);
		input.close();
	}
}

