package lab4s2;

public class TreeNode {

	public int id;
	public Student st;
	public TreeNode right;
	public TreeNode left;
	public TreeNode parent;

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
		System.out.print(this.id+": ");
		this.st.printStudent();
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
			z.st = y.st;
		}
		return y;
	}
	
	public void treeRemoveCriteria(MyList list, int course, int todayYear, TreeNode node){
		int fullYear = todayYear - this.st.year;
		if (this.st.malegender == true && fullYear >= 0 && this.st.course == course){
			list.addLast(node); 
		}
		if (left != null){
			left.treeRemoveCriteria(list, course, todayYear, left);
		}
		if(right != null){
			right.treeRemoveCriteria(list, course, todayYear, right);
		}
		return;
	}
}