package dfs;

public class ����ָ� {
	
	final static int N = 6;
	static int count = 0 ;
	static int [][] map = new int [N+1][N+1];
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void dfs(int x, int y){
		//�������ű�Ե�г�
		if(x==0 || y==0 || x==N || y==N){
			count++;
			return;
		}
		for(int i=0;i<4;i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>N || ny<0 || ny>N || map[nx][ny]==1 || map[N-nx][N-ny]==1)
				continue;
			map[nx][ny] = 1;//���ѡ�е�
			map[N-nx][N-ny] = 1;//��ǶԳƵ�
			dfs(nx, ny);
			map[nx][ny] = 0;//��ԭ
			map[N-nx][N-ny] = 0;
		}
	}
	public static void main(String[] args) {
		map[N/2][N/2] = 1;//�����ָ���ӵ��ߣ���Ϊ��Ҳ�ǹ��ڣ�3,3����ԳƵ�
		dfs(N/2, N/2);
		System.out.println(count/4);
	}
}
