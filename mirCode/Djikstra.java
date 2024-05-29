package mirCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class Vertex implements Comparable<Vertex>{
    public final String name;
    public List<Edge> adjacencies; //a list of edges that adjacent to this vertex
    public int minDistance = Integer.MAX_VALUE;
    public Vertex previous; //reference to the previous vertex in the shortest path 

    public Vertex(String argName) {
        this.name = argName; 
        this.adjacencies = new ArrayList<>();
    }
    public String toString() { 
        return name; 
    }
    public int compareTo(Vertex other){
        return Integer.compare(minDistance, other.minDistance);
    }

}

class Edge{
    public final Vertex target;
    public final int weight;

    public Edge(Vertex argTarget, int argWeight){ 
        this.target = argTarget; 
        this.weight = argWeight; 
    }
}

public class Djikstra{
    private Vertex randomTargetTown;
    private List<Vertex> path;
    private Vertex Saffron;
    private List<Vertex> vertices;

    public static void computePaths(Vertex source){
        source.minDistance = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.offer(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge adj 
            for (Edge e : u.adjacencies){
                Vertex v = e.target;
                int weight = e.weight;
                int distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static Vertex randomTarget(List<Vertex> vertices){
        int numberOfSelections = new Random().nextInt(vertices.size()); // ensure at least 1 selection
        Vertex randomNode = vertices.get(numberOfSelections); // select the first element of the shuffled list
        return randomNode;
    }

    public static List<Vertex> getShortestPathTo(Vertex target){
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
    public Djikstra() {
        initializeGraph();
        computePaths(Saffron);
        randomTargetTown = randomTarget(vertices);
        //System.out.println("Distance to " + randomTargetTown + ": " + randomTargetTown.minDistance);
        path = getShortestPathTo(randomTargetTown);
        //System.out.println("Path: " + path);
    }

    public void initializeGraph() {
        Saffron = new Vertex("Saffron City");
        Vertex Celadon = new Vertex("Celadon City");
        Vertex Cerulean = new Vertex("Cerulean City");
        Vertex Lavender = new Vertex("Lavender Town");
        Vertex Vermillion = new Vertex("Vermillion City");
        Vertex Fuschia = new Vertex("Fuschia City");
        Vertex Cinnabar = new Vertex("Cinnabar Island");
        Vertex Pallet = new Vertex("Pallet Town");
        Vertex Viridian = new Vertex("Viridian City");
        Vertex Pewter = new Vertex("Pewter City");

        Saffron.adjacencies.add(new Edge(Celadon, 4));
        Saffron.adjacencies.add(new Edge(Cerulean, 6));
        Saffron.adjacencies.add(new Edge(Lavender, 3));
        Saffron.adjacencies.add(new Edge(Vermillion, 3));

        Celadon.adjacencies.add(new Edge(Saffron, 4));
        Celadon.adjacencies.add(new Edge(Fuschia, 10));

        Cerulean.adjacencies.add(new Edge(Saffron, 6));
        Cerulean.adjacencies.add(new Edge(Pewter, 12));
        Cerulean.adjacencies.add(new Edge(Lavender, 9));

        Lavender.adjacencies.add(new Edge(Cerulean, 9));
        Lavender.adjacencies.add(new Edge(Saffron, 3));
        Lavender.adjacencies.add(new Edge(Vermillion, 5));
        Lavender.adjacencies.add(new Edge(Fuschia, 11));

        Vermillion.adjacencies.add(new Edge(Lavender, 5));
        Vermillion.adjacencies.add(new Edge(Saffron, 3));
        Vermillion.adjacencies.add(new Edge(Fuschia, 7));

        Fuschia.adjacencies.add(new Edge(Lavender, 11));
        Fuschia.adjacencies.add(new Edge(Vermillion, 7));
        Fuschia.adjacencies.add(new Edge(Celadon, 10));
        Fuschia.adjacencies.add(new Edge(Cinnabar, 5));

        Cinnabar.adjacencies.add(new Edge(Pallet, 7));
        Cinnabar.adjacencies.add(new Edge(Fuschia, 5));

        Pallet.adjacencies.add(new Edge(Viridian, 5));
        Pallet.adjacencies.add(new Edge(Cinnabar, 7));

        Viridian.adjacencies.add(new Edge(Pewter, 8));
        Viridian.adjacencies.add(new Edge(Pallet, 5));

        Pewter.adjacencies.add(new Edge(Viridian, 8));
        Pewter.adjacencies.add(new Edge(Cerulean, 12));

        vertices = new ArrayList<>();
        Collections.addAll(vertices, Celadon, Cerulean, Lavender, Vermillion, Fuschia, Cinnabar, Pallet, Viridian, Pewter);
    }

    // Helper method to convert path list to string
    private String getPathAsString() {
        StringBuilder pathString = new StringBuilder();
        for (Vertex vertex : path) {
            pathString.append(vertex).append(" -> ");
        }
        if (pathString.length() > 0) {
            pathString.setLength(pathString.length() - 4); // Remove the last arrow
        }
        return pathString.toString();
    }

    public String getRandomTargetTown(){
        return ""+randomTargetTown;
    }

    public String getShortestPath(){
        return "Shortest path: \n"+getPathAsString();
    }

}
