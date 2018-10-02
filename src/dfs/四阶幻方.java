package dfs;

/**
 * ��1~16����������4x4�ķ����У�ʹ���С����Լ������Խ��ߵĺͶ���ȣ���������������ʱ��Ϊ���Ľ׻÷���

�Ľ׻÷������кܶ෽��������̶����Ͻ�Ϊ1�������һ���ж����ַ�����
���磺
  1  2 15 16
 12 14  3  5
 13  7 10  4
  8 11  6  9

�Լ���
  1 12 13  8
  2 14  7 11
 15  3 10  6
 16  5  4  9
 
�Ϳ�����Ϊ���ֲ�ͬ�ķ�����

���ύ���Ͻǹ̶�Ϊ1ʱ�����з������֣���Ҫ��д�κζ������ݻ�˵�����֡�
*/
public class �Ľ׻÷� {
	
	static int [][] s = new int [4][4];
	static boolean [] vis = new boolean [17];//�ж�1~16�Ƿ��Ѿ�ʹ��
	static int count = 0;
	static final int value = 34;//ÿһ��ÿһ���Լ���б�Խ��������34
	
	public static void init(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				s[i][j]=0;
			}
		}
		for(int i=0;i<17;i++)
			vis[i]=false;
		
		s[0][0]=1;//�̶����Ͻ�Ϊ1
		vis[1]=true;
	}
	
	public static void print(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean check_row(int n){//�жϵ�n��

		int sum1=0, sum2=0, sum3=0, sum4=0;
		for(int i=0;i<4;i++){
			sum1+=s[n][i];
			sum2+=s[n][i];
			sum3+=s[n][i];
			sum4+=s[n][i];
		}
		if(sum1!=value || sum2!=value || sum3!=value || sum4!=value)
			return false;
		return true;
	}
	public static boolean check_col(int n){//�жϵ�n��
		
		int sum1=0, sum2=0, sum3=0, sum4=0;
		for(int i=0;i<4;i++){
			sum1+=s[n][i];
			sum2+=s[i][n];
			sum3+=s[i][n];
			sum4+=s[i][n];
		}
		if(sum1!=value || sum2!=value || sum3!=value ||sum4!=value)
			return false;
		return true;
	}
	public static boolean check(){//�ж���б�Խ���
		
		int a = s[0][0]+s[1][1]+s[2][2]+s[3][3];
		int b = s[0][3]+s[1][2]+s[2][1]+s[3][0];
		if(a!=value || b!=value)
			return false;
		return true;
	}
	
	public static void dfs(int pos){
		
		if(pos%4==0 && pos!=0){//���ÿһ��
			if(!check_row((pos-1)/4))
				return;
		}
		
		if(pos==13 || pos==14 || pos==15 || pos==16){//���ÿһ��
			if(!check_col((pos-1)%4))
				return;
		}
		
		if(pos >= 16){	
			if(check()){
				//print();
				count++;	
			}
			return;
		}

		int x = pos/4;
		int y = pos%4;
		for(int i=2;i<=16;i++){
			if(!vis[i]){
				s[x][y]=i;
				vis[i]=true;	
				dfs(pos+1);
				s[x][y]=0;
				vis[i]=false;
			}
		}
	}
	
	public static void main(String [] args){
		init();
		dfs(1);
		System.out.println(count);//416
	}
}

