import javax.swing.*;
import java.awt.*;

public class SmartParkingGUI {

    public static void main(String[] args) {

        ParkingSystem ps = new ParkingSystem();

        JFrame frame = new JFrame("Smart Parking System");
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        JTextField carField = new JTextField(15);
        JTextArea output = new JTextArea(20, 40);
        output.setEditable(false);

        JButton parkBtn = new JButton("Park Car");
        JButton removeBtn = new JButton("Remove Car");
        JButton showBtn = new JButton("Show Status");

        frame.add(new JLabel("Enter Car Number:"));
        frame.add(carField);
        frame.add(parkBtn);
        frame.add(removeBtn);
        frame.add(showBtn);
        frame.add(new JScrollPane(output));

        parkBtn.addActionListener(e -> {
            String car = carField.getText();
            output.setText(ps.parkCar(car));
        });

        removeBtn.addActionListener(e -> {
            String car = carField.getText();
            output.setText(ps.removeCar(car));
        });

        showBtn.addActionListener(e -> {
            output.setText(ps.display());
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}