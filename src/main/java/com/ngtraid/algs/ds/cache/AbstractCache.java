package com.ngtraid.algs.ds.cache;

import com.ngtraid.algs.ds.api.Cache;

/**
 * @author jaron
 * created on 2021/3/8
 */
public abstract class AbstractCache<K, V> implements Cache<K, V> {


    private int size;
    private final int capacity;


    public AbstractCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("cache size is negative!");
        }
        this.capacity = capacity;
    }

    @Override
    public void set(K key, V value) {
        evict();
        size += doSet(key, value);
    }

    private void evict() {
        if (capacity <= size) {
            size -= doEvict();
            if (size < 0) {
                throw new RuntimeException("cache size is negative!");
            }
        }
    }

    abstract int doSet(K key, V value);

    /**
     * do an eviction
     * @return number of element evicted
     */
    abstract int doEvict();
}
