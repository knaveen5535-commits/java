
import java.util.LinkedList;
public class GraphList {
    public static void main(String[] args) {
        int vertices = 5;
        LinkedList<Integer>[] graph = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(1);
        graph[0].add(4);
        graph[1].add(0);
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(1);
        graph[3].add(2);
        graph[3].add(4);
        graph[4].add(0);
        graph[4].add(3);

        System.out.println("Graph represented as an adjacency list:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Integer neighbor : graph[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
}
