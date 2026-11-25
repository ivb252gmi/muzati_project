package lab3;

import java.time.LocalDate;

/**
 * Класс, представляющий продукты питания.
 * Наследует {@link Product} и реализует интерфейс {@link Discountable}.
 * @author Музаев Д.Н
 * @version 1.0
 */
class FoodProduct extends Product implements Discountable {
    /** Поле для хранения даты истечения срока годности */
    private LocalDate expirationDate;
    /** Поле, указывающее, является ли продукт скоропортящимся */
    private boolean isPerishable;
    /** Поле для хранения текущего процента скидки */
    private double discountPercent = 0;

    /**
     * Создает продукт питания с указанием срока годности и условий хранения.
     * @param name           наименование продукта
     * @param manufacturer   производитель
     * @param basePrice      базовая цена
     * @param expirationDate дата окончания срока годности
     * @param isPerishable   признак скоропортящегося продукта
     */
    public FoodProduct(String name, String manufacturer, double basePrice, LocalDate expirationDate, boolean isPerishable) {
        super(name, manufacturer, basePrice);
        this.expirationDate = expirationDate;
        this.isPerishable = isPerishable;
    }

    /**
     * Вычисляет цену продукта с учетом установленной скидки.
     * @return итоговая цена со скидкой
     */
    @Override
    public double getPrice() {
        return basePrice * (1 - discountPercent / 100);
    }

    @Override
    public double applyDiscount(double percent) {
        this.discountPercent = percent;
        return getPrice();
    }

    @Override
    public String getCategory() {
        return "Продукты питания";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(", Срок годности: %s, Скоропортящийся: %s",
                expirationDate, isPerishable ? "Да" : "Нет");
    }
}
