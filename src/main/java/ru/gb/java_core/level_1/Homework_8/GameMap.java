package ru.gb.java_core.level_1.Homework_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    public static final Random random = new Random();
    private int stateGameOver;
    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;


    public GameMap() {
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    //*
    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) {
            return;
        }

        if (!playerTurn(e, playerNumTurn)) {
            return;
        }

        if (gameCheck(DOT_HUMAN, STATE_WIN_HUMAN)) {
            return;
        }

//        aiTurn();
//        repaint();

        // если игра c AI или player
        if (gameMode == MODE_VS_AI) {
            playerNumTurn = 0;
            aiTurn();
            repaint();
        } else {
            // TODO: какая-то логика переключения фишек и хода игрока
//            System.out.println("До " + playerNumTurn);
            playerNumTurn();
//            System.out.println("Меняем  " + playerNumTurn);
            playerTurn(e, playerNumTurn);
//            System.out.println("После " + playerNumTurn);
//            System.out.println();
            repaint();
//            playerNumTurn();
//            playerTurn(e, playerNumTurn());
//            System.out.println(playerNumTurn);
//            playerNumTurn();
        }

        if (gameCheck(DOT_AI, STATE_WIN_AI)) {
            return;
        }
    }

    //**
    private int playerNumTurn() {
        if (playerNumTurn == 1) {
            playerNumTurn = 2;
            return playerNumTurn;
        } else if (playerNumTurn == 0) {
            playerNumTurn = 2;
            return playerNumTurn;
        } else {
            playerNumTurn = 1;
            return playerNumTurn;
        }
    }

    //*
    private boolean playerTurn(MouseEvent event, int playerNum) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;

        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return false;
        }
//        field[cellY][cellX] = DOT_HUMAN;
//        System.out.println("playerNum " + playerNum);
        if (gameMode == MODE_VS_HUMAN && (playerNum == 1 || playerNum == 0 )) {
            field[cellY][cellX] = DOT_HUMAN;
//            System.out.println(playerNum + " если 1 или 0 " + DOT_HUMAN);
        } else if (gameMode == MODE_VS_HUMAN && playerNum == 2) {
            field[cellY][cellX] = DOT_AI;
//            System.out.println(playerNum + " если 2 " + DOT_AI);
        } else if (gameMode == MODE_VS_AI && (playerNum == 0 || playerNum == 1)) {
            field[cellY][cellX] = DOT_HUMAN;
//            System.out.println(playerNum + " если 0 " + DOT_HUMAN);
        }
        repaint();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        cellHeight = height / fieldSizeY;
        cellWidth = width / fieldSizeX;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {
                    continue;
                }

                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    g.setColor(Color.magenta);
                    g.fillRect(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                }
            }
        }

        if (isGameOver) {
            showGameOverMessage(g);
        }
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    //* сделал автоматическое центрирование текста в зависимости от сообщения по вертикали и горизонтали
    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, getHeight() / 2 - 55, getWidth(), 110);
        g.setColor(Color.YELLOW);
        Font font = new Font("Times New Roman", Font.BOLD, 55);
        g.setFont(font);
//        g.setFont(new Font("Times New Roman", Font.BOLD, 55));
        String str;

        switch (stateGameOver) {
            case STATE_DRAW -> {
                str = "DRAW";
                g.drawString(str, getWidth() / 2 - g.getFontMetrics(font).stringWidth(str) / 2, getHeight() / 2 + g.getFontMetrics(font).getHeight() / 4);}
            case STATE_WIN_HUMAN -> {
                if (gameMode == MODE_VS_HUMAN) {
                    str = "HUMAN " + playerNumTurn + " WIN";
                } else {
                    str = "HUMAN WIN";
                }
//                str = "HUMAN " + playerNumTurn + " WIN";
                g.drawString(str, getWidth() / 2 - g.getFontMetrics(font).stringWidth(str) / 2, getHeight() / 2 + g.getFontMetrics(font).getHeight() / 4);}
            case STATE_WIN_AI -> {
                if (gameMode == MODE_VS_HUMAN) {
                    str = "HUMAN " + (playerNumTurn + 1) + " WIN";
                } else {
                    str = "AI WIN";
                }
//                str = "AI WIN";
                g.drawString(str, getWidth() / 2 - g.getFontMetrics().stringWidth(str) / 2, getHeight() / 2 + g.getFontMetrics(font).getHeight() / 4);}
        }
    }

    private boolean gameCheck(int dot, int stateGameOver) {
        if (checkWin(dot, winLength)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (checkDraw()) {
            this.stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }


    private void aiTurn() {
        if (scanField(DOT_AI, winLength)) return;        // проверка выигрыша компа
        if (scanField(DOT_HUMAN, winLength)) return;    // проверка выигрыша игрока на след ходу
        if (scanField(DOT_AI, winLength - 1)) return;
        if (scanField(DOT_HUMAN, winLength - 1)) return;
        if (scanField(DOT_AI, winLength - 2)) return;
        if (scanField(DOT_HUMAN, winLength - 2)) return;
        aiTurnEasy();
    }

    private void aiTurnEasy() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean scanField(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {                // поставим фишку в каждую клетку поля по очереди
                    field[y][x] = dot;
                    if (checkWin(dot, length)) {
                        if (dot == DOT_AI) return true;    // если комп выигрывает, то оставляем
                        if (dot == DOT_HUMAN) {
                            field[y][x] = DOT_AI;            // Если выигрывает игрок ставим туда 0
                            return true;
                        }
                    }
                    field[y][x] = DOT_EMPTY;            // если никто ничего, то возвращаем как было
                }
            }
        }
        return false;
    }

    private boolean checkWin(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {            // проверяем всё поле
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, length, dot)) return true;    // проверка  по +х
                if (checkLine(x, y, 1, 1, length, dot)) return true;    // проверка по диагонали +х +у
                if (checkLine(x, y, 0, 1, length, dot)) return true;    // проверка линию по +у
                if (checkLine(x, y, 1, -1, length, dot)) return true;    // проверка по диагонали +х -у
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int incrementX, int incrementY, int len, int dot) {
        int endXLine = x + (len - 1) * incrementX;            // конец линии по Х
        int endYLine = y + (len - 1) * incrementY;            // конец по У
        if (!isCellValid(endYLine, endXLine)) return false;    // Выход линии за пределы
        for (int i = 0; i < len; i++) {                    // идем по линии
            if (field[y + i * incrementY][x + i * incrementX] != dot) return false;    // символы одинаковые?
        }
        return true;
    }

    private boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

}