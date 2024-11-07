package UI;

import Operation.servise.DateService;
import UI.menu.Menu;
import UI.commans.MainMenu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUi {
//    public static final int SIZE_LINE = 110;
    private static final Scanner scanner = new Scanner(System.in);
    private static Menu menu = new MainMenu();
//    private final MainMenu m = new MainMenu();
    private static boolean isWork = true;

    public void start() {
//        clearConsole();
//        printLineWithSymbol("=", SIZE_LINE);
//        printCaption("РЕЕСТР ЖИВОТНЫХ", " ");
//        printLineWithSymbol("=", SIZE_LINE);
//        m.showAnimals();
//        printLineWithSymbol("-", SIZE_LINE);
        while (isWork) {
            print(menu.toString());
            menu.execute(getIntInput() - 1);
        }

    }

    public static void close() {
        scanner.close();
        isWork = false;
    }

//    private void clearConsole() {
//        System.out.print("\033[H\033[J");
//    }

//    private void printLineWithSymbol(String symbol, int sizeLine) {
//        println(symbol.repeat(sizeLine));
//    }

//    private void printCaption(String caption, String padSymb) {
//        int spaceSize = (SIZE_LINE - caption.length()) / 2;
//        String captionLine = padSymb.repeat(spaceSize) + caption + padSymb.repeat(spaceSize);
//        println(captionLine);
//    }

    public static void setMenu(Menu newMenu) {
        menu = newMenu;
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static int getIntInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= menu.size()) {
                    return number;
                }
            }
        } while (true);
    }

    public static String getStringInput(int minLength) {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.length() >= minLength) {
                return input;
            }
        } while (true);
    }

    public static Date getDateInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                return DateService.stringToDate(input);
            }
        } while (true);
    }

    public static String chooseName(List<String> names) {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (names.contains(input)) {
                return input;
            }
        } while (true);
    }
}
