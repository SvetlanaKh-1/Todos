package ru.netology.Todos.managers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(6, "Купить продукты");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подсолнечное масло", "Сливочное масло", "Молочные продукты"};
    Epic epic = new Epic(10, subtasks);

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
    public void shouldSearchMatchesForSeveralTasks() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("продукты");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMatchesForSimpleTask() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Купить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMatchesForEpic() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("масло");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMatchesForMeetingInTopic() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("3й версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMatchesForMeetingInProject() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchMatchesForMeetingInStart() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("вторник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchMatches() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("релиз");
        Assertions.assertArrayEquals(expected, actual);
    }
}