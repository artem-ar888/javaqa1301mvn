package tasktypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void searchInSimpleTaskIfQueryIsEmpty() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = " ";

        boolean expected = false;
        boolean actual = simpleTask.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInSimpleTaskIfNotContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = " пзв ";

        boolean expected = false;
        boolean actual = simpleTask.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInSimpleTaskIfContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = " позв ";

        boolean expected = true;
        boolean actual = simpleTask.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInEpicIfNotContainsQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "мало";

        boolean expected = false;
        boolean actual = epic.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInEpicIfContainsQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "яйца";

        boolean expected = true;
        boolean actual = epic.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInMeetingIfNotContainsQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "третей";

        boolean expected = false;
        boolean actual = meeting.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInMeetingIfTopicContainsQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "3Й ВЕРСИИ";

        boolean expected = true;
        boolean actual = meeting.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInMeetingIfProjectContainsQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = " НИЕ НЕТ";

        boolean expected = true;
        boolean actual = meeting.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchInTask() {
        Task task = new Task(888);
        String query = "проверяем";

        boolean expected = false;
        boolean actual = task.queryVerificationWithMatches(query);

        Assertions.assertEquals(expected, actual);
    }
}