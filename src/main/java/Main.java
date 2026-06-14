import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class Main {
    public static void main(String[] args) {
        try {
            // Створюємо екземпляри класу та їх масив
            Cosmetics cosmetic1 = new Cosmetics("Hugo Boss", "BOSS The Scent", "Парфуми", 100, 2015);
            Cosmetics cosmetic2 = new Cosmetics("Catrice", "Soft Glam Filter", "Макіяж", 30, 290);
            Cosmetics cosmetic3 = new Cosmetics("Montblanc", "Explorer", "Парфуми", 100, 2000);
            Cosmetics cosmetic4 = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);
            Cosmetics cosmetic5 = new Cosmetics("Rexona", "Maximum Protection Antiperspirant", "Антиперспірант", 45, 220);
            Cosmetics cosmetic6 = new Cosmetics("Uriage", "DS HAIR Soft Balancing Shampoo", "Шампунь", 500, 640);
            Cosmetics cosmetic7 = new Cosmetics("Boucheron", "Singulier", "Парфуми", 100, 1040);
            Cosmetics cosmetic8 = new Cosmetics("Rexona", "Maximum Protection Sensitive Dry", "Антиперспірант", 45, 210);
            Cosmetics cosmetic9 = new Cosmetics("Beauty of Joseon", "Relief Sun Rice + Probiotics", "Сонцезахисна косметика", 50, 460);
            Cosmetics cosmetic10 = new Cosmetics("Dr. Althea", "345 Relief Cream", "Догляд за шкірою", 50, 840);
            Cosmetics[] array = {cosmetic1, cosmetic2, cosmetic3, cosmetic4, cosmetic5, cosmetic6, cosmetic7, cosmetic8, cosmetic9, cosmetic10};


            // Сортуємо за спаданням по volumeMl, і за зростанням по priceUAH.
            Arrays.sort(array, Comparator.comparing(Cosmetics::getVolumeMl).reversed().thenComparing(Cosmetics::getPriceUAH));


            // Форматований вивід відсортованого масиву
            System.out.println("Спадання за об'ємом (зростання за ціною)");
            System.out.printf("%-40s  %-5s    %-4s   %-20s  %-15s %n", "Назва", "Об'єм, мл", "Ціна, грн", "Бренд", "Тип");
            System.out.printf("-".repeat(110) + "%n");
            for (Cosmetics element : array) {
                System.out.printf("%-40s  %-5dмл      %-4d грн    %-20s  %-15s %n", element.getName(), element.getVolumeMl(), element.getPriceUAH(), element.getBrand(), element.getType());
            }


            // Пошук ідентичного об'єкта
            Cosmetics testCosmetic = new Cosmetics("Mixa", "Ceramide Protect", "Догляд за шкірою", 400, 340);

            ArrayList<Cosmetics> foundObjects = new ArrayList<>();
            for (Cosmetics element : array) {
                if (element.equals(testCosmetic)) {
                    foundObjects.add(element);
                }
            }


            System.out.println();
            if (foundObjects.isEmpty()) {
                System.out.println("Не знайдено жодного такого об'єкта");
            } else {
                System.out.println("Знайдено ідентичний об'єкт:");
                for (Cosmetics element : foundObjects) {
                    System.out.printf("%-40s  %-5s    %-4s   %-20s  %-15s %n", "Назва", "Об'єм, мл", "Ціна, грн", "Бренд", "Тип");
                    System.out.printf("-".repeat(110) + "%n");
                    System.out.printf("%-40s  %-5dмл      %-4d грн    %-20s  %-15s %n", element.getName(), element.getVolumeMl(), element.getPriceUAH(), element.getBrand(), element.getType());
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.printf("Помилка аргуемнту: %s%n", e.getMessage());
        } catch (Exception e) {
            System.err.printf("Помилка %s%n", e.getMessage());
        }
    }
}
