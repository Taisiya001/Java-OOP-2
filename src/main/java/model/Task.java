package model;
// Файл должен содержать следующие данные: id, дату добавления записи, время добавления записи, дедлай задачи, ФИО автора,
public class Task {
    private String id = " ";
    private String term;
    private String firstName;
    private String lastName;
    private String priority;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Task(String firstName, String lastName, String term, String priority) {
        this.term = term;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
    }
    public Task(String id, String firstName, String lastName,String term, String priority) {
        this(term,firstName,lastName, priority);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nИмя: %s,\nФамилия: %s,\nСрок: %s,\nПриоритет: %s", id, firstName, lastName, term, priority);
    }
}