package algorithm;

import java.util.*;

public class ����Ʊ�� {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		LinkedList <Integer> list = new LinkedList<Integer>();
		int break_p = 0;//�ϵ�
		int repeat_p = 0;//�ص�
		int n = input.nextInt();
		String [] str = new String [n];
		/*
		 * nextLine()ɨ�赱ǰ�У������س��󷵻ػس�ǰ���ַ�����������ĩβ�Ļ��з���
		 * nextInt()���������һ����Ƿ���Ϊһ��int���ݣ�
		 * �����ָ�ָ��������ڿո���߻س���֮����ַ������������ָ�������
		 * �����ڵ�һ�ε���nextLine()�����ַ���ǰ����һ��nextLine()�������
		 * */
		input.nextLine();
		for(int i=0;i<n;i++){
			str[i] = input.nextLine();
		}	
		for(int i=0;i<n;i++){	
			//��ȥ����λ�ո�Ȼ������ʽƥ��ո�Ϊ�����ո�,����õ����ո�ָ�
			String [] temp = str[i].trim().replaceAll("\\s+", " ").split(" ");//str[i].replaceAll("\\D+", " ");
			//��������ӵ�������
			for(int j=0;j<temp.length;j++){
				int t = Integer.valueOf(temp[j]).intValue();
				list.push(t);
			}
		}
		//����
		Collections.sort(list);
		//�Ҷϵ�
		for(int i=1;i<list.size();i++){
			if(list.get(i)-list.get(i-1) > 1){
				break_p = list.get(i) - 1; 
			}
		}
		//���ص�
		for(int i=0;i<list.size()-1;i++){
			for(int j=i+1;j<list.size();j++){
				if(list.get(i) == list.get(j)){
					repeat_p = list.get(i);
				}
			}
		}
		System.out.println(break_p+" "+repeat_p);
		input.close();
	}
}
