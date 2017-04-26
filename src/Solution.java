import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String string = getText();
        checkCondition(string);
    }

    static String getText() throws IOException {
        System.out.println("введите текст");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().trim().replaceAll("\\s{2,}", " ");
    }

    static String getCondition() throws IOException {
        System.out.println("введите условие для проверки");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().trim().replaceAll("\\s{2,}", " ");
    }

    static void checkCondition(String str) throws IOException {
        String condition = getCondition();
        Pattern pattern = Pattern.compile("^" + condition + "$");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches() ? "совпадение" : " не думаю");
    }
}