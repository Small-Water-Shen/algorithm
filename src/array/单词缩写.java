package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * ����һ�� n ����ͬ�ķǿ��ַ���������Ҫ�����¹���Ϊÿ���������� ��С ����д��
 * �ӵ�һ���ַ���ʼ��Ȼ������м���д�����ַ��ĳ��ȣ�������һ���ַ���
 * ����г�ͻ�����Ƕ�����ʹ�����ͬ����д��ʹ�ýϳ���ǰ׺�������ǽ�ʹ�õ�һ���ַ���ֱ��ʹ���ʵ���д��ӳ���ΪΨһ�� ���仰˵�����յõ�����д����ӳ�䵽���ԭʼ���ʡ�
 * �����д����ʹ���ʸ��̣��򲻽�����д������ԭ��
 * n ��ÿ�����ʵĳ��Ⱦ����ᳬ�� 400��
 * ÿ�����ʵĳ��ȴ��� 1�� 
 * ��Щ��ֻ����СдӢ����ĸ��
 * ���ش�Ӧ����ԭʼ���鱣����ͬ��˳��
 * ���� dict = ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * ���� ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 */
public class ������д {
	
	/********************** ����1 (not AC) ***********************
	 * �г�ͻ�������
	 * 1. ������ͬ�ĵ���
	 * 2. �����һ��letter��ͬ
	 * ����ֻ�г�����ͬ�ĵ��ʲŻ��г�ͻ�Ŀ��ܣ���Ϊ���Ȳ�ͬ����д������Ҳ��ͬ��
	 * ���ߣ���Ϊ���һ���ַ��ǹ̶������
	 * ��Ҫȡ����ǰ׺���Ƿ�һ��������internal=>inte3l, intarval=>inta3l
	 * �ⷨ��
	 * �Ƚ�������ͬ�Ĵ��ó�������ȷ����Щ������ͬ�Ĵ��Ĺ������ȵ�λ��k����ô�Ϳ��Դ�k+1����ʼ��д
	 * Ѱ�ҹ������ȣ�����ʹ������������Եõ������ͬ�ĳ���
	 */
	// ���浥���Լ��±�
	public static class word {
		String str;
		int index;
		public word(String str, int index) {
			// TODO Auto-generated constructor stub
			this.index = index;
			this.str = str;
		}
		@Override
		public String toString() {
			return "('" + str + "', " + index + ")";
		}
	}
	
    public static String[] wordsAbbreviation1(String[] dict) {
        // write your code here
    	Map<Integer, ArrayList<word>> words = new HashMap<>();
    	for (int i = 0; i < dict.length; i++) {
    		int len = dict[i].length();
    		ArrayList<word> value = words.get(len);
    		if (value == null) {
				value = new ArrayList<>();
				value.add(new word(dict[i], i));
				words.put(len, value);
			} else {
				value.add(new word(dict[i], i));
				words.put(len, value);
			}
		}
//    	System.out.println(words.toString());
    	for (int item : words.keySet()) {
			if (words.get(item).size() > 1) {
				ArrayList<word> value = words.get(item);
				// ��ͬ���ȵ��鰴����ĸ����
				Collections.sort(value, new Comparator<word>() {
					@Override
					public int compare(word o1, word o2) {
						// TODO Auto-generated method stub
						return o1.str.compareTo(o2.str);
					}
				});
				int len = value.size();
				System.out.println(item + ": " + value.toString());
				for (int i = 0; i < len; i++) {
					int maxPub = 0;
					boolean canAbbr = true;
					for (int j = 0; j < len; j++) {
						if (i == j) continue;
						String iStr = value.get(i).str;
						String jStr = value.get(j).str;
						if (iStr.charAt(iStr.length() - 1) != jStr.charAt(jStr.length() - 1)) {
							continue;
						}
						// Ѱ����Ĺ�������
						maxPub = findPub(iStr, jStr);
						String abbr1 = abbreviate(iStr, maxPub + 1);
						String abbr2 = abbreviate(jStr, maxPub + 1);
						if (abbr1.equals(abbr2)) {
							canAbbr = false;
							break;
						}
					}
					if (canAbbr) dict[value.get(i).index] = abbreviate(dict[value.get(i).index], maxPub + 1); 
				}
			} else {
				word w = words.get(item).get(0);
				dict[w.index] = abbreviate(dict[w.index], 1);
			}
		}
    	return dict;
    }
    
    public static int findPub(String s1, String s2) {
    	int p1 = 0, p2 = 0;
    	while (p1 < s1.length() - 1 && p2 < s2.length() - 1
    			&& s1.charAt(p1) == s2.charAt(p2)) {
				++p1;
				++p2;
		}
    	return p1;
    }
    
    // С��4����д
    public static String abbreviate(String str, int preLen) {
    	return (preLen >= str.length() - 2) ? str : 
    		str.substring(0, preLen) + (str.length() - 1 - preLen) + str.charAt(str.length() - 1);
    }
    
