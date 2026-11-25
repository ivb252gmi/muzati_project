package lab3;

/**
 * Класс для обработки платежа покупателя.
 * @author Музаев Д.Н.
 * @version 1.0
 */
class Payment {
    /** Сумма денежных средств, внесенная покупателем */
    private double payAmount;

    /**
     * Создает объект оплаты с указанной внесенной суммой.
     * @param payAmount внесенная сумма денег
     */
    public Payment(double payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * Проверяет, достаточно ли внесенных средств для оплаты указанной суммы.
     * @param amount итоговая сумма к оплате
     * @return {@code true}, если средств достаточно, иначе {@code false}
     */
    public boolean pay(double amount) {
        return payAmount >= amount;
    }

    /**
     * Возвращает значение поля {@link Payment#payAmount}.
     * @return внесенная покупателем сумма
     */
    public double getPayAmount() {
        return payAmount;
    }
}
