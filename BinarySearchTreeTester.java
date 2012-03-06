package binarytree;
import java.util.Random;

public class BinarySearchTreeTester 
{
	   
    // Test program
    public static void main( String [ ] args ) 
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 4000;
        final int GAP  =   37;
        
        System.out.println( "Checking... (no more output means success)" );
        
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
        {
            t.insert( new Integer( i ) );
        }

        for( int i = 1; i < NUMS; i+= 2 )
        {
            t.remove( new Integer( i ) );
        }
        
        if( ((Integer)(t.findMin( ))).intValue( ) != 2 || ((Integer)(t.findMax( ))).intValue( ) != NUMS - 2 )
        {
            System.out.println( "FindMin or FindMax error!" );
        }
        
        for( int i = 2; i < NUMS; i+=2 )
        {
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i )
                System.out.println( "Find error1!" );
        }
        
        for( int i = 1; i < NUMS; i+=2 ) 
        {
            if( t.find( new Integer( i ) ) != null )
                System.out.println( "Find error2!" );
        }
        t.makeEmpty();
        Random rand = new Random(System.currentTimeMillis());
        for( int i = 1; i < 20; i++)
        {
        	try{
        	t.insert(rand.nextInt(50));
        	}
        	catch (DuplicateItemException e)
        	{
              //Continue
        	}
        }
        System.out.println("In Order Traversal:");
        t.inOrderTraversal();
        System.out.println("Post Order Traversal:");
        t.postOrderTraversal();
        System.out.println("Pre Order Traversal:");
        t.preOrderTraversal();
  
    }
}
