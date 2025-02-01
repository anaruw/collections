package ru.netology.exceptions;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Игрок с таким именем(" + playerName + ") не зарегистрирован и не может принимать участие");
    }
}