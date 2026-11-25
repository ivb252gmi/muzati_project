package lab3;

/**
 * Класс, представляющий предметы одежды.
 *
 * @author Музаев Д.Н.
 * @version 1.0
 */
class ClothingProduct extends Product implements Discountable {
    /** Поле для хранения размера одежды */
    private String size;
    /** Поле для хранения материала изготовления */
    private String material;
    /** Поле для хранения текущего процента скидки */
    private double discountPercent = 0;

    /**
     * Создает товар категории «Одежда».
     *
     * @param name         наименование предмета одежды
     * @param manufacturer бренд или производитель
     * @param basePrice    базовая цена
     * @param size         размер изделия
     * @param material     материал изготовления
     */
    public ClothingProduct(String name, String manufacturer, double basePrice, String size, String material) {
        super(name, manufacturer, basePrice);
        this.size = size;
        this.material = material;
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
        return "Одежда";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(", Размер: %s, Материал: %s", size, material);
    }
}
