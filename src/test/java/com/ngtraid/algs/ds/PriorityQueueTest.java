package com.ngtraid.algs.ds;

import java.util.Random;

import org.junit.jupiter.api.Test;


public class PriorityQueueTest {
    @Test
    public void test() {
        PriorityQueue pq = new PriorityQueue(50);
        for (int i = 0; i < 50; i++) {
            pq.offer(new Random().nextInt(50));
        }
        for (int i = 0; i < 50; i++) {
            System.out.print(pq.poll() + " ");
        }
    }
}
