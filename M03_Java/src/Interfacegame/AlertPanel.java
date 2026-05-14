package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AlertPanel extends JPanel {

    public AlertPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(38, 45, 55));

        JLabel title = new JLabel("Amenaza enemiga", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 34));
        title.setForeground(new Color(245, 200, 100));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(4, 1, 15, 15));
        grid.setBackground(new Color(38, 45, 55));

        grid.add(createThreat("Caballeros enemigos", "16"));
        grid.add(createThreat("Lanceros enemigos", "12"));
        grid.add(createThreat("Arqueros enemigos", "4"));
        grid.add(createThreat("Cañones enemigos", "2"));

        add(grid, BorderLayout.CENTER);
    }

    private JPanel createThreat(String name, String amount) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(57, 62, 70));

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        nameLabel.setForeground(Color.WHITE);

        JLabel amountLabel = new JLabel(amount, SwingConstants.CENTER);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 30));
        amountLabel.setForeground(new Color(255, 90, 90));

        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(amountLabel, BorderLayout.CENTER);

        return panel;
    }
}