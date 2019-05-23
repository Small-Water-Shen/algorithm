package algorithm;

/*������3���ֱ�����ΪX��Y��Z��������������X�ϲ���n��ֱ����С������ͬ��
 * ����С������Ϊ1,2��...��n��Բ��(��ͼ��ʾ)��
 * ��Ҫ��X���ϵ�n��Բ����������Z�ϲ��԰�ͬ��˳����ţ�Բ���ƶ�ʱ������ѭ���й���
 *��1��ÿ��ֻ���ƶ�һ��Բ�̣�
 *��2��Բ�̿��Բ���X��Y��Z�е���һ�����ϣ�
 *��3���κ�ʱ�̶����ܽ�һ���ϴ��Բ��ѹ�ڽ�С��Բ��֮�ϡ�
 * ��������ƣ�Ҫ�ƶ��ٴΣ�*/
import java.util.Scanner;

public class Hanoi {
	
	static int count;
	
	public static void move(int num,char a,char b){
		System.out.println("��"+(++count)+"��:��"+num+"��Բ��"+a+" �� "+b);
	}
	
	public static void hanoi(int num,char source,char depend_on,char target){
		if(num == 1)
			move(1,source,target);
		else{
			hanoi(num-1,source,target,depend_on);//��A�ϵ�1~n-1��Բ�̽���C�Ƶ�B
			move(num,source,target);			 //�����һ��Բ��ֱ���Ƶ�C
			hanoi(num-1,depend_on,source,target);//���B�ϵ�1~n-1��Բ�̽���A�Ƶ�C
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		char source = 'A';
		char depend_on = 'B';
		char target = 'C';
		int num = input.nextInt();	
		count = 0;
		hanoi(num,source,depend_on,target);
		input.close();
	}

}
