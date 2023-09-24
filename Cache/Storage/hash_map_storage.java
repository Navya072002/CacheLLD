package Cache.CacheLLD.Cache.Storage;

import Cache.CacheLLD.Cache.Exceptions.not_found_ex;
import Cache.CacheLLD.Cache.Exceptions.storage_full_ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull())
            throw new StorageFullException("Storage full");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key))
            throw new NotFoundException(key + "not found in cache.");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key))
            throw new NotFoundException(key + "not found in cache.");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}