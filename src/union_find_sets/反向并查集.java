package union_find_sets;

import java.util.*;

/**
 * �������� 
����C����n��С����ɣ�Ϊ�˷���С��֮�����磬C����С���佨����m�����ţ�ÿ��������������С����
	����С������ܴ��ڶ��������ӡ�Ȼ�������ں�ˮ��ˢ����һЩ���������Ų���ʹ�õ�Σ�ա�

�����������С��������д��Ŷ�����ʹ�ã���������С���Ͳ���ֱ�ӵ����ˡ�
	Ȼ����ֻҪ������С���ľ�����ͨ���������Ż���������С�����ൽ����ǾͻᰲȻ���¡�
	���ǣ����ǰһ������С��֮�仹�з������Ե����һ��ȴ���ܵ����ˣ������Ǿͻ�һ���顣

��������C���Ĺ����Ѿ�֪����ÿ������ʹ�õ�������������������Ͳ���ʹ���ˡ���������֪�������ǻ��ж�������п��顣 

	�����ʽ 
	����ĵ�һ�а�����������n, m���ֱ��ʾС���ĸ������ŵ������� 
	������m�У�ÿ����������a, b, t���ֱ��ʾ����������a�ź�b������С������ʹ��t�졣С���ı�Ŵ�1��ʼ������ 
	�����ʽ 
	���һ����������ʾ�����ǻΌ��������� 
	�������� 
	4 4 
	1 2 2 
	1 3 2 
	2 3 1 
	3 4 3 
	������� 
	2 
	����˵�� 
������һ���2��3֮����Ų���ʹ�ã���Ӱ�졣 
�����ڶ����1��2֮�䣬�Լ�1��3֮����Ų���ʹ�ã������ǻΌ�顣 
�����������3��4֮����Ų���ʹ�ã������ǻΌ�顣 
	���ݹ�ģ��Լ�� 
��������30%�����ݣ�1<=n<=20��1<=m<=100�� 
��������50%�����ݣ�1<=n<=500��1<=m<=10000�� 
��������100%��0<=n<=10000��1<=m<=10000�� 
����1<=a, b<=n�� 1<=t<=100000��
 *
 */
public class ���򲢲鼯 {
	
	static int[] pre;//���鼯����

	//�Žṹ�壬��������֮����ŵ�ʹ������
	public static class bridge {
		int island1;
		int island2;
		int day;
		public bridge(int a, int b, int t) {
			this.island1 = a;
			this.island2 = b;
			this.day = t;
		}
	}

	public static class myCompare implements Comparator<bridge> {
		/*
		 * Returns a negative integer, zero, or a positive integer as the first
		 * argument is less than, equal to, or greater than the second.
		 */
		@Override
		public int compare(bridge o1, bridge o2) {
			// TODO Auto-generated method stub
			return (o1.day < o2.day) ? 1 : -1;
		}
	}
	
	public static int find_root(int x){
		int r = x;
		while(pre[r] != r){
			r = pre[r];
		}
		//·��ѹ��
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
	}

	public static boolean join(int a, int b){
		int x = find_root(a);
		int y = find_root(b);
		if(x != y){
			pre[x] = y;
			return true;//������
		}
		return false;//���蹹��
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		// init
		bridge[] b = new bridge[m];
		pre = new int[n+1];
		for(int i=0;i<=n;i++){
			pre[i] = i;
		}
		//input
		for (int i = 0; i < m; i++) {//�����������������0��ʼ
			int x = input.nextInt();
			int y = input.nextInt();
			int t = input.nextInt();
			b[i] = new bridge(x, y, t);
		}
		// �Ӵ�С����day���򣬷�������
		Arrays.sort(b, new myCompare());
		int sum = 0;
		int dd = -1;
		for(int i=0;i<m;i++){
			boolean connected = join(b[i].island1, b[i].island2);
			//����蹹������ʱ��������ȣ�����Ϊ����һ��(һ���ڶ����Ż�Ҳֻ��һ�ο���)
			if(connected && b[i].day != dd){
				sum++;
				dd = b[i].day;
			}
		}
		System.out.println(sum);
//		System.out.println(Arrays.toString(pre));
		input.close();
	}
}
