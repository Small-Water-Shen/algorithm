package dfs;

/**
 * ���⣺��������

�硾ͼ1.png��������ͼ���ڵ��������֣�1~12����ȥ7��11��
Ҫ��ÿ��ֱ�������ֺ���ȡ�

��ͼ����ǡ�������

�������ü�����������п��ܵ���ж����֡�
ע�⣺��ת�������ͬ����ͬһ�����
 *
 */
public class �������� {

	static int count = 0;
	static int [] map = new int [11];
	static boolean [] vis = new boolean [13];
	
	public static boolean check(){
		//������
		int a = map[1]+map[7]+map[9]+map[3];
		int b = map[1]+map[6]+map[8]+map[4];
		int c = map[2]+map[6]+map[7]+map[5];
		int d = map[2]+map[9]+map[10]+map[4];
		int e = map[3]+map[10]+map[8]+map[5];
		//����������ȣ��򷵻�true���ȼ۽�����
		if(a==b && a==c && a==d && a==e){
			return true;
		}
		return false;
	}
	
	public static void dfs(int pos){
		
		if(pos>=11){
			if(check()){
				count++;
			}
			return;
		}
		
		for(int i=1;i<=12;i++){
			if(!vis[i]){
				map[pos]=i;
				vis[i]=true;
				dfs(pos+1);
				vis[i]=false;
			}
		}
	}
	
	public static void main(String [] args){
		//��ʼ������ȥ7,11
		vis[7]=true;
		vis[11]=true;
		dfs(1);
		System.out.println(count/5/2);//��ת���֣���������
	}
}
