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

public class BuildingsPanel extends JPanel {

    private Empire empire;
    private JLabel info;

    public BuildingsPanel(Empire empire) {
        this.empire = empire;

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(12, 21, 27));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("EDIFICIOS DISPONIBLES", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 38));
        title.setForeground(new Color(255, 210, 90));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(5, 1, 12, 12));
        grid.setBackground(new Color(12, 21, 27));

        grid.add(row("Granja", "Comida +50", "5000 comida", () -> empire.buildFarm()));
        grid.add(row("Carpintería", "Madera +40", "2000 comida / 3000 madera", () -> empire.buildCarpentry()));
        grid.add(row("Herrería", "Hierro +30", "2000 comida / 2000 madera / 3000 hierro", () -> empire.buildSmithy()));
        grid.add(row("Torre Mágica", "Maná +30", "3000 comida / 4000 madera / 2000 hierro", () -> empire.buildMagicTower()));
        grid.add(row("Iglesia", "Permite sacerdotes", "3000 comida / 3000 madera / 1000 hierro", () -> empire.buildChurch()));

        add(grid, BorderLayout.CENTER);

        info = new JLabel("Construye edificios para mejorar tu civilización.", SwingConstants.CENTER);
        info.setFont(new Font("Arial", Font.BOLD, 17));
        info.setForeground(Color.WHITE);
        add(info, BorderLayout.SOUTH);
    }

    private JPanel row(String name, String effect, String cost, BuildAction action) {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.setBackground(new Color(32, 25, 17));
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 135, 45), 2));

        JLabel n = label(name, 20, new Color(255, 210, 90));
        JLabel e = label(effect, 15, Color.WHITE);
        JLabel c = label(cost, 13, Color.WHITE);

        JButton button = new JButton("Construir");
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(new Color(90, 45, 100));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.addActionListener(ev -> {
            boolean ok = action.execute();

            if (ok) {
                empire.generateResources();
                info.setText("Construido: " + name + " | Recursos actualizados.");
            } else {
                info.setText("No tienes recursos suficientes para construir: " + name);
            }
        });

        panel.add(n);
        panel.add(e);
        panel.add(c);
        panel.add(button);

        return panel;
    }

    private JLabel label(String text, int size, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, size));
        label.setForeground(color);
        return label;
    }

    private interface BuildAction {
        boolean execute();
    }
}