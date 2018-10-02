package dfs;

/**
 * �ҹ��ż�����ͼ�����

2 9 4
7 5 3
6 1 8

����һ�����׻÷���ÿ��ÿ���Լ��Խ����ϵ�������Ӷ���ȡ�
*/

public class ���׻÷� {


	static int [][] s = new int [3][3];
	static boolean [] vis = new boolean [10];//�ж�1~9�Ƿ��Ѿ�ʹ��
	static int count = 0;
	static final int value = 15;//ÿһ��ÿһ���Լ���б�Խ��������15������������5
	
	public static void init(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				s[i][j]=0;
			}
		}
		for(int i=0;i<10;i++)
			vis[i]=false;
	}
	
	public static void print(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean check(){
		
		if(s[1][1]!=5)
			return false;
		
		int sum1=0, sum2=0, sum3=0;
		for(int j=0;j<3;j++){//�ж�ÿһ��
			sum1+=s[0][j];
			sum2+=s[1][j];
			sum3+=s[2][j];
		}
		if(sum1!=value || sum2!=value || sum3!=value)
			return false;
		
		sum1=0; sum2=0; sum3=0;
		for(int i=0;i<3;i++){//�ж�ÿһ��
			sum1+=s[i][0];
			sum2+=s[i][1];
			sum3+=s[i][2];
		}
		if(sum1!=value || sum2!=value || sum3!=value)
			return false;
		
		int a = s[0][0]+s[1][1]+s[2][2];//���Խ���
		int b = s[0][2]+s[1][1]+s[2][0];//б�Խ���
		if(a!=value || b!=value)
			return false;
		
		return true;
	}
	
	public static void dfs(int pos, int cur_value){
		
		if(pos >= 9){	
			if(check()){
				print();
				count++;	
			}
			return;
		}
		int x = pos/3;
		int y = pos%3;
		for(int i=1;i<=9;i++){
			//��֦
			if(cur_value > value)
				return;	
			if(pos==2 && cur_value+i!=value)
				continue;
			//�ݹ����
			if(!vis[i]){
				s[x][y]=i;
				vis[i]=true;
				if(pos==3|| pos==6 || pos==9)
					cur_value=0;	
				dfs(pos+1, cur_value+i);
				s[x][y]=0;
				vis[i]=false;
			}
		}
	}
	
	public static void main(String [] args){
		init();
		dfs(0, 0);
		System.out.println(count);
	}
}
