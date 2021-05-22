package thread;

import model.*;

public class ThreadL extends Thread {

    private Color line;

    public ThreadL(Color line) {
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
