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
    private static ArrayList<Task> todoList = new ArrayList<>();
    private static ArrayList<Task> deadlineList = new ArrayList<>();
    private static ArrayList<Task> eventList = new ArrayList<>();
    private static ArrayList<Task> doneList = new ArrayList<>();
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
                if (temp[0].contains("T")) {
                    Task task = new Todo(temp[2]);
                    ((Todo) task).setTaskTodo();

                    todoList.add(task);
                    tasks.add(counter, task);
                    counter++;
                    if (temp[1].equals("\u2713")) {
                        task.setIsDone();
                        doneList.add(task);
                    }
                } else if (temp[0].contains("D")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Deadline(temp[2], date);
                    ((Deadline) task).setDeadline();

                    deadlineList.add(task);
                    tasks.add(counter, task);
                    counter++;
                    if (temp[1].equals("\u2713")) {
                        task.setIsDone();
                        doneList.add(task);
                    }
                } else if (temp[0].contains("E")) {
                    int day = Integer.parseInt(temp[3].split("-")[2]);
                    int month = Integer.parseInt(temp[3].split("-")[1]);
                    int year = Integer.parseInt(temp[3].split("-")[0]);
                    LocalDate date = LocalDate.of(year, month, day);
                    Task task = new Event(temp[2], date);
                    ((Event) task).setEvent();

                    eventList.add(task);
                    tasks.add(counter, task);
                    counter++;
                    if (temp[1].equals("\u2713")) {
                        task.setIsDone();
                        doneList.add(task);
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

            String content = "\n";
            for (Task task : toSave) {
                content = content + task.saveToFile() + "\n";
            }
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> getTodoList() {
        return todoList;
    }

    public static ArrayList<Task> getDeadlineList() {
        return deadlineList;
    }

    public static ArrayList<Task> getEventList() {
        return eventList;
    }

    public static ArrayList<Task> getDoneList() {
        return doneList;
    }
}
