package dfs;

import java.util.Scanner;

/**
 * 1/a �ķ�����Ϊ��λ������
���԰�1�ֽ�Ϊ���ɸ�������ͬ�ĵ�λ����֮�͡�
���磺
1 = 1/2 + 1/3 + 1/9 + 1/18
1 = 1/2 + 1/3 + 1/10 + 1/15
1 = 1/3 + 1/5 + 1/7 + 1/9 + 1/11 + 1/15 + 1/35 + 1/45 + 1/231

�ȵȣ����������ķֽ������޾���
��������һ��Լ�����������ķ�ĸ���벻����20
��������ֽ�Ϊn��ʱ�����в�ͬ�ֽⷨ��
���ݸ�ʽҪ��
����һ������n����ʾҪ�ֽ�Ϊn�n<12��
����ֽ��ĵ�λ������м���һ���ո�ֿ���
ÿ�ַֽⷨռ��һ�У��м��˳���շ�ĸ��С��������

�������룺4
����Ӧ�������
1/2 1/3 1/8 1/24
1/2 1/3 1/9 1/18
1/2 1/3 1/10 1/15
1/2 1/4 1/5 1/20
1/2 1/4 1/6 1/12

 *
 */
public class ��λ����֮�� {
	
	static int [] a = new int [13];
	static boolean [] vis = new boolean [21];
	
	public static boolean check(int num) {
		double sum = 0;
		for(int i=0;i<num;i++) sum += 1.0/a[i];
		//�ж��Ƿ���ӵ�1
		if(Math.abs(sum - 1) < 0.0000001)
			return true;
		else
			return false;
	}
	public static void dfs(int cur_num, int num, int value) {
	
		if(cur_num == num){
			if(check(num)){
				for(int i=0;i<num;i++)
					System.out.print("1/"+a[i]+" ");//���
				System.out.println();
			}
			return;
		}
		if(cur_num < num){
			for(int i=value;i<=20;i++){//���ܳ���20
				if(!vis[i]){ //�����ظ���
					a[cur_num] = i;
					vis[i] = true;
					dfs(cur_num+1, num, i);
					a[cur_num] = 0;
					vis[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i=0;i<a.length;i++) a[i] = 0;
			for(int i=0;i<vis.length;i++) vis[i] = false;
			dfs(0, input.nextInt(), 2);//���һ�������Ǵӷ�ĸΪ2��ʼ
		}
		input.close();
	}
}
