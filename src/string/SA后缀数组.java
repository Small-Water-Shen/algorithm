package string;

import java.util.Arrays;

/*
 * author: shenhao
 * date: 2019-5-31 14:00:46
 */
public class SA��׺���� {

    /* SA��RANK�����߻����ϵ��SA[����]=����(ǰ׺�±�)��RANK[�±�]=����
     * HEIGHT[RANK[i]] >= HEIGHT[RANK[i - 1]] - 1
     * tax[i] ��������ĸ�������
     * tp[i] RANK�ĸ�������(���������еĵڶ��ؼ���)����SA����һ��
     * HEIGHT[RANK[i]]����ΪRANK[i]�ĺ�׺i������ΪRANK[i-1]�ĺ�׺i-1��LCP(�����ǰ׺)
     * ��HEIGHT[i]ΪSA[i-1]��SA[i]��LCP
     */
    static int[] SA, RANK, HEIGHT, tax, tp;
    static int sign = 127; // �ַ�������ascii����127

    public static void init(int len) {
        // initialize
        RANK = new int[2 * len];
        SA = new int[2 * len];
        tax = new int[sign + 1];
        tp = new int[2 * len];
        HEIGHT = new int[2 * len];
    }

	/* ��������
	 * �����Ѿ��õ���w���ȵ�������Ҫ����2w���ȵ�����
	 * tax: ��¼Ԫ�س��ֵĸ���
	 * SA[i]: ��ʾ����Ϊw�ĺ�׺�У�����Ϊi�ĺ�׺�±�
	 * RANK[i]: ��ʾ����Ϊw�ĺ�׺�У���i��λ�ÿ�ʼ�ĺ�׺������
	 * tp[i]: ��ʾ����Ϊ2w�ĺ�׺�У��ڶ��ؼ�������Ϊi�ĺ�׺�±�
	 */

