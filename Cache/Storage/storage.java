package Cache.CacheLLD.Cache.Storage;

import Cache.CacheLLD.Cache.Exceptions.not_found_ex;
import Cache.CacheLLD.Cache.Exceptions.storage_full_ex;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}