package violence;

/**
 *
 *���⣺�ֻ���

X�ϰ�Ƣ���Ź֣����ǹ�˾�ĵ绰�ֻ��Ŷ���3λ�����ϰ�涨�����к�������ǽ������У��Ҳ������ظ�����λ�����磺

751,520,321 ������Ҫ�󣬶���
766,918,201 �Ͳ�����Ҫ��

�����������һ�£����������Ĺ涨��һ���ж��ٸ����õ�3λ�ֻ����룿
 */
public class �ֻ��� {

	public static void main(String [] args){
		int sum = 0;
		for(int i=0;i<=9;i++){
			for(int j=0;j<=9;j++){
				if(i<=j) continue;
				for(int k=0;k<=9;k++){
					if(i<=k || j<=k) continue;
					sum++;
				}
			}
		}
		System.out.print(sum);
	}
}
