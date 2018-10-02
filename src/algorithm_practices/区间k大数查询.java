package algorithm_practices;

import java.util.*;

/**
 *  ��������
	����һ�����У�ÿ��ѯ�������е�l��������r�����е�K��������ĸ���
	
	�����ʽ
	��һ�а���һ����n����ʾ���г��ȡ�
	
	�ڶ��а���n������������ʾ���������С�
	
	����������һ��������m����ʾѯ�ʸ�����
	
	������m�У�ÿ��������l,r,K����ʾѯ�����д������ҵ�l��������r�����У��Ӵ���С��K��������ĸ�������Ԫ�ش�1��ʼ��š�
	
	�����ʽ
	�ܹ����m�У�ÿ��һ��������ʾѯ�ʵĴ𰸡�
	��������
	5
	1 2 3 4 5
	2
	1 5 2
	2 3 2
	�������
	4
	2
	���ݹ�ģ��Լ��
	����30%�����ݣ�n,m<=100��
	
	����100%�����ݣ�n,m<=1000��
	
	��֤k<=(r-l+1)�������е���<=106��
 *
 */
public class ����k������ѯ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//-----��������-------
		int n = input.nextInt();
		int [] data = new int [n+1];
		for(int i=1;i<=n;i++) data[i] = input.nextInt();
		int m = input.nextInt();
		int [] l = new int [m+1];
		int [] r = new int [m+1];
		int [] k = new int [m+1];
		//�����ѯ�����Լ�ѯ����
		for(int i=1;i<=m;i++){
			l[i] = input.nextInt();
			r[i] = input.nextInt();
			k[i] = input.nextInt();
		}
		//��ѯ����
		for(int i=1;i<=m;i++){
			//���Ƚ�l ~ r ���������������������
			int [] temp = new int [r[i]-l[i]+2];//���鳤��:r-l+1+1
			for(int e=1;e<temp.length;e++) temp[e] = data[l[i]++];
			//����С�����������
			Arrays.sort(temp);
			k[i]--;//�Լ�1��Ϊ�����ҵ���k�����	
			//������ҵ�k�����
			for(int j=temp.length-1;j>=0;j--){
				if(k[i]==0){
					System.out.println(temp[j]);
					break;
				}
				else{
					k[i]--;
				}
			}
		}
		input.close();
	}
}
