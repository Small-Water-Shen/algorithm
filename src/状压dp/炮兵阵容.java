package ״ѹdp;

import java.util.Scanner;

public class �ڱ����� {

	static int[] state;//��¼״̬
	static int[] sum;//��¼�ڱ�����
	static int n, m, num;
	
	//�ж�x��Χ2���Ƿ���������ڱ���true����
	public static boolean adjacent_lr(int x){
		return ((x & (x<<1)) != 0) && ((x & (x<<2)) != 0); 
	}
	
	public static void init(){
		num = 0;
		int total = 1<<m;
		for(int i=0;i<total;i++){
			if(!adjacent_lr(i)){
				state[++num] = i;
				//��ʼ��¼��ǰ״̬���ڱ�����
				int t = i;
				while(t != 0){
					sum[num] += ((t & 1) == 1) ? 1 : 0;
					t = t >> 1;
				}
			}
		}
	}
	
	public static void dp(){
		init();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		dp();
		input.close();
	}

}
