package violence;

/**
 * ��6�����֣������ظ�����ɵ����6λ������С6λ��֮��Ĳ�ֵҲ��һ��6λ�����Ҹպð�������6�����֡�
 * 
 * ĳ6λ����ֻ����1~9�е�ĳЩ����(�����ظ�����ͬһ���֣�����������0)��

    ����������������λ�󣬿��Եõ����������С���������С֮��Ҳ��6λ����������ǡ�ð��������ԭ6λ��ͬ�������֡�

    ���磺766431 - 134667 = 631764 ���Ǿ����������������֡�

    �㻹���ҵ���һ��������6λ����

	����д������������λ��õ����������________________  
 */
public class ��С֮�� {

	public static boolean number(int number) {
		int n = 0;
		while(number!=0){
			n++;
			number /= 10;
		}
		return (n==6) ? true: false;
	}
	/* �����ظ�Ԫ��
	public static boolean noRepeat(int value){
		int [] a = new int [6];
		int len = 0;
		while(value!=0){
			a[len++] = value % 10;
			value /= 10;
		}
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]==a[j]) return false;
			}
		}
		return true;
	}*/
	public static void main(String [] args){
		int max, min, value, count = 0;
		boolean flag;
		for(int a=1;a<=9;a++){
			for(int b=1;b<=9;b++){
				for(int c=1;c<=9;c++){
					for(int d=1;d<=9;d++){
						for(int e=1;e<=9;e++){
							for(int f=1;f<=9;f++){
								max = f*100000+e*10000+d*1000+c*100+b*10+a;
								min = a*100000+b*10000+c*1000+d*100+e*10+f;
								if(!number(max) || !number(min)) continue;
								value = max - min;
								if(!number(value)) continue;
								flag = true;
								int value1 = value;
								while(value1!=0){
									int temp = value1%10;
									value1 /=10;
									if(temp!=a && temp!=b && temp!=c && temp!=d && temp!=e && temp!=f){
										flag = false;
										break;
									}
								}
								if(flag){
									count++;
									System.out.print(max+" - "+min+" = "+value+"\n");
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
