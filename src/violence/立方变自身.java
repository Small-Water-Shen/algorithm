package violence;

/**
 * ����������

�۲����������,ĳ�����ֵ���������λ�ۼ���Ȼ��������
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

����������1,8,17���ڣ�����������ʵ�������һ���ж��ٸ���
 */
public class ���������� {

	public static void main(String [] args){
		int count = 0;
		for(int i=1;i<1000;i++){
			int value = (int) Math.pow(i, 3);
			double temp = value;
			int sum = 0;
			while(temp>0){
				sum += temp%10;
				temp /=10;
			}
			/*
			int value = (int) Math.pow(i, 3);
			String s1 = value + "";
			char [] s2 = s1.toCharArray();
			int sum = 0;
			for(int j=0;j<s2.length;j++){
				sum += s2[j]-'0';
			}*/
			if(sum == i){
				count++;
				System.out.print(i+" ");
			}
		}
		System.out.println("\n"+count);
	}
}
