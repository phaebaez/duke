public class Statistics {
    int totalCount = 0;
    int todoCount = 0;
    int deadlineCount = 0;
    int eventCount = 0;

public String statsTask() {
        int totalCount = 0;
        int todoCount = 0;
        int deadlineCount = 0;
        int eventCount = 0;

        return "Percentage of task of type todo: " + (todoCount / totalCount) +
        "\n Percentage of task of type deadline: " + (deadlineCount / totalCount) +
        "\n Percentage of task of type event: " + (eventCount / totalCount);
        }
}
