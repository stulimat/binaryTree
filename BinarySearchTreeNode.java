package binarytree;

public class BinarySearchTreeNode<E extends Comparable<E>> implements BinaryTreeNode<E>{
	  private BinaryTreeNode<E> parent;
	  private BinaryTreeNode<E> left;
	  private BinaryTreeNode<E> right;
	  private E value;

	public BinarySearchTreeNode(E value)
	{
	  this.value = value;
	  this.setLeft(null);
	  this.setRight(null);
	  this.setParent(null);
	}
	public BinarySearchTreeNode(BinaryTreeNode<E> node)
	{
		this.setValue(node.getValue());
		this.setLeft(node.getLeft());
		this.setRight(node.getRight());
		this.setParent(node.getParent());
	}
	
	public BinarySearchTreeNode()
	{
		this.setValue(null);
		this.setLeft(null);
		this.setRight(null);
	}
	  
	public Comparable<E> getKey()
	{
	  return value;
	}

	public BinaryTreeNode<E> getParent() 
	{
		return parent;
	}

	public void setParent(BinaryTreeNode<E> parent) 
	{
		this.parent = parent;
	}

	public BinaryTreeNode<E> getLeft() 
	{
		return left;
	}

	public void setLeft(BinaryTreeNode<E> left) 
	{
		this.left = left;
	}

	public BinaryTreeNode<E> getRight() 
	{
		return right;
	}

	public void setRight(BinaryTreeNode<E> right) 
	{
		this.right = right;
	}
	public E getValue() 
	{
		return this.value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	
	public int compareTo(BinaryTreeNode<E> node)
	{
		return this.value.compareTo(node.getValue());
	}
}

