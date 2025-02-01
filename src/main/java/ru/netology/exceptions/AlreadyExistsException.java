package ru.netology.exceptions;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String playerName) {
        super("Игрок с таким именем(" + playerName + ") уже зарегистрирован");
    }

    public AlreadyExistsException(int id) {
        super("Игрок с таким id(" + id + ") уже зарегистрирован");
    }
}