package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Empire;
import core.DatabaseManager;

public class ArmyPanel extends JPanel {

    private Empire empire;
    private JLabel info;

    public ArmyPanel(Empire empire) {
        this.empire = empire;

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(12, 21, 27));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("EJÉRCITO", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 42));
        title.setForeground(new Color(255, 210, 90));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(3, 3, 15, 15));
        grid.setBackground(new Color(12, 21, 27));

        grid.add(unit("Espadachín", "Ataque: 80", "Defensa: 400", () -> empire.createSwordsman()));
        grid.add(unit("Lancero", "Ataque: 150", "Defensa: 1000", () -> empire.createSpearman()));
        grid.add(unit("Ballesta", "Ataque: 1000", "Defensa: 6000", () -> empire.createCrossbow()));
        grid.add(unit("Cañón", "Ataque: 700", "Defensa: 8000", () -> empire.createCannon()));
        grid.add(unit("Torre", "Ataque: 80", "Defensa: 200", () -> empire.createArrowTower()));
        grid.add(unit("Catapulta", "Ataque: 250", "Defensa: 1200", () -> empire.createCatapult()));
        grid.add(unit("Torre Cohete", "Ataque: 2000", "Defensa: 7000", () -> empire.createRocketTower()));
        grid.add(unit("Mago", "Ataque: 3000", "Defensa: 0", () -> empire.createMagician()));
        grid.add(unit("Sacerdote", "Ataque: 0", "Defensa: 0", () -> empire.createPriest()));

        add(grid, BorderLayout.CENTER);

        info = new JLabel("Crea unidades para defender tu civilización.", SwingConstants.CENTER);
        info.setFont(new Font("Arial", Font.BOLD, 17));
        info.setForeground(Color.WHITE);
        add(info, BorderLayout.SOUTH);
    }

    private JPanel unit(String name, String attack, String defense, UnitAction action) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 25, 17));
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 135, 45), 2));

        JLabel title = new JLabel(name, SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(new Color(255, 210, 90));

        JLabel stats = new JLabel("<html><center>" + attack + "<br>" + defense + "</center></html>", SwingConstants.CENTER);
        stats.setFont(new Font("Arial", Font.BOLD, 16));
        stats.setForeground(Color.WHITE);

        JButton button = new JButton("Crear");
        button.setBackground(new Color(80, 55, 25));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.addActionListener(e -> {
            boolean ok = action.execute();

            if (ok) {
            	DatabaseManager.saveEmpire(empire);
                info.setText("Unidad creada: " + name + " | Guardado en MySQL.");
            } else {
                info.setText("No puedes crear: " + name + ". Faltan recursos o edificio.");
            }
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(stats, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    private interface UnitAction {
        boolean execute();
    }
}