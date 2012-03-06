package binarytree;
/**
 * Exception class for failed finds/removes in search tree.
*/


public class ItemNotFoundException extends RuntimeException {
    /**
     * Construct this exception object.
     */
    public ItemNotFoundException( ) {
        super( );
    }
    
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public ItemNotFoundException( String message ) {
        super( message );
    }
}