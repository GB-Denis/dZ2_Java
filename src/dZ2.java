import java.io.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class dZ2 {
    public static void main(String[] args) throws SecurityException, IOException {
        zadacha1();
        zadacha2();
        zadacha3();
    }
    static void zadacha1() {
        /*
        Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
        Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.
        Используйте StringBuilder для подготовки ответа
         */
        int size = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\dfazy\\IdeaProjects\\Seminar\\dZ2\\src\\zadacha1.txt"))) {
            while (bufferedReader.readLine() != null) {
                size += 1;
            }
        } catch (IOException e) {
            e.getMessage();
        }

        String[] listData = new String[size];
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader("C:\\Users\\dfazy\\IdeaProjects\\Seminar\\dZ2\\src\\zadacha1.txt"))) {
            String str;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {
                listData[i] = str;
                i++;
            }
        } catch (IOException e) {
            e.getMessage();

        }

        System.out.println("вывод: ");
        for (int i = 0; i < listData.length; i++) {
            System.out.println(resultText(listData[i]));
        }

    }
    static StringBuilder resultText(String line) {
        StringBuilder result = new StringBuilder("");
        String line_one = line.replace("{", "");
        String line_two = line_one.replace("}", "");
        String line_three = line_two.replace("\"", "");
        String[] arrayData = line_three.split(",");
        String[] listName = {"Студент ", " получил ", " по предмету ",};
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
        }
        return result;


    }
    static void zadacha2() {
        /*
        Создать метод, который запишет результат работы в файл Обработайте исключения и запишите ошибки в лог файл
         */
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Всё хорошо");
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("C:\\Users\\dfazy\\IdeaProjects\\Seminar\\dZ2\\src\\logZadacha2.txt");
            fileHandler.setFormatter(simpleFormatter);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();

        }
        logger.addHandler(fileHandler);
    }
    static String readFile(String filepath) {
        File file = new File("C:\\Users\\dfazy\\IdeaProjects\\Seminar\\dZ2\\src\\logZadacha2.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static void zadacha3() {
        /*
        Получить исходную json строку из файла, используя FileReader или Scanner
         */
        StringBuilder jsonString = new StringBuilder();
        try (FileReader reader = new FileReader("C:\\Users\\dfazy\\IdeaProjects\\Seminar\\dZ2\\src\\file.json")) {
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString + "\n");
    }
}