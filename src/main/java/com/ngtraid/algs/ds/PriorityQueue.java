package com.ngtraid.algs.ds;

import java.util.Comparator;

public class PriorityQueue {
    private int cap;
    private int size;
    private int[] pq;
    private Comparator<Integer> comparator;

    public PriorityQueue(int cap) {
        this(cap, (a, b) -> a - b);
    }

    public PriorityQueue(int cap, Comparator<Integer> comparator) {
        this.size = 0;
        this.cap = cap;
        this.pq = new int[cap];
        this.comparator = comparator;
    }

    public void offer(int i) {
        pq[size] = i;
        swim(size);
        size++;
    }

    public int peek() {
        if (size > 0) {
            return pq[0];
        } else {
            throw new RuntimeException("no element in queue");
        }
    }

    public int poll() {
        int ret;
        if (size > 0) {
            ret = pq[0];
            exch(0, size - 1);
            size--;
            sink(0);
        } else {
            throw new RuntimeException("no element in queue");
        }
        return ret;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return cap;
    }

    private void sink(int idx) {
        int lIdx = lIdx(idx);
        int rIdx = rIdx(idx);
        if (lIdx == size - 1) {
            if (comparator.compare(pq[idx], pq[lIdx]) > 0) {
                exch(idx, lIdx);
            }
        } else if (lIdx < size - 1) {
            int temp = comparator.compare(pq[lIdx], pq[rIdx]) <= 0 ? pq[lIdx] : pq[rIdx];
            if (comparator.compare(pq[idx], temp) > 0) {
                int to = temp == pq[lIdx] ? lIdx : rIdx;
                exch(idx, to);
                sink(to);
            }
        }
    }

    private void swim(int idx) {
        if (idx <= 0) {
            return;
        }
        int ftrIdx = ftrIdx(idx);
        if (comparator.compare(pq[idx], pq[ftrIdx]) < 0) {
            exch(idx, ftrIdx);
            swim(ftrIdx);
        }
    }

    private int lIdx(int i) {
        return i * 2 + 1;
    }

    private int rIdx(int i) {
        return i * 2 + 2;
    }

    private int ftrIdx(int i) {
        return (i - 1) / 2;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
