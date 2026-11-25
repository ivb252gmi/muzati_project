package lab3;

/**
 * Класс, представляющий непродовольственные хозяйственные товары.
 * @author Музаев Д.Н.
 * @version 1.0
 */
class HouseholdProduct extends Product implements Discountable {
    /** Поле для хранения области применения товара в быту */
    private String usageArea;
    /** Поле для хранения текущего процента скидки */
    private double discountPercent = 0;

    /**
     * Создает хозяйственный товар с указанием области применения.
     * @param name         наименование товара
     * @param manufacturer производитель
     * @param basePrice    базовая цена
     * @param usageArea    область применения
     */
    public HouseholdProduct(String name, String manufacturer, double basePrice, String usageArea) {
        super(name, manufacturer, basePrice);
        this.usageArea = usageArea;
    }

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
        return "Хозяйственные товары";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Область применения: " + usageArea;
    }
}
