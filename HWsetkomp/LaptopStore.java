package HWsetkomp;
import java.util.*;
public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = createLaptops();

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = getFiltersFromUser(scanner);

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);

        printLaptops(filteredLaptops);
    }

    private static Set<Laptop> createLaptops() {
        return new HashSet<>(Set.of(
            new Laptop("Asus", 8, 512, "Windows", "Black"),
            new Laptop("Apple", 16, 1024, "MacOS", "Red"),
            new Laptop("Lenovo", 12, 256, "Linux", "Blue"),
            new Laptop("Acer", 16, 512, "Windows", "Red"),
            new Laptop("HP", 8, 1024, "Linux", "White"),
            new Laptop("Apple", 16, 256, "MacOS", "Gray"),
            new Laptop("Lenovo", 12, 512, "Linux", "Green"),
            new Laptop("Dell", 8, 256, "Windows", "Silver"),
            new Laptop("Apple", 16, 512, "MacOS", "Black")
        ));
    }

    private static Map<String, Object> getFiltersFromUser(Scanner scanner) {
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите критерии поиска (для поиска оставьте поле пустым):");

        while (true) {
            System.out.println("1 - Бренд");
            System.out.println("2 - ОЗУ (гигабайты)");
            System.out.println("3 - Объем жесткого диска (гигабайты)");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("Для поиска оставьте поле пустым");

            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("")) {
                break;
            }

            int criterion;
            try {
                criterion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
                continue;
            }

            switch (criterion) {
                case 1:
                    System.out.println("Введите бренд:");
                    filters.put("brand", scanner.nextLine().toLowerCase().trim());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ОЗУ (гигабайты):");
                    filters.put("ramSizeGB", scanner.hasNextInt() ? scanner.nextInt() : null);
                    scanner.nextLine(); 
                    break;
                case 3:
                    System.out.println("Введите минимальный объем жесткого диска (гигабайты):");
                    filters.put("storageSizeGB", scanner.hasNextInt() ? scanner.nextInt() : null);
                    scanner.nextLine(); 
                    break;
                case 4:
                    System.out.println("Введите операционную систему:");
                    filters.put("operatingSystem", scanner.nextLine().toLowerCase().trim());
                    break;
                case 5:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.nextLine().toLowerCase().trim());
                    break;
                default:
                    System.out.println("Некорректный выбор критерия. Попробуйте еще раз.");
                    break;
            }
        }

        return filters;
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean satisfiesFilters = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String criterion = entry.getKey();
                Object value = entry.getValue();

                switch (criterion) {
                    case "brand":
                        satisfiesFilters = satisfiesFilters && laptop.getBrand().toLowerCase().equals(value);
                        break;
                    case "ramSizeGB":
                        satisfiesFilters = satisfiesFilters && (value == null || laptop.getRamSizeGB() >= (int) value);
                        break;
                    case "storageSizeGB":
                        satisfiesFilters = satisfiesFilters && (value == null || laptop.getStorageSizeGB() >= (int) value);
                        break;
                    case "operatingSystem":
                        satisfiesFilters = satisfiesFilters && laptop.getOperatingSystem().toLowerCase().equals(value);
                        break;
                    case "color":
                        satisfiesFilters = satisfiesFilters && laptop.getColor().toLowerCase().equals(value);
                        break;
                    default:
                        System.out.println("Некорректный критерий фильтрации.");
                        break;
                }

                if (!satisfiesFilters) {
                    break; // Если хоть один критерий не выполняется, можно прекращать проверку
                }
            }

            if (satisfiesFilters) {
                result.add(laptop);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Не удалось найти ноутбуки по вашему запросу");
        }

        return result;
    }

    private static void printLaptops(Set<Laptop> laptops) {
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }
}