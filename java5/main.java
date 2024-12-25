// Абстрактний клас для квітів
abstract class Flower {
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

// Клас-нащадок: Троянда
class Rose extends Flower {
    public Rose(int freshnessLevel, int stemLength, double price) {
        super("Rose", freshnessLevel, stemLength, price);
    }
}

// Клас-нащадок: Лілія
class Lily extends Flower {
    public Lily(int freshnessLevel, int stemLength, double price) {
        super("Lily", freshnessLevel, stemLength, price);
    }
}

// Клас-нащадок: Тюльпан
class Tulip extends Flower {
    public Tulip(int freshnessLevel, int stemLength, double price) {
        super("Tulip", freshnessLevel, stemLength, price);
    }
}

// Клас для аксесуарів
class Accessory {
    private String name;
    private double price;

    public Accessory(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Accessory{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}

// Клас для букета
class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Flower flower : flowers) {
            totalPrice += flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            totalPrice += accessory.getPrice();
        }
        return totalPrice;
    }

    public void sortByFreshness() {
        Arrays.sort(flowers, (f1, f2) -> Integer.compare(f2.getFreshnessLevel(), f1.getFreshnessLevel()));
    }

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
        StringBuilder bouquetDetails = new StringBuilder("Bouquet:\n");
        for (Flower flower : flowers) {
            bouquetDetails.append(flower).append("\n");
        }
        for (Accessory accessory : accessories) {
            bouquetDetails.append(accessory).append("\n");
        }
        return bouquetDetails.toString();
    }
}

// Основний клас
public class Main {
    public static void main(String[] args) {
        // Створення квітів
        Flower[] flowers = {
                new Rose(8, 40, 15.0),
                new Lily(7, 35, 12.0),
                new Tulip(9, 30, 10.0),
                new Rose(6, 50, 18.0)
        };

        // Створення аксесуарів
        Accessory[] accessories = {
                new Accessory("Ribbon", 5.0),
                new Accessory("Wrapping paper", 3.0)
        };

        // Створення букета
        Bouquet bouquet = new Bouquet(flowers, accessories);

        // Виведення початкового стану букета
        System.out.println("Initial bouquet:");
        System.out.println(bouquet);

        // Обчислення загальної вартості букета
        System.out.println("\nTotal price of the bouquet: " + bouquet.calculateTotalPrice());

        // Сортування квітів за рівнем свіжості
        bouquet.sortByFreshness();
        System.out.println("\nBouquet sorted by freshness:");
        System.out.println(bouquet);

        // Пошук квітки за довжиною стебла
        int minLength = 30;
        int maxLength = 40;
        Flower foundFlower = bouquet.findFlowerByStemLength(minLength, maxLength);
        System.out.println("\nFlower found with stem length between " + minLength + " and " + maxLength + ":");
        System.out.println(foundFlower != null ? foundFlower : "No flower found in this range.");
    }
}
