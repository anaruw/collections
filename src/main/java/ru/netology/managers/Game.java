package ru.netology.managers;

import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Map<String, Integer> players = new HashMap<>();

    public void register(Player player) {

        players.put(player.getName(), player.getStrength());
    }

    public Map<String, Integer> registeredList() {
        return players;
    }

    public int round(String playerName1, String playerName2) {

        if (players.containsKey(playerName1) && players.containsKey(playerName2)) {

            if (players.get(playerName1) == players.get(playerName2)) {
                return 0;
            } else {
                return (players.get(playerName1) > players.get(playerName2)) ? 1 : 2;
            }
        } else {
            if (!players.containsKey(playerName1)) {

                throw new NotRegisteredException(playerName1);
            } else {

                throw new NotRegisteredException(playerName2);
            }
        }
    }
}