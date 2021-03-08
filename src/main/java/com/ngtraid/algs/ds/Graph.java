package com.ngtraid.algs.ds;

import java.util.Arrays;

public class Graph  {
    public static int[][] graph;

    static {
        graph = new int[6][6];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        graph[0][1] = 1;
        graph[0][2] = 12;
        graph[1][2] = 9;
        graph[1][3] = 3;
        graph[2][4] = 5;
        graph[3][2] = 4;
        graph[3][4] = 13;
        graph[3][5] = 15;
        graph[4][5] = 4;
    }
    
}
