package algorithm;

import java.util.Scanner;

/**
 *  ���ϻ���

	���������ϳ����ھٰ�һ�δ����Żݻ��������C�����ϣ�ƾ3��ƿ�ǿ����ٻ�һƿC�����ϣ����ҿ���һֱѭ����ȥ�������������ˡ�
	
	�������һ�£����С�����˷�ƿ�ǣ������زμӻ����ô����������ʼ�����nƿ���ϣ������һ���ܵõ�����ƿ���ϡ�
	
	���룺һ������n����ʾ��ʼ���������������0<n<10000��
	�����һ����������ʾʵ�ʵõ���������
	
	���磺
	�û����룺
	100
	����Ӧ�������
	149
	
	�û����룺
	101
	����Ӧ�������
	151
 */
public class �������� {

	public static void func(int n){
		int temp = n;
		int sum = 0;
		int r;
		while(true){
			sum +=temp/3;
			r = temp%3;//ȡ����
			temp /= 3;
			if(temp==0) break;
			temp += r;
		}
		System.out.println(sum+n);
	}

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			func(n);
		}
		input.close();
	}
}
