package ru.gb.java_core.level_1.Homework_4;


import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*  (*) - одна звезда - это измененная функция
 *  (**) - две звезды - это добавленная функция
 *
 *  играть можно на квадратном поле от 3 до 99 (больше 99 не проработана отрисовка поля)
 *  и выбирать любую длину выигрышной комбинации от 3 до максимального размера поля
 *  логика игры AI строится вокруг центральной клетки c расширяющимся диапазоном ходов
 *
 * */

public class Homework_4_TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int sizeField;
    private static int winLength;

    // запуск всего процесса
    public static void main(String[] args) {
        startNewGame();
    }

    // *запускаем новую игру с выбором фишки первым ходом и отрисовкой поля
    private static void startNewGame() {
        while (true) {
            chooseSizeField(); // выбор размера поля
            chooseDot(); // выбор фишки
            playRound(); // запускаем новый раунд с отрисовкой поля и определяем первого ходящего

            System.out.printf("SCORE:    HUMAN     AI\n" +
                    "            %d       %d\n", scoreHuman, scoreAi);

            System.out.print("Want to play again ? (Y or N) >>> ");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) { // по завершению раунда запрашиваем повтор игры
                System.out.println("BYE");
                break;
            }
        }
    }

    // инициируем новый раунд - генерим поле и рисуем его, определяем кто ходит первым
    private static void playRound() {
        initField(sizeField, sizeField); // вызываем функцию отрисовки чистого поля в начале раунда
        chooseWinLength(); // *вызываем функцию получения длины выигрышной последовательности
        System.out.printf("Round %d start\n", ++roundCounter);
        printField(); // рисуем чистое поле заданного размера
        if (dotHuman == DOT_X) { // если X, то игрок первый ходит, иначе AI
            humanFirst(); // если первым ходит игрок
        } else {
            aiFirst(); // если первым ходит AI
        }
    }

    // функция первого хода игрока
    private static void humanFirst() {
        while (true) {
            humanTurn(); // ход игрока на чистую клетку поля
            printField(); // заново печатаем поле с ходом игрока
            if (gameCheck(dotHuman)) { // проверяем выигрышную комбинацию для игрока
                break;
            }
            aiTurn(); // ход AI на чистую клетку поля
            printField(); // заново печатаем поле с ходом AI
            if (gameCheck(dotAi)) { // проверяем выигрышную комбинацию для AI
                break;
            }
        }
    }

    // функция первого хода AI
    private static void aiFirst() {
        while (true) {
            aiTurn(); // ход AI на чистую клетку поля
            printField(); // заново печатаем поле с ходом игрока
            if (gameCheck(dotAi)) { // проверяем выигрышную комбинацию для AI
                break;
            }
            humanTurn(); // ход игрока на чистую клетку поля
            printField(); // заново печатаем поле с ходом игрока
            if (gameCheck(dotHuman)) { // проверяем выигрышную комбинацию для игрока
                break;
            }
        }
    }

    // функция проверки статуса игры для фишки - был выигрыш и чей он или никто не выиграл
    private static boolean gameCheck(char dot) {
        if (checkWin(dot) && dot == dotHuman) { // если фишка выиграла и она игрока
            System.out.println("Human win!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAi) { // если фишка выиграла и она AI
            System.out.println("AI win!");
            scoreAi++;
            return true;
        }
        return checkDraw(); // проверяем есть ли пустые клетки, если пока никто не выиграл
    }

    // выбираем какими фишками будем играть - X или 0
    private static void chooseDot() {
        System.out.print("Type 'X' to play with X and for 0 type anything >>> ");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
    }

    // *ход AI
    private static void aiTurn() {
        int x;
        int y;

        if (field[fieldSizeY / 2][fieldSizeX / 2] == DOT_EMPTY) { // ходить в центр поля, если клетка пустая
            x = fieldSizeX / 2;
            y = fieldSizeY / 2;
//            System.out.println("Center X=" + x + " Y=" + y);
        } else if (field[fieldSizeY / 2][fieldSizeX / 2] != DOT_EMPTY && winLength <= fieldSizeX) { // если клетка не пустая и выигрышная комбинация не больше поля
//            System.out.println(dotAi);
            int range = winLength;
            do { // ждать корректного ввода AI координат на поле в определенном диапазоне от центральной клетки
                x = fieldSizeX / 2 - range / 2 + random.nextInt(range);
                y = fieldSizeY / 2 - range / 2 + random.nextInt(range);
                // если в определенном диапазоне все пустые клетки заняты, то увеличить диапазон
                if (x >= fieldSizeX / 2 - range / 2 && y >= fieldSizeY / 2 - range / 2 && x <= fieldSizeX / 2 + range / 2 && y <= fieldSizeY / 2 + range / 2 && field[y][x] != DOT_EMPTY) {
                    range++;
                }
//                System.out.println("Random X=" + x + " Y=" + y);
            } while (!isCellValidRange(y, x, range)); // пока ход не будет внутри поля определенного диапазона и ход в пустую клетку
        } else { // ходить случайно во всех остальных случаях
            do { // ждать корректного ввода AI координат на поле
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
//                System.out.println("Random X=" + x + " Y=" + y);
            } while (!isCellValid(y, x)); // пока ход не будет внутри поля и ход в пустую клетку
        }

        field[y][x] = dotAi; // проставляем ход торока в массиве
    }

    // ход игрока
    private static void humanTurn() {
        int x;
        int y;

        do { // ждать корректного ввода игроком координат на поле
            System.out.print("Please enter coordinates x & y >>>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x)); // пока ход не будет внутри поля и ход в пустую клетку

        field[y][x] = dotHuman; // проставляем ход торока в массиве
    }

    // *функция проверки выигрышной комбинации для фишки по вертикалям, горизонталям и диагоналям
    private static boolean checkWin(char dot) {

        for (int y = 0; y < fieldSizeY; y++) {
            int nX = 0;
            int nY = 0;
            int nLR1 = 0;
            int nLR2 = 0;
            int nLR3 = 0;
            int nRL1 = 0;
            int nRL2 = 0;
            int nRL3 = 0;

            for (int x = 0; x < fieldSizeX; x++) {

                // по горизонтали
                if (field[y][x] == dot) {
                    nX++;
                } else {
                    nX = 0;
                }

                // по вертикали
                if (field[x][y] == dot) {
                    nY++;
                } else {
                    nY = 0;
                }

                // все диагонали слева направо
                if (x + y < fieldSizeX) {

                    // центральная диагональ слева направо
                    if (field[x][x] == dot) {
                        nLR1++;
//                        System.out.println("DOT=" + dot + " X=" + x + " Y=" + x + " nLR1=" + nLR1);
                    } else {
                        nLR1 = 0;
                    }

                    // под диагональю слева направо
                    if (field[x + y][x] == dot) {
                        nLR2++;
//                        System.out.println("DOT=" + dot + " X=" + (int)(x + y) + " Y=" + x + " nLR2=" + nLR2);
                    } else {
                        nLR2 = 0;
                    }

                    // над диагональю слева направо
                    if (field[x][x + y] == dot) {
                        nLR3++;
//                        System.out.println("DOT=" + dot + " X=" + x + " Y=" + (int)(x + y) + " nLR3=" + nLR3);
                    } else {
                        nLR3 = 0;
                    }

                }

                // все диагонали справа налево
                if (fieldSizeX - x - y > 0) {
                    // центральная диагональ справа налево
                    if (field[x][fieldSizeX - x - 1] == dot) {
                        nRL1++;
//                    System.out.println("DOT=" + dot + " X=" + (int)(fieldSizeX - x - 1) + " Y=" + x + " nRL1=" + nRL1);
                    } else {
                        nRL1 = 0;
                    }

                    // над диагональю справа налево
                    if (field[fieldSizeX - x - y - 1][x] == dot) {
                        nRL2++;
//                        System.out.println("DOT=" + dot + " X=" + x + " Y=" + (int)(fieldSizeX - x - y - 1) + " nRL2=" + nRL2);
                    } else {
                        nRL2 = 0;
                    }

                    // под диагональю справа налево
                    if (field[x + y][fieldSizeX - x - 1] == dot) {
                        nRL3++;
//                        System.out.println("DOT=" + dot + " X=" + (int)(fieldSizeX - x - 1) + " Y=" + (int)(x + y) + " nRL3=" + nRL3);
                    } else {
                        nRL3 = 0;
                    }

                }

                // если есть выигрышная комбинация, то завершаем игру
                if (nX >= winLength || nY >= winLength || nLR1 >= winLength || nLR2 >= winLength || nLR3 >= winLength || nRL1 >= winLength || nRL2 >= winLength || nRL3 >= winLength) {
//                    System.out.println("WIN nX = " + nX);
//                    System.out.println("WIN nY = " + nY);
//                    System.out.println("WIN nLR1 = " + nLR1);
//                    System.out.println("WIN nLR2 = " + nLR2);
//                    System.out.println("WIN nLR3 = " + nLR3);
//                    System.out.println("WIN nRL1 = " + nRL1);
//                    System.out.println("WIN nRL2 = " + nRL2);
//                    System.out.println("WIN nRL3 = " + nRL3);
                    return true;
                }
            }
        }

        return false;
    }

    // функция проверки есть ли еще свободные клетки для хода
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) { // если есть пустые клетки, то продолжаем false
                    return false;
                }
            }
        }
        System.out.println("DRAW!");
        return true; // иначе кустых клеток нет true
    }

    // функция проверки, что фишку ставят внутри поля и что ходят в пустую клетку
    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

    // **функция проверки, что фишку ставят внутри поля определенного диапазона и что ходят в пустую клетку
    private static boolean isCellValidRange(int y, int x, int range) {
        return x >= fieldSizeX / 2 - range / 2 && y >= fieldSizeY / 2 - range / 2 && x <= fieldSizeX / 2 + range / 2 && y <= fieldSizeY / 2 + range / 2 && field[y][x] == DOT_EMPTY;
    }

    // **функция получения размера поля
    private static void chooseSizeField() {
        do { // ждать корректного ввода игроком размера поля
            System.out.print("Type field size (>3) >>> ");
            sizeField = scanner.nextInt();
        } while (!(sizeField >= 3 && sizeField <= 99)); // пока размер поля не в диапазоне 3..99
    }

    // **функция получения длины выигрышной последовательности
    private static void chooseWinLength() {
        do { // ждать корректного ввода игроком длины выигрышной последовательности
            System.out.print("Type the length of the winning sequence >>> ");
            winLength = scanner.nextInt();
        } while (!(winLength >= 3 && winLength <= fieldSizeX && winLength <= fieldSizeY)); // пока длина не будет меньше размеров поля, но больше или равна 3
    }

    // *создаем массив указанной размерности и заполняем все его элементы '.' - пустое поле
    private static void initField(int sizeX, int sizeY) {
        fieldSizeY = sizeY;
        fieldSizeX = sizeX;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    // *отрисовываем "чистое" поле заданного размера
    private static void printField() {
        // отрисовываем начало строки "++"
        System.out.print("++");

        // отрисовываем строку "-1-2-3-"
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        // *отрисовываем строки массива заданного размера, заполняя его значениями по-умолчанию
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            if (i < 9) {
                System.out.print(i + 1 + " |");
            } else {
                System.out.print(i + 1 + "|");
            }

            for (int j = 0; j < fieldSizeX; j++) {
                if (j < 8) {
                    System.out.print(field[i][j] + "|");
                } else {
                    System.out.print(field[i][j] + "| ");
                }
            }
            System.out.println();
        }

        // отрисовываем последнюю строку "-------"

        int lastLine;

        if (fieldSizeX > 9) {
            lastLine = 3 + 9 * 2 + (fieldSizeX - 9) * 3;
        } else {
            lastLine = 3 + fieldSizeX * 2;
        }

        for (int i = 0; i < lastLine; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}