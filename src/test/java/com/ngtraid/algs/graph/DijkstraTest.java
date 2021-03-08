package com.ngtraid.algs.graph;


import org.junit.jupiter.api.Test;

public class DijkstraTest {
    @Test
    public void test() {
        for (int i : Dijkstra.solve()) {
            System.out.print(i + " ");
        }
    }
}
