package dp;

import java.util.*;

/**
 * ���⣺���Ӵ���
	
	С������ÿ���糿������һ�Ұ����̳���͡���������Ұ�������N�����������е�i������ǡ���ܷ�Ai�����ӡ�
	
	ÿ���������зǳ�������������Ϊ����������
	
	ÿ���й˿�����X�����ӣ������ӵĴ���ͻ�Ѹ��ѡ����������������ʹ������������ǡ��һ����X�����ӡ�
	
	����һ����3���������ֱ��ܷ�3��4��5�����ӡ�
	
	���˿�����11������ʱ������ͻ�ѡ2��3�����ټ�1��5���ģ�Ҳ����ѡ��1��3�����ټ�2��4���ģ���
	
	��Ȼ��ʱ���Ӵ����������Ҳ�ղ����˿����������������һ����3���������ֱ��ܷ�4��5��6�����ӡ�
	
	���˿�����7������ʱ������ʹղ������ˡ�
	
	С����֪��һ���ж�������Ŀ�ǰ��Ӵ���ղ������ġ�
	
	����
	----
	��һ�а���һ������N��(1 <= N <= 100)
	����N��ÿ�а���һ������Ai��(1 <= Ai <= 100)  
	
	���
	----s
	һ����������𰸡�����ղ�������Ŀ�����޶�������INF��
	
	���磬
	���룺
	2  
	4  
	5   
	
	����Ӧ�������
	6  
	
	�����磬
	���룺
	2  
	4  
	6    
	
	����Ӧ�������
	INF
	
	�������ͣ�
	��������1���ղ�������Ŀ������1, 2, 3, 6, 7, 11��  
	��������2�������������ղ����������������޶����  
 *
 */
public class ���Ӵ��� {
	
	static int N = 1000*100;
	static byte [] data = new byte [N];
	
	public static void init(){
		for(int i=0;i<N;i++){
			data[i]=0;
		}
	}
	
	public static int func(int [] a){
		
		int count = 0;
		
		//�ж��Ƿ���ż�����ղ�������������
		for(int i=0;i<a.length;i++){
			if(a[i]%2!=0)
				return -1;
		}
		//��ȫΪż��ʱ
		data[0]=1;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<N;j++){
				//��֦
				if(a[i]>j){
					continue;
				}
				/* �ⷨ:      �±�:0 1 2 3 4 5 6 ......
				 * ������data��ֵΪ:1 0 0 0 0 0 0 ......
				 * ��ѭ����j�ܼ���a[i]ʱ�����ܴճ�
				 * */
				if(data[j-a[i]]==1){
					data[j]=1;
				}
			}
		}
		for(int i=0;i<N;i++){
			if(data[i]!=1)
				count++;
		}
		
		return count;
	}
	
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			int n = input.nextInt();
			int [] a = new int [n];
			
			for(int i=0;i<n;i++){
				a[i]=input.nextInt();
			}
			init();
			int count = func(a);
			if(count==-1)
				System.out.println("INF");
			else
				System.out.println(count);
		}
		input.close();
	}
}
