package violence;
/*
 * ��������
 * ĳ����ĳ�꿪ʼÿ�궼�ٰ�һ������party������ÿ�ζ�Ҫ��Ϩ��������ͬ����������
 * ��������������һ����Ϩ��236������
 * ���ʣ����Ӷ����꿪ʼ������party�ģ�
 * */
public class Birth2 {
	
	public static void main(String [] args){
	
		for(int i=1;i<100;i++){
			int sum=0;
			for(int j=i;j<100;j++){
				sum+=j;
				if(sum==236){
					System.out.println(i);
					return;
				}
			}
		}
	}
}
