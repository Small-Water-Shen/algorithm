package dfs;

/**
 * �ҹ��ż�����ͼ�����

2 9 4
7 5 3
6 1 8

����һ�����׻÷���ÿ��ÿ���Լ��Խ����ϵ�������Ӷ���ȡ�

���濼��һ���෴�����⡣
�ɲ������� 1~9 ����������Ź���
ʹ�ã�ÿ��ÿ��ÿ���Խ����ϵ����ֺͶ���������أ�

��Ӧ����������
���磺
9 1 2
8 4 3
7 5 6

����������������е����׷��÷�����ͳ�Ƴ�һ���ж����֡�
��ת������ͬһ�֡�

���磺
9 1 2
8 4 3
7 5 6

7 8 9
5 4 1
6 3 2

2 1 9
3 4 8
6 5 7

�ȶ�����ͬһ�������*/

public class ���÷� {
	
	static int [] s = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int [] value = new int [s.length];//��ֵ
	static boolean [] vis = new boolean [s.length];//�ж�1~9�Ƿ��Ѿ�ʹ��
	static int count = 0;

	public static boolean check(){

		int [] p = new int [s.length];
		//ÿһ��
		p[1] = value[0]+value[1]+value[2];
		p[2] = value[3]+value[4]+value[5];
		p[3] = value[6]+value[7]+value[8];
		//ÿһ��
		p[4] = value[0]+value[3]+value[6];
		p[5] = value[1]+value[4]+value[7];
		p[6] = value[2]+value[5]+value[8];
		//�����Խ���
		p[7] = value[0]+value[4]+value[8];
		p[8] = value[2]+value[4]+value[6];
		//ð�ݷ��Ƚ�
		for(int i=1;i<p.length-1;i++){
			for(int j=i+1;j<p.length;j++)
				if(p[i]==p[j])
					return false;
		}
		return true;

	}
	
	public static void dfs(int pos){
		
		if(pos >= s.length){	
			if(check()){
				count++;	
			}
			return;
		}
		
		for(int i=0;i<s.length;i++){
			if(!vis[i]){
				value[pos]=s[i];
				vis[i]=true;
				dfs(pos+1);
				vis[i]=false;
			}
		}
	}
	
	public static void main(String [] args){

		dfs(0);
		System.out.println(count/8);
	}
}
