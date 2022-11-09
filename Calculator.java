import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class Calculator implements ActionListener {

    // declaring variables
    JFrame jf;
    JLabel displayLabel;
    JButton sevenButton, eightButton, nineButton, fourButton;
    JButton fiveButton, sixButton, oneButton, twoButton, threeButton, zeroButton;
    JButton clearButton, pointButton, delButton, equalButton, divisionButton, mulButton;
    JButton subtractButton, modButton, additionButton;

    boolean isOperatorClicked = false;
    String oldValue, newValue, operator;
    float newFloatValue, oldFloatValue, result;

    public Calculator() {
        jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(700, 700);
        jf.setLocationRelativeTo(null);
        displayLabel = new JLabel();
        displayLabel.setBounds(70, 30, 510, 60);
        displayLabel.setFont(new Font("Ariel", Font.BOLD, 40));
        displayLabel.setOpaque(true);
        displayLabel.setBackground(Color.gray);
        displayLabel.setBackground(Color.white);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        jf.add(displayLabel);

        // create each button
        sevenButton=this.createButton("7", 70,150,40);
        eightButton=this.createButton("8", 180,150,40);
        nineButton=this.createButton("9", 290,150,40);
        additionButton=this.createButton("+", 400,150,40);
        clearButton=this.createButton("AC", 510,150,20);

        fourButton=this.createButton("4", 70,260,40);
        fiveButton=this.createButton("5", 180,260,40);
        sixButton=this.createButton("6", 290,260,40);
        subtractButton=this.createButton("-", 400,260,40);
        delButton=this.createButton("DEL", 510,260,18);

        oneButton=this.createButton("1", 70,370,40);
        twoButton=this.createButton("2", 180,370,40);
        threeButton=this.createButton("3", 290,370,40);
        mulButton=this.createButton("*", 400,370,40);
        modButton=this.createButton("%", 510,370,40);

        pointButton=this.createButton(".", 70,480,40);
        zeroButton=this.createButton("0", 180,480,40);
        equalButton=this.createButton("=", 290,480,40);
        divisionButton=this.createButton("/", 400,480,40);
        
        

        jf.setVisible(true);
        jf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sevenButton) {
            this.displayContent(sevenButton);
        } else if (e.getSource() == eightButton) {
            this.displayContent(eightButton);
        } else if (e.getSource() == nineButton) {
            this.displayContent(nineButton);
        } else if (e.getSource() == sixButton) {
            this.displayContent(sixButton);
        } else if (e.getSource() == fiveButton) {
            this.displayContent(fiveButton);
        } else if (e.getSource() == fourButton) {
            this.displayContent(fourButton);
        } else if (e.getSource() == threeButton) {
            this.displayContent(threeButton);
        } else if (e.getSource() == twoButton) {
            this.displayContent(twoButton);
        } else if (e.getSource() == oneButton) {
            this.displayContent(oneButton);
        } else if (e.getSource() == zeroButton) {
            this.displayContent(zeroButton);
        } else if (e.getSource() == pointButton) {
            this.displayContent(pointButton);
        } else if (e.getSource() == clearButton) {
            displayLabel.setText("");
        } else if (e.getSource() == delButton) {
            String text = displayLabel.getText();
            StringBuffer sb = new StringBuffer(text);
            String newResult = sb.deleteCharAt(text.length() - 1) + "";
            displayLabel.setText(newResult);
        } else if (e.getSource() == additionButton) {
            this.toGetValue(additionButton);
            operator = "+";
        } else if (e.getSource() == mulButton) {
            this.toGetValue(mulButton);
            operator = "*";
        } else if (e.getSource() == subtractButton) {
            this.toGetValue(subtractButton);
            operator = "-";
        } else if (e.getSource() == divisionButton) {
            this.toGetValue(divisionButton);
            operator = "/";
        } else if (e.getSource() == modButton) {
            this.toGetValue(modButton);
        } else if (e.getSource() == equalButton) {
            newValue = displayLabel.getText();
            try {
                newFloatValue = Float.parseFloat(newValue);
                oldFloatValue = Float.parseFloat(oldValue);
            } catch (Exception ae) {
                operator = "e";
            }
            switch (operator) {
                case "+":
                    result = oldFloatValue + newFloatValue;
                    this.displayResult(result);
                    break;

                case "-":
                    result = oldFloatValue - newFloatValue;
                    this.displayResult(result);
                    break;

                case "*":
                    result = oldFloatValue * newFloatValue;
                    this.displayResult(result);
                    break;

                case "%":
                    result = oldFloatValue % newFloatValue;
                    this.displayResult(result);
                    break;

                case "/":
                    result = oldFloatValue / newFloatValue;
                    this.displayResult(result);
                    break;

                case "e":
                    //to create an error message
                    Error newError = new Error("Syntax Error");
                    newError.setVisible(true);
                    displayLabel.setText("0");
                    break;

                default:
                    new Error("Invalid operation");
            }
        }
    }

    // to create a button

    public JButton createButton(String buttonSymbol,int x,int y,int size){
        JButton Button = new JButton(buttonSymbol);
        Button.setFont(new Font("Arial", Font.PLAIN, size));
        jf.add(Button);
        Button.setBounds(x, y, 70, 70);
        Button.addActionListener(this);
        return Button;
    }

    // to store the value after operator clicked
    public void toGetValue(JButton thisButton) {
        oldValue = displayLabel.getText();
        isOperatorClicked = true;
        operator = thisButton.getText();
    }

    // to display number in the input field
    public void displayContent(JButton thisButton) {
        if (isOperatorClicked) {
            displayLabel.setText(thisButton.getText());
            isOperatorClicked = false;
        } else {
            displayLabel.setText(displayLabel.getText() + thisButton.getText());
        }
    }

    // to display result after operation
    public void displayResult(float result) {
        displayLabel.setText(result + "");
    }

}