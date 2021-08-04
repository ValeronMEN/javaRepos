package ex3;

public class TreeNode {

	public int id;
	public int data;
	public TreeNode right;
	public TreeNode left;
	public TreeNode parent;

	public TreeNode(int id, int data) {
		this.data = data;
		this.id = id;
	}

	public TreeNode(int id, int data, TreeNode parent) {
		this.data = data;
		this.id = id;
		this.parent = parent;
	}
	
	public void printNode(){
		System.out.print(this.id+") ");
		System.out.print(this.data+"; ");
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
	
	public TreeNode treeSearch(int key){
		if (key < this.id && left != null){
			return left.treeSearch(key);
		}
		if(key > this.id && right != null){
			return right.treeSearch(key);
		}
		if (key == this.id){
			return this; 
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
	
	public TreeNode treeSuccessor(){
		if (this.right != null){
			return treeMin(this.right);
		}
		return null;
	}
}