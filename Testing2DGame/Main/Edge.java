package Testing2DGame.Main;

class Edge{
    public final Vertex target;
    public final int weight;

    public Edge(Vertex argTarget, int argWeight){
        this.target = argTarget;
        this.weight = argWeight;
    }
}