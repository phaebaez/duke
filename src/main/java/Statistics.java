//import java.util.ArrayList;
//
//public class Statistics {
//    int totalCount = 0;
//    int todoCount = 0;
//    int deadlineCount = 0;
//    int eventCount = 0;
//
//public String statsTask() {
//        int totalCount = 0;
//        int todoCount = 0;
//        int deadlineCount = 0;
//        int eventCount = 0;
//
//        for (Task t: tasks) {
//        String type = t.getType();
//        if (type.equals("T")) {
//        todoCount++;
//        } else if (type.equals("D")) {
//        deadlineCount++;
//        } else if (type.equals("E")){
//        eventCount++;
//        }
//        totalCount++;
//        }
//
//        return "Percentage of task of type todo: " + (todoCount / totalCount) +
//        "\n Percentage of task of type deadline: " + (deadlineCount / totalCount) +
//        "\n Percentage of task of type event: " + (eventCount / totalCount);
//        }
//}
