package com.anirudh;

import com.anirudh.model.Grid;
import com.anirudh.model.Player;
import com.anirudh.model.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final List<Player> playerList = new ArrayList<>();

        //Hard coding the number of players to 2 for now.
        for (int i=0; i < 2; i++) {
            final String playerNamePrompt = String.format("Enter Player %d name: ", i + 1);
            System.out.print(playerNamePrompt);
            final String playerName = scanner.next();

            final String chooseShapePrompt = "Pick X or O: ";
            //In reality the player can choose any shape.
            // TODO:Need to ensure that the player doesn't pick already chosen shape.
            System.out.print(chooseShapePrompt);
            final String shapeName = scanner.next();
            playerList.add(new Player(i, playerName,new Shape(shapeName)));
        }

        for (Player p : playerList) {
            System.out.println(String.format("%s picked %s", p.getName(), p.getShape().getShapeName()));
        }

        final Grid grid = new Grid(3); //Hard coding to a 3x3 grid for now
        final TicTacToe ticTacToe = new TicTacToe(playerList, grid);
        ticTacToe.play();
    }
}
