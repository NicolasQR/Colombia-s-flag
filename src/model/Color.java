package model;

public class Color {

    public final static String ESC = "\u001b[";
    public final static String UP = ESC + "A";
    public final static String DOWN = ESC + "B";
    public final static String RIGHT = ESC + "C";
    public final static String LEFT = ESC + "D";

    private int initialPos;
    private int height;
    private int width;
    private String color;
    private int sleep;

    private boolean isFirst;

    String move;

    public Color(int height, int width, String color, int sleep, int initialPos, boolean isFirst) {
        this.height = height;
        this.width = width;
        this.color = color;
        this.sleep = sleep;
        this.initialPos = initialPos;
        this.isFirst = isFirst;
        move = DOWN;
    }

    public void printLine() throws InterruptedException {
        if (!isFirst) {
            setInitialPoint();
        }
        for (int i = 0; i < width; i++) {
                for (int k = initialPos; k < initialPos+height; k++) {
                    printIn(i, k);
                    Thread.sleep(sleep);
                }
            }
    }

    private synchronized void printIn(int xpos, int ypos){  
        System.out.print(ESC + xpos + "G" + ESC + ypos + "d" + color + " " + "\u001B[0m");
    }

    public  void changeDirection() {
        if (move.equals(UP)) {
            move = DOWN;
        } else {
            move = UP;
        }
    }

    public  void setInitialPoint() {
        System.out.print(ESC + initialPos + "d");
    }
}
