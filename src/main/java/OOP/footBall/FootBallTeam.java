package OOP.footBall;

public class FootBallTeam {
  private String name;
  private String League;
  private int gamesWon;
  private int gamesLost;
  private int gamesDraw;

  public FootBallTeam(String name) {
    this.name = name;
  }

  public FootBallTeam(String name, String league, int gamesWon, int gamesLost, int gamesDraw) {
    this.name = name;
    League = league;
    this.gamesWon = gamesWon;
    this.gamesLost = gamesLost;
    this.gamesDraw = gamesDraw;
  }

  public void draw() {
    gamesDraw++;
  }

  public void win() {
    gamesWon++;
  }

  public void lose() {
    gamesLost++;
  }

  @Override
  public String toString() {
    return "FootBallTeam{" + "name='" + name + '\'' + ", League='" + League + '\'' + ", gamesWon="
           + gamesWon + ", gamesLost=" + gamesLost + ", gamesDraw=" + gamesDraw + '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLeague() {
    return League;
  }

  public void setLeague(String league) {
    League = league;
  }

  public int getGamesWon() {
    return gamesWon;
  }

  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }

  public int getGamesLost() {
    return gamesLost;
  }

  public void setGamesLost(int gamesLost) {
    this.gamesLost = gamesLost;
  }

  public int getGamesDraw() {
    return gamesDraw;
  }

  public void setGamesDraw(int gamesDraw) {
    this.gamesDraw = gamesDraw;
  }
}
