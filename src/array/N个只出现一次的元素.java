package array;

/*
 * ��һ����������n��ֻ����һ�ε�Ԫ��, �����Ķ���������, �ҳ���
 * */
public class N��ֻ����һ�ε�Ԫ�� {

	// ��������ͬ�������Ϊ0������,����������򼴵�
	public static void emergeOne() {
		int[] data = {1, 1, 2, 2, 3};
		int num = data[0];
		for (int i = 1; i < data.length; i++) {
			num ^= data[i];
		}
		System.out.println(num);
	}
	
	/** ������Ԫ�����õ�x=a^b, a,bΪֻ����һ�ε�����Ԫ��
	 * ͻ�ƿ�:��Ϊ����Ԫ�ض�����������,����������ʿ��������ظ�����,��a,b����Ԫ�ز���ͬ,����x��Ϊ0
	 * x��Ϊ0��������һ��1,�Ǹ�1��λ������a,b��mλ�õ�0����1���õ���.
	 * ����ֻҪ��x��mλ��0�Ĺ�Ϊһ��(ֻ����a),��1�Ĺ�Ϊ��һ��(ֻ����b)�Ϳ��Խ��
	 * ��index����Ϊx�е�һ��Ϊ1��λ��(��������), ����a��b��indexλ����,����һ��Ϊ1,һ��Ϊ0
	 * �ɴ˽������Ϊ����, һ���index��Ϊ1, ��һ�鶼Ϊ0, ����ֱ����õ�a,b
	 * */
	public static void emergeTwo() {
		int[] data = {1, 1, 2, 2, 3, 4};
		int x = data[0], index = 0, a = 0, b = 0;
		// ����Ԫ�����õ�x=a^b
		for (int i = 1; i < data.length; i++) {
			x ^= data[i];
		}
		// intΪ32λ
		for (int i = 0; i < 32; i++) {
			if (((x >> i) & 1) == 1) {
				index = i;
				break;
			}
		}
		// �������ý��
		for (int i = 0; i < data.length; i++) {
			// index��Ϊ1��һ��
			if (((data[i] >> index) & 1) == 1) {
				a ^= data[i];
			}
			// index��Ϊ0��һ��
			else {
				b ^= data[i];
			}
		}
		System.out.println(a + " " + b);
	}
	
	// ��������n�Ķ����Ʊ�ʾ�е����һλ1��������������λ�����0
	public static int remainLastBit(int num) {
		return ~(num - 1) & num;
	}
	
	/*
	 * ������������򣬵õ��Ľ��Ϊx=a^b^c��x��Ȼ��a,b,c������ͬ�����x^a,x^b,x^c����Ϊ0. (x^a = b^c, x^b = a^c, x^c = a^b)
	 * ��Ϊx��a,b,c������������ͬ,���Է�֤��֤��:����x=a,��a=a^b^c => b^c=0 => b��c��ͬ => ��ԭ��ì�� 
	 * ����x��a,b,c������ͬ,x^a,x^b,x^c����Ϊ0.
	 * ���ú���remainLastBit��������n�Ķ����Ʊ�ʾ�е����һλ1��������������λ�����0
	 * �������remainLastBit(n)Ϊf(n)
	 * ����f(x^a), f(x^b), f(x^c) ����Ϊ0
	 * ����f(x^a)^f(x^b)^f(x^c)�Ľ��, ����f(n)�Ľ���϶�ֻ��һλΪ1, ����f(x^a)^f(x^b)^f(x^c)�϶���Ϊ0
	 * ��Ϊ�������������������i��j��k��f(i)^f(j)�Ľ��ҪôΪ0��Ҫô����Ķ����ƽ����������1�����������������f(i)^f(j)�������ܵ���f(k)����Ϊf(k)������0�����ҽ���Ķ�������ֻ��һλ��1��
	 * ����f(x^a)^f(x^b)^f(x^c)�Ľ��������һ��1, �������һλΪ1��λ����m,
	 * ��ô��x^a,x^b,x^c�Ľ����, ��һ�������������ֵ�mλ��1
	 * ֤��x^a,x^b,x^c�в������������ֵ�mλ��1:
	 * 		����x^a,x^b,x^c�Ľ����mλ��Ϊ1,��x��a,b,c��mλ�෴,����a,b,c��mλ��ͬ,����Ϊ0,��x��mλΪ0(��Ϊx=a^b^c),����x��a,b,c��mλ��Ϊ0,��x^a��mλΪ0,��������
	 * 		ͬ��,��a,b,c��mλ��ͬ,����Ϊ1,��x��mλ��1,����x^a��mλΪ0,��������
	 * ���,x^a,x^b,x^c��,ֻ��һ�����ֵ�mλ��1
	 * �ҵ����������������ֵı�׼: ����������,ֻ��һ����������mλ��1,����������������.
	 * �ҵ�һ����֮���������������ķ����ҳ�����������
	 * */
	public static void emergeThree() {
		int[] data = { 1, 1, 2, 2, 3, 4, 5 };
		int x = data[0], all = 0, index;
		int firstNum = 0, senNum = 0, thirNum = 0;
		// ����Ԫ�����õ�x=a^b^c
		for (int i = 1; i < data.length; i++) {
			x ^= data[i];
		}
		// all = f(x^a)^f(x^b)^f(x^c)
		for (int i : data) {
			all ^= remainLastBit(x ^ i);
		}
		// index = f(all)
		index = remainLastBit(all);
		for (int i : data) {
			// x^a,x^b,x^c��,ֻ��һ�����ֵ�mλ��1
			if (remainLastBit(i ^ x) == index) {
				// ȥ���ظ�Ԫ��
				firstNum ^= i;
			}
		}
		// �õ���һ����
		System.out.println(firstNum);
		// �Ƚ�firstNum��������ɾ��
		for (int i = 0; i < data.length; i++) {
			if (data[i] == firstNum) {
				// swap
				int t = data[i];
				data[i] = data[data.length - 1];
				data[data.length - 1] = t;
				// ������ʵ��Ч����Ϊdata.length-1
			}
		}
		// �����������ķ����ҳ�����������
		int x1 = 0;
		for (int i = 0; i < data.length - 1; i++) {
			x1 ^= data[i];
		}
		// �ҳ�����λ��
		index = remainLastBit(x1);	
		// ����
		for (int i = 0; i < data.length - 1; i++) {
			if ((data[i] & index) != 0) {
				senNum ^= data[i];
			} else {
				thirNum ^= data[i];
			}
		}
		// �õ��ڶ�,������
		System.out.println(senNum + "\n" + thirNum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		emergeOne();
//		emergeTwo();
		emergeThree();
	}

}
