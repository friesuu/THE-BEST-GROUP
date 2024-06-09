public class Main 
{
    public static void main(String[] args) 
    {
        String inputDAGFile = ".\\DAG.txt";

        WorkflowGraph graph = new WorkflowGraph();

        // Read input DAG file and construct the graph
        graph.readDAGFile(inputDAGFile);
        graph.printSortedTasks();
        graph.getCriticalPath();
    }
}