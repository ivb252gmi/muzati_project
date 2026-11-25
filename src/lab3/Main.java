package lab3;

import java.time.LocalDate;

/**
 * Главный класс программы для демонстрации работы системы супермаркета.
 * @author Музаев Д.Н.
 * @version 1.0
 */
public class Main {
    /**
     * Точка входа в программу.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        FoodProduct milk = new FoodProduct("Молоко 3.2%", "Простоквашино", 90.0, LocalDate.now().plusDays(7), true);
        HouseholdProduct soap = new HouseholdProduct("Мыло жидкое", "Dove", 150.0, "Ванная комната");
        ClothingProduct tShirt = new ClothingProduct("Футболка хлопковая", "Nike", 1200.0, "L", "Хлопок");

        tShirt.applyDiscount(10);

        System.out.println("=== Информация о доступных товарах ===");
        System.out.println(milk.getDescription());
        System.out.println(soap.getDescription());
        System.out.println(tShirt.getDescription());
        System.out.println();

        ShoppingCart cart = new ShoppingCart();
        System.out.println("Добавляем товары в корзину...");
        cart.addProduct(milk, 2);
        cart.addProduct(soap, 1);
        cart.addProduct(tShirt, 1);
        cart.printReceipt();

        System.out.println("\nУдаляем 'Мыло жидкое' из корзины...");
        cart.removeProduct(soap);
        cart.printReceipt();

        CashRegister cashRegister = new CashRegister();
        Payment customerPayment = new Payment(1500.0);

        System.out.println("\nПроведение оплаты на кассе...");
        cashRegister.checkout(cart, customerPayment);
    }
}

