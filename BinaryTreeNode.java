package binarytree;

public interface BinaryTreeNode<E extends Comparable<E>> {
  public BinaryTreeNode<E> getParent();
  public BinaryTreeNode<E> getLeft();
  public BinaryTreeNode<E> getRight();
  public void setLeft(BinaryTreeNode<E> node);
  public void setRight(BinaryTreeNode<E> node);
  public void setParent(BinaryTreeNode<E> node);
  public E getValue();
  public void setValue(E value);
  public Comparable<E> getKey();
}
