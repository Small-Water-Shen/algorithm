package violence;

/**
 * У�ﾶ�˶�����A��B��C��D��E�ֱ����ס��İ��ס����ߡ���Զ���������ھ���
 * 
	���ڼ�˵��B���������ھ���D�����߹ھ���
	
	������˵��A����׹ھ���E�����߹ھ���
	
	���ڱ�˵��C����Զ�ھ���D���İ��׹ھ���
	
	���ڶ�˵�� B�����߹ھ���E���������ھ���
	
	ʵ�������ÿ��˵��һ�롣�������A��B��C��D��E��������ھ���
 */
public class ����ھ� {

	public static void main(String [] args){
		//1-���ף�2-�İ��ף�3-���ߣ�4-��Զ��5-������
		for(int a=1;a<=5;a++){
			for(int b=1;b<=5;b++){
				if(a==b) continue;
				for(int c=1;c<=5;c++){
					if(a==c || b==c) continue;
					for(int d=1;d<=5;d++){
						if(a==d || b==d || c==d) continue;
						for(int e=1;e<=5;e++){
							if(a==e || b==e || c==e || d==e) continue;
							//һ��˵��һ�룬��4��
							int count = 0;
							if(b==5 || d==3) count++;
							if(a==1 || e==3) count++;
							if(c==4 || d==2) count++;
							if(b==3 || e==5) count++;
							if(count==4){
								System.out.println(a+" "+b+" "+c+" "+d+" "+e);
							}
						}
					}
				}
			}
		}
	}
}