    public static void suffix(char[] str, int len) {
        int i, w, p;
        init(len); // initialize
        // ���ȶԵ�һ���ַ����л�������
        for (i = 0; i <= sign; ++i) tax[i] = 0;
        for (i = 0; i < len; ++i) { RANK[i] = str[i]; tax[RANK[i]]++; }
        for (i = 1; i <= sign; ++i) tax[i] += tax[i - 1];
        for (i = len - 1; i >= 0; --i) SA[--tax[RANK[i]]] = i;
		// �Ӵ�����w����������RANK
        // wΪ��ǰ�Ӵ��ĳ��ȣ�asciiΪӳ��������������
        // ��ǰtp(�ڶ��ؼ���)��ֱ������һ�ε�SA�õ�
        for (w = 1, p = 1; p < len; w <<= 1, sign = p) {
            // �±곬��w��ʱ�򣬽������ڵڶ��ؼ��֣�����len-w+1~len�ĵڶ��ؼ���Ϊ0,�����ʱ��Ӧ����ǰ��
            for (p = 0, i = len - w; i < len; ++i) tp[p++]= i;
            // ���ಿ�ֿ������õ�һ�ؼ��ֵ��������(�������ϵľ���ͼ)�����ǵڶ��ؼ��ֵ��±�͵�һ�ؼ��ֵ��±��ǲ�һ���ģ�
            // ��һ�ؼ��ֵ�ֵ��Ӧ�±�(SA[i])���Ǹùؼ��ֵ��±꣬�ڶ��ؼ��ֵ�ֵ���±��ȥw���Ƕ�Ӧ�ؼ��ֵ��±�(SA[i]-w)��
            for (i = 0; i < len; ++i) if (SA[i] >= w) tp[p++] = SA[i] - w;
			/* ��һ�ؼ��ֵ����λ���ǲ���ı�ģ�Ψһ�б仯����RANkֵ��ͬ����Щ��׺��������Ҫ����tp��ֵ��ȷ�����ǵ����λ��
			 * �ϲ���һ�ڶ��ؼ��֣�Ȼ�������ȸ��ݵ�һ�ؼ������򣬵�һ�ؼ������ʱ���ݵڶ��ؼ��ִ�С����
			 * ����ʵ�ϣ��Ǹ��ݵڶ��ؼ��ֵ�˳�����¸ı��˵�һ�ؼ��ֵ�˳��Ҳ����˵�ڱ��λ��������У������Ⱥ��������=�ڶ��ؼ��ִ�С����
			 * ���仰˵�������ȵ����Եڶ��ؼ������򣬸������˳��ı��һ�ؼ��ֵ�˳�������ڻ�������ʱ���Ȱ��յ�һ�ؼ��ֵ�ֵ����
			 * ����һ�ؼ��ֵ�ֵû�иı��������Ȼ��Ǹ��ݵ�һ�ؼ������򣬸ı���ǵ�һ�ؼ�����ͬ��ʱ�򣬳�����ǰ��ĵڶ��ؼ�������ǰ�档
			 * ��:RANk��ͬ��tp[1]=2,tp[2]=4����ô��4��ʼ�ĺ�׺�����ȴ�2��ʼ�ĺ�׺��������
			 * ���ȵ���ö��i����ôSA[tax[RANK[tp[i]]]--]����˼����˵��
			 * �ҴӴ�Сö�ٵڶ��ؼ��֣�����RANK[i]��λ����һ�ؼ��ֵĴ�С
			 * ��ôtax[RANK[tp[i]]]�ͱ�ʾ����һ�ؼ�����ͬʱ���ڶ��ؼ��ֽϴ�������׺��������ɶ
			 * �õ�������������Ҳ���ܸ���SA��
			 */
            for (i = 0; i <= sign; ++i) tax[i] = 0;
            for (i = 0; i < len; ++i) tax[RANK[tp[i]]]++;
            for (i = 1; i <= sign; ++i) tax[i] += tax[i - 1];
            for (i = len - 1; i >= 0; --i) SA[--tax[RANK[tp[i]]]] = tp[i];
            // ����õ�SA����֮��Ȼ�����Ҫ����RANK����
            // ��ʱ���ֱ����õ���һ���rankֵ������Ҽ�Ҫ��rank�����ã���Ҫ��rank����ţ���ô�죿
            // ��Ȼ���Ȱ�rank�Ķ����ŵ�����һ����������, ����tp�Ѿ�û�����ˣ����Կ���rank��tp����һ�£�ʡ�ÿ���������
            swap();
            RANK[SA[0]] = 0; // �ϴ�����ϴ�
            // ��������ɵ�SA��Ҫ�õ�rank����Ҳ�����ס����Ƕ�����ͬ��ֵ��rankӦ����ͬ������Ҫ�ж�һ�ºϲ��Ժ�Ĺؼ����Ƿ���ͬ
            // �õ���һ���rankֵ,ǰ�����SAֵ��ʱ������ַ�����ͬ��Ĭ��ǰ��ĸ�С�ģ�
            // ���������rank��ʱ����뽫��ͬ���ַ�����������ͬ��rank����Ȼp==n֮���ֹͣѭ����
            for (i = 1, p = 1; i < len; ++i) RANK[SA[i]] = cmp(SA[i - 1], SA[i], w) ? p - 1 : p++;
        }
        calcHeight(str, len);
    }
    
