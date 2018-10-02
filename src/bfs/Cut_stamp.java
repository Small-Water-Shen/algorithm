package bfs;

import java.util.*;

/*
 * ����Ʊ

 ��12������һ���12��Ф����Ʊ��
������Ҫ���м���5������Ҫ����������ŵġ�

������㣬һ���ж����ֲ�ͬ�ļ�ȡ������
*/
public class Cut_stamp { //��12����ѡ5�����ж��Ƿ��������(dfs+bfs)

	static boolean [][] map_vis = new boolean [3][4];//���������ϱ��ѡ����5��
	static boolean [][] bfs_vis = new boolean [3][4];//�����ж�ѡ����5���Ƿ���ͨ
	static int [] direction_x = {1, 0, -1, 0};
	static int [] direction_y = {0, 1, 0, -1};
	static int [] a = new int [10];//���posλ�õ�����
	static int len = 0;
	static int count = 0; 	
	static Queue <Integer> q = new LinkedList <Integer> ();

	public static int bfs(){
		//��ͨ�ĸ���
		int sum = 1;
		//���������ϵı�Ǹ��Ƶ�bfs_vis
		for(int i=0;i<3;i++)
			for(int j=0;j<4;j++)
				bfs_vis[i][j]=true;
		//����ͷλ�ý���
		q.offer(a[0]);
		bfs_vis[a[0]/4][a[0]%4]=false;
		
		while(!q.isEmpty()){
			int temp = q.poll();
			int x = temp/4;
			int y = temp%4;
			for(int i=0;i<4;i++){
				int nx = x+direction_x[i];
				int ny = y+direction_y[i];
				if(nx>=0 && nx<3 && ny>=0 && ny<4 && bfs_vis[nx][ny] && !map_vis[nx][ny]){
					bfs_vis[nx][ny]=false;//��ֹ��"�߹���·"
					temp=nx*4+ny;
					q.offer(temp);
					sum++;
				}
			}
		}
		return sum;
	}
	
	public static void dfs(int x, int y, int dep){//��12��������ѡ��5��,depΪѡ���ĸ���
		
		if(dep==5){//ѡ��5����
			if(bfs()==5)//����ͨ
				count++;
			return;
		}
		if(x>=3)//�����������������
			return;
		
		for(int i=y;i<=4;i++){//���Ʊ�������
			if(i>=4){//��һ��
				dfs(x+1, 0, dep);
			}
			else{
				map_vis[x][i]=false;//���˵���Ϊѡ��
				int pos = x*4+i;
				a[len]=pos;//�������걣����a����
				len++;
				dfs(x, i+1, dep+1);
				map_vis[x][i]=true;
				len--;
			}
		}
	}
	
	public static void main(String [] args){
		
		for(int i=0;i<3;i++)
			for(int j=0;j<4;j++)
				map_vis[i][j]=true;
		
		dfs(0, 0, 0);
		System.out.println(count); //116
	}
}
