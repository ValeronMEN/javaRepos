package ex3;

public class MyTree {
	private TreeNode root;

	public MyTree(){}

	public boolean containsKey(int id) {
		if (root!=null){
			if (root.treeSearch(id)!=null){
				return true;
			}
		}
		return false;
	}

	public void traverse(){
		if (root!=null){
			System.out.println("There are numbers in Tree:");
			root.postOrderTreeWalk();
			System.out.println("");
			return;
		}
		System.out.println("This tree is empty\n");
		return;
	}

	public int insert(int id, int value) {
		if (root == null){
			root = new TreeNode(id, value);
			return 0;
		}
		
		TreeNode oldNode = root.treeSearch(id);
		if (oldNode != null){
			int old = oldNode.data;
			oldNode.data = value;
			return old;
		}
		
		TreeNode z = new TreeNode(id, value);
		TreeNode y = null;
		TreeNode x = root;
		while(x != null){
			y = x;
			if (z.id < x.id){
				x = x.left;
			}
			else {
				x = x.right;
			}
		}
		
		z.parent = y;
		if(z.id < y.id){
			y.left = z;
		}
		else{
			y.right = z;
		}
		
		return 0;
	}

	public int size() {
		if (root != null){
			return root.getSize();
		}
		return 0;
	}

	public int get(int id) {
		return root.treeSearch(id).data;
	}

	public int remove(int id){
		TreeNode current = root.treeSearch(id);
		return remove(current);
	}

	private int remove(TreeNode toDel){
		TreeNode x=null, y=null;
		if (toDel.left == null || toDel.right == null){
			y = toDel;
		}
		else {
			y = toDel.treeSuccessor();
		}
			
		if (y.left != null){
			x = y.left;
		}
		else{
			x = y.right;
		}
			
		if (x!=null){
			x.parent = y.parent;
		}
			
		if (y.parent == null){
			this.root = x;
		}
		else if(y == y.parent.left){
			y.parent.left = x;
		}
		else{
			y.parent.right = x;
		}
			
		if (y!=toDel){
			toDel.id = y.id;
			toDel.data = y.data;
		}
		return y.data;
	}
}
