package algorithm_practices;

import java.util.Scanner;

public class QuickSort {
	
	public static void Swap(int [] date,int a,int b){//����λ��
		int t;
		t = date[a];
		date[a] = date[b];
		date[b] = t;
	}
	
	public static int quickSort(int [] date,int iLeft,int iRight){//�������ڵ����ݿ���
		int i = iLeft+1,j = iRight;
		int major = date[iLeft];
		while(i <= j){
			while(date[j] >= major && j >= i)//�ҳ���majorС����
				j--;
			while(date[i] < major && i <= j)//�ҳ���major�����
				i++;
			if(i < j){
				Swap(date,i,j);
				i++;
				j--;
			}
		}
		Swap(date,iLeft,j);//��󽻻�major�����һ�������
		return j;//���ػ�׼��
	}
	
	public static void partion(int [] date,int iLeft,int iRight){
		if(iRight > iLeft){
			int k = quickSort(date,iLeft,iRight);
			partion(date,iLeft,k-1);//�����������
			partion(date,k+1,iRight);//�����������
		}
	}
	

	public static void QuickSortFast(int[] arr, int left, int right) {
		// �������
		if (left >= right) {
			return;
		}
		// ѡleftλ�õ���Ϊ����
		int radix = arr[left];
		int l = left + 1, r = right, t;
		while (l != r) {
			// ���ұ߿�ʼ�ұ�radixС��һ����
			while (l < r && radix < arr[r]) {
				--r;
			}
			// ����߱߿�ʼ�ұ�radix���һ����
			while (l < r && radix > arr[l]) {
				++l;
			}
			// ����λ��
			if (l < r) {
				t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;
			}
		}
		// ����radix�͵�ǰ�ཻ�㽻��λ��
		arr[left] = arr[l];
		arr[l] = radix;
		// ����������
		QuickSortFast(arr, left, l - 1);
		// ���Ұ������
		QuickSortFast(arr, l + 1, right);
	}
	
	/*
	public static void quickSort(int [] date,int left,int right){
		if(left < right){
			int i = left,j = right;
			int major = date[i];//��ʱ��¼��׼��
			
			while(i != j){
				while(date[j] >= major && i<j)//�ҵ��Ȼ�׼��С����
					j--;
				date[i] = date[j];	//��С��������ǰ��
				while(date[i] <= major && j>i)//�ҵ��Ȼ�׼�������
					i++;
				date[j] = date[i];//�����������ǰ��
			}
			date[j] = major;//�����һ���ظ������û�׼������
			quickSort(date,left,j-1);//�ݹ�������
			quickSort(date,j+1,right);//�ݹ�������
		}
	}*/
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int [] date = new int [100];
		int num = input.nextInt();
		
		for(int i=0;i<num;i++)
			date[i] = input.nextInt();
		
		partion(date,0,num-1);
		
		for(int i=0;i<num;i++)
			System.out.print(date[i]+" ");
		System.out.println();
		
		input.close();
	}
}
