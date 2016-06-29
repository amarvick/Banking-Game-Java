/**
 * Created by user on 12/30/15.
 */
import java.util.Scanner;

public class User {

    int cash;
    int cheMoney = -1;
    int savMoney = -1;
    //Integers above represent how much you have in your pocket, checking and savings.

    int depMoney;
    int witMoney;
    int scChoice;
    //Inputs for depositing/checking

    int tCtoS;
    int tStoC;
    int transOption;
    //Inputs for transferring from checking to savings or savings to checking.

    int luckGen = 0;
    //Operates within the luck method

    void entry() {
        System.out.println("Hello! Welcome to the banking game. To begin, you will start with $10000 cash.");
        System.out.println("");

        while (cheMoney < 0 || cheMoney > 10000) {
            Scanner cheInput = new Scanner(System.in);
            System.out.print("How much of your money do you put in your checking account?: ");
            cheMoney = cheInput.nextInt();

            if (cheMoney > 10000) {
                System.out.println("");
                System.out.println("Please put in a number less than or equal to 10000.");
                System.out.println("");

            } else if (cheMoney < 0) {
                System.out.println("");
                System.out.println("Please put in a number greater than 0, or 0 itself.");
                System.out.println("");

            }

        }

        while (cheMoney + savMoney > 10000 || savMoney < 0) {
            Scanner savInput = new Scanner(System.in);
            System.out.print("How much of your money do you put in your savings account?: ");
            savMoney = savInput.nextInt();
            System.out.println("");

            if (cheMoney + savMoney > 10000) {
                System.out.println("You've exceeded $10000. Please try again. Available money: $" + (10000 - cheMoney));
                System.out.println("");

            } else if (savMoney < 0) {
                System.out.println("Please put in a number greater than '0', or '0' itself.");
                System.out.println("");

            } else {
                System.out.println("You have $" + cheMoney + " in your checking and $" + savMoney + " in your savings.");
                System.out.println("As a result, you are holding on to $" + (10000 - (savMoney + cheMoney) + " cash."));
                System.out.println("");
                cash = (10000 - (savMoney + cheMoney));
                break;

            }

        }

    }

    void deposit() {
        System.out.println("You are depositing.");

        while (true) {

            Scanner CorS = new Scanner(System.in);
            System.out.println("Pick checking or savings.");
            System.out.println("0. Neglect");
            System.out.println("1. Checking (" + cheMoney + ")");
            System.out.println("2. Saving (" + savMoney + ")");
            System.out.print("Select (0-2): ");
            scChoice = CorS.nextInt();
            System.out.println("");

            if (scChoice == 0) {
                break;

            } else if (scChoice == 1) {
                while(true) {
                    depMoney = 0;
                    Scanner deposit = new Scanner(System.in);
                    System.out.print("Enter how much money you will deposit to your checking account: ");
                    depMoney = deposit.nextInt();

                    if (depMoney > cash) {
                        System.out.println("");
                        System.out.println("The amount you have attempted to deposit exceeds what you're carrying.");
                        System.out.println("For reference, you are carrying $" + cash + " in cash.");
                        System.out.println("");

                    } else if (depMoney < 0) {
                        System.out.println("");
                        System.out.println("Please enter a number from 0 to the maximum amount of cash you're carrying.");
                        System.out.println("For reference, you are carrying $" + cash + " in cash.");
                        System.out.println("");

                    } else {
                        cash -= depMoney;
                        cheMoney += depMoney;
                        System.out.println("");
                        System.out.println("You deposited " + depMoney + " in your checking account.");
                        System.out.println("You now have $" + cheMoney + " in your checking account and $" + cash + " in cash.");
                        System.out.println("");
                        break;

                    }

                }
                break;

            } else if (scChoice == 2) {
                while(true) {
                    depMoney = 0;
                    Scanner deposit = new Scanner(System.in);
                    System.out.print("Enter how much money you will deposit to your savings account: ");
                    depMoney = deposit.nextInt();

                    if (depMoney > cash) {
                        System.out.println("");
                        System.out.println("The amount you have attempted to deposit exceeds what you're carrying.");
                        System.out.println("For reference, you are carrying $" + cash + " in cash.");
                        System.out.println("");

                    } else if (depMoney < 0) {
                        System.out.println("");
                        System.out.println("Please enter a number from 0 to the maximum amount of cash you're carrying.");
                        System.out.println("For reference, you are carrying $" + cash + " in cash.");
                        System.out.println("");

                    } else {
                        cash -= depMoney;
                        savMoney += depMoney;
                        System.out.println("");
                        System.out.println("You deposited " + depMoney + " in your savings account.");
                        System.out.println("You now have $" + savMoney + " in your savings account and $" + cash + " in cash.");
                        System.out.println("");
                        break;

                    }

                }
                break;

            } else {
                System.out.println("Invalid choice. Please select again.");
                System.out.println("");

            }

        }

    }

