import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> expenses= new ArrayList<>(); 
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean running = true;


        

        while(running){
        System.out.println("====Expense Tracker====");
        System.out.println("Enter choice");
        System.out.println("1.Add expense");
        System.out.println("2.List all Expenses");
        System.out.println("3.Exit");     
        System.out.println("4.Delete Expense");
        
        choice = scanner.nextInt();
        scanner.nextLine();
        

        switch(choice){
            case 1:
            System.out.println("You selected option 1");
            addExpense(scanner);
            break;

            case 2:
            System.out.println("You selected option 2");
            ListExpense();
            break;

            case 3:
            System.out.println("You choose option 3");
            System.out.println("Goodbye");
            running = false;
            break;

            case 4:
            DeleteExpense(scanner);
            break;


            default:
            System.out.println("Invalid choice");
        }
        System.out.println();

        }
        scanner.close();
        

    }
    public static void addExpense(Scanner scanner){
        
        System.out.println("Enter expense description");
        String description = scanner.nextLine();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        String newExpense = "Description: "+ description + " Amount : ₹ " + String.format("%.2f",(double)amount);
        expenses.add(newExpense);
        System.out.println("Expense added successfully"); 


    }
    public static void ListExpense(){
        if(expenses.isEmpty()){
            System.out.println("No expenses added");
        }else{
            System.out.println("Listing all expenses");
            for(String expense : expenses){
                System.out.println("- " + expense);
            }
        }
    }
    public static void DeleteExpense(Scanner scanner){
        if(expenses.isEmpty()){
            System.out.println("No Expense");
            return;
        }
        System.out.println("Choose an expense to delete");

        for(int i=0;i<expenses.size();i++){
            System.out.println((i + 1) + ". " +expenses.get(i));
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        if(number < 1 || number > expenses.size()){
            System.out.println("Invalid number");
            return;
        }
        expenses.remove(number - 1);
        System.out.println("Expense deleted");

            
        

    }
}