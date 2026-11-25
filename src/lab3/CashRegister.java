package lab3;

/**
 * Кассовый аппарат, отвечающий за проведение расчетов и печать фискального чека.
 * @author Музаев Д.Н.
 * @version 1.0
 */
class CashRegister {
    /**
     * Проводит расчет по корзине с использованием выбранного способа оплаты.
     * @param cart    корзина с товарами
     * @param payment объект реализации оплаты {@link Payment}
     * @return размер сдачи при успешной оплате или {@code -1} при отказе
     */
    public double checkout(ShoppingCart cart, Payment payment) {
        double total = cart.calculateTotal();
        if (!payment.pay(total)) {
            System.out.println("Ошибка: Недостаточно средств для оплаты!");
            return -1;
        }
        double change = payment.getPayAmount() - total;
        System.out.println("\n=== ЧЕК ОПЛАТЫ. ===");
        printReceipt(cart);
        System.out.println(String.format("Оплачено: %.2f руб.", payment.getPayAmount()));
        System.out.println(String.format("Сдача: %.2f руб.", change));
        System.out.println("==================\n");
        return change;
    }

    /**
     * Выводит в консоль фискальный чек оплаты по переданной корзине.
     * @param cart корзина с оплаченными товарами
     */
    public void printReceipt(ShoppingCart cart) {
        cart.printReceipt();
    }
}
