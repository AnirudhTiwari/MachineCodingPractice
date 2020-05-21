package com.company;

import com.company.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int snakes = scanner.nextInt();
        final List<Snake> snakeList = getSnakesList(snakes, scanner);

        final int ladders = scanner.nextInt();
        final List<Ladder> ladderList = getLadderList(ladders, scanner);

        final int players = scanner.nextInt();
        scanner.nextLine();
        final List<Player> playerList = getPlayersList(players, scanner);

        final Dice dice = new Dice(6);
        final Board board = new Board(snakeList, ladderList, 100);
        final SnakesAndLadders snakesAndLadders = new SnakesAndLadders(playerList, dice, board);

        snakesAndLadders.play();
    }

    private static List<Player> getPlayersList(final int players, final Scanner scanner) {
        final List<Player> playerList = new ArrayList<>();

        for (int i = 1; i <= players; i++) {
            final String playerName = scanner.nextLine();
            final Player player = new Player(i, playerName, 0);
            playerList.add(player);
        }
        return playerList;
    }

    private static List<Ladder> getLadderList(final int ladders, final Scanner scanner) {
        final List<Ladder> ladderList = new ArrayList<>();

        for (int i = 0; i < ladders; i++) {
            final int start = scanner.nextInt();
            final int end = scanner.nextInt();
            final Ladder ladder = new Ladder(start, end);
            ladderList.add(ladder);
        }
        return ladderList;
    }

    private static List<Snake> getSnakesList(final int snakes, final Scanner scanner) {
        final List<Snake> snakesList = new ArrayList<>();

        for (int i = 0; i < snakes; i++)
        {
            final int head = scanner.nextInt();
            final int tail = scanner.nextInt();
            final Snake snake = new Snake(head, tail);
            snakesList.add(snake);
        }
        return snakesList;
    }
}
