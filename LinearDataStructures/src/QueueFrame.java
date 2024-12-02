import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class QueueFrame extends JFrame {

	private JPanel contentPanel;
	private Queue<Integer> queue;
	private JTextField inputField;
	private JTextArea displayArea;
	public QueueFrame() {
	        // Initialize the queue
	        queue = new LinkedList<>();

	        // Set up the frame
	        setTitle("Queue Operations");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        // Input label and field
	        JLabel inputLabel = new JLabel("Enter element:");
	        inputLabel.setBounds(10, 10, 100, 25);
	        getContentPane().add(inputLabel);

	        inputField = new JTextField();
	        inputField.setBounds(120, 10, 150, 25);
	        getContentPane().add(inputField);

	        // Buttons
	        JButton enqueueButton = new JButton("Enqueue");
	        enqueueButton.setBounds(10, 50, 100, 25);
	        getContentPane().add(enqueueButton);
	        enqueueButton.addActionListener(new EnqueueAction());

	        JButton dequeueButton = new JButton("Dequeue");
	        dequeueButton.setBounds(120, 50, 100, 25);
	        getContentPane().add(dequeueButton);
	        dequeueButton.addActionListener(new DequeueAction());

	        JButton peekButton = new JButton("Peek");
	        peekButton.setBounds(230, 50, 100, 25);
	        getContentPane().add(peekButton);
	        peekButton.addActionListener(new PeekAction());

	        JButton isEmptyButton = new JButton("Check Empty");
	        isEmptyButton.setBounds(10, 90, 150, 25);
	        getContentPane().add(isEmptyButton);
	        isEmptyButton.addActionListener(new IsEmptyAction());

	        JButton displayQueueButton = new JButton("Display Queue");
	        displayQueueButton.setBounds(170, 90, 150, 25);
	        getContentPane().add(displayQueueButton);
	        displayQueueButton.addActionListener(new DisplayQueueAction());
	        
	        JButton btnBack = new JButton("Back");
	        btnBack.setBounds(280, 11, 89, 23);
	        getContentPane().add(btnBack);
	       
	        btnBack.addActionListener(e -> {
	                dispose(); // Close the QueueOperationsFrame
	            });
	        

	        // Display area
	        displayArea = new JTextArea();
	        displayArea.setBounds(10, 130, 360, 120);
	        displayArea.setEditable(false);
	        getContentPane().add(displayArea);
	        
	        
	    }

	    private class EnqueueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                int element = Integer.parseInt(inputField.getText());
	                queue.add(element);
	                displayArea.setText("Element " + element + " enqueued.");
	                inputField.setText("");
	            } catch (NumberFormatException ex) {
	                displayArea.setText("Please enter a valid integer.");
	            }
	        }
	    }

	    private class DequeueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (!queue.isEmpty()) {
	                int element = queue.poll();
	                displayArea.setText("Element " + element + " dequeued.");
	            } else {
	                displayArea.setText("Queue is empty.");
	            }
	        }
	    }

	    private class PeekAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (!queue.isEmpty()) {
	                int element = queue.peek();
	                displayArea.setText("Front element is " + element);
	            } else {
	                displayArea.setText("Queue is empty.");
	            }
	        }
	    }

	    private class IsEmptyAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            displayArea.setText(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
	        }
	    }

	    private class DisplayQueueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            displayArea.setText("Queue contents: " + queue.toString());
	        }
	    }


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
