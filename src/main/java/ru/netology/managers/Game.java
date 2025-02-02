package ru.netology.managers;

import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {

        players.add(player);
    }

    public List<Player> registeredList() {
        return players;
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {

            if (player1 == null) {

                if (playerName1.equals(player.getName())) {
                    player1 = player;
                    continue;
                }
            }
            if (player2 == null) {
                player2 = (playerName2.equals(player.getName())) ? player : null;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else {
            return (player1.getStrength() > player2.getStrength()) ? 1 : 2;
        }
    }
}