import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String password;
        String bankcard_number;
        int funds;
        int choice;
        int money;

        ReaderDataFromFile r = new ReaderDataFromFile();
        r.read("data.txt");
        //r.getUser(3).getInfo();

        Scanner con = new Scanner(System.in);

        System.out.println("Enter the card number:");
        bankcard_number = con.nextLine();
        System.out.println("Enter the password:");
        password = con.nextLine();

        while (true){
            if ((funds = r.authenticationData(bankcard_number, password)) == -1){
                System.out.println("Incorrect data entered");
                break;
            } else {
                System.out.println("Choose an action:");
                System.out.println("1. Show balance");
                System.out.println("2. Withdraw funds");
                System.out.println("3. Top up the card balance");
                System.out.println("4. Exit");
                choice = con.nextInt();
                if (choice == 4){
                    break;
                }
                switch (choice){
                    case 1:
                        System.out.println("Your balance: " + funds);
                        break;
                    case 2:
                        System.out.println("Enter the amount of money you want to withdraw:");
                        money = con.nextInt();
                        if(funds >= money){
                            funds -= money;
                            DataWriter.write(bankcard_number, password, "data.txt", funds);
                            System.out.println("Money successfully withdrawn!");
                            System.out.println("Remaining balance: " + funds);
                        } else {
                            System.out.println("Insufficient funds!");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the top-up amount:");
                        money = con.nextInt();
                        if (money <= 1000000){
                            funds += money;
                            DataWriter.write(bankcard_number, password, "data.txt", funds);
                            System.out.println("The amount has been successfully topped up!");
                            System.out.println("Remaining balance: " + funds);
                        } else {
                            System.out.println("The amount exceeds 1,000,000");
                        }
                        break;
                }

            }

        }

    }

}