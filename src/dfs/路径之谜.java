package dfs;

/**
 * ·��֮��

С��ð��X�������ʿ��������һ����ֵĳǱ���
�Ǳ����ʲô��û�У�ֻ�з���ʯͷ�̳ɵĵ��档

����Ǳ������� n x n �����񡣡���ͼ1.png����ʾ��

��ϰ�ף���ʿҪ���������ߵ����Ͻǡ�
���Ժ���������ƶ���������б���ߣ�Ҳ������Ծ��
ÿ�ߵ�һ���·��񣬾�Ҫ��������������������һ����
���Ǳ�����ǽ�ͱ�ǽ�ڸ��� n �����ӣ�


ͬһ������ֻ������һ�Ρ��������������еķ���

���ֻ���������ϼ�����Ŀ�������ƶϳ���ʿ������·����

�����Ҫ�������֪�������֣�����ʿ������·�����������ݱ�֤·��Ψһ��

���룺
��һ��һ������N(0<N<20)����ʾ������ N x N ������
�ڶ���N���������ո�ֿ�����ʾ���ߵļ����ϵ����֣������򶫣�
������N���������ո�ֿ�����ʾ���ߵļ����ϵ����֣��Ա����ϣ�

�����
һ�����ɸ���������ʾ��ʿ·����

Ϊ�˷����ʾ������Լ��ÿ��С������һ�����ִ����������ǿ�ʼ���: 0,1,2,3....
���磬ͼ1.png�еķ�����Ϊ��

0  1  2  3
4  5  6  7
8  9  10 11
12 13 14 15


ʾ����
�û����룺
4
2 4 3 4
4 3 3 3

����Ӧ�������
0 4 5 1 2 3 7 11 10 9 13 14 15
 *
 */
import java.util.*;

public class ·��֮�� {

	static int [][] map;//��ͼ
	static boolean [][] vis; //�Ƿ��߹���·
	static int [] north;//���ߵİ���
	static int [] west;	//���ߵİ���
	static int [] dir_x = {1, 0, -1, 0};//�����ƶ�
	static int [] dir_y = {0, 1, 0, -1};//�����ƶ�
	
	public static void init(){

		int k=0;
		for(int i=0;i<map.length;i++)
			for(int j=0;j<map.length;j++){
				map[i][j]=k++;	
				vis[i][j]=true;
			}
		//��㿪ʼ
		vis[0][0]=false;
	}
	//�Ƿ�Խ��
	public static boolean isOut(int nx, int ny, int N){
		if(nx>=0 && nx<N && ny>=0 && ny<N){
			return true;
		}
		return false;
	}
	public static int check_x(int N, int x) {//�жϵ�x��

		int sum=0;
		for(int i=0;i<N;i++){
			if(!vis[x][i])
				sum++;
		}
		return sum;
	}
	public static int check_y(int N, int y) {//�жϵ�y��

		int sum=0;
		for(int i=0;i<N;i++){
			if(!vis[i][y])
				sum++;
		}
		return sum;
	}
	public static boolean check(int N){//�жϸ��и��еĴ����������Ŀ�Ƿ����
		
		int x=0, y=0;
		for(int i=0;i<N;i++){
			if(north[i]==check_y(N, i))
				y++;//���߰�����·�����ϵĸ���
		}
		for(int i=0;i<N;i++){
			if(west[i]==check_x(N,i))
				x++;//���߰�����·�����ϵĸ���
		}
		if(x==N && y==N)//������
			return true;
		else
			return false;
	}
	
	public static void dfs(int N, int x, int y, String path){//���ѱ��������ַ�����¼·��
		
		if(x==N-1 && y==N-1 && check(N)){
			System.out.println(path);
			return;	
		}
		
		for(int i=0;i<4;i++){
			int nx = x + dir_x[i];
			int ny = y + dir_y[i];
			int pos;	
			String path1 = "";
			if(isOut(nx, ny, N) && vis[nx][ny]){
				vis[nx][ny]=false;
				pos = map[nx][ny];//�������Ӧ��ֵ
				path1 = path+" "+pos;//�����ַ���
				dfs(N, nx, ny, path1);
				vis[nx][ny]=true;
			}
		}
	}

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			
			int N = input.nextInt();
			//��ʼ������
			map = new int [N][N];
			vis = new boolean [N][N]; 
			north = new int [N];
			west = new int [N];
			//��������
			for(int i=0;i<north.length;i++){
				north[i]=input.nextInt();
			}
			for(int i=0;i<west.length;i++){
				west[i]=input.nextInt();
			}
			
			init();
			dfs(N, 0, 0, "0");
		}
		input.close();
	}
}
