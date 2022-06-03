package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.coordinator.MainCoordinator;

public class Main {
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainCoordinator.getInstance().openLoginForm();
    }
}
