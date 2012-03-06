package binarytree;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E>
{
	
    /** The tree root. */
    protected BinaryTreeNode<E> root;
    
    /**
     * Instantiate the tree.
     */
    public BinarySearchTree() 
    {
        this.root = null;
    }
    
    /**
     * Insert into the tree.
     * @param value the value to insert.
     * @throws DuplicateItemException if value is already present.
     */
    public void insert(E value) 
    {
        this.root = insert( value, this.root );
    }
    
    /**
     * Remove from the tree.
     * @param value the value to remove.
     * @throws ItemNotFoundException if value is not found.
     */
    public void remove(E value) 
    {
        this.root = remove( value, this.root );
    }
    
    /**
     * Remove minimum element from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin() 
    {
       this.root = removeMin(this.root);
    }
    
    /**
     * Find the smallest element in the tree.
     * @return smallest element or null if empty.
     */
    public E findMin() 
    {
        return valueAt(findMin(this.root));
    }
    
    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public E findMax() {
        return valueAt(findMax(this.root));
    }
    
    /**
     * Find an item in the tree.
     */
    public E find(E value) 
    {
        return valueAt(find(value, this.root ));
    }
    
    /**
     * Reset the tree.
     */
    public void makeEmpty() 
    {
        root = null;
    }
    
    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() 
    {
        return root == null;
    }
    
    /**
     * Internal method to get element field.
     * @param node the node.
     * @return the element field or null if t is null.
     */
    private E valueAt( BinaryTreeNode<E> node ) 
    {
        return node == null ? null : node.getValue();
    }
    
    /**
     * Internal method to insert into a subtree.
     * @param value the item to insert.
     * @param node the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryTreeNode<E> insert(E value, BinaryTreeNode<E> node) 
    {
        if( node == null )
        {
          node = new BinarySearchTreeNode<E>(value);
        }
        else if( value.compareTo( node.getValue() ) < 0 )
        {
          node.setLeft(insert( value, node.getLeft()));
        }
        else if( value.compareTo( node.getValue() ) > 0 )
        {
            node.setRight(insert(value, node.getRight()));
        }
        else
        {
            throw new DuplicateItemException( node.getValue().toString( ) );  // Duplicate
        }
        return node;
    }
    
    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryTreeNode<E> remove( E value, BinaryTreeNode<E> node ) {
        if( node == null )
        {
            throw new ItemNotFoundException( value.toString( ) );
        }
        if( value.compareTo( node.getValue() ) < 0 )
        {
            node.setLeft(remove(value, node.getLeft()));
        }
        else if( value.compareTo( node.getValue() ) > 0 )
        {
            node.setRight(remove( value, node.getRight()));
        }
        else if( node.getLeft() != null && node.getRight() != null ) // Two children
        {
            node.setValue(findMin( node.getRight() ).getValue());
            node.setRight(removeMin(node.getRight()));
        } 
        else
        {
            node = ( node.getLeft() != null ) ? node.getLeft() : node.getRight();
        }
        return node;
    }
    
    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryTreeNode<E> removeMin( BinaryTreeNode<E> node ) 
    {
        if( node == null )
        {
            throw new ItemNotFoundException();
        }
        else if( node.getLeft() != null ) 
        {
            node.setLeft(removeMin(node.getLeft()));
            return node;
        }
        else
        {
            return node.getRight();
        }
    }
    
    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryTreeNode<E> findMin(BinaryTreeNode<E> node ) 
    {
        if( node != null )
            while( node.getLeft() != null )
                node = node.getLeft();
        
        return node;
    }
    
    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryTreeNode<E> findMax(BinaryTreeNode<E> node) 
    {
      if( node != null )
      {
            while( node.getRight() != null )
            {
                node = node.getRight();
            }
      }
        return node;
    }
    
    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryTreeNode<E> find( E value, BinaryTreeNode<E> node ) 
    {
        while( node != null ) 
        {
            if( value.compareTo( node.getValue() ) < 0 )
                node = node.getLeft();
            else if( value.compareTo( node.getValue() ) > 0 )
                node = node.getRight();
            else
                return node;    // Match
        }
        return null;         // Not found
    }
    
    private String inOrderTreeWalk(BinaryTreeNode<E> node)
    {
    	String output = "";
    	if(node != null)
    	{
    		output += " Left:" + inOrderTreeWalk(node.getLeft());
    		output += " Main:" + node.getValue().toString();
    		output += " Right:" + inOrderTreeWalk(node.getRight());
    	}
    	return output;
    }
    
    private String preOrderTreeWalk(BinaryTreeNode<E> node)
    {
    	String output = "";
    	if(node != null)
    	{
    		output +=node.getValue().toString();
    		output +=inOrderTreeWalk(node.getLeft());
    		output +=inOrderTreeWalk(node.getRight());
    	}
    	return output;
    }
    
    private String postOrderTreeWalk(BinaryTreeNode<E> node)
    { 
    	String output = "";
    	if(node != null)
    	{
    		output +=inOrderTreeWalk(node.getLeft());
    		output +=inOrderTreeWalk(node.getRight());
    		output +=node.getValue().toString();
    	}
    	return output;
    }
    
    public void inOrderTraversal()
    {
    	System.out.println(inOrderTreeWalk(this.root));
    }
    public void preOrderTraversal()
    {
    	System.out.println(preOrderTreeWalk(this.root));
    }
    public void postOrderTraversal()
    {
    	System.out.println(postOrderTreeWalk(this.root)); 
    }
}



