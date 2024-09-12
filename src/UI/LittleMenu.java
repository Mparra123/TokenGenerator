package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LittleMenu extends JFrame {

    private JButton MenuButton;
    private JPanel panel1;


    public LittleMenu() {

        // Configuración de la ventana principal
        setupFrame();

        initMenuLabel();
        initMenuButton();
    }

    private void initMenuButton() {

        MenuButton = new JButton("Regresar");

        MenuButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                TokenGeneratorUI tokenGeneratorUI = new TokenGeneratorUI();
                tokenGeneratorUI.setVisible(true); //Volver o presentar ventana #1

                panel1.setLayout(new BorderLayout());
                panel1.add(MenuButton, BorderLayout.CENTER);
                dispose(); //close windows 2
            }
        });
        add(MenuButton);
    }

    private void setupFrame() {
        setTitle("Pantalla Menu");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
    }

    private void initMenuLabel() {
        JLabel MenuLabel = new JLabel("Hola Mundos / Ventana#2");
        add(MenuLabel);
    }
}
