import java.io.BufferedReader;
import java.lang.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Ili on 24.04.2017.
 */
/* строка на наличие совпадения с вводимимым аругемнтом для проверки
в качестве аргумента принимается String
*/

interface FuncInt {
    ArrayList<String> sortText(ArrayList<String> list, int index);
}

public class Solution {

    public static void main(String[] args) throws IOException {
        //System.out.println(getCondition(getText().replaceAll("[\\s]{2,}", " ")) ? "совпадение" : "не думаю");
        String str = getString();
        System.out.println(str);
        System.out.println(sortByABC(str));

        // сортировка строки по количеству символов с слове по возрастанию
        FuncInt sortByNumberOfChar = (list, index) -> {
            System.out.println("сортировка будет производится по " + index + " слову в строке");
            for (int i = list.size() - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    String[] str1 = list.get(j).split(" ");
                    String[] str2 = list.get(j + 1).split(" ");
                    if (str1[index].charAt(0) > str2[index].charAt(0)) {
                        String tmp = list.get(j);
                        list.set(j, list.get(j));
                        list.set(j + 1, tmp);
                    }
                }
            }
            return list;
        };
        for (String x : sortByNumberOfChar.sortText(getText(), getIndex())) {
            System.out.println(x);
        }

    }

    //ввод с консоли текстовой строки
    static String getString() throws IOException {
        System.out.println("Введиет строку");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine().replaceAll("[\\s]{2,}", " ");
    }

    // ввод с консоли блока текста
    static ArrayList<String> getText() throws IOException {
        System.out.println("Введиет строки. для прекращения ввода набрать словов Конец");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (!bufferedReader.readLine().equals("Конец".toLowerCase())) {
            list.add(bufferedReader.readLine().replaceAll("[\\s]{1,}", ""));
        }
        return list;
    }

    //получение номера слова в строке, по которому будет вестись сортировка текста
    static int getIndex() throws IOException {
        System.out.println("введиет номер слова в строке для сортировки");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }

    //ввод с консоли условий для проверки на наличие их в строке
    static boolean getCondition(String str) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean match = false;
        do {
            System.out.println("введите условие для проверки");
            //String matStr = "^" + reader.readLine() + "$";
            String matStr = reader.readLine();
            if (matches(str, matStr)) match = true;
            System.out.println("продолжить ввод условий: Enter. Выход: N");
        } while (!(reader.readLine().toLowerCase().equals("N".toLowerCase())));
        return match;
    }

    // проверка строки на наличие в ней рег выражения
    static boolean matches(String str, String cond) {
        Pattern pattern = Pattern.compile(cond);
        Matcher matcher = pattern.matcher(str.toLowerCase());
        return matcher.find();
    }

    // сортировка строки по алфавиту
    static String sortByABC(String str) {
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (s[j].toLowerCase().charAt(0) > s[j + 1].toLowerCase().charAt(0)) {
                    String tmp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = tmp;
                }
            }
        }
        String sortStr = "";
        for (String x : s) {
            sortStr = sortStr + x + " ";
        }
        return sortStr;
    }

}
