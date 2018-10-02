package union_find_sets;

import java.util.*;

/**
 * @author ��Сˮ
 *
 *ĳʡ�������ͨ״�����õ����г����·ͳ�Ʊ������г���ÿ����·ֱ����ͨ�ĳ���
 *ʡ��������ͨ���̡���Ŀ����ʹȫʡ�κ���������䶼����ʵ�ֽ�ͨ������һ����ֱ�ӵĵ�·������
 *ֻҪ������ͨ����·�ɴＴ�ɣ��������ٻ���Ҫ�����������·�� 
	Input
	��������������ɲ���������ÿ�����������ĵ�1�и����������������ֱ��ǳ�����ĿN ( < 1000 )�͵�·��ĿM������M�ж�ӦM����·��ÿ�и���һ�����������ֱ��Ǹ�����·ֱ����ͨ����������ı�š�Ϊ������������1��N��š� 
	ע��:��������֮������ж�����·��ͨ,Ҳ����˵
	3 3
	1 2
	1 2
	2 1
	��������Ҳ�ǺϷ���
	��NΪ0ʱ������������������������� 

	Output
	��ÿ��������������1����������ٻ���Ҫ����ĵ�·��Ŀ�� 

	Sample Input
	4 2
	1 3
	4 3
	3 3
	1 2
	1 3
	2 3
	5 2
	1 2
	3 5
	999 0
	0

	Sample Output
	1
	0
	2
	998
 */
public class ��ͨ���� {
	
	static int[] pre;
	static boolean[] root;
	
	//�ҵ���ǰ�ڵ�ĸ��ڵ�
	public static int find_root(int x){
		int r = x;
		while(pre[r] != r){
			r = pre[r];
		}
		/*
		 * ·��ѹ���㷨
		 * 
		 * Ϊ�˼ӿ���ҵ��ٶȣ���x��������ڵ�ֱ������
		 * �����������ֻ��Ҷ�ӽ���û�з�֧������
		 */
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
	}
	
	//����ǰ�����ڵ�ĸ��ڵ�ϲ�
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
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0){
				System.exit(0);
			}
			int m = input.nextInt();
			//init
			pre = new int[n+1];
			root = new boolean[n+1];
			for(int i=0;i<=n;i++){
				pre[i] = i;//��ʼ�Ƕ����ĸ��壬�Լ����Լ���boss
			}
			for(int i=0;i<m;i++){
				int x = input.nextInt();
				int y = input.nextInt();
				join(x, y);
			}
			for(int i=1;i<=n;i++){
				root[find_root(i)] = true;
			}
			int sum = 0;
			for(boolean i : root){
				sum += (i) ? 1 : 0;
			}
			System.out.println(sum - 1);
//			System.out.println(Arrays.toString(root));
//			System.out.println(Arrays.toString(pre));
		}
		input.close();
	}

}
