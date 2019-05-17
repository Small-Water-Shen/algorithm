package algorithm;

import java.util.*;

/**
 * ���⣺��������

	С����������һ����ʷ���ס���Щ��ʷ�����г����˺ܶ����ڡ�С��֪����Щ���ڶ���1960��1��1����2059��12��31�ա�
	��С��ͷ�۵��ǣ���Щ���ڲ��õĸ�ʽ�ǳ���ͳһ���в�����/��/�յģ��в�����/��/��ģ����в�����/��/��ġ�
	�����鷳���ǣ����Ҳ��ʡ����ǰ��λ��ʹ�������ϵ�һ�����ڣ����ںܶ���ܵ����������Ӧ��  
	
	����02/03/04��������2002��03��04�ա�2004��02��03�ջ�2004��03��02�ա�  
	
	����һ�������ϵ����ڣ����ܰ���С���ж�����Щ���ܵ����ڶ����Ӧ��
	
	����
	----
	һ�����ڣ���ʽ��"AA/BB/CC"��  (0 <= A, B, C <= 9)  
	
	����
	----
	������ɸ�����ͬ�����ڣ�ÿ������һ�У���ʽ��"yyyy-MM-dd"��������ڰ����絽�����С�  
	
	��������
	----
	02/03/04  
	
	�������
	----
	2002-03-04  ��/��/��
	2004-02-03  ��/��/��
	2004-03-02  ��/��/��
 *
 */
public class �������� {
	
	static class day{
		int year;
		int month;
		int date;
	}
	public static boolean check(day data){
		
		int year = data.year;
		int month = data.month;
		int date = data.date;
		//һ���12����
		int [] date_max = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//�����ж�
		if(year%4==0 && year%100!=0 || year%100==0 && year%400==0){
			date_max[2]=29;
		}
		else{
			date_max[2]=28;
		}
		//�Ƿ��ڷ�Χ֮��
		if(year<1960 || year>2059)
			return false;
		if(month<1 || month>12)
			return false;
		if(date<1 || date>date_max[month])
			return false;
		
		return true;
	}
	//ʵ��Comparator����дcompare����
	static class compare implements Comparator <Object>{
		public int compare(Object o1, Object o2) {

			day a = (day) o1;
			day b = (day) o2;
			
			if(a.year != b.year){
				return a.year > b.year ? 1 : -1;//a.year > b.year
			}
			if(a.month != b.month){
				return a.month > b.month ? 1 : -1;
			}
			return a.date > b.date ? 1 : -1;
		}
	}

	public static void func(String [] st){

		day [] data = new day [6];
		
		int a = Integer.parseInt(st[0]);
		int b = Integer.parseInt(st[1]);
		int c = Integer.parseInt(st[2]);
		
		for(int i=0;i<data.length;i++){
			data[i] = new day();//ʵ��������
		}
		//��ֵ
		data[0].year=1900+a; data[0].month=b; data[0].date=c;
		data[1].year=2000+a; data[1].month=b; data[1].date=c;
		data[2].year=1900+c; data[2].month=a; data[2].date=b;
		data[3].year=2000+c; data[3].month=a; data[3].date=b;
		data[4].year=1900+c; data[4].month=b; data[4].date=a;
		data[5].year=2000+c; data[5].month=b; data[5].date=a;
		
		//����
		Arrays.sort(data, new compare ());
		//ɾ���ظ�
	
		//������ϵ�����
		for(int i=0;i<data.length;i++){
			if(check(data[i])){
				System.out.println(data[i].year+"-"+data[i].month+"-"+data[i].date);
			}
		}
	} 

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String str = "";
		
		while(input.hasNext()){
			str = input.nextLine();
			String [] st = str.split("/");
			func(st);
		}
		input.close();
	}
}
