package LA3dot3_Generic_Classes.classes;

public class InvalidIndexException extends RuntimeException{
    public InvalidIndexException(int max) {
        super("Index must be between 0 and " + max);
    }
    public InvalidIndexException() {
        super("Cannot use index on empty array");
    }
}