package string;

import java.util.Arrays;

/*
 * ���ַ������Ӵ��Լ��ظ��Ӵ�
 */
public class SA��׺���� {
	
	/* SA��RANK�����߻����ϵ��SA[����]=����(ǰ׺�±�)��RANK[�±�]=����
	 * HEIGHT[RANK[i]] >= HEIGHT[RANK[i - 1]] - 1
	 * tax[i] ��������ĸ�������
	 * tp[i] RANK�ĸ�������(���������еĵڶ��ؼ���)����SA����һ��
	 * arr��charӳ����������������radixSort
	 * HEIGHT[RANK[i]]����ΪRANK[i]�ĺ�׺������ΪRANK[i-1]�ĺ�׺��LCP(�����ǰ׺)
	 * ���ʣ�
	 * ��RANK[i]<RANK[j],���׺str[i..len]��LCPΪmin(HEIGHT[RANK[i]+1],HEIGHT[RANK[i]+2]..HEIGHT[RANK[i]+j])(������Ϊ�ǰ��ֵ�˳������)
	 */
	static int[] SA, RANK, HEIGHT, tax, tp, arr;
	
	public static void init(char[] str, int len) {
		// initialize
		RANK = new int[len * 2 + 1];
		SA = new int[len + 1];
		tax = new int[127 + 1];
		tp = new int[len * 2 + 1];
		arr = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			arr[i] = str[i - 1]; // ӳ��Ϊint
		}
	}
	
	/* ��������
	 * �����Ѿ��õ���w���ȵ�������Ҫ����2w���ȵ�����
	 * tax��¼Ԫ�س��ֵĸ���
	 * SA[i]: ��ʾ����Ϊw�ĺ�׺�У�����Ϊi�ĺ�׺�±�
	 * RANK[i]: ��ʾ����Ϊw�ĺ�׺�У���i��λ�ÿ�ʼ�ĺ�׺������
	 * tp[i]: ��ʾ����Ϊ2w�ĺ�׺�У��ڶ��ؼ�������Ϊi�ĺ�׺�±�
	 */
	public static void radixSort(int ascii, int len) {
		// ��ʼ��������tax
		for (int i = 0; i <= ascii; i++) tax[i] = 0; 
		// ���䣬RANK[tp[i]]��ʾ��tp[i]ǰ׺��ͷ�����ڵڼ�
		for (int i = 1; i <= len; i++) tax[RANK[tp[i]]]++;
		// �ռ������㵱ǰ�������ڵĴ�Сλ��
		for (int i = 1; i <= ascii; i++) tax[i] += tax[i - 1]; 
		/* ��һ�ؼ��ֵ����λ���ǲ���ı�ģ�Ψһ�б仯����RANkֵ��ͬ����Щ��׺��������Ҫ����tp��ֵ��ȷ�����ǵ����λ��
		 * ��:RANk��ͬ��tp[1]=2,tp[2]=4����ô��4��ʼ�ĺ�׺�����ȴ�2��ʼ�ĺ�׺��������
		 * ���ȵ���ö��i����ôSA[tax[RANK[tp[i]]]--]����˼����˵��
		 * �ҴӴ�Сö�ٵڶ��ؼ��֣�����RANK[i]��λ����һ�ؼ��ֵĴ�С
		 * ��ôtax[RANK[tp[i]]]�ͱ�ʾ����һ�ؼ�����ͬʱ���ڶ��ؼ��ֽϴ�������׺��������ɶ
		 * �õ�������������Ҳ���ܸ���SA��
		 */
		for (int i = len; i >= 1; --i) SA[tax[RANK[tp[i]]]--] = tp[i]; // Ҫtax[RANK[tp[i]]]--����Ϊindex�Ǵ�1��ʼ��
	}
	
	public static void suffix(int len) {
		// ��ʼ��SA��RANK
		for (int i = 1; i <= len; i++) {
			RANK[i] = arr[i]; 
			tp[i] = i; // �൱��SA������
		}
		// �����ַ�������ascii����127
		int ascii = 127;
		radixSort(ascii, len);
		Dbug();
		/* �Ӵ����ȷ���������RANK
		 * wΪ��ǰ�Ӵ��ĳ��ȣ�asciiΪӳ��������������
		 * ��ǰtp(�ڶ��ؼ���)��ֱ������һ�ε�SA�õ�
		 */
		for (int w = 1, p = 1, i; p < len; w <<= 1, ascii = p) {
			// �±곬��w��ʱ�򣬽������ڵڶ��ؼ��֣�����len-w+1~len�ĵڶ��ؼ���Ϊ0,�����ʱ��Ӧ����ǰ��
			for (p = 0, i = len - w + 1; i <= len; ++i) tp[++p]= i; 
			/*
			 * ���ಿ�ֿ������õ�һ�ؼ��ֵ�������С����ǵڶ��ؼ��ֵ��±�͵�һ�ؼ��ֵ��±��ǲ�һ���ģ�
			 * ��һ�ؼ��ֵ�ֵ��Ӧ�±�(SA[i])���Ǹùؼ��ֵ��±꣬�ڶ��ؼ��ֵ�ֵ���±��ȥw���Ƕ�Ӧ�ؼ��ֵ��±�(SA[i]-w)��
			 */
			for (i = 1; i <= len; ++i) {
				if (SA[i] > w) {
					tp[++p] = SA[i] - w; 
				}
			}
			Dbug();
			// ����SA
			radixSort(ascii, len);
			Dbug();
			int[] temp = tp;
			tp = RANK;
			RANK = temp;
			RANK[SA[1]] = 1;
			p = 1;
			Dbug();
			// ��������ɵ�SA��Ҫ�õ�RANK����Ҳ�����ס����Ƕ�����ͬ��ֵ��RANKӦ����ͬ������Ҫ�ж�һ�ºϲ��Ժ�Ĺؼ����Ƿ���ͬ
			for (i = 2; i <= len; i++) RANK[SA[i]] = cmp(tp, SA[i], SA[i - 1], w) ? p : ++p; 
			Dbug();
		}
	}

	public static boolean cmp(int[] tp, int i, int j, int w) {
		return tp[i] == tp[j] && tp[i + w] == tp[j + w];
	}
	
	public static void Dbug() {
		System.out.println("**********************");
		System.out.print("index:\t ");
		for (int i = 1; i <= SA.length; i++) System.out.print(i + ", ");
		System.out.println("\n" + "SA:\t" + Arrays.toString(SA));
		System.out.println("RANK:\t" + Arrays.toString(RANK));
		System.out.println("TP:\t" + Arrays.toString(tp));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SimpleSuffixArray("aabaaaab");
//		System.out.println(Arrays.toString(SA));
		String string = "aabaaaab";
		init(string.toCharArray(), string.length());
		suffix(string.length());
//		System.out.println("SA: " + Arrays.toString(SA));
//		System.out.println("RANK: " + Arrays.toString(RANK));

	}
	
	// �򵥵Ĵ���SA��HEIGHT
	public static void SimpleSuffixArray(String str) {
		int n = str.length();
		SA = new int[n];
		HEIGHT = new int[n];
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++) {
			suffixes[i] = str.substring(i);
		}
		Arrays.sort(suffixes);
		for (int i = 0; i < n; i++) {
			SA[i] = n - suffixes[i].length(); // SA[����]=����(ǰ׺)
		}
		// �Ƚ�LCP
		HEIGHT[0] = 0;
		for (int i = 1; i < n; i++) {
			HEIGHT[i] = compareLCP(suffixes[i - 1], suffixes[i]); 
		}
	}

	// �õ������ǰ׺
	public static int compareLCP(String str1, String str2) {
		int l = 0;
		while (l < str1.length() && l < str2.length() && str1.charAt(l) == str2.charAt(l)) ++l;
		return l;
	}

}
