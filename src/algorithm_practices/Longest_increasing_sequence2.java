package algorithm_practices;

import java.util.Scanner;

public class Longest_increasing_sequence2 {

	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
			
			int n = input.nextInt();
			int top,temp,low,hight,middle;
			int [] stack = new int [100];
			
			top=0;
			stack[top]=-1;//ģ��ջ
			
			for(int i=0;i<n;i++){
				temp=input.nextInt();
				if(stack[top]<temp){//��������������ջ����Ԫ�ؾ���ջ
					top++;
					stack[top]=temp;
				}
				else{
					low=1;
					hight=top;
					while(low<=hight){
						middle=(low+hight)/2;
						if(stack[middle]==temp)
							low=middle;
						if(stack[middle]<temp)
							low=middle+1;
						if(stack[middle]>temp)
							hight=middle-1;
					}
					stack[low]=temp;
				}
			}
			System.out.println(top);
			input.close();
		}	
}
