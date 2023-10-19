package OOP.boom7;

public class Game {
  private int currentPlayers;
  private int outPlayers;
  private int lastNumber;

  public Game(int currentPlayers) {
    this.currentPlayers = currentPlayers;
    lastNumber = 0;
  }

  public void subPlayers() {
    currentPlayers--;
    outPlayers++;
  }

  public boolean need7() {
    interface lambda {
      boolean has7(int next);
    }
    lambda has7 = (n) -> {
      while (n > 0) {
        if (n % 10 == 7) return true;
        n /= 10;
      }
      return false;
    };

    return (lastNumber + 1) % 7 == 0 || has7.has7((this.lastNumber + 1));
  }

  public int getCurrentPlayers() {
    return currentPlayers;
  }

  public void setCurrentPlayers(int currentPlayers) {
    this.currentPlayers = currentPlayers;
  }

  public int getOutPlayers() {
    return outPlayers;
  }

  public void setOutPlayers(int outPlayers) {
    this.outPlayers = outPlayers;
  }

  public int getLastNumber() {
    return lastNumber;
  }

  public void setLastNumber(int lastNumber) {
    this.lastNumber = lastNumber;
  }
}
