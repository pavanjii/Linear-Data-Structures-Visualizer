import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.border.EmptyBorder;

import LinkedListGUI.AddFirstAction;
import LinkedListGUI.AddLastAction;
import LinkedListGUI.DisplayListAction;
import LinkedListGUI.RemoveFirstAction;
import LinkedListGUI.RemoveLastAction;

public class LinkedListFrame extends JFrame {

	private JPanel contentPanel;
	private LinkedList<Integer> linkedList;
	private JTextField inputField;
	private JTextArea displayArea;

	public LinkedListFrame() {
        // Initialize the linked list
        linkedList = new LinkedList<>();

        // Set up the frame
        setTitle("Linked List Operations");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Input label and field
        JLabel inputLabel = new JLabel("Enter element:");
        inputLabel.setBounds(10, 10, 100, 25);
        getContentPane().add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(120, 10, 150, 25);
        getContentPane().add(inputField);

        // Buttons for operations
        JButton addFirstButton = new JButton("Add First");
        addFirstButton.setBounds(10, 50, 100, 25);
        getContentPane().add(addFirstButton);
        addFirstButton.addActionListener(new AddFirstAction());

        JButton addLastButton = new JButton("Add Last");
        addLastButton.setBounds(120, 50, 100, 25);
        getContentPane().add(addLastButton);
        addLastButton.addActionListener(new AddLastAction());

        JButton removeFirstButton = new JButton("Remove First");
        removeFirstButton.setBounds(230, 50, 120, 25);
        getContentPane().add(removeFirstButton);
        removeFirstButton.addActionListener(new RemoveFirstAction());

        JButton removeLastButton = new JButton("Remove Last");
        removeLastButton.setBounds(360, 50, 120, 25);
        getContentPane().add(removeLastButton);
        removeLastButton.addActionListener(new RemoveLastAction());

        JButton displayListButton = new JButton("Display List");
        displayListButton.setBounds(10, 90, 150, 25);
        getContentPane().add(displayListButton);
        displayListButton.addActionListener(new DisplayListAction());
        

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(198, 92, 80, 20);
        getContentPane().add(btnBack);
        
        btnBack.addActionListener(e -> {
            dispose(); // Close the LinkedListOperationsFrame
        });

        // Display area
        displayArea = new JTextArea();
        displayArea.setBounds(10, 130, 470, 220);
        displayArea.setEditable(false);
        getContentPane().add(displayArea);
    }

    private class AddFirstAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int element = Integer.parseInt(inputField.getText());
                linkedList.addFirst(element);
                displayArea.setText("Added " + element + " at the beginning of the list.");
                inputField.setText("");
            } catch (NumberFormatException ex) {
                displayArea.setText("Please enter a valid integer.");
            }
        }
    }

    private class AddLastAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int element = Integer.parseInt(inputField.getText());
                linkedList.addLast(element);
                displayArea.setText("Added " + element + " at the end of the list.");
                inputField.setText("");
            } catch (NumberFormatException ex) {
                displayArea.setText("Please enter a valid integer.");
            }
        }
    }

    private class RemoveFirstAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!linkedList.isEmpty()) {
                int element = linkedList.removeFirst();
                displayArea.setText("Removed " + element + " from the beginning of the list.");
            } else {
                displayArea.setText("The list is empty.");
            }
        }
    }

    private class RemoveLastAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!linkedList.isEmpty()) {
                int element = linkedList.removeLast();
                displayArea.setText("Removed " + element + " from the end of the list.");
            } else {
                displayArea.setText("The list is empty.");
            }
        }
    }

    private class DisplayListAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("Current Linked List: " + linkedList.toString());
        }
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedListFrame frame = new LinkedListFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
