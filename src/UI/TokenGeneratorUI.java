package UI;

import Business.TokenGeneratorBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokenGeneratorUI extends JFrame {

    private JTextField tokenField;
    private JButton generateButton;
    private final TokenGeneratorBusiness tokenGeneratorBusiness;

    public TokenGeneratorUI() {
        // Inicialización del negocio
        tokenGeneratorBusiness = new TokenGeneratorBusiness();

        // Configuración de la ventana principal
        setupFrame();

        // Inicialización de componentes UI
        initTokenLabel();
        initTokenField();
        initGenerateButton();
    }

    private void setupFrame() {
        setTitle("Token Generator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
    }

    private void initTokenLabel() {
        JLabel tokenLabel = new JLabel("Contraseña Generada:");
        add(tokenLabel);
    }

    private void initTokenField() {
        tokenField = new JTextField(25);
        tokenField.setEditable(false);
        add(tokenField);
    }

    private void initGenerateButton() {
        generateButton = new JButton("Generar Contraseña");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateToken();
            }
        });
        add(generateButton);
    }

    private void generateToken() {
        String token = tokenGeneratorBusiness.createToken(2,2,2,2);  // Genera un token de "n" caracteres
        tokenField.setText(token);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TokenGeneratorUI().setVisible(true);
            }
        });
    }
}
