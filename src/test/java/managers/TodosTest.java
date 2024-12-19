package managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasktypes.Epic;
import tasktypes.Meeting;
import tasktypes.SimpleTask;
import tasktypes.Task;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить прабабушке");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Шпроты"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findQueryInTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);
        String query = " позвонить ";

        Task[] expected = {simpleTask, simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findQueryWhichIsContainedInAllTasks() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "ПР";

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }
}