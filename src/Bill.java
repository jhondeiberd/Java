public class Bill {

    Burger burger;

    public Bill(Burger burger){
        this.burger = burger;
    }

    public void generateReciept(){
        double total = calculateTotal(this.burger);
        double tax = total * 0.15;
        double netTotal= total + tax;

        System.out.println("Total : "+ netTotal);
    }


    private double calculateTotal(Burger burger){
        double tempTotal = 0;

        tempTotal += burger.getPrice();

        for (Topping topping: burger.getToppings()) {
            tempTotal += topping.getPrice();
        }

        return tempTotal;
    }


}