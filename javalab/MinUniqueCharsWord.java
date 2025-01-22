import java.io.PrintStream;
import java.util.*;

public class MinUniqueCharsWord {
    public static void main(String[] args) throws Exception {
        // Встановлення UTF-8 для коректного відображення
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // Введення рядка з консолі
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть рядок:");
        String input = scanner.nextLine();

        // Поділ рядка на слова
        String[] words = input.split("\\s+");
        System.out.println("Слова: " + Arrays.toString(words)); // Проміжне виведення для перевірки

        // Змінні для збереження результатів
        List<String> resultWords = new ArrayList<>();
        int minUniqueChars = Integer.MAX_VALUE;

        // Перевірка кожного слова
        for (String word : words) {
            // Пропускаємо порожні слова
            if (word.trim().isEmpty()) continue;

            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }

            System.out.println("Слово: \"" + word + "\", Унікальні символи: " + uniqueChars.size()); // Проміжне виведення

            // Оновлюємо список результатів залежно від кількості унікальних символів
            if (uniqueChars.size() < minUniqueChars) {
                minUniqueChars = uniqueChars.size();
                resultWords.clear(); // Очистити попередні слова
                resultWords.add(word);
            } else if (uniqueChars.size() == minUniqueChars) {
                resultWords.add(word);
            }
        }

        // Виведення результату
        if (!resultWords.isEmpty()) {
            System.out.println("Слова з мінімальною кількістю різних символів: " + resultWords);
        } else {
            System.out.println("Не знайдено слів у введеному рядку.");
        }
    }
}
