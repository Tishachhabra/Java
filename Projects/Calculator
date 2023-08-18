package basicCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener 
{
    private JTextField textField;
    private JButton[] numberButtons=new JButton[10];
    private JButton[] functionButtons=new JButton[9];
    private JButton addButton,subButton,mulButton,divButton;
    private JButton equButton, clrButton,decButton,delButton,negButton;
    JPanel panel=new JPanel();
    Font font=new Font("Raleway",Font.PLAIN,30);
    private double num1=0, num2=0, result=0;
    private char operator;

    public Calculator() 
    {
        setTitle("Basic Calculator");
        setSize(420, 550);
        setBounds(480,80,420,550);
        setLayout(null);
        textField = new JTextField();
        textField.setBounds(50, 25,300, 50);
        textField.setFont(font);
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
        }
         addButton= new JButton("-");
         subButton= new JButton("+");
         mulButton= new JButton("*");
         divButton= new JButton("/");
         decButton= new JButton(".");
         equButton= new JButton("=");
         delButton= new JButton("Del");
         clrButton= new JButton("CLR");
         negButton= new JButton("-");
         
         functionButtons[0]=addButton;
         functionButtons[1]=subButton;
         functionButtons[2]=mulButton;
         functionButtons[3]=divButton;
         functionButtons[4]=decButton;
         functionButtons[5]=equButton;
         functionButtons[6]=delButton;
         functionButtons[7]=clrButton;
         functionButtons[8]=negButton;
         
         for (int i = 0; i < 9; i++) 
         {
             functionButtons[i].setFont(font);
             functionButtons[i].addActionListener(this);
         }
         panel.setBounds(50,100,300,300);
         panel.setLayout(new GridLayout(4,4,10,10));  
         panel.add(numberButtons[1]);
         panel.add(numberButtons[2]);
         panel.add(numberButtons[3]);
         panel.add(addButton);
         panel.add(numberButtons[4]);
         panel.add(numberButtons[5]);
         panel.add(numberButtons[6]);
         panel.add(subButton);
         panel.add(numberButtons[7]);
         panel.add(numberButtons[8]);
         panel.add(numberButtons[9]);
         panel.add(mulButton);
         panel.add(decButton);
         panel.add(numberButtons[0]);
         panel.add(equButton);
         panel.add(divButton);
         add(panel);
         
         delButton.setBounds(50,430,145,50);
         clrButton.setBounds(205,430,145,50);
         
         add(delButton);
         add(clrButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	String command = e.getActionCommand();

        // Handle number button clicks
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') 
        {
            textField.setText(textField.getText() + command);
        }

        if (command.charAt(0) == '+' || command.charAt(0) == '-' || command.charAt(0) == '*' || command.charAt(0) == '/') {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }

        // Handle equal button click
        if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        textField.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }

        // Handle clear button click
        if (command.charAt(0) == 'C') {
            textField.setText("");
        } 
    }
    public static void main(String[] args) 
    {
    	new Calculator();
    }
}
