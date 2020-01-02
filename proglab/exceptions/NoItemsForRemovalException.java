package proglab.exceptions;

public class NoItemsForRemovalException extends Exception {
    public NoItemsForRemovalException(String message) {
        System.out.println(message);
    }
}
