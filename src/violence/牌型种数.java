package violence;

/**
 * @author ��Сˮ
 *
 * С�����ٳֵ�X�ĳǣ�����������3�����ơ�һ���˿��ƣ�ȥ����С���ƣ���52�ţ���
 * ���ȷ���4���ˣ�ÿ����13�š���ʱ��С��������ͻȻð��һ�����⣺
 * ��������ǻ�ɫ��ֻ���ǵ�����Ҳ�������Լ��õ����Ƶ��Ⱥ�˳��
 * �Լ��������õ��ĳ�ʼ�������һ���ж������أ�
 *
 */
public class �������� {
		
	public static void violence(){
		int count = 0;
		for(int a=0;a<=4;a++){
			for(int b=0;b<=4;b++){
				for(int c=0;c<=4;c++){
					for(int d=0;d<=4;d++){
						for(int e=0;e<=4;e++){
							for(int f=0;f<=4;f++){
								for(int g=0;g<=4;g++){
									for(int h=0;h<=4;h++){
										for(int i=0;i<=4;i++){
											for(int j=0;j<=4;j++){
												for(int k=0;k<=4;k++){
													for(int l=0;l<=4;l++){
														for(int m=0;m<=4;m++){
															if((a+b+c+d+e+f+g+h+i+j+k+l+m) == 13){
																count++;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String [] args){
		violence();
	}

}
