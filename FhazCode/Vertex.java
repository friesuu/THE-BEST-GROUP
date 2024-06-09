package FhazCode;

import java.util.*;

public class Vertex implements Comparable<Vertex>{
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
