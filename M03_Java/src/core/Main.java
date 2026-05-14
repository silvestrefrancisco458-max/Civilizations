package core;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        Empire empire = new Empire();

        // Abrir ventana gráfica
        Interfacegame.EmpireWindow window = new Interfacegame.EmpireWindow(empire);
        window.setVisible(true);

        Timer timer = new Timer();

        // Cada 1 minuto suma recursos
        timer.schedule(new TimerTask() {
            public void run() {
                empire.addResources();
                DatabaseManager.saveEmpire(empire);

                System.out.println("Recursos generados automáticamente");
            }
        }, 60000, 60000);

        // Cada 2 minutos ocurre un ataque
        timer.schedule(new TimerTask() {
            public void run() {
                War war = new War(empire);
                war.startBattle();

                DatabaseManager.saveEmpire(empire);

                System.out.println("Ataque enemigo realizado");
            }
        }, 120000, 120000);
    }
}