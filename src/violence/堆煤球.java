package violence;
/*
 *  ��һ��ú�򣬶ѳ�������׶�Ρ����壺
	��һ���1����
	�ڶ���3�������г������Σ���
	������6�������г������Σ���
	���Ĳ�10�������г������Σ���
	....
	���һ����100�㣬���ж��ٸ�ú��
	
	1 3 6 10 ... 
	 2 3 4  5... �Ȳ�����֮�ͣ�((1+n)n)/2
*/
public class ��ú�� {

	public static void main(String [] args){
		int sum=0;
		for(int i=1;i<=100;i++){
			sum+=((i+1)*i)/2;
		}	
		System.out.println(sum);
	}
}