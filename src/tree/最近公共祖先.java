package tree;

/*
 * ��һ�ö������Ͷ������е������ڵ㣬�ҵ��������ڵ�������������LCA��
 * �����ڵ������������ȣ���ָ�����ڵ�����и��׽ڵ��У������������ڵ㣩�����������ڵ�����Ĺ����Ľڵ㡣
 * ÿ���ڵ�������Ҷ���ָ�����⣬������һ������ָ��parent��ָ���Լ��ĸ��ס�
 * */
public class ����������� {

	static class TreeNode {
		public int value;
		public TreeNode left, right;

		public TreeNode() {
			// TODO Auto-generated constructor stub
		}

		public TreeNode(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.left = this.right = null;
		}

		public void visit() {
			System.out.print(this.value + " ");
		}

	}

	// �������
	public static void prePrint(TreeNode node) {
		if (node != null) {
			node.visit();
			prePrint(node.left);
			prePrint(node.right);
		}
	}

	// �������
	public static void midPrint(TreeNode node) {
		if (node != null) {
			midPrint(node.left);
			node.visit();
			midPrint(node.right);
		}
	}

	// �������
	public static void afterPrint(TreeNode node) {
		if (node != null) {
			afterPrint(node.left);
			afterPrint(node.right);
			node.visit();
		}
	}

	/*
	 * ����һ��Ķ�����ʱ��(�Ƕ��������) ��������һ��root���ʱ��
	 * 1.�ж�root�ǲ���null���rootΪnull����ô������ν���Ƚڵ㣬ֱ�ӷ���null�ͺ���
	 * 2.���root������������p������������q����ôroot�϶������������ 3.���pq����root������������ô����Ҫ�ݹ�root����������������ͬ��
	 */
	public static TreeNode searchLCA1(TreeNode root, TreeNode lNode, TreeNode rNode) {
		if (root == null || root == lNode || root == rNode) {
			return root;
		}
		TreeNode left = searchLCA1(root.left, lNode, rNode);
		TreeNode right = searchLCA1(root.right, lNode, rNode);
		if (left != null && right != null) {
			return root;
		} else {
			return (left == null) ? right : left;
		}
	}

	/*
	 * ���Ƕ��������ʱ ����ǰ�ڵ㶼����r, l. �����������в��� ����ǰ�ڵ㶼С��r, l. �����������в��� ����ǰ�ڵ����l��С��r, �򷵻ص�ǰ�ڵ�
	 */
	public static TreeNode searchLCA2(TreeNode root, TreeNode lNode, TreeNode rNode) {
		// swap
		if (lNode.value > rNode.value) {
			TreeNode temp = lNode;
			lNode = rNode;
			rNode = temp;
		}
		if (root == null || root == lNode || root == rNode) {
			return root;
		}
		if (root.value < lNode.value && root.value < rNode.value) {
			return searchLCA2(root.left, lNode, rNode);
		} else if (root.value > lNode.value && root.value > rNode.value) {
			return searchLCA2(root.right, lNode, rNode);
		} else {
			return root;
		}
	}

	/*
	 * tarjan�㷨(dfs+���鼯)
	 * 
	 */
	static int[] pre = new int[6666];
	static boolean[] vis = new boolean[6666];
	static int result = Integer.MIN_VALUE;
	
	private static void INITIALIZE() {
		// TODO Auto-generated method stub
		for (int i = 0; i < pre.length; i++) {
			pre[i] = i;
			vis[i] = false;
		}
	}

	public static void merge(int child, int parent) {
		int a = find(child);
		int b = find(parent);
		if (a != b) {
			pre[a] = b;
		}
	}

	// �ҵ�ĳ�ڵ��root
	public static int find(int x) {
		int r = x;
		while (pre[r] != r) {
			r = pre[r];
		}
		// ·��ѹ���㷨
		int i = x, j;
		while (pre[i] != r) {
			j = pre[i];
			pre[i] = r; 
			i = j;
		}
		return r;
	}

	public static void tarjan(TreeNode tree, TreeNode parent, TreeNode uNode, TreeNode vNode) {
		if (tree.left != null) {
			tarjan(tree.left, tree, uNode, vNode);
		}
		if (tree.right != null) {
			tarjan(tree.right, tree, uNode, vNode);
		}
		// ����û�з��ʹ��Ľڵ�
		int pos = tree.value;
		if (!vis[pos]) {
			/* 
			 * ���жϵ�ǰ�ڵ��Ƿ���Ҫ��ѯ�Ľڵ�
			 * ����ǰ�ڵ���Ҫ��ѯ�Ľڵ�u, ���ж϶�Ӧ�ڵ�v�Ƿ���ʹ�,���ʹ������v��root�ڵ�
			 * ����ǰ�ڵ���Ҫ��ѯ�Ľڵ�v, ���ж϶�Ӧ�ڵ�u�Ƿ���ʹ�,���ʹ������u��root�ڵ�
			 */
			if (pos == uNode.value && vis[vNode.value]) {
				result = find(vNode.value);
//				System.out.println(find(vNode.value));
			} else if (pos == vNode.value && vis[uNode.value]) {
				result = find(uNode.value);
//				System.out.println(find(uNode.value));
			}
			// ��ǵ�ǰ�ڵ��Ѿ������ʹ�, �����丸�ڵ�
			vis[pos] = true;
			// �ϲ�
			merge(pos, parent.value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 4 / \ 3 7 / \ 5 6
		 */
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(7);
		TreeNode l2 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.left = l2;
		r1.right = r2;
//		TreeNode rTreeNode = searchLCA1(root, l2, r2);
//		rTreeNode.visit();
		INITIALIZE();
		tarjan(root, root, l1, r2);
		System.out.println((result == Integer.MIN_VALUE) ? null : result);
	}

}
