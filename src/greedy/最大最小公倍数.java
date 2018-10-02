package greedy;

import java.util.Scanner;

/**
 *  ��������
	��֪һ��������N���ʴ�1~N����ѡ�������������ǵ���С������������Ϊ���١�
	
	�����ʽ
	����һ��������N��
	
	�����ʽ
	���һ����������ʾ���ҵ�����С��������
	��������
	9
	�������
	504
	���ݹ�ģ��Լ��
	1 <= N <= 106��
 *
 */
public class �����С������ {
	
	/* ̰�Ĳ��ԣ���֤ѡ�����������ǻ�Ϊ��Լ�ֵ������ɵ����
	 * ��: ĩβ������  7 8 9 = 504 ��1~9��
	 *     ĩβ��ż��  7 9 10 = 630 ��1~10��
	 *     �������  9 10 11 = 990 (1~12)
	 *     	       69 70 71 = ..(1~72)
	 */
	public static void lcm(long n){
		long sum = 0;
		//ĩβ������,ֱ��ѡ�������
		if(n%2!=0){
			sum = n*(n-1)*(n-2);
		}
		//ĩβ��ż�������������
		else{
			//�������,... 9 10 11 12����Ҫѡ9 10 11
			if((n-3)%3==0 && n%3==0){
				sum = (n-1)*(n-2)*(n-3);
			}
			else{
				sum = n*(n-1)*(n-3);
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		if(n < 3){
			System.out.println(1);
		}
		else{
			lcm(n);		
		}
		input.close();
		System.exit(0);
	}
}
