package OOP.banks;

import utils.Input;

public class Main {
  public static void bankWhile() {
    int opCode = 2;
    int amount = 0;
    int totalWithdraw = 0;
    int totalDeposit = 0;
    BankAccount bankAccount;

    System.out.println("Please enter id, name, money");
    bankAccount = new BankAccount(Input.nextLine(), Input.nextLine(), Input.nextInt());
    while (opCode != -1) {
      switch (opCode) {
        case 0 -> {
          if (bankAccount.withdraw(amount)) totalWithdraw += amount;
        }
        case 1 -> {
          bankAccount.deposit(amount);
          totalDeposit += amount;
        }
      }

      System.out.println("Please enter opcode and amount");
      opCode = Input.nextInt();
      amount = Input.nextInt();
    }

    System.out.println(bankAccount);
    System.out.println("Total Withdraw: " + totalWithdraw + " Total Deposit: " + totalDeposit);
  }

  public static void bankAction() {
    int opCode;
    int amount;

    System.out.println("Please enter number, name, money");
    BankAccount account = new BankAccount(Input.nextLine(), Input.nextLine(), Input.nextInt());

    System.out.println("Please enter opCode and amount");
    opCode = Input.nextInt();
    amount = Input.nextInt();

    switch (opCode) {
      case 0 -> account.withdraw(amount);
      case 1 -> account.deposit(amount);
      default -> throw new IllegalStateException("Unexpected value: " + opCode);
    }
  }
}
