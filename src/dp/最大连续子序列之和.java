package dp;

import java.util.Scanner;

/**
 * ����K������������{ N1, N2, ..., NK }�����������������пɱ�ʾΪ{ Ni, Ni+1, ..., Nj }��
 * 
 * ���� 1 <= i <= j <= K�������������������������������Ԫ�غ�����һ����
 * 
 * �����������{ -2, 11, -4, 13, -5, -2 }�����������������Ϊ{ 11, -4, 13 }������Ϊ20��
 *
 */
public class �������������֮�� {
	
	static int [] data;
	
	//״̬ת�Ʒ��̣�sum[i] = math.max(sum[i-1]+data[i], data[i])
	public static void Dp(){
		int max = 0;
		int temp = 0;
		for(int i=0;i<data.length;i++){
			temp += data[i];
			if(temp > max){
				max = temp;
			}
			if(temp < 0){
				temp = 0;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		data = new int [n];
		for(int i=0;i<n;i++){
			data[i] = input.nextInt();
		}
		Dp();
		input.close();
	}
}
