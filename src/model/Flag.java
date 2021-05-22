package model;

import thread.*;

public class Flag {

    public final static String ESC = "\u001b[";
    public final static String DOWN = ESC + "B";

    public final static String YELLOW = "\033[43m";
    public final static String BLUE = "\033[46m";
    public final static String RED = "\033[41m";

    private ColorLine line1;
    private ColorLine line2;
    private ColorLine line3;

    private int finalPos;

    public Flag(int time1, int time2, int time3, int hight1, int hight2, int hight3, int width) {
        finalPos = hight1 + hight2 + hight3 + 3;
        line1 = new ColorLine(hight1, width, YELLOW, time1, 1, true);
        line2 = new ColorLine(hight2, width, BLUE, time2, hight1 + 1, false);
        line3 = new ColorLine(hight3, width, RED, time3, hight1 + hight2 + 1, false);
    }

    public void paintFlag() throws InterruptedException {
        lineThread t1 = new lineThread(line1);
        lineThread t2 = new lineThread(line2);
        lineThread t3 = new lineThread(line3);
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
        System.out.print(ESC + "0G" + ESC + "0d");// Cursor in 0,0
        System.out.print(DOWN);
    }

    public void goFinal() {
        System.out.print(ESC + "0G" + ESC + finalPos + "d");
    }
}
