package dfs;

/**
 * ��˵��ʫ����ף�һ���������Һ����Ӳ�������
 * 
    һ�죬�����žƺ����Ӽ���������ƺ����о�2���������߱߳���
    
    ���½����ߣ����ȥ��ơ�
    ����һ����������һ����
    
    ��һ·�ϣ���һ��������5�Σ�������10�Σ���֪���һ���������ǻ��������ðѾƺȹ��ˡ� 
    
    ����������������ͻ��Ĵ��򣬿��԰������Ϊa��������Ϊb����babaabbabbabbbb ���Ǻ���Ĵ���
    
    �������Ĵ�һ���ж����أ������������п��ܷ����ĸ�����������Ŀ�����ģ���

 */
public class ��״�� {//�򵥵Ķ�̬�滮+�ݹ�

	static int count = 0;
	
	public static void dfs(int shop, int flower, int wine, String value) {
		if(shop==5 && flower==10 && wine==0){
			count++;
			System.out.println(value);
			return;
		}
		if(wine!=0){
			if(shop!=5){
				dfs(shop+1, flower, wine*2, value+"a");
			}
			if(flower!=10){
				dfs(shop, flower+1, wine-1, value+"b");
			}
		}
	}
	public static void main(String[] args) {
		dfs(0, 0, 2, "");
		System.out.println(count);
	}
}
