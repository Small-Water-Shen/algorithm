package violence;

/**
 * ��1,2...9��9�����ֳ����飬�ֱ����������λ������ʹ��������λ������1:2:3�ı�����
 * 
 * �������������������������λ�������磺������λ��192��384��576��������������
 *
 */
public class ������ {


	public static boolean check(int num){
		int a = num/100;
		int b = num/10%10;
		int c = num%10;
		if(a==b || a==c || b==c){
			return false;
		}
		if(a==0 || b==0 || c==0){
			return false;
		}
		return true;
	}
	public static boolean judge(int x, int y, int z) {
		int [] a = new int [10];
		int len = 0;
		while(true){
			a[len++] = x%10;
			a[len++] = y%10;
			a[len++] = z%10;
			x /= 10;
			y /= 10;
			z /= 10;
			if(x==0 && y==0 && z==0){
				len--;
				break;
			}
		}
		for(int i=0;i<len;i++){
			for(int j=i+1;j<=len;j++){
				if(a[i]==a[j])
					return false;
			}
		}
		return true;
	}
	public static void main(String [] args){
		double start = System.currentTimeMillis();
		for(int x=100;x<=400;x++){
			if(!check(x)) continue;
			for(int y=x;y<=700;y++){
				if(!check(y)) continue;
				for(int z=y;z<=999;z++){
					if(!check(z)) continue;
					if(x*2==y && x*3==z && judge(x, y, z)){
						System.out.print(x+" "+y+" "+z);
						System.out.println();
					}
				}
			}
		}
		System.out.println((System.currentTimeMillis() - start)/1000);//��������ʱ��(s)
	}
}
