import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class StackFrame extends JFrame {
    private JTextField txtSize, txtElement;
    private JLabel lblStackContents;
    private Stack<Integer> stack;
    private int stackSize;
    private JTextField textField;

    public StackFrame() {
        setTitle("Stack Operations");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        getContentPane().setLayout(null);

        JLabel lblSize = new JLabel("Stack Size:");
        lblSize.setBounds(10, 10, 80, 20);
        getContentPane().add(lblSize);

        txtSize = new JTextField();
        txtSize.setBounds(100, 10, 100, 20);
        getContentPane().add(txtSize);

        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(220, 10, 80, 20);
        getContentPane().add(btnCreate);

        JLabel lblElement = new JLabel("Element:");
        lblElement.setBounds(10, 50, 80, 20);
        getContentPane().add(lblElement);

        txtElement = new JTextField();
        txtElement.setBounds(100, 50, 100, 20);
        getContentPane().add(txtElement);

        JButton btnPush = new JButton("Push");
        btnPush.setBounds(220, 50, 80, 20);
        getContentPane().add(btnPush);

        JButton btnPop = new JButton("Pop");
        btnPop.setBounds(220, 90, 80, 20);
        getContentPane().add(btnPop);

        JLabel lblContents = new JLabel("Stack Contents:");
        lblContents.setBounds(10, 130, 100, 20);
        getContentPane().add(lblContents);

        lblStackContents = new JLabel("");
        lblStackContents.setBounds(120, 130, 200, 20);
        getContentPane().add(lblStackContents);

        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(220, 130, 80, 20);
        getContentPane().add(btnDisplay);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 200, 80, 20);
        getContentPane().add(btnBack);
        
        textField = new JTextField();
        textField.setBounds(100, 130, 96, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        // Action listener for Create button
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stackSize = Integer.parseInt(txtSize.getText());
                stack = new Stack<>();
                JOptionPane.showMessageDialog(null, "Stack of size " + stackSize + " created.");
            }
        });

        // Action listener for Push button
        btnPush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack != null && stack.size() < stackSize) {
                    int element = Integer.parseInt(txtElement.getText());
                    stack.push(element);
                    JOptionPane.showMessageDialog(null, "Element " + element + " pushed to stack.");
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is full or not created.");
                }
            }
        });

        // Action listener for Pop button
        btnPop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack != null && !stack.isEmpty()) {
                    int element = stack.pop();
                    JOptionPane.showMessageDialog(null, "Element " + element + " popped from stack.");
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty or not created.");
                }
            }
        });

        // Action listener for Display button
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack != null) {
                    lblStackContents.setText(stack.toString());
                } else {
                    lblStackContents.setText("Stack not created.");
                }
            }
        });

        // Action listener for Back button
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close StackFrame
            }
        });
    }
}
