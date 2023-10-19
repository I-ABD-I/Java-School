package OOP.banks;

public class BankAccount {
  private final String number;
  private final String name;
  private int money;

  public BankAccount(String number, String name, int money) {
    this.number = number;
    this.name = name;
    this.money = money;
  }

  public boolean withdraw(int money) {
    if (money > this.money) {
      System.out.println("Not Enough money in the Account");
      return false;
    }
    this.money -= money;
    return true;
  }

  public void deposit(int money) {
    this.money += money;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

}
