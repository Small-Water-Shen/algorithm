package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ĳ�����ٰ���Ʊ��������ѡ���л���Ӯ����������Ʊ��
 
�������ó� N �ſ�Ƭ������д�� 1~N �����֣�������˳���ų�һ��ԲȦ��
����Դ�����һ�ſ�Ƭ��ʼ˳ʱ������: 1,2,3.....
������������ָպúͿ�Ƭ�ϵ�������ͬ����Ѹÿ�Ƭ�������У�����һ����Ƭ����������
ֱ�����޷��ջ��κο�Ƭ����Ϸ���������п�Ƭ���ֵĺ;���Ӯ����Ʊ��������
 
���磺
��Ƭ�����ǣ�1 2 3
���Ǵ�1�ſ���ʼ�����Ͱ�1�ſ����ߡ��ٴ�2�ſ���ʼ�������������޷��뿨Ƭ���ϣ�
�ܿ�����Խ��Խ�󣬲����������߿�Ƭ�ˡ�����������ֻӮ����1����Ʊ��
 
������̫����������ǿ�ʼ��ɵɵ�ش�2��3�ſ�Ƭ�����Ǿ�һ�ſ�Ƭ���ò����ˡ�
 
��������ã���Ƭ������ 2 1 3
�����ǿ���˳���õ����еĿ�Ƭ��
 
�����Ŀ����ǣ���֪˳ʱ�뿨Ƭ���С�
���������￪ʼ�����������Ӯ��������Ʊ�������������еĿ�Ƭ����֮�ͣ�
 
�������ݣ�
��һ��һ������N(N<100)����ʾ��Ƭ��Ŀ
�ڶ��� N ����������ʾ˳ʱ�����еĿ�Ƭ
 
������ݣ�
һ�У�һ����������ʾ����������Ӯ�ö�������Ʊ
 
�������룺
3
1 2 3
 
���������
1
 
�������룺
3
2 1 3
 
���������
6
 * */
public class Ӯ��Ʊ {

	public static int max = 0;

	public static void f(int n, int[] num) {
		for (int i = 0; i < n; i++) {// �ӵ�i����Ƭ��ʼ
			int[] temp = Arrays.copyOf(num, num.length - 1);// ��ʱ����
			int sum = 0;// ÿ��������Ƭ�ĺ�
			int count = 1;// �ӵ�һ�ſ�ʼ��
			int start = i;// ��i�ſ�Ƭ
			while (true) {
				boolean judge = false;
				// �����Ƭ�ϵ�����Զ��countС, �Ͳ��������õ���Ƭ
				for (int k = 0; k < n; k++)
					if (temp[k] >= count) {// �жϴ���count�ģ����߾�ֱ������
						judge = true;
						break;
					}
				if (!judge)// �����Ϊ���ֱ������
					break;
				int j = start % n;// ѭ��ͷβ���
				if (temp[j] == count) {
					sum = sum + count;// ÿ��������Ƭ�ĺͼ�����
					temp[j] = -1;// ��������
					count = 1;// ���´�1��ʼ��
				} else if (temp[j] != -1)
					count++;
				start++;
			}
			max = (sum > max) ? sum : max;// ÿ�αȳ�����ֵ
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] num = new int[n + 1];
		for (int i = 0; i < n; i++) {
			num[i] = input.nextInt();
		}
		f(n, num);
		input.close();
	}

}
