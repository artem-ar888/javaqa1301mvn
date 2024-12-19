package tasktypes;

import java.util.Objects;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /*
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя.
     * "query" – поисковый запрос;
     * "return" – ответ на вопрос, подходит ли эта задача под поисковый запрос;
     */
    protected boolean matches(String query) {
        return false;
    }

    public boolean queryVerificationWithMatches(String query) {
        String newQuery = query.strip().toLowerCase(); // удаляет в запросе лишние пробелы вначале и конце, переводит в нижний регистр
        if (newQuery.isEmpty()) {
            return false;   // проверяет не пустой ли запрос
        }
        return matches(newQuery);
    }

    // Ниже находятся вспомогательные методы для корректной работы equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}