    /* O(n)����height���飬H[i] >= H[i-1]-1
     * ���ʣ�
     * ��RANK[i]<RANK[j],���׺str[i..len]��LCPΪmin(HEIGHT[RANK[i]+1],HEIGHT[RANK[i]+2]..HEIGHT[RANK[i]+j])(������Ϊ�ǰ��ֵ�˳������)
     * ��H[i]=HEIGHT[RANK[i]], ����i�Ǻ�׺��λ�ã��У�H[i]>=H[i-1]-1
     * ֤����
     * ���i-1���ַ���(�����i-1��ָ�������ĺ�׺����ԭ�ַ����еĺ�׺)����������ǰ����ַ�������Ϊ��k���ַ�����
     * ע�⣬�����k��һ����i-2,��Ϊi-1�Ƿ�������׺����k��i-1��������ǰһλ�����ĺ�׺
     * ����HEIGHT�Ķ��壬��׺k�ͺ�׺i-1��LCP��Ȼ��HEIGHT[RANK[i-1]], �ٿ���k+1��׺��i��׺�Ĺ�ϵ
     * 1. ��׺k�����ַ��ͺ�׺i-1�����ַ���ͬ����ôk+1��׺������i��׺��ǰ�棬Ҳ������i��׺�ĺ��棬
     *    ������û��ϵ����ΪHEIGHT[RANK[i-1]]Ϊ0����HEIGHT[RANK[i]]Ϊ���٣�����HEIGHT[RANK[i]]>=HEIGHT[RANK[i-1]]-1
     * 2. ��׺k�����ַ��ͺ�׺i-1�����ַ���ͬ����ô����k+1��׺����k��׺ȥ�����ַ��õ��ģ�i��׺Ҳ����i-1��׺ȥ�����ַ��õ��ġ�
     *    ��ô��Ȼ��k+1��׺һ��Ҫ����i��׺��ǰ�棬��Ȼ��ì���ˡ�ͬʱ����׺k�ͺ�׺i-1��LCP��HEIGHT[RANK[i-1]]
     *    ��֪����׺k+1�ͺ�׺i��LCP��Ȼ��HEIGHT[RANK[i-1]]-1��
     * ���ڱȵ�i���ַ������ֵ�����������ǰ����Щ�ַ�����˭�͵�i����׺�������ǰ׺�ĳ��ȣ�
     * ����Ȼ�����������ź�׺i���Ǹ���׺ ���� SA[RANK[i]-1], Ҳ����˵��
     * SA[RANK[i]]��׺��SA[RANK[i]-1]��׺��LCP������HEIGHT[RANK[i-1]]-1��(ע��SA[i]��ֵ��������i��Ӧ�ĺ�׺)
     * ��ô����HEIGHT[RANK[i]] >= HEIGHT[RANK[i-1]]-1, ��H[i]>=H[i-1]-1
     */
    public static void calcHeight(char[] s, int len) {
    	for (int i = 0, j, k = 0; i < len; i++) {
			if (RANK[i] == 0) continue; // skip zero rank
			if (k > 0) --k;
			j = SA[RANK[i] - 1]; // jΪi����һ�����ĺ�׺
			while (i + k < len && j + k < len && s[i + k] == s[j + k]) ++k;
			HEIGHT[RANK[i]] = k;
		}
    }

    public static boolean cmp(int i, int j, int w) {
        return tp[i] == tp[j] && tp[i + w] == tp[j + w]; // ��1,2�ؼ��ֺϲ��������Ƿ���ͬ
    }

    public static void swap() {
        int[] temp = tp;
        tp = RANK;
        RANK = temp;
    }

    public static void Debug(int len) {
        System.out.print("index:\t");
        for (int i = 0; i < len; i++) System.out.print(i + " ");
        System.out.print("\nsa:\t");
        for (int i = 0; i < len; i++) System.out.print(SA[i] + " ");
        System.out.print("\nrank:\t");
        for (int i = 0; i < len; i++) System.out.print(RANK[i] + " ");
        System.out.print("\ntp:\t");
        for (int i = 0; i < len; i++) System.out.print(tp[i] + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		SimpleSuffixArray("aabaaaab");
//		System.out.println(Arrays.toString(SA));
        String string = "aabaaaab";
        suffix(string.toCharArray(), string.length());
        Debug(string.length());
        for (int i = 0; i < string.length(); i++) System.out.print(HEIGHT[i] + " ");
    }

    // ---------------------- �򵥵Ĵ���SA��HEIGHT -----------------------

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

    // ----------------------------- end -------------------------
}
