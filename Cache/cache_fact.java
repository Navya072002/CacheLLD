package Cache.CacheLLD.Cache;

import Cache.CacheLLD.Cache.cache;
import Cache.CacheLLD.Cache.EvictionPolicy.lru;
import Cache.CacheLLD.Cache.Storage.hash_map_storage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}