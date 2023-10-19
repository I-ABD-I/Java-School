package OOP.boxes;

public class BoxFactory {
  private Box[] boxes;
  private int current;

  public BoxFactory(Box[] boxes, int current) {
    this.boxes = boxes;
    this.current = current;
  }

  public BoxFactory() {
    this.boxes = new Box[100];
    this.current = 0;
  }

  public static void printAllBoxesVolAbv7(BoxFactory br) {
    for (int i = 0; i < br.getCurrent(); i++) {
      if (br.getBoxes()[i].getHeight() * br.getBoxes()[i].getWidth() * br.getBoxes()[i].getWidth()
          > 7) System.out.println(br.getBoxes()[i]);
    }
  }

  public void AddBox(Box box) {
    if (current < boxes.length) boxes[current++] = box;
  }

  public double getAvgVolumeIfHeightAbv7() {
    double sum = 0;
    for (int i = 0; i < current; i++) {
      if (boxes[i].getHeight() > 7)
        sum += boxes[i].getHeight() * boxes[i].getLength() * boxes[i].getWidth();
    }
    return sum / current;
  }

  public void printVolumeAbvBox(Box b1) {
    double vol = b1.getHeight() * b1.getLength() * b1.getWidth();
    for (int i = 0; i < current; i++) {
      if (boxes[i].getHeight() * boxes[i].getHeight() * boxes[i].getHeight() > vol)
        System.out.println(boxes[i]);
    }
  }

  public Box[] getBoxes() {
    return boxes;
  }

  public void setBoxes(Box[] boxes) {
    this.boxes = boxes;
  }

  public int getCurrent() {
    return current;
  }

  public void setCurrent(int current) {
    this.current = current;
  }
}
