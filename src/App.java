public class App {
    public static void main(String[] args) {

        new Restaurant();

        Restaurant.displayBurgers();

        Burger selectedBurger =  Restaurant.selectBurger();

        Restaurant.displayToppings();

        Restaurant.chooseToppings(selectedBurger);

        Bill bill = new Bill(selectedBurger);

        bill.generateReciept();

    }
}