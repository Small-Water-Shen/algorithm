package algorithm_practices;

import java.util.*;

/**
 *  ��������
	����һ��n�����㣬m���ߵ�����ͼ������ĳЩ��Ȩ����Ϊ��������֤û�и�������
	��������1�ŵ㵽����������·�������1��n��ţ���
	
	�����ʽ
	��һ����������n, m��
	
	��������m�У�ÿ������������u, v, l����ʾu��v��һ������Ϊl�ıߡ�
	
	�����ʽ
	��n-1�У���i�б�ʾ1�ŵ㵽i+1�ŵ�����·��
	��������
	3 3
	1 2 -1
	2 3 -1
	3 1 2
	�������
	-1
	-2
	���ݹ�ģ��Լ��
	����10%�����ݣ�n = 2��m = 2��
	
	����30%�����ݣ�n <= 5��m <= 10��
	
	����100%�����ݣ�1 <= n <= 20000��1 <= m <= 200000��-10000 <= l <= 10000����֤�����ⶥ�㶼�ܵ����������ж��㡣
 *
 */
public class ���·�� {

	static int n;
	static int m;
	static class Node{
		int a;
		int b;
		int pow;
		
		public Node(int a, int b, int pow){
			this.a = a;
			this.b = b;
			this.pow = pow;
		}
	}
	
	public static void spfa(HashSet <Node> node, int n){
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		Node [] node = new Node[n+1];
		for(int i=1;i<=m;i++){
			int u = input.nextInt();
			int v = input.nextInt();
			int l = input.nextInt();
			
		}
		input.close();
	}
}
