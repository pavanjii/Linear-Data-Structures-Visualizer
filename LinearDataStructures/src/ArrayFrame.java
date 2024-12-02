import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayFrame extends JFrame {
    private JTextField txtSize, txtPosition, txtElement, txtDeletePosition;
    private JLabel lblArrayContents;
    private int[] array;
    private int currentSize = 0;
    private JTextField textField;

    public ArrayFrame() {
        setTitle("Array Operations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Array Size
        JLabel lblSize = new JLabel("Array Size:");
        lblSize.setBounds(10, 10, 100, 20);
        getContentPane().add(lblSize);
        txtSize = new JTextField();
        txtSize.setBounds(120, 10, 50, 20);
        getContentPane().add(txtSize);

        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(180, 10, 80, 20);
        getContentPane().add(btnCreate);

        // Insert Position & Element
        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(10, 50, 100, 20);
        getContentPane().add(lblPosition);
        txtPosition = new JTextField();
        txtPosition.setBounds(120, 50, 50, 20);
        getContentPane().add(txtPosition);

        JLabel lblElement = new JLabel("Element:");
        lblElement.setBounds(10, 80, 100, 20);
        getContentPane().add(lblElement);
        txtElement = new JTextField();
        txtElement.setBounds(120, 80, 50, 20);
        getContentPane().add(txtElement);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(180, 50, 80, 20);
        getContentPane().add(btnInsert);

        // Delete Position
        JLabel lblDeletePosition = new JLabel("Array Position:");
        lblDeletePosition.setBounds(10, 110, 100, 20);
        getContentPane().add(lblDeletePosition);
        txtDeletePosition = new JTextField();
        txtDeletePosition.setBounds(120, 110, 50, 20);
        getContentPane().add(txtDeletePosition);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(180, 110, 80, 20);
        getContentPane().add(btnDelete);

        // Display Array Contents
        lblArrayContents = new JLabel("Array Contents:");
        lblArrayContents.setBounds(10, 149, 200, 20);
        getContentPane().add(lblArrayContents);
       
        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(10, 180, 80, 20);
        getContentPane().add(btnDisplay);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(300, 220, 80, 20);
        getContentPane().add(btnBack);
        
        textField = new JTextField();
        textField.setBounds(91, 150, 96, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        // Button Actions
        btnCreate.addActionListener(e -> {
            int size = Integer.parseInt(txtSize.getText());
            array = new int[size];
            currentSize = 0;
            JOptionPane.showMessageDialog(this, "Array of size " + size + " created.");
        });

        btnInsert.addActionListener(e -> {
            int pos = Integer.parseInt(txtPosition.getText());
            int element = Integer.parseInt(txtElement.getText());
            if (pos >= 0 && pos < array.length) {
                array[pos] = element;
                currentSize++;
                JOptionPane.showMessageDialog(this, "Array Element at" + pos + " index " + element + " is inserted.");
            }
        });

        btnDelete.addActionListener(e -> {
            int pos = Integer.parseInt(txtDeletePosition.getText());
            if (pos >= 0 && pos < array.length) {
                array[pos] = 0;
                currentSize--;
                JOptionPane.showMessageDialog(this, "Array Element at " + pos + " index  is deleted.");
            }
        });

        btnDisplay.addActionListener(e -> {
            StringBuilder contents = new StringBuilder("Array Contents: ");
            for (int i = 0; i < array.length; i++) contents.append(array[i]).append(" ");
            lblArrayContents.setText(contents.toString());
        });

        btnBack.addActionListener(e -> {
            dispose(); // Close the ArrayOperationsFrame
        });
    }
}
