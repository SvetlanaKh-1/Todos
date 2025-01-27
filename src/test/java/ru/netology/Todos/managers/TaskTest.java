package ru.netology.Todos.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    SimpleTask simpleTask = new SimpleTask(6, "Купить продукты");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Подсолнечное масло", "Сливочное масло"};
    Epic epic = new Epic(10, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindMatchesForSimpleTask() {

        boolean expected = true;
        boolean actual = simpleTask.matches("продукты");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesForSimpleTask() {

        boolean expected = false;
        boolean actual = simpleTask.matches("одежду");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesForEpic() {

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesForSeveralEpic() {

        boolean expected = true;
        boolean actual = epic.matches("масло");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesForEpic() {

        boolean expected = false;
        boolean actual = epic.matches("Кефир");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesForMeetingInTopic() {

        boolean expected = true;
        boolean actual = meeting.matches("3й версии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesForMeetingInProject() {

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesForMeeting() {

        boolean expected = false;
        boolean actual = meeting.matches("релиз");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesForMeetingInStart() {

        boolean expected = false;
        boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }
}