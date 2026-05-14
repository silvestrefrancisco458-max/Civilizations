package Interfacegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel {

    public MenuPanel(CardLayout cardLayout, JPanel contentPanel) {
        setPreferredSize(new Dimension(230, 760));
        setBackground(new Color(10, 10, 8));
        setBorder(BorderFactory.createEmptyBorder(15, 12, 15, 12));
        setLayout(new GridLayout(8, 1, 10, 10));

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/images/logo.png")));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        add(logo);

        addButton("Resumen", "empire", cardLayout, contentPanel);
        addButton("Recursos", "resources", cardLayout, contentPanel);
        addButton("Edificios", "buildings", cardLayout, contentPanel);
        addButton("Ejército", "army", cardLayout, contentPanel);
        addButton("Batalla", "war", cardLayout, contentPanel);
    }

    private void addButton(String text, String panelName, CardLayout cardLayout, JPanel contentPanel) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 31, 18));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(203, 137, 35), 2));

        button.addActionListener(e -> cardLayout.show(contentPanel, panelName));

        add(button);
    }
}