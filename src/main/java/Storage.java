import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/** Represents a storage that has methods to load from and save to
 *    the list of tasks from the input file.
 */
public class Storage {
    private String filepath;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int counter = 0;

    /** Creates a storage object which takes in the file path
     *    of the file that contains the list of tasks.
     * @param filepath is the file path of the file that
     *     contains the list of tasks.
     */
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /** Loads the list of tasks from the input file.
     * @return the list of tasks already in the input file
     */
    public ArrayList<Task> load() {
        try { //read file
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" - ");
                if (temp[0].equals("T")) {
                    Task task = new Todo(temp[2]);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.setIsDone();
                    }
                } else if (temp[0].equals("D")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(temp[2], date);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.setIsDone();
                    }
                } else if (temp[0].equals("E")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Event(temp[2], date);
                    tasks.add(counter, task);
                    counter++;
                    if (Integer.parseInt(temp[1]) == 1) {
                        task.setIsDone();
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    /** Replaces the list of tasks in the input file with the new list of tasks
     *    that has been modified through the user commands.
     * @param toSave represents the new list of tasks that is to be written back
     *     into the input file.
     */
    public void save(ArrayList<Task> toSave) {
        try { //write file
            FileWriter fileWriter = new FileWriter(filepath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String content = "";
            for (Task task : toSave) {
                content = content + task.printToFile() + "\n";
            }
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
