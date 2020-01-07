package proglab.exceptions;

// unchecked

public class FasterThanLightException extends RuntimeException {
    public FasterThanLightException(String message){
        super(message);
    }
}
