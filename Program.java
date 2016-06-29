/**
 * Created by user on 12/30/15.
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        User human = new User();

        int options;

        human.entry();

        while(true) {
            Scanner menuOpt = new Scanner(System.in);
            System.out.println("What would you like to do? Pick from the following options below");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balances");
            System.out.println("5. Check Luck");
            System.out.println("6. Check Items");
            System.out.println("7. Quit");
            System.out.print("Option (1-6): ");
            options = menuOpt.nextInt();
            System.out.println("");

            if (options == 1) {
                human.deposit();

            } else if (options == 2) {
                human.withdraw();

            } else if (options == 3) {
                human.transfer();

            } else if (options == 4) {
                human.check();

            } else if (options == 5) {
                human.luck(); //Will work on

            } else if (options == 6) {
                human.items(); //Will work on

            } else if (options == 7) {
                human.quit();
                break;

            } else {
                System.out.println("Please choose a number between 1-6.");
                System.out.println("");
            }

        }

    }

}