    void withdraw() {
        System.out.println("You are withdrawing.");

        while (true) {
            Scanner CorS = new Scanner(System.in);
            System.out.println("Pick checking or savings.");
            System.out.println("0. Neglect");
            System.out.println("1. Checking (" + cheMoney + ")");
            System.out.println("2. Saving (" + savMoney + ")");
            System.out.print("Select (0-2): ");
            scChoice = CorS.nextInt();
            System.out.println("");

            if (scChoice == 0) {
                break;

            } else if (scChoice == 1) {
                while(true) {
                    witMoney = 0;
                    Scanner withdraw = new Scanner(System.in);
                    System.out.print("Enter how much money you will withdraw from your checking account: ");
                    witMoney = withdraw.nextInt();

                    if (witMoney > cheMoney) {
                        System.out.println("");
                        System.out.println("The amount you attempted to withdraw exceeds what you have in your checkings.");
                        System.out.println("For reference, you have $" + cheMoney + " in your checking account.");
                        System.out.println("");

                    } else if (witMoney < 0) {
                        System.out.println("");
                        System.out.println("Please enter a number from 0 to your maximum checking balance.");
                        System.out.println("For reference, you have $" + cheMoney + " in your checking account.");
                        System.out.println("");

                    } else {
                        cheMoney -= witMoney;
                        cash += witMoney;
                        System.out.println("");
                        System.out.println("You withdrew " + witMoney + " in your checking account.");
                        System.out.println("You now have $" + cheMoney + " in your checking account and $" + cash + " in cash.");
                        System.out.println("");
                        break;

                    }

                }
                break;

            } else if (scChoice == 2) {
                while (true) {
                    witMoney = 0;
                    Scanner withdraw = new Scanner(System.in);
                    System.out.print("Enter how much money you will withdraw from your savings account: ");
                    witMoney = withdraw.nextInt();

                    if (witMoney > savMoney) {
                        System.out.println("");
                        System.out.println("The amount you attempted to withdraw exceeds what you have in your savings.");
                        System.out.println("For reference, you have $" + savMoney + " in your savings account.");
                        System.out.println("");

                    } else if (witMoney < 0) {
                        System.out.println("");
                        System.out.println("Please enter a number from 0 to your maximum savings balance.");
                        System.out.println("For reference, you have $" + savMoney + " in your savings account.");
                        System.out.println("");

                    } else {
                        savMoney -= witMoney;
                        cash += witMoney;
                        System.out.println("");
                        System.out.println("You withdrew " + witMoney + " in your savings account.");
                        System.out.println("You now have $" + savMoney + " in your savings account and $" + cash + " in cash.");
                        System.out.println("");
                        break;

                    }

                }
                break;

            } else {
                System.out.println("Invalid choice. Please select again.");
                System.out.println("");

            }

        }

    }

    void transfer() {
        //Allows user to transfer between checking and savings
        System.out.println("You are making a transfer.");
        System.out.println("");

        while(true) {
            Scanner tChoice = new Scanner(System.in);
            System.out.println("What would you like to transfer between?");
            System.out.println("0. Neglect");
            System.out.println("1. Checking to Savings");
            System.out.println("2. Savings to Checking");
            System.out.print("Select a transfer option (0-2): ");
            transOption = tChoice.nextInt();
            System.out.println("");

            if (transOption == 0) {
                break;

            } else if (transOption == 1) {
                while (true) {
                    Scanner CtoS = new Scanner(System.in);
                    System.out.println("How much would you like to transfer?");
                    System.out.println("For reference, you have $" + cheMoney + " in your checking and $" + savMoney
                                     + " in your savings.");
                    System.out.print("Input: ");
                    tCtoS = CtoS.nextInt();
                    System.out.println("");

                    if (tCtoS > cheMoney) {
                        System.out.println("The amount you have attempted to transfer exceeds what you have in your checking.");
                        System.out.println("");

                    } else if (tCtoS < 0) {
                        System.out.println("Please put in any number between 0 and the amount you have in your checking.");
                        System.out.println("");

                    } else {
                        cheMoney -= tCtoS;
                        savMoney += tCtoS;
                        System.out.println("Transfer successful. You have $" + cheMoney + " in your checking and $"
                                         + savMoney + " in your savings.");
                        System.out.println("");
                        break;

                    }

                }

            } else if (transOption == 2) {
                while(true) {
                    Scanner StoC = new Scanner(System.in);
                    System.out.println("How much would you like to transfer?");
                    System.out.println("For reference, you have $" + savMoney + " in your savings and $" + cheMoney
                                     + " in your checking.");
                    tStoC = StoC.nextInt();
                    System.out.println("");

                    if (tStoC > savMoney) {
                        System.out.println("The amount you have attempted to transfer exceeds what you have in your savings.");
                        System.out.println("");

                    } else if (tStoC < 0) {
                        System.out.println("Please put in any number between 0 and the amount you have in your savings.");
                        System.out.println("");

                    } else {
                        cheMoney += tCtoS;
                        savMoney -= tCtoS;
                        System.out.println("Transfer successful. You have $" + savMoney + " in your savings and $"
                                + cheMoney + " in your checking.");
                        System.out.println("");
                        break;

                    }

                }

            } else {
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("");

            }
        break;

        }

    }

    void check() {
        System.out.println("You have $" + cheMoney + " in your checking account and $" + savMoney + " in your savings. "
                           + "You are carrying $" + cash + " in cash.");
        System.out.println("");

    }

    void luck() {
        //Random number generator should be implemented for 'luckGen'.
        if (luckGen > 5 && luckGen < 10) {
            System.out.println("Congratulations! You have collected a sweater.");
            System.out.println("");

        }

    }

    void items() {
        System.out.println("Below are all of the items you have obtained:");
        System.out.println("");
        //Get an array of items

    }

    void quit() {
        System.out.println("Thank you for playing the bank game.");
        System.out.println("");

    }

}