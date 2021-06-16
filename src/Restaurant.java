import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {

    private static Scanner input;
    private static ArrayList<Burger> allBurgers;
    private static ArrayList<Topping> allToppings;

    Restaurant(){
        allBurgers = Fridge.prepareBurgers();
        allToppings = Fridge.prepareToppings();
    }

    public static void displayBurgers(){
        System.out.println("\n\t\t Brampton Burger");

        int i = 1;
        for (Burger burger: allBurgers) {
            System.out.println(i+". \t"+burger);
            i++;
        }
    }

    public static void displayToppings(){
        System.out.println("\nPlease add some toppings");

        int i = 1;
        for (Topping topping : allToppings) {
            System.out.println(i+". \t"+topping);
            i++;
        }
    }

    public static Burger selectBurger(){
        Burger burger;
        System.out.print("Select: ");

        try{
            input  = new Scanner(System.in);

            int choice = input.nextInt();

            // if user chooses the wrong burger.
            if (choice > 3 || choice < 1){
                Error("Please select the burger shown in the list.");
                burger = selectBurger();
            }else{
                burger = allBurgers.get(choice - 1);
            }

        }catch (Exception e){
            Error("Please select the burger shown in the list.");
            burger = selectBurger();
        }

        return burger;
    }


    public static void chooseToppings(Burger selectedBurger){

        System.out.print(String.format("Choose any %d toppings : ",selectedBurger.getMaxToppings()-selectedBurger.getToppings().size()));

        try{
            input = new Scanner(System.in);
            int choice = input.nextInt();

            if(choice==0){
                return;
            }else if(choice > allToppings.size() || choice < 1){
                Error("Please select the right topping.");
                chooseToppings(selectedBurger);
            }else{
                selectedBurger.setToppings(allToppings.get(choice-1));
            }

            if(selectedBurger.getMaxToppings() !=  selectedBurger.getToppings().size()){
                chooseToppings(selectedBurger);
            }

        }catch (Exception e){
            Error("Please select the right topping.");
            chooseToppings(selectedBurger);
        }

    }

    private static void Error(String error){
        System.out.println(error);
    }
}