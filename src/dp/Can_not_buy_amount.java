package dp;
/*
 * ��������
С������һ���ǹ��ꡣ������Ĳã���ˮ���ǰ���4��һ����7��һ�������֡��ǹ����ܲ������
С���������ǵ�ʱ�������������ְ�װ����ϡ���Ȼ��Щ�ǹ���Ŀ���޷���ϳ����ģ�����Ҫ�� 10 ���ǡ�
������ü��������һ�£������ְ�װ����£�������򵽵�������17������17���κ����ֶ�������4��7��ϳ�����
�����Ҫ���������֪������װ������ʱ�����������ϳ������֡�
�����ʽ
��������������ʾÿ�ְ�װ���ǵĿ���(��������1000)
�����ʽ
һ������������ʾ������򵽵�����
*/
import java.util.*;

public class Can_not_buy_amount {
		
	static int x = 1000*100;

	public static void screen(byte [] a,int m,int n){//��֤ m < n
		for(int i=0;i<=x/m;i++)
			for(int j=0;j<=(x-i*m)/n;j++){
				if(i*n+j*m<x)
					a[i*n+j*m]=1;
			}
	}
	public static void screen_for_print(byte [] a,int n){
		int count=0;
		for(int i=0;i<=a.length;i++){
			if(a[i]==1){
				count++;
				if(count>n){//����������n������ϳ����ǹ���
					System.out.println(i-count);//���ǰn����������������
					return;
				}
			}
			else
				count=0;//�������¼���
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		byte [] a = new byte[x];
		int m = input.nextInt();
		int n = input.nextInt();
		
		if(m>n){//����λ��
			m=m+n;
			n=m-n;
			m=m-n;
		}
		
		screen(a,m,n);
		screen_for_print(a,n);
	
		input.close();
	}
}
