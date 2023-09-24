package Cache.CacheLLD.Cache;

import Cache.CacheLLD.Cache.Exceptions.not_found_ex;
import Cache.CacheLLD.Cache.Exceptions.storage_full_ex;
import Cache.CacheLLD.Cache.EvictionPolicy.eviction_policy;
import Cache.CacheLLD.Cache.Storage.storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Storage full. Trying to evict.");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full & nothing to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Evicting item..." + keyToRemove + " to empty storage.");
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Key doesn't exist.");
            return null;
        }
    }

}