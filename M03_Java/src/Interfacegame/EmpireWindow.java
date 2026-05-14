package Interfacegame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import core.Empire;

public class EmpireWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public EmpireWindow() {
        Empire empire = new Empire();

        setTitle("Civilizations - M03");
        setSize(1280, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(8, 14, 18));

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setOpaque(false);

        contentPanel.add(new EmpirePanel(empire), "empire");
        contentPanel.add(new ResourcesPanel(empire), "resources");
        contentPanel.add(new BuildingsPanel(empire), "buildings");
        contentPanel.add(new ArmyPanel(empire), "army");
        contentPanel.add(new WarPanel(empire), "war");

        add(new MenuPanel(cardLayout, contentPanel), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmpireWindow::new);
    }
}