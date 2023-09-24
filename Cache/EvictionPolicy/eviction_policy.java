package Cache.CacheLLD.Cache.EvictionPolicy;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}