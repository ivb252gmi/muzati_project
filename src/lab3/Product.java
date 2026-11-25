package lab3;

/**
 * Абстрактный базовый класс для всех товаров супермаркета.
 * Реализует интерфейс {@link Sellable}.
 * @author Музаев Д.Н.
 * @version 1.0
 * @see Sellable
 */
abstract class Product implements Sellable {
    /** Поле для хранения наименования товара */
    protected String name;
    /** Поле для хранения названия производителя товара */
    protected String manufacturer;
    /** Поле для хранения базовой цены товара без учета скидок */
    protected double basePrice;

    /**
     * Создает новый экземпляр товара с заданными характеристиками.
     * @param name         наименование товара
     * @param manufacturer производитель товара
     * @param basePrice    базовая стоимость единицы товара
     */
    public Product(String name, String manufacturer, double basePrice) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
    }

    /**
     * Возвращает значение поля {@link Product#name}.
     * @return строку с наименованием товара
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает значение поля {@link Product#manufacturer}.
     * @return строку с названием производителя
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Возвращает значение поля {@link Product#basePrice}.
     * @return вещественное значение базовой цены
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Возвращает базовую цену товара.
     * @return базовая цена товара
     */
    @Override
    public double getPrice() {
        return getBasePrice();
    }

    /**
     * Возвращает базовое описание товара.
     * @return форматированная строка с названием, производителем и ценой
     */
    @Override
    public String getDescription() {
        return String.format("Наименование: %s, Производитель: %s, Базовая цена: %.2f руб.",
                getName(), getManufacturer(), getBasePrice());
    }

    /**
     * Возвращает название категории, к которой относится данный товар.
     * @return строковое название категории товара
     */
    public abstract String getCategory();
}