package union_find_sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
 * ����һ���ʻ��б�ÿ��Ԫ��accounts [i]��һ���ַ����б����е�һ��Ԫ��accounts [i] [0]���˻����ƣ�����Ԫ��������ʻ��ĵ����ʼ���
 * ���ڣ�������ϲ���Щ�ʻ���
 * ��������ʻ�����ͬ�ĵ����ʼ���ַ�����������ʻ��϶�����ͬһ���ˡ�
 * ��ע�⣬��ʹ�����ʻ�������ͬ�����ƣ�����Ҳ�������ڲ�ͬ���ˣ���Ϊ������ͬ���˿��ܻ�ʹ����ͬ�����ơ�
 * һ���˿���ӵ�������������˻��������������ʻ��϶�������ͬ�����ơ�
 * �ϲ��ʻ��󣬰����¸�ʽ�����ʻ���ÿ���ʻ��ĵ�һ��Ԫ�������ƣ�����Ԫ���ǰ��ֵ��������ĵ����ʼ����ʻ�������԰��κ�˳�򷵻ء�
 * �˻�������1~1000֮��
 * ÿ���˻��µĵ����ʼ���1~10֮��
 * ÿ���ַ����ĳ�����1~30֮��
 */
public class �˻��ϲ� {
	
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // write your code here
    	if (accounts == null) return null;
    	if (accounts.size() == 0) return new ArrayList<List<String>>();
		// initialize
    	Map<String, Integer> id = new HashMap<>(); // email��Ψһ��,name��һ��
    	int[] pre = new int[accounts.size()];
    	for (int i = 0; i < pre.length; i++) pre[i] = i; // ��ÿ���˻���index��Ϊ�ڵ�
		for (int i = 0; i < accounts.size(); i++) {
			List<String> em = accounts.get(i);
			// em : name, email_1, email_2...
			for (int j = 1; j < em.size(); ++j) {
				String email = em.get(j);
				if (!id.containsKey(email)) id.put(email, i);
				// union
				else union(pre, i, id.get(email)); // ��ǰ��i��Ϊ�ӽڵ���뵽�Ѵ��ڵ�֮ǰ��id��
			}
		}
		// �����Ѿ��ϲ��õ�index����email����, TreeSet�Դ���������(����)
		Map<Integer, TreeSet<String>> users = new HashMap<>();
		for (int i = 0; i < pre.length; i++) {
			int root = find(pre, i); // get root
			users.putIfAbsent(root, new TreeSet<>());
			// ����ǰ�˻���email���ӵ�root��(start with 1, 0 is name)
			users.get(root).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
		}
		// Add into res
		List<List<String>> res = new ArrayList<>();
		for (int user : users.keySet()) {
			List<String> emails = new ArrayList<>(users.get(user));
			emails.add(0, accounts.get(user).get(0)); // insert name into 0 index
			res.add(emails);
		}
		return res;
    }
    
    public static int find(int[] pre, int x) {
    	int r = x;
    	while (r != pre[r]) {
			r = pre[r];
		}
    	// ·��ѹ��
    	int i = x, j;
    	while (pre[i] != r) {
			j = pre[i];
			pre[i] = r; 
			i = j;
		}
    	return r;
    }
    
    public static void union(int[] pre, int x, int y) {
    	int a = find(pre, x);
    	int b = find(pre, y);
    	if (a != b) pre[a] = b; // b is root
    }

	/* ------------------ limit time -------------------------------
	// ������emailΪ���ģ���Ϊname�����ظ�
	static Map<String, String> pre; // store email
	static Map<String, String> owner; // store name of email
	static Map<String, List<String>> res; // store result which processed
	
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // write your code here
    	if (accounts == null) return null;
    	if (accounts.size() == 0) return new ArrayList<List<String>>();
		pre = new HashMap<>();
		owner = new HashMap<>();
    	res = new HashMap<>();
		// initialize
		for (int i = 0; i < accounts.size(); i++) {
			List<String> em = accounts.get(i);
			// em : name, email_1, email_2...
			for (int j = 1; j < em.size(); ++j) {
				owner.put(em.get(j), em.get(0));
				pre.put(em.get(j), em.get(j)); // keep self
			}
		}
//		System.out.println(pre.toString() + "\n" + owner.toString());
		// ��ÿ���˻��µĵ�һ��email��Ϊroot
		for (int i = 0; i < accounts.size(); i++) {
			List<String> em = accounts.get(i);
			for (int j = 2; j < em.size(); ++j) {
				union(em.get(j), em.get(1)); // let email_1 be root of others emails
			}
		}
//		for (String i : pre.keySet()) System.out.println(pre.get(i) + ": " + i);
		// ���������µļ���
		for (int i = 0; i < accounts.size(); i++) {
			List<String> em = accounts.get(i);
			for (int j = 1; j < em.size(); ++j) {
				String root = find(em.get(j));
				res.putIfAbsent(root, new ArrayList<>());
				if (res.get(root).contains(em.get(j))) continue;
				res.get(root).add(em.get(j));
			}
		}
//		for (String key : res.keySet()) System.out.println(key + ": " + res.get(key));
		accounts.clear();
		for (String key : res.keySet()) {
			List<String> values = res.get(key);
			Collections.sort(values);
			List<String> emails = new ArrayList<>();
			emails.add(owner.get(key)); // get name
			emails.addAll(values);
			accounts.add(emails);
		}
    	return accounts;
    }
    
    public static String find(String x) {
//    	if (pre.get(x).equals(x)) return x;
//    	return pre.put(x, find(pre.get(x)));
    	String r = x;
    	while (!pre.get(r).equals(r)) {
			r = pre.get(r);
		}
    	// ·��ѹ��
    	String i = x, j;
    	while (!pre.get(i).equals(r)) {
			j = pre.get(i);
			pre.put(i, r);
			i = j;
		}
    	return r;
    }
    
    public static void union(String x, String y) {
    	String a = find(x);
    	String b = find(y);
    	if (!a.equals(b)) pre.put(a, b); // b is root
    }
    */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> accounts = new ArrayList<List<String>>();
		List<String> emails = new ArrayList<>();
		emails.add("David");
		emails.add("David0@m.co");
		emails.add("David1@m.co");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("David");
		emails.add("David3@m.co");
		emails.add("David4@m.co");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("David");
		emails.add("David4@m.co");
		emails.add("David5@m.co");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("David");
		emails.add("David2@m.co");
		emails.add("David3@m.co");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("David");
		emails.add("David1@m.co");
		emails.add("David2@m.co");
		accounts.add(emails);
		accountsMerge(accounts);
		for (List<String> account : accounts) System.out.println(account.toString());
	}

}
