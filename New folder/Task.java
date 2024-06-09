import java.util.*;

public class Task 
{
    String taskName;
    int estimatedRunTime;
    List<String> dependencies;

    public Task(String taskName, int estimatedRunTime, List<String> dependencies) 
    {
        this.taskName = taskName;
        this.estimatedRunTime = estimatedRunTime;
        this.dependencies = dependencies;
    }
}
