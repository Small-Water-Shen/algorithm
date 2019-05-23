package algorithm;

import java.util.Scanner;
	
public class True_or_false_coins {
		
		static String  [] left = new String [3];//��ƽ��
		static String  [] right = new String [3];//��ƽ��
		static String  [] result = new String [3];//״̬
		
	public static boolean isLight(char curchar){//������
			
		char s;
		for(int i=0;i<3;i++){
			s = result[i].charAt(0);
			switch(s){
			
			case 'e' :
				if((left[i].indexOf(curchar) != -1) || (right[i].indexOf(curchar) != -1))
					return false; break;
			case 'u' : 
				if(right[i].indexOf(curchar) == -1)
					return false; break;
			case 'd' :
				if(left[i].indexOf(curchar) == -1)
					return false; break;
			}
		}	
		return true;
	}

	public static boolean isHeavy(char curchar){//�ص����
			
		char s;
		for(int i=0;i<3;i++){
			s = result[i].charAt(0);
			switch(s){
			
			case'e' :
				if((left[i].indexOf(curchar) != -1) || (right[i].indexOf(curchar) != -1))
					return false; break;
			case 'd' : 
				if(right[i].indexOf(curchar) == -1)
					return false; break;
			case 'u' :
				if(left[i].indexOf(curchar) == -1)
					return false; break;
			}
		}	
		return true;
	}

	public static void main(String [] args){
			
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();	//����������
			
		while(n>0){
			for(int i=0;i<3;i++){
				left[i]=input.next();
				right[i]=input.next();
				result[i]=input.next();
			}
		for(char curchar='A';curchar<='L';curchar++){//�����ⷨ����A��ʼ�ж�
			if(isLight(curchar)){
				System.out.println(curchar+" Light");
				break;	
			}
			if(isHeavy(curchar)){
				System.out.println(curchar+" Heavy");
				break;
			}
		}
			n--;
	}
			input.close();
		}
	}
