package UI;

import Business.TokenGeneratorBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokenGeneratorUI extends JFrame {

    private JTextField tokenField;
    private JButton generateButton;
    private JButton MenuGoButton;
    private JButton DialogButton;
    private final TokenGeneratorBusiness tokenGeneratorBusiness;
    private JPanel panel;

    public TokenGeneratorUI() {
        // Inicialización del negocio
        tokenGeneratorBusiness = new TokenGeneratorBusiness();

        // Configuración de la ventana principal
        setupFrame();

        // Inicialización de componentes UI
        initTokenLabel();
        initTokenField();
        initGenerateButton();
        initMenuGoButton();
    }

    //Button To go to Menu
    private void initMenuGoButton() {

        JFrame parentFrame = this;
        MenuGoButton = new JButton("Modificar contraseña");
        MenuGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*In this section will be doing all respect the Action after press the Button MenuGoButton*/


                /* this section below is for the regular frame page*/
                //LittleMenu littleMenu = new LittleMenu();
                //littleMenu.setVisible(true);
                //dispose(); //close windows 1

                /* this section instead of Jframe we're trying to show a Dialog box*/
                JDialog dialog = new JDialog(parentFrame, "Modificador de Token" , true);
                JRadioButton radioOption1 = new JRadioButton("Solo números");
                JRadioButton radioOption2 = new JRadioButton("Solo Letras");
                JRadioButton radioOption3 = new JRadioButton("Solo Especiales");
                JButton dialogButton = new JButton("Modificar");
                ButtonGroup group = new ButtonGroup();
                //Grouping of the radiobuttons options, so only can choose one option.

                group.add(radioOption1);
                group.add(radioOption2);
                group.add(radioOption3);

                /*Add radio Buttons options to the Panel*/
                JPanel panel = new JPanel();
                panel.add(radioOption1);
                panel.add(radioOption2);
                panel.add(radioOption3);
                panel.add(dialogButton);

                /*Presentation and size of the Dialog Box*/
                dialog.add(panel);
                dialog.setSize(200,150);
                dialog.setLocationRelativeTo(parentFrame);
                dialog.setVisible(true);
            }

        });
        //showing the after Button is press.
        add(MenuGoButton);
    }

    private void setupFrame() {
        setTitle("Generador");
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
        String token = tokenGeneratorBusiness.createToken(2,2,2,2);  // Genera un token de "n" characters. Already adding a length of 2 each.
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
