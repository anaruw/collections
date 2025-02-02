package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    //Players
    Player player1 = new Player(3, "Вася", 1);
    Player player2 = new Player(24, "Петер", 2);
    Player player3 = new Player(111, "Мурзик", 1);
    Player notRegisteredPlayer = new Player(22, "Читер", 54);

    @Test
    public void registerTest() {

        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        List<Player> expected = new ArrayList<>(Arrays.asList(player1, player2, player3));
        List<Player> actual = game.registeredList();

        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(useHeadersInDisplayName = true, value = {
            "playerName1,          playerName2,        result",
            "Вася,                Петер,              2",
            "Петер,               Мурзик,             1",
            "Вася,                Мурзик,             0"
    })
    public void roundWithResultTest(String playerName1, String playerName2, int expected) {

        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(playerName1, playerName2);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Читер, Вася",
            "Вася, Читер"
    })
    public void roundTestWithNotRegisteredPlayer(String playerName1, String playerName2) {

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {

            game.round(playerName1, playerName2);
        });
    }
}