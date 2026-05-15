package core;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import Interfacegame.EmpireWindow;

public class Main {

    public static void main(String[] args) {

        Empire empire = new Empire();

        EmpireWindow window = new EmpireWindow(empire);
        window.setVisible(true);

        Timer timer = new Timer();

        // Cada 1 minuto suma recursos
        timer.schedule(new TimerTask() {
            public void run() {
                empire.addResources();
                DatabaseManager.saveEmpire(empire);

                SwingUtilities.invokeLater(() -> {
                    window.refreshWindow();
                    window.addLog("Recursos generados: +comida, +madera, +hierro y +maná");
                });
            }
        }, 60000, 60000);

        // Cada 1 minuto ocurre un ataque enemigo
        timer.schedule(new TimerTask() {
            public void run() {
                War war = new War(empire);
                war.startBattle();

                DatabaseManager.saveEmpire(empire);

                SwingUtilities.invokeLater(() -> {
                    window.refreshWindow();
                    window.addLog("Ataque enemigo realizado");
                });
            }
        }, 60000, 60000);
    }
}