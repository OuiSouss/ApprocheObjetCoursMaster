package fr.ubordeaux.ao.referencemanagement.ui;

import java.io.IOException;

public class CommandLineMain {

    public static void main(String[] args) {
        try {
            TextualMenu tm = new TextualMenu(System.in, System.out);
            tm.handleUserInstructions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
