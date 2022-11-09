import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Error extends JFrame {
    Error(String errorMsg) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 200);
        setTitle("Error");
        JLabel errorLabel = new JLabel(errorMsg);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(errorLabel);

    }
}
