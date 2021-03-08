package com.ngtraid.algs.ds.cache;

import com.ngtraid.algs.ds.api.Cache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author jaron
 * created on 2021/3/8
 */
class LRUCacheTest {

    @Test
    void testConstruction() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LRUCache<Integer, Integer>(-1));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LRUCache<Integer, Integer>(0));
        Assertions.assertDoesNotThrow(() -> {
            new LRUCache<Integer, Integer>(1);
            new LRUCache<Integer, Integer>(Integer.MAX_VALUE);
        });
    }

    @Test
    void testGet() {
        // default capacity is 10
        Cache<Integer, Integer> cache = new LRUCache<>();
        List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        nums.forEach(num -> cache.set(num, num));

        // 10 added, 0 evicted
        cache.set(10, 10);
        Assertions.assertNull(cache.get(0));
        Assertions.assertEquals(10, cache.get(10));

        // 11 added, 1 evicted
        cache.set(11, 11);
        Assertions.assertNull(cache.get(1));
        Assertions.assertEquals(11, cache.get(11));

        // 2 used
        Assertions.assertEquals(2, cache.get(2));
        // 12 added, 3 evicted
        cache.set(12, 12);
        Assertions.assertNull(cache.get(3));
        Assertions.assertEquals(12, cache.get(12));
    }
}
