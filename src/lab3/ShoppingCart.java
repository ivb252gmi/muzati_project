package lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Покупательская корзина для хранения выбранных товаров и подсчета их общей стоимости.
 * @author Музаев Д.Н.
 * @version 1.0
 */
class ShoppingCart {
    /** Список всех позиций в корзине */
    private List<CartItem> items = new ArrayList<>();

    /**
     * Добавляет товар в корзину. Если товар уже есть, увеличивает его количество.
     * @param product добавляемый товар
     * @param qty количество единиц
     */
    public void addProduct(Product product, int qty) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + qty);
                return;
            }
        }
        items.add(new CartItem(product, qty));
    }

    /**
     * Полностью удаляет указанный товар из корзины.
     * @param product товар для удаления
     */
    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    /**
     * Рассчитывает итоговую стоимость всех товаров в корзине.
     * @return общая сумма покупок
     */
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.calculateItemCost();
        }
        return total;
    }

    /**
     * Выводит в консоль текущее содержимое корзины и ее предварительную стоимость.
     */
    public void printReceipt() {
        System.out.println("------- СОДЕРЖИМОЕ КОРЗИНЫ -------");
        for (CartItem item : items) {
            Product p = item.getProduct();
            System.out.println(String.format("- %s [%s] x %d шт. = %.2f руб.",
                    p.name, p.getCategory(), item.getQuantity(), item.calculateItemCost()));
        }
        System.out.println(String.format("Итого в корзине: %.2f руб.", calculateTotal()));
        System.out.println("----------------------------------");
    }

    /**
     * Возвращает список всех элементов корзины {@link ShoppingCart#items}.
     * @return список объектов {@link CartItem}
     */
    public List<CartItem> getItems() {
        return items;
    }
}
