package lab3;

/**
 * Элемент покупательской корзины, связывающий конкретный товар и его количество.
 * @author Музаев Д.Н.
 * @version 1.0
 * @see ShoppingCart
 */
class CartItem {
    /** Ссылка на объект товара */
    private Product product;
    /** Количество единиц данного товара в корзине */
    private int quantity;

    /**
     * Создает новую позицию в корзине.
     * @param product выбранный товар
     * @param quantity количество единиц товара
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Возвращает значение поля {@link CartItem#product}.
     * @return объект товара {@link Product}
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Возвращает значение поля {@link CartItem#quantity}.
     * @return целое количество единиц товара
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает значение поля {@link CartItem#quantity}
     * @param quantity новое количество (должно быть больше 0)
     */
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    /**
     * Вычисляет общую стоимость данной позиции в корзине.
     * @return произведение актуальной цены товара на его количество
     */
    public double calculateItemCost() {
        return product.getPrice() * quantity;
    }
}
