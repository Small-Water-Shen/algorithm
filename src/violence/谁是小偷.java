package violence;

/**
 * ����ץסA B C D�����ﷸ������һ����С͵��
 * 
 * ����,A˵���Ҳ���С͵��B˵C��С͵��C˵С͵�϶���D��D˵C��ԩ���ˡ�
 * 
 * �����Ѿ�֪���ĸ���������˵�����滰��һ����˵�ٻ�����С͵������˭��
 *
 */
public class ˭��С͵ {

	public static void main(String [] args){
		//1��С͵��0����С͵
		for(int a=0;a<=1;a++){
			for(int b=0;b<=1;b++){
				for(int c=0;c<=1;c++){
					for(int d=0;d<=1;d++){
						//��һ����С͵
						if(a+b+c+d==1){
							//3����˵�滰
							int count = 0;
							if(a==0) count++;
							if(c==1) count++;
							if(d==1) count++;
							if(d==0) count++;
							if(count == 3){
								System.out.println(a+" "+b+" "+c+" "+d);
							}
						}
					}
				}
			}
		}
	}
}
