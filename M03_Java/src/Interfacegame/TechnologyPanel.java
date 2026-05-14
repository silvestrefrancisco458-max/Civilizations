package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Empire;

public class TechnologyPanel extends JPanel {

    private int attackLevel = 0;
    private int defenseLevel = 0;

    private JLabel attackLabel;
    private JLabel defenseLabel;

    public TechnologyPanel(Empire empire) {
        setLayout(new BorderLayout());
        setBackground(new Color(38, 45, 55));

        JLabel title = new JLabel("Tecnología", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 34));
        title.setForeground(new Color(245, 200, 100));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(2, 2, 25, 25));
        grid.setBackground(new Color(38, 45, 55));

        attackLabel = createLabel("Ataque nivel: 0");
        defenseLabel = createLabel("Defensa nivel: 0");

        JButton attackButton = createButton("Mejorar ataque");
        JButton defenseButton = createButton("Mejorar defensa");

        attackButton.addActionListener(e -> {
            attackLevel++;
            attackLabel.setText("Ataque nivel: " + attackLevel);
        });

        defenseButton.addActionListener(e -> {
            defenseLevel++;
            defenseLabel.setText("Defensa nivel: " + defenseLevel);
        });

        grid.add(attackLabel);
        grid.add(attackButton);
        grid.add(defenseLabel);
        grid.add(defenseButton);

        add(grid, BorderLayout.CENTER);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(new Color(57, 62, 70));
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(120, 80, 35));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }
}