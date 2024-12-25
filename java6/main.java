import java.util.*;

// Узагальнений клас з лабораторної роботи №5
class Flower {
    private String name;
    private int freshnessLevel; // Рівень свіжості (1-10)
    private int stemLength; // Довжина стебла в сантиметрах
    private double price;

    public Flower(String name, int freshnessLevel, int stemLength, double price) {
        this.name = name;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public int getStemLength() {
        return stemLength;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", freshnessLevel=" + freshnessLevel +
                ", stemLength=" + stemLength +
                ", price=" + price +
                '}';
    }
}

// Типізована колекція на основі List
class FlowerList {
    private LinkedList<Flower> flowers;

    // Конструктор 1: Порожній
    public FlowerList() {
        this.flowers = new LinkedList<>();
    }

    // Конструктор 2: Один об'єкт Flower
    public FlowerList(Flower flower) {
        this();
        this.flowers.add(flower);
    }

    // Конструктор 3: Колекція Flower
    public FlowerList(Collection<Flower> flowers) {
        this.flowers = new LinkedList<>(flowers);
    }

    // Додавання квітки
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    // Видалення квітки
    public void removeFlower(Flower flower) {
        flowers.remove(flower);
    }

    // Отримання квітки за індексом
    public Flower getFlower(int index) {
        return flowers.get(index);
    }

    // Сортування за рівнем свіжості
    public void sortByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshnessLevel).reversed());
    }

    // Пошук квітки за заданим діапазоном довжини стебла
    public Flower findFlowerByStemLength(int minLength, int maxLength) {
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                return flower;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FlowerList:\n");
        for (Flower flower : flowers) {
            sb.append(flower).append("\n");
        }
        return sb.toString();
    }
}

// Основний клас
public class Main {
    public static void main(String[] args) {
        // Створення квітів
        Flower rose = new Flower("Rose", 8, 40, 15.0);
        Flower lily = new Flower("Lily", 7, 35, 12.0);
        Flower tulip = new Flower("Tulip", 9, 30, 10.0);

        // Використання порожнього конструктора
        FlowerList flowerList1 = new FlowerList();
        flowerList1.addFlower(rose);
        flowerList1.addFlower(lily);
        System.out.println("FlowerList1 (empty constructor):\n" + flowerList1);

        // Використання конструктора з одним об'єктом
        FlowerList flowerList2 = new FlowerList(tulip);
        System.out.println("FlowerList2 (single flower constructor):\n" + flowerList2);

        // Використання конструктора з колекцією
        List<Flower> flowerCollection = Arrays.asList(rose, lily, tulip);
        FlowerList flowerList3 = new FlowerList(flowerCollection);
        System.out.println("FlowerList3 (collection constructor):\n" + flowerList3);

        // Сортування квітів за свіжістю
        flowerList3.sortByFreshness();
        System.out.println("\nFlowerList3 after sorting by freshness:\n" + flowerList3);

        // Пошук квітки за діапазоном довжини стебла
        int minLength = 30;
        int maxLength = 40;
        Flower foundFlower = flowerList3.findFlowerByStemLength(minLength, maxLength);
        System.out.println("\nFlower found with stem length between " + minLength + " and " + maxLength + ":\n" +
                (foundFlower != null ? foundFlower : "No flower found"));
    }
}
