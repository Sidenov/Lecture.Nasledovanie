package ru.netology.domain;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super("Товар с данным Id=" + id + " уже существует");
    }
}
