package algorithm;
/*
 * �����100002��ʮ�������������
 * 2�ǵ�һ��������3�ǵڶ�������......
 * */
public class The_N_primeNumber {
			
	static int x = 1000*1000*10;
	static int num = 1000*10*10+2;

	public static void screen(byte [] a){//ɸѡ
		for(int i=2;i<=x/2;i++){
			if(a[i]==1)	continue;//��һ��for�Ѿ��жϹ���ֱ������
			for(int j=2;j<=x/i;j++){
				if(i*j<x)
					a[i*j]=1;//�Ǻ������1���������0
			}
		}
	}
	
	public static void main(String [] args){
		byte [] a = new byte [x];
		screen(a);
		int count=0;
		for(int i=2;i<x;i++){
			if(a[i]==0)
				count++;
			if(count == num){
				System.out.println(i);
				break;
			}
		}
	}

}
