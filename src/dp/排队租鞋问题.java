package dp;

import java.util.*;
/**
 * ÿ�궬�죬����δ�����϶��ǻ����ĺõط�������������׼��������Ь��
 * ������̫���ˣ�ÿ�������չ��󣬳���һ˫��Ь����ʣ��
 * ÿ�����ϣ���Ь���ڶ����������������л�Ь��m����
 * ����Ҫ��Ь��n�������ڵ������ǣ���Щ���ж������ŷ���
 * ���Ա������������û�б�Ь��������γ��档
 * ������ͬ��������ˣ����綼����Ь���ǻ�Ь������λ����ͬһ���ŷ�
 */
public class �Ŷ���Ь���� {
	
	public static int func(int m, int n){
		
		if(m < n)//����Ь���˱Ȼ�Ь���˶�ʱ���޷���������
			return 0;
		if(n == 0)//û����Ьʱ�������ǻ�Ь�������Ŷӣ�
			return 1;
		/*
		 * �� m>=nʱ
		 * ���� m m n n m|n
		 * ������˲��ܴ治���ڡ���m����n�� �������޹�
		 * */
		return func(m, n-1)+func(m-1, n);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
	
		int m = input.nextInt();
		int n = input.nextInt();
		System.out.println(func(m, n));
	
		input.close();
	}
}

