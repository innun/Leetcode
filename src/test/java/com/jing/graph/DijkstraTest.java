package com.jing.graph;

import org.junit.Test;

public class DijkstraTest {
    @Test
    public void test() {
        for (int i : Dijkstra.solve()) {
            System.out.print(i + " ");
        }
    }
}