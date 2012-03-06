package binarytree;

public interface BinaryTree<E extends Comparable<E>>
{
   public void inOrderTraversal();
   public void postOrderTraversal();
   public void preOrderTraversal();
   public void insert(E value);
   public void remove(E value);
   public E find(E value);
}
