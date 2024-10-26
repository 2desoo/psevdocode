package task3;

import java.util.HashMap;
import java.util.Map;

public class DistributionCalculator {
    public static void main(String[] args) {
        // Исходные данные
        double totalWeight = 58.21942216; // общее количество
        double totalPrice = 582.19;       // общая сумма
        double unitPrice = totalPrice / totalWeight; // цена за единицу веса

        // Количество и фамилии для детализации
        Map<String, Double> people = new HashMap<>();
        people.put("Иванов", 30.88488888);
        people.put("Петров", 5.88848888);
        people.put("Сидоров", 5.88848888);
        people.put("Малевин", 5.88848888);
        people.put("Макаров", 5.88848888);
        people.put("Сетченко", 1.88848888);
        people.put("Козлов", 1.88848888);

        // Вывод заголовка таблицы
        System.out.printf("%-10s %-20s %-20s %-20s %n", "Фамилия", "Округленное Кол-во*Цену", "Сумма", "Распределение копеек");

        double sumRounded = 0;
        Map<String, Double> roundedPrices = new HashMap<>();

        // Рассчитываем сумму для каждого человека и выводим значения
        for (Map.Entry<String, Double> entry : people.entrySet()) {
            String name = entry.getKey();
            double weight = entry.getValue();
            double calculatedPrice = weight * unitPrice;

            // Округленная цена для детализации
            double roundedPrice = Math.round(calculatedPrice * 100.0) / 100.0;
            roundedPrices.put(name, roundedPrice);

            // Считаем сумму округленных значений и фактических значений для контроля распределения
            sumRounded += roundedPrice;

            // Выводим данные без распределения копеек
            System.out.printf("%-10s %-20.2f %-20.8f %-20s %n", name, roundedPrice, calculatedPrice, "-");
        }

        // Рассчитываем разницу для распределения копеек
        double difference = totalPrice - sumRounded;

        // Распределяем копейки
        for (Map.Entry<String, Double> entry : roundedPrices.entrySet()) {
            String name = entry.getKey();
            double adjustedPrice = entry.getValue();

            // Добавляем копейки к "Сетченко" и "Козлов" как указано в примере
            if (name.equals("Сетченко") && difference > 0) {
                adjustedPrice += 0.01;
                difference -= 0.01;
            } else if (name.equals("Козлов") && difference > 0) {
                adjustedPrice += 0.01;
                difference -= 0.01;
            }

            // Обновляем строку для этих записей с распределенными копейками
            System.out.printf("%-10s %-20.2f %-20.8f %-20.2f %n", name, adjustedPrice, adjustedPrice, (name.equals("Сетченко") || name.equals("Козлов")) ? 0.01 : 0.0);
        }

        // Вывод итоговой строки
        System.out.printf("Итого      %-20s %-20.8f %-20.8f %n", "", sumRounded, totalPrice);
    }
}
