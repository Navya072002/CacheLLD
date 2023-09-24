package Cache.CacheLLD.Cache.Exceptions;

public class StorageFullException extends RuntimeException {

    public StorageFullException(String message) {
        super(message);
    }
}