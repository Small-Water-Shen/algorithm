package algorithm_practices;

/**
 * ���

	С���μ�X����Ĵ�б�����
	����ʹ�õ��Ӹ�Ӧ�Ʒ�ϵͳ��������һ�֣�С������96�֡�

	���С��������6���ӵ���û���ѰС�
	����Զ������ȥ��ֻ��3�����ס�
	��Ȼ����Щ�ӵ�׼ȷ�ش�����ǰ�ߵĵ��ס�

	��ͬ�����÷����������õģ�
	1,2,3,5,10,20,25,50

	��ôС����6���ӵ��÷ֶ��Ƕ����أ�����Щ��������أ�
 *
 */
public class ��� {
	
	static void f(int[] ta, int[] da, int k, int ho, int bu, int sc)
	{
		if(ho<0 || bu<0 || sc<0) return;
		if(k==ta.length){
			if(ho>0 || bu>0 || sc>0) return;
			for(int i=0; i<da.length; i++){//ִ����������Ϊ��ho=0,bu=0,sc=0
				for(int j=0; j<da[i]; j++) 
					System.out.print(ta[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<=bu; i++){
		//�������Ӳ��Դ���
		//	int t = 0;
			da[k] = i;//iΪ��ֵ�Ĵ���
		//	if(i==0)
		//		t=0;
		//	else
		//		t=1;	   ho-t
			f(ta, da, k+1, ho-(i==0?0:1), bu-i, sc-ta[k]*i);   // ���λ��
		}
		
		da[k] = 0;
	}
	
	public static void main(String[] args)
	{			  //0 0 2 0  0  2  2  0  Ϊһ�����,����Ϊ0ʱ,ho�Ϳ��Լ�һ
		int[] ta = {1,2,3,5,10,20,25,50};
		int[] da = new int[8];
		f(ta, da, 0, 3, 6, 96);
	}

}
