import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SubFileGenerator {

    public static void generateSubFile(String taskName, String executable, String log, String error, int cpu, String output, int memory, int disk, int runtime, String yesOrNo) 
    {
        String subFileName = taskName + ".sub";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(subFileName))) {
            writer.write("# " + subFileName + " -- " + taskName + " job\n");
            writer.write("executable = " + executable + "\n");
            writer.write("log = " + log + "\n");
            writer.write("output = " + output + "\n");
            writer.write("error = " + error + "\n");
            writer.write("should_transfer_files" + yesOrNo + "\n");
            writer.write("when_to_transfer_files = ON_EXIT\n");
            writer.write("request_cpus = " + cpu + "\n");
            writer.write("request_memory = " + memory + "M\n");
            writer.write("request_disk = " + disk + "G\n");
            writer.write("estimate_runtime = " + runtime + "\n");
            writer.write("queue\n");
            System.out.println("Generated " + subFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateSubFile("A", "A.sh", "A.log", "A.err", 1, "A.out", 512, 1, 12, "Yes");
        generateSubFile("B", "B.sh", "B.log", "B.err", 2, "B.out", 1024, 2, 15, "Yes");
        generateSubFile("C", "C.sh", "C.log", "C.err", 1, "C.out", 512, 1, 20, "No");
        generateSubFile("D", "D.sh", "D.log", "D.err", 2, "D.out", 1024, 2, 25, "No");
    }
}