package lab4s2;

public class MyTree {
	private TreeNode root;

	public MyTree(){}

	public boolean containsKey(int id) {
		if (root!=null){
			if (root.treeSearch(id, root)!=null){
				return true;
			}
		}
		return false;
	}

	public void traverse(){
		if (root!=null){
			System.out.println("There are students:");
			root.postOrderTreeWalk();
			System.out.println("");
			return;
		}
		System.out.println("This tree is empty\n");
		return;
	}

	public Student insert(int id, Student value) {
		if (root == null){
			root = new TreeNode(id, value);
			return null;
		}
		
		TreeNode oldNode = root.treeSearch(id, root);
		if (oldNode != null){
			Student old = oldNode.st;
			oldNode.st = value;
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

		
		return null;
	}

	public int size() {
		if (root != null){
			return root.getSize();
		}
		return 0;
	}

	public Student get(int id) {
		return root.treeSearch(id, root).st;
	}

	public Student remove(int id){
		TreeNode current = root.treeSearch(id, root);
		if(current == null){
			return null;
		}
		Student toReturn = current.st;
		if (current.left == null && current.right == null){
			if (current.parent.id < id){
				current.parent.right = null;
			}
			else{
				current.parent.left = null;
			}
			return toReturn;
		}
		if (current.left == null){
			if (current.parent.id < id){
				current.parent.right = current.right;
				current.right.parent = current.parent;
			}
			else{
				current.parent.left = current.right;
				current.right.parent = current.parent;
			}
			return toReturn;
		}
		if (current.right == null){
			if (current.parent.id < id){
				current.parent.right = current.left;
				current.left.parent = current.parent;
			}
			else{
				current.parent.left = current.left;
				current.left.parent = current.parent;
			}
			return toReturn;
		} else {
		/*if (current.left != null && current.right != null){*/
			return root.treeDelete(current, this.root).st;
		}
	}

	/*
	private void remove(TreeNode toDel){
		remove(toDel.id);
	}
	*/

	public int remove(int course, int todayYear) {
		if (root==null){
			System.out.println("Tree is empty");
			return 0;
		}
		int size = root.getSize();
		MyList list = new MyList();
		root.treeRemoveCriteria(list, course, todayYear, root);
		for (int i=0; i<list.getSize(); i++){
			remove(list.getFromIndex(i).id);
		}
		if (size-list.getSize() != root.getSize()){
			System.out.println("Fail!");
		}
		return list.getSize();
	}

}
