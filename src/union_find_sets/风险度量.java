package union_find_sets;

import java.util.*;

/**
 * X��ϵ�ĵķ�����ϵ���� n ���ռ�վ���� n ���ռ�վ���� m ��ͨ����·������ͨ������ �����ռ�վ�����ֱ��ͨ�ţ�Ҳ����ͨ�������ռ�վ��ת��
 * 
 * ��������վ��x��y (x != y), ������ҵ�һ��վ��z��ʹ�ã� ��z���ƻ���x��y�޷�ͨ�ţ����zΪ����x,y�Ĺؼ�վ�㡣
 * 
 * ��Ȼ�����ڸ���������վ�㣬�������ǵĹؼ���ĸ���Խ�࣬ͨ�ŷ���Խ��
 * 
 * ��������ǣ���֪����ṹ������վ��֮���ͨ�ŷ��նȣ���������֮��Ĺؼ���ĸ�����
 * 
 * �������ݵ�һ�а���2������n(2 <= n <= 1000), m(0 <= m <= 2000),�ֱ����վ��������·����
 * �ռ�վ�ı�Ŵ�1��n��ͨ����·�������˵�վ���ű�ʾ�� ������m�У�ÿ���������� u,v (1 <= u, v <= n; u != v)����һ����·��
 * ���1�У�������u,v������ѯ��ͨ�ŷ��նȵ�����վ�㡣
 * 
 * �����һ�����������ѯ�ʵ����㲻��ͨ�����-1.
 * 
 * ���磺 �û����룺 7 6 1 3 2 3 3 4 3 5 4 5 5 6 1 6 Ӧ������� 2
 *
 */
public class ���ն��� {
	
	static int[] pre;//��¼��ǰ��ĸ��ڵ�
	static int[][] rount;//��¼����ĸ������ӹ�ϵ
	
	public static int find_root(int x){
		int r = x;
		while(pre[r] != r){
			r = pre[r];
		}
		//·��ѹ���㷨
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
	}
	
	public static void join(int x, int y){
		int a = find_root(x);
		int b = find_root(y);
		if(a != b){
			pre[a] = b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		//init
		pre = new int[n+1];
		rount = new int[n+1][2];
		for(int i=1;i<=n;i++){
			pre[i] = i;
		}
		for(int i=1;i<=m;i++){
			rount[i][0] = input.nextInt();
			rount[i][1] = input.nextInt();
			join(rount[i][0], rount[i][1]);
		}
		//input asked point
		int p1 = input.nextInt();
		int p2 = input.nextInt();
		//whether the judgment is connected 
		int a = find_root(p1);
		int b = find_root(p2);
		if(a != b){
			System.out.println(-1);
		}
		else{
			int sum = 0;
			System.out.print("�ؼ�ͨ�ŵ㣺");
			//ö�����е�
			for(int i=1;i<=n;i++){
				//������ѯ�ʵ㣬�����԰�����·���յ��·ȥ��
				if(i == p1 || i == p2) continue;
				//��ʼ����
				for(int i1=1;i1<=n;i1++) pre[i1] = i1;
				//��ʼ���ӵ�
				for(int j=1;j<=m;j++){
					//ȥ����ǰ������ı�
					if(rount[j][0] == i || rount[j][1] == i) continue;
					//���뵱ǰ���޹صı�������
					join(rount[j][0], rount[j][1]);
				}
				//�ж��Ƿ�����ͨ
				int start = find_root(p1);
				int end = find_root(p2);
				//���ȥ����ǰ��ı߲�����ͨ����˵���õ���ǹؼ�ͨ�ŵ�
				if(start != end){
					sum++;
					System.out.print(i+" ");
				}
			}
			System.out.println("\n������"+sum);
		}
		input.close();
	}

}
