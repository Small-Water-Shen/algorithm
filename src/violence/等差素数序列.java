package violence;

/**
 * 2,3,5,7,11,13,....���������С�
 * 
���ƣ�7,37,67,97,127,157 ������ȫ��������ɵĵȲ����У��еȲ��������С����й���Ϊ30������Ϊ6��

2004�꣬�����뻪������������֤���ˣ��������ⳤ�ȵ������Ȳ����С�

������������һ��˵ĳɹ���

����һ����Ϊ����������������еļ�������������ĵ�������

����Ϊ10�ĵȲ������У��乫����Сֵ�Ƕ��٣�

 */
public class �Ȳ��������� {
	
	public static boolean isSS(int n){
		for(int i=2;i<n;i++){
			if(n%i==0)
				return false;
		}
		return true;
	}
	public static int func() {
		for(int i=2;i<1000;i++){
			for(int j=2;j<1000;j++){
				if(isSS(j)
				&& isSS(j+i)
				&& isSS(j+2*i)
				&& isSS(j+3*i)
				&& isSS(j+4*i)
				&& isSS(j+5*i)
				&& isSS(j+6*i)
				&& isSS(j+7*i)
				&& isSS(j+8*i)
				&& isSS(j+9*i)
				&& !isSS(j+10*i))
					return i;
				/*
				if(isSS(j)){
					len = 1;
					temp = j;
				}
				else
					continue;
				while(true){
					temp += i;
					if(!isSS(temp) && len==10){
						return i;
					}
					if(isSS(temp)){
						len++;
					}
					else
						break;
				}
				*/
			}
		}
		return 0;
	}
	public static void main(String [] args){
		System.out.println(func());
	}
}
