package ui;
import model.*;

public class Main {

    private static Flag col;
    public static void main(String[] args) throws Exception {

        col = new Flag(20, 37, 42, 5, 3, 3, 50);
        col.paintFlag();
        col.goFinal();
        
    }
}