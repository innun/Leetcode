package com.ngtraid.algs.graph;

import com.ngtraid.algs.ds.Graph;

public class Dijkstra {
    private static int[] dist;
    private static boolean[] certain;
    private static int[][] graph;
    private static int nums;

    static {
        graph = Graph.graph;
        nums = graph.length;
        dist = new int[nums];
        certain = new boolean[nums];
        for (int i = 0; i < nums; i++) {
            dist[i] = Graph.graph[0][i];
        }
        certain[0] = true;
    }

    public static int[] solve() {
        for (int k = 1; k < nums; k++) {
            int cur = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums; i++) {
                if (!certain[i] && dist[i] < min) {
                    cur = i;
                    min = dist[i];
                }
            }
            for (int j = 0; j < nums; j++) {
                if (graph[cur][j] != Integer.MAX_VALUE) {
                    int newDist = dist[cur] + graph[cur][j];
                    dist[j] = dist[j] < newDist ? dist[j] : newDist;
                }
            }
            certain[cur] = true;
        }
        return dist;
    }
}
