package com.ngtraid.algs.ds.api;

/**
 * @author jaron
 * created on 2021/3/8
 */
public interface Cache<K, V> {

    /**
     * get the value of the key from this cache
     * @param key key to get
     * @return value
     */
    V get(K key);

    /**
     * set a key value pair to this cache
     * @param key the key
     * @param value the value
     */
    void set(K key, V value);

}
