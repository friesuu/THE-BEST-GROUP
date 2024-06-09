import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class WorkflowGraph 
{
    Map<String, Task> tasks;

    public WorkflowGraph() 
    {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) 
    {
        tasks.put(task.taskName, task);
    }

    public Task getTask(String taskName) 
    {
        return tasks.get(taskName);
    }

    public void printSortedTasks() 
    {
        List<Task> sortedTasks = new ArrayList<>(tasks.values());
        Collections.sort(sortedTasks, Comparator.comparingInt(task -> task.estimatedRunTime));

        System.out.println("Tasks sorted by estimated run time:");
        for (Task task : sortedTasks) 
        {
            System.out.println(task.taskName + " : " + task.estimatedRunTime);
        }
    }

    public void getCriticalPath() 
    {
        Map<String, Integer> earliestStartTimes = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        // Initialize start times for tasks with no dependencies
        for (Task task : tasks.values()) 
        {
            if (task.dependencies.isEmpty()) 
            {
                earliestStartTimes.put(task.taskName, 0);
                queue.add(task.taskName);
            }
        }

        // Calculate earliest start times for each task
        while (!queue.isEmpty()) 
        {
            String currentTaskName = queue.poll();
            Task currentTask = tasks.get(currentTaskName);
            int currentTaskStartTime = earliestStartTimes.get(currentTaskName);

            for (String dependentTaskName : currentTask.dependencies) 
            {
                Task dependentTask = tasks.get(dependentTaskName);
                int dependentTaskStartTime = earliestStartTimes.getOrDefault(dependentTaskName, 0);
                int dependentTaskFinishTime = dependentTaskStartTime + dependentTask.estimatedRunTime;

                if (dependentTaskFinishTime > currentTaskStartTime) 
                {
                    currentTaskStartTime = dependentTaskFinishTime;
                }
            }

            earliestStartTimes.put(currentTaskName, currentTaskStartTime);

            for (String childTaskName : tasks.keySet()) 
            {
                if (!queue.contains(childTaskName) && currentTask.dependencies.contains(childTaskName)) 
                {
                    queue.add(childTaskName);
                }
            }
        }

        // Find the task with the maximum completion time
        int maxCompletionTime = 0;
        String lastTaskName = null;
        for (Map.Entry<String, Integer> entry : earliestStartTimes.entrySet()) 
        {
            if (entry.getValue() + tasks.get(entry.getKey()).estimatedRunTime > maxCompletionTime) 
            {
                maxCompletionTime = entry.getValue() + tasks.get(entry.getKey()).estimatedRunTime;
                lastTaskName = entry.getKey();
            }
        }

        // Trace back the critical path
        List<String> criticalPath = new ArrayList<>();
        criticalPath.add(lastTaskName);
        int currentTaskEndTime = maxCompletionTime - tasks.get(lastTaskName).estimatedRunTime;
        while (currentTaskEndTime > 0) 
        {
            for (String parentTaskName : tasks.keySet()) 
            {
                if (tasks.get(parentTaskName).dependencies.contains(lastTaskName) && earliestStartTimes.get(parentTaskName) == currentTaskEndTime) 
                {
                    criticalPath.add(parentTaskName);
                    lastTaskName = parentTaskName;
                    currentTaskEndTime -= tasks.get(lastTaskName).estimatedRunTime;
                    break;
                }
            }
        }
        Collections.reverse(criticalPath);

        // Print critical path
        System.out.println("Critical Path: " + String.join(" -> ", criticalPath));
        System.out.println("Total Run Time: " + maxCompletionTime);
    }

    public void readDAGFile(String filePath) 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                if (line.startsWith("JOB")) 
                {
                    String[] parts = line.split("\\s+");
                    String taskName = parts[1];
                    int estimatedRunTime = 0;
                    // Read the corresponding .sub file to get the estimated run time
                    String subFilePath = parts[2]; // Assuming the .sub file path is provided directly
                    try (BufferedReader subReader = new BufferedReader(new FileReader(subFilePath))) 
                    {
                        String subLine;
                        while ((subLine = subReader.readLine()) != null) 
                        {
                            if (subLine.startsWith("estimate_runtime")) 
                            {
                                estimatedRunTime = Integer.parseInt(subLine.split("=")[1].trim());
                                break;
                            }
                        }
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                    addTask(new Task(taskName, estimatedRunTime, new ArrayList<>())); // Estimated run time is set based on .sub file
                } 
                else if (line.startsWith("PARENT")) 
                {
                    String[] parts = line.split("\\s+");
                    String parentTask = parts[1];
                    String childTask = parts[3];
                    tasks.get(childTask).dependencies.add(parentTask);
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}