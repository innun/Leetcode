package com.ngtraid.algs.ds.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jaron
 * created on 2021/3/8
 */
public class LRUCache<K, V> extends AbstractCache<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private final Deque<K> list;
    private final Map<K, V> map;


    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        super(capacity);
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if (list.remove(key)) {
            list.addFirst(key);
            return map.get(key);
        }
        return null;
    }

    @Override
    int doSet(K key, V value) {
        boolean exists = list.remove(key);
        list.addFirst(key);
        map.put(key, value);
        return exists ? 0 : 1;
    }

    @Override
    int doEvict() {
        K key = list.removeLast();
        map.remove(key);
        return 1;
    }

}
