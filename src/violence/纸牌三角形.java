package violence;

public class ֽ�������� {
	  
/**
 *  ���⣺ֽ��������

A,2,3,4,5,6,7,8,9 ��9��ֽ���ų�һ���������Σ�A��1���㣩��Ҫ��ÿ���ߵĺ���ȡ�
��ͼ����һ���ŷ�

      A
     9 6
    4   8
   3 7 5 2

�������ŷ����ܻ��кܶࡣ

���������ת���������ͬ����ͬһ�֣�һ���ж����ֲ�ͬ���ŷ��أ�

������㲢�ύ�����֡�

ע�⣺��Ҫ�ύ����һ����������Ҫ�ύ�κζ������ݡ�
 */
	/*
	static int count = 0;
	static int [] a = new int [9];//��ʼ��0
	static boolean [] vis = new boolean [10];//��ʼ��false
	
	public static boolean check(){
		
		int len1 = a[0]+a[1]+a[2]+a[3];
		int len2 = a[3]+a[4]+a[5]+a[6];
		int len3 = a[6]+a[7]+a[8]+a[0];
		
		if(len1==len2 && len1==len3 && len2==len3)
			return true;
		return false;
	}
	
	public static void dfs(int pos){
		
		if(pos>=9){
			if(check()){
				count++;
			}
			return;
		}
		
		for(int i=1;i<=9;i++){
			if(!vis[i]){
				a[pos]=i;
				vis[i]=true;
				dfs(pos+1);
				vis[i]=false;
			}
		}
	}
	
    public static void main(String[] args) {
    
    	dfs(0);
    	System.out.println(count/3/2);
    }*/
	
    public static void main(String[] args) {
     
	   	 int count = 0;
	   	 for(int a=1;a<10;a++){
	   		 for(int b=1;b<10;b++){
	   			 if(a==b) continue;
	   			 for(int c=1;c<10;c++){
	       			 if(c==a || b==c) continue;
	   				 for(int d=1;d<10;d++){
	   					 if(d==a || d==b || d==c) continue;
	   					 for(int e=1;e<10;e++){
	   						 if(e==a || e==b || e==c || e==d) continue;
	   						 for(int f=1;f<10;f++){
	   							 if(f==a || f==b || f==c || f==d || f==e) continue;
	   							 for(int g=1;g<10;g++){
	   								 if(g==a || g==b || g==c || g==d || g==e || g==f) continue;
	   								 for(int h=1;h<10;h++){
	   									 if(h==a || h==b || h==c || h==d || h==e || h==f || h==g) continue;
	   									 for(int i=1;i<10;i++){
	   										 if(i==a || i==b || i==c || i==d || i==e || i==f || i==g || i==h) continue;
	   										 if((a+b+c+d)==(d+e+f+g) && (a+b+c+d) == (g+h+i+a) && (d+e+f+g)==(g+h+i+a))
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
	   	 System.out.println(count/3/2);//����3�������Ƕȵ���ת������2�Ǿ���
    }
}
