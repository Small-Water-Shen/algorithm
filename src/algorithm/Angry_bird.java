package algorithm;
/**
 * 
	��ŭС��
	
	X�����ŭ��С��ϲ��ײ�𳵣�
	
	һ��ƽֱ�����������𳵼���� 1000 ��
	���� ��������A��B�� ��ʱ�� 10��/�� �����ʻ��
	
	��ŭ��С���A��������ʱ��50��/�룬ײ��B����
	Ȼ�󷵻�ȥײA�����ٷ���ȥײB�����������....
	���������1�״�ͣ����
	
	�ʣ����ڼ��ŭ��С��ײ  B �����ٴΣ�
*/
public class Angry_bird {

	public static void main(String [] args){
		
		double a = 0;
		double b = 1000;
		double time;
		int count = 0;
		
		while(b-a > 1){
			time = (b-a)/(50+10);
			a += time*10;
			b -= time*10;
			count++;
		}
		System.out.println(count/2);
	}
}