    // ********************* ����2 (AC) ***********************
    /* ��һ��pre�����¼���ʵ�ǰ׺���ȣ���ʼΪ1
     * �Ƚ������ַ�������pre�����Ӧ�Ľ������̣��ٱ������̺�ĵ��ʣ�����ͻ
     * ����ͻ�ͽ���ͻ���ʼ������뼯���У�pre��Ӧǰ׺����+1,��������֪��û�г�ͻΪֹ
     */
    public static String[] wordsAbbreviation(String[] dict) {
    	int len = dict.length;
    	int[] pre = new int[len];
    	String[] res = new String[len];
    	Arrays.fill(pre, 1);
    	for (int i = 0; i < len; i++) {
			res[i] = abbreviate(dict[i], pre[i]); 
		}
//    	System.out.println(Arrays.toString(res));
    	for (int i = 0; i < len; i++) {
			while (true) {
				Set<Integer> set = new HashSet<>();
				for (int j = i + 1; j < len; j++) {
					if (res[i].equals(res[j])) set.add(j);
				}
				if (set.isEmpty()) break;
				set.add(i);
				for (int index : set) {
					res[index] = abbreviate(dict[index], ++pre[index]);
				}
			}
		}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(wordsAbbreviation(new String[] {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"})));
		/*
		System.out.println(Arrays.toString(wordsAbbreviation(new String[] {
				"aaaaaaaaaaaaaaaaabbbbbbbbbbkjufifeudlk","aaaaaaaaaaaaaaaaabbbbbbbbbbojqbrmfsyfqqsrwhled","aaaaaaaaaaaaaaaaabbbbbbbbbbolhhvpdpkfoidvsqqpd",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbwzrnlhyendbfhepobh","aaaaaaaaaaaaaaaaabbbbbbbbbbopsdoysmslhriwwwu","aaaaaaaaaaaaaaaaabbbbbbbbbbbwjevqdzacev",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbrhweyqriepzroy","aaaaaaaaaaaaaaaaabbbbbbbbbbcnjfjigbhlklazdqgiuk","aaaaaaaaaaaaaaaaabbbbbbbbbbfasjlcdvacpfeoj",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbzrlmyegzwztrhgqm","aaaaaaaaaaaaaaaaabbbbbbbbbbsabrljwjkvad","aaaaaaaaaaaaaaaaabbbbbbbbbbblgubwcxecfis",
				"aaaaaaaaaaaaaaaaabbbbbbbbbblilftczybunuobolyt","aaaaaaaaaaaaaaaaabbbbbbbbbbbppubgbkifd","aaaaaaaaaaaaaaaaabbbbbbbbbbmobkpochkyoujbhi",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbvivbqhsnzkkuaw","aaaaaaaaaaaaaaaaabbbbbbbbbbmdfewpyryuc","aaaaaaaaaaaaaaaaabbbbbbbbbbwnengvqbcrnqvp",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbgxpgvmnmmc","aaaaaaaaaaaaaaaaabbbbbbbbbbipqsetrtzstbxbr","aaaaaaaaaaaaaaaaabbbbbbbbbbppjuokaakaur",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbliascfhjkoaoipnjfpza","aaaaaaaaaaaaaaaaabbbbbbbbbbcurqfbnwaeaecnwbzjxx","aaaaaaaaaaaaaaaaabbbbbbbbbbwerunjzxrxysrwe",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbmgiftahfve","aaaaaaaaaaaaaaaaabbbbbbbbbbvfilicjzkxjel","aaaaaaaaaaaaaaaaabbbbbbbbbbtodddhiogutkleg",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbjpdkecyqjk","aaaaaaaaaaaaaaaaabbbbbbbbbbxklpodeyvvpormm","aaaaaaaaaaaaaaaaabbbbbbbbbbepfdtqwxnseptm",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbipkimfiegpxc","aaaaaaaaaaaaaaaaabbbbbbbbbbvobtdxwkgmeihlwehyy","aaaaaaaaaaaaaaaaabbbbbbbbbbdvmonnkdkyareqprlixp",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbkocjwexxlvlaw","aaaaaaaaaaaaaaaaabbbbbbbbbbprdbqdxkna","aaaaaaaaaaaaaaaaabbbbbbbbbbqkgvantcuwhvegiddwwi",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbdyjysydfihjysnmdrg","aaaaaaaaaaaaaaaaabbbbbbbbbbvuecaamqmedpjozahb","aaaaaaaaaaaaaaaaabbbbbbbbbbvgrrtznjnoudzhjlv",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbzmhztrtxvmgujlix","aaaaaaaaaaaaaaaaabbbbbbbbbbjnlkcvgqodiaduadrr","aaaaaaaaaaaaaaaaabbbbbbbbbbhrgfqmhktqld",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbnznbubvpomh","aaaaaaaaaaaaaaaaabbbbbbbbbbbjxllcohnworrkccgz","aaaaaaaaaaaaaaaaabbbbbbbbbbvezvdzhrtiezu",
				"aaaaaaaaaaaaaaaaabbbbbbbbbblerlstmbmc","aaaaaaaaaaaaaaaaabbbbbbbbbbeukfebwmqcw","aaaaaaaaaaaaaaaaabbbbbbbbbbulatiybbzkysaco",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbcdxksbqede","aaaaaaaaaaaaaaaaabbbbbbbbbbpqyapdgwlchhsphrje","aaaaaaaaaaaaaaaaabbbbbbbbbbttvgpfeithql",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbzexpmlggutgcjkdjkuxk","aaaaaaaaaaaaaaaaabbbbbbbbbbycmbcitrmyviztp","aaaaaaaaaaaaaaaaabbbbbbbbbbccybojvvwldhu",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbtmpojutxufmzmsoktdn","aaaaaaaaaaaaaaaaabbbbbbbbbbopavgkytqmrdn","aaaaaaaaaaaaaaaaabbbbbbbbbbttabhxgcyau",
				"aaaaaaaaaaaaaaaaabbbbbbbbbbtiydxbummwn","aaaaaaaaaaaaaaaaabbbbbbbbbbytftfezlwtbxwx","aaaaaaaaaaaaaaaaabbbbbbbbbbbajuqotjrhoukeezls"
		})));
		*/
	}

}
