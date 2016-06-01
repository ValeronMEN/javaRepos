package lab4s2;

public class MyTree {
	class TreeNode {

		private int id;
		private Student st;
		private TreeNode right;
		private TreeNode left;
		private TreeNode parent;

		public TreeNode(int id, Student s) {
			this.st = s;
			this.id = id;
		}

		public TreeNode(int id, Student s, TreeNode parent) {
			this.st = s;
			this.id = id;
			this.parent = parent;
		}
		
		public void printNode(){
			System.out.println(this.id+" - "+st.name+" "+st.surname);
		}
		
		public void postOrderTreeWalk(){
			if (this.left != null){
				left.postOrderTreeWalk();
			}
			if (this.right != null){
				right.postOrderTreeWalk();
			}
			this.printNode();
		}
		
		public int getSize(){
			int result = 0;
			if (this.left != null){
				result += left.getSize();
			}
			if (this.right != null){
				result += right.getSize();
			}
			return result += 1;
		}
		
		public TreeNode treeSearch(int key, TreeNode node){
			if (key == this.id){
				return node; 
			}
			if (key < this.id && left != null){
				return left.treeSearch(key, left);
			}
			if(key > this.id && right != null){
				return right.treeSearch(key, right);
			}
			return null;
		}
		
		public TreeNode treeMin(TreeNode node){
			if (node!=null){
				while (node.left != null){
					node = node.left;
				}
				return node;
			}
			else{
				return null;
			}
		}
		
		public TreeNode treeMax(TreeNode node){
			if (node!=null){
				while (node.right != null){
					node = node.right;
				}
				return node;
			}
			else{
				return null;
			}
		}
		
		public TreeNode treeSuccessor(TreeNode node){
			if (node.right != null){
				return treeMin(node.right);
			}
			return null;
		}
		
		public TreeNode treeDelete(TreeNode z, TreeNode root){
			TreeNode x=null, y=null;
			if (z.left == null || z.right == null){
				y = z;
			}
			else {
				y = treeSuccessor(z);
				if (y.left != null){
					x = y.left;
				}
				else {
					x = y.right;
				}
			}
			if (x!=null){
				x.parent = y.parent;
			}
			if (y.parent == null){
				root = x;
			}
			else if(y == y.parent.left){
				y.parent.left = x;
			}
			else{
				y.parent.right = x;
			}
			
			if (y!=z){
				z.id = y.id;
			}
			return y;
		}
	}

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
		if (containsKey(id) == true){
			Student old = root.treeSearch(id, root).st;
			root.treeSearch(id, root).st = value;
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
		if (y == null){
			root = z;
		}
		else if(z.id < y.id){
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


	/**
	 * Removes the student for this id from this tree if present.
	 * 
	 * @param id
	 *            id for which student should be removed
	 * @return the previous value of student associated with id, or null if
	 *         there was no student for id.
	 */
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

	private void remove(TreeNode toDel){
		TreeNode current = root.treeSearch(toDel.id, root);
		if (current.left == null && current.right == null){
			if (current.parent.id < toDel.id){
				current.parent.right = null;
			}
			else{
				current.parent.left = null;
			}
			return;
		}
		if (current.left == null || current.right == null){
			return;
		}
		else{
			return;
		}
	}

	/**
	 * Remove from a tree all students that satisfy specified criteria
	 * 
	 * @param removeCriteria
	 *            one or more criteria by witch students will be removed from
	 *            this tree
	 * @return number of students was be removed
	 */
	public int remove(String... removeCriteria) {
		// TODO
		// 1) find all nodes witch students satisfy specified removeCriteria
		// save in a list nodes to be removed
		// 2) call method remove (node) for each node in a list
		// 3) call size method to check successful removing
		// 4) return difference between old size and new size
		return 0;

	}

}
