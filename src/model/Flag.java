package model;

import thread.*;

public class Flag {

    public final static String ESC = "\u001b[";
    public final static String DOWN = ESC + "B";

    public final static String YELLOW = "\033[43m";
    public final static String BLUE = "\033[46m";
    public final static String RED = "\033[41m";

    private Color line1;
    private Color line2;
    private Color line3;

    private int finalPos;

    public Flag(int time1, int time2, int time3, int hight1, int hight2, int hight3, int width) {
        finalPos = hight1 + hight2 + hight3 + 3;
        line1 = new Color(hight1, width, YELLOW, time1, 1, true);
        line2 = new Color(hight2, width, BLUE, time2, hight1 + 1, false);
        line3 = new Color(hight3, width, RED, time3, hight1 + hight2 + 1, false);
    }

    public void paintFlag() throws InterruptedException {
        Thread t1 = new ThreadL(line1);
        Thread t2 = new ThreadL(line2);
        Thread t3 = new ThreadL(line3);
        clearConsole();
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(ESC + "0G" + ESC + "0d");
        System.out.print(DOWN);
    }

    public void goFinal() {
        System.out.print(ESC + "0G" + ESC + finalPos + "d");
    }
}
