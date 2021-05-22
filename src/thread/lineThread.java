package thread;

import model.*;

public class lineThread extends Thread {

    private ColorLine line;

    public lineThread(ColorLine line) {
        this.line = line;
    }

    @Override
    public void run() {
        try {
            line.printLine();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
