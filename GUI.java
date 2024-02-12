package power_OptiNew;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Addition GUI");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        int num1 = 5;
        int num2 = 7;

        JLabel num1Label = new JLabel("Number 1: " + num1);
        num1Label.setBounds(10, 20, 120, 25);
        panel.add(num1Label);

        JLabel num2Label = new JLabel("Number 2: " + num2);
        num2Label.setBounds(10, 50, 120, 25);
        panel.add(num2Label);

        int result = num1 + num2;

        JLabel resultLabel = new JLabel("Result: " + result);
        resultLabel.setBounds(10, 80, 120, 25);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(resultLabel);
    }
}
