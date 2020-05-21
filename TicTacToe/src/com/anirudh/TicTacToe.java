package com.anirudh;

import com.anirudh.model.Grid;
import com.anirudh.model.Player;
import com.anirudh.model.Position;
import com.anirudh.model.Shape;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private final List<Player> playerList;
    private final Grid grid;

    public TicTacToe(List<Player> playerList, Grid grid) {
        this.playerList = playerList;
        this.grid = grid;
    }

    /**
     * The players are make a move one after the other by picking a row and col to place their cross/zero.
     * After each move, it is checked if the game reached a terminal position (win/draw) by checking the
     * relevant diagonals, rows and columns after the last move.
     */
    public void play() {
        System.out.println("Starting Tic Tac Toe");
        printGrid();
        boolean flag = true;
        while (flag) {
            for (Player player : playerList) {

                final Shape shape = player.getShape();
                final Position position = getPositionInput(player);

                if (!isValidMove(position)) {
                    System.out.println("Invalid move!Your turn is skipped!");
                    continue;
                }

                move(shape, position);

                if (isWinningMove(shape, position)) {
                    final String winMsg = String.format("%s WON!!", player.getName());
                    System.out.println(winMsg);
                    flag = false;
                    break;
                }

                if (isGameDrawn()) {
                    System.out.println("Game Drawn!!");
                    flag = false;
                    break;
                }
            }
        }
    }

    private Position getPositionInput(final Player player) {
        final String makeAMovePrompt = String.format("%s to place a %s, please enter row and col",
                player.getName(), player.getShape().getShapeName());

        Scanner scanner = new Scanner(System.in);
        int row=0, col=0;
        Position position = null;

        do {
            System.out.println(makeAMovePrompt);
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                position = new Position(row, col);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input, try again!!");
            } finally {
                scanner = new Scanner(System.in);
            }
        } while (position == null);

        return position;

    }

    private boolean isGameDrawn() {
        final Shape[][] grid = this.grid.getGrid();
        final int size = this.grid.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].equals(this.grid.getBlankCell())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinningMove(final Shape shape, final Position position) {
        return (isColumnWinning(shape, position) || isRowWinning(shape, position) || isDiagonalWinning(shape, position));
    }

    private boolean isDiagonalWinning(Shape shape, Position position) {
        final int size = grid.getSize();
        final Shape[][] grid = this.grid.getGrid();
        boolean negativeSlope = true;
        boolean positiveSlope = true;

        //Check negative slope diagonal
        for (int i = 0; i < size; i++) {
            if (!grid[i][i].equals(shape)) {
                negativeSlope = false;
                break;
            }

        }

        //Check positive slope diagonal
        for (int i=0; i < size; i++) {
                if (!grid[i][size - i - 1].equals(shape)) {
                    positiveSlope = false;
                    break;
                }
            }
        return (positiveSlope || negativeSlope);
    }

    private boolean isRowWinning(Shape shape, Position position) {
        final int size = grid.getSize();
        final Shape[][] grid = this.grid.getGrid();

        for (int i = 0; i < size; i++) {
            if (!grid[i][position.getCol()].equals(shape))
                return false;
        }
        return true;
    }

    private boolean isColumnWinning(Shape shape, Position position) {
        final int size = grid.getSize();
        final Shape[][] grid = this.grid.getGrid();

        for (int i = 0; i < size; i++) {
            if (!grid[position.getRow()][i].equals(shape))
                return false;
        }
        return true;
    }

    private void move(final Shape shape, final Position position) {
        final Shape[][] grid = this.grid.getGrid();
        grid[position.getRow()][position.getCol()] = shape;
        printGrid();
    }

    private boolean isValidMove(Position position) {
        final int row = position.getRow();
        final int col = position.getCol();
        final int size = this.grid.getSize();

        if (row < 0 || row >= size) {
            return false;
        }

        if (col < 0 || col >= size) {
            return false;
        }

        return this.grid.getGrid()[row][col].equals(this.grid.getBlankCell());
    }

    private void printGrid() {
        final int size = this.grid.getSize();

        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j < size; j++) {
                System.out.print(this.grid.getGrid()[i][j].getShapeName());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}