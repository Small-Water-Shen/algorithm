package algorithm_practices;

import java.util.Scanner;

public class �������� {
	
	public static int gcd(int x, int y){
		return (y==0) ? x: gcd(y, x%y);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		//���������������Լ��
		int num1 = (a * b) / gcd(a, b);
		//�ٽ��õ���������һ���������Լ��
		int num2 = (num1 * c) / gcd(num1, c);
		System.out.println(num2);
		input.close();
	}
}
