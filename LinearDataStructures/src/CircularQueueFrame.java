import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircularQueueFrame extends JFrame {

	private JPanel contentPanel;
	private int[] queue;
	private int front, rear, size;
	private JTextField inputField;
	private JTextArea displayArea;
	private JTextField sizeField;
	    

	    public CircularQueueFrame() {
	        // Initialize the frame
	        setTitle("Circular Queue Operations");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        // Input label and field for queue size
	        JLabel sizeLabel = new JLabel("Enter queue size:");
	        sizeLabel.setBounds(10, 10, 150, 25);
	        getContentPane().add(sizeLabel);

	        sizeField = new JTextField();
	        sizeField.setBounds(170, 10, 150, 25);
	        getContentPane().add(sizeField);

	        // Button to create the queue
	        JButton createButton = new JButton("Create Queue");
	        createButton.setBounds(330, 10, 140, 25);
	        getContentPane().add(createButton);
	        createButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                size = Integer.parseInt(sizeField.getText());
	                queue = new int[size];
	                front = -1;
	                rear = -1;
	                displayArea.setText("Circular queue of size " + size + " created.");
	            }
	        });

	        // Input label and field
	        JLabel inputLabel = new JLabel("Enter element:");
	        inputLabel.setBounds(10, 50, 100, 25);
	        getContentPane().add(inputLabel);

	        inputField = new JTextField();
	        inputField.setBounds(170, 50, 150, 25);
	        getContentPane().add(inputField);

	        // Buttons for operations
	        JButton enqueueButton = new JButton("Enqueue");
	        enqueueButton.setBounds(10, 90, 100, 25);
	        getContentPane().add(enqueueButton);
	        enqueueButton.addActionListener(new EnqueueAction());

	        JButton dequeueButton = new JButton("Dequeue");
	        dequeueButton.setBounds(120, 90, 100, 25);
	        getContentPane().add(dequeueButton);
	        dequeueButton.addActionListener(new DequeueAction());

	        JButton peekButton = new JButton("Peek");
	        peekButton.setBounds(230, 90, 100, 25);
	        getContentPane().add(peekButton);
	        peekButton.addActionListener(new PeekAction());

	        JButton isEmptyButton = new JButton("Check Empty");
	        isEmptyButton.setBounds(340, 90, 150, 25);
	        getContentPane().add(isEmptyButton);
	        isEmptyButton.addActionListener(new IsEmptyAction());

	        JButton isFullButton = new JButton("Check Full");
	        isFullButton.setBounds(10, 130, 150, 25);
	        getContentPane().add(isFullButton);
	        isFullButton.addActionListener(new IsFullAction());

	        JButton displayQueueButton = new JButton("Display Queue");
	        displayQueueButton.setBounds(170, 130, 150, 25);
	        getContentPane().add(displayQueueButton);
	        displayQueueButton.addActionListener(new DisplayQueueAction());
	        

	        JButton btnBack = new JButton("Back");
	        btnBack.setBounds(361, 132, 80, 20);
	        getContentPane().add(btnBack);
	        
	        btnBack.addActionListener(e -> {
                dispose(); // Close the ArrayOperationsFrame
            });
        

	        // Display area
	        displayArea = new JTextArea();
	        displayArea.setBounds(10, 170, 460, 180);
	        displayArea.setEditable(false);
	        getContentPane().add(displayArea);
	    }

	    private class EnqueueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
	                displayArea.setText("Queue is full.");
	                return;
	            }
	            int element = Integer.parseInt(inputField.getText());
	            if (front == -1) {
	                front = 0;
	                rear = 0;
	                queue[rear] = element;
	            } else if (rear == size - 1 && front != 0) {
	                rear = 0;
	                queue[rear] = element;
	            } else {
	                rear++;
	                queue[rear] = element;
	            }
	            displayArea.setText("Enqueued element: " + element);
	            inputField.setText("");
	        }
	    }

	    private class DequeueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (front == -1) {
	                displayArea.setText("Queue is empty.");
	                return;
	            }
	            int element = queue[front];
	            if (front == rear) {
	                front = -1;
	                rear = -1;
	            } else if (front == size - 1) {
	                front = 0;
	            } else {
	                front++;
	            }
	            displayArea.setText("Dequeued element: " + element);
	        }
	    }

	    private class PeekAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (front == -1) {
	                displayArea.setText("Queue is empty.");
	            } else {
	                displayArea.setText("Front element: " + queue[front]);
	            }
	        }
	    }

	    private class IsEmptyAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (front == -1) {
	                displayArea.setText("Queue is empty.");
	            } else {
	                displayArea.setText("Queue is not empty.");
	            }
	        }
	    }

	    private class IsFullAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
	                displayArea.setText("Queue is full.");
	            } else {
	                displayArea.setText("Queue is not full.");
	            }
	        }
	    }

	    private class DisplayQueueAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            if (front == -1) {
	                displayArea.setText("Queue is empty.");
	                return;
	            }
	            StringBuilder result = new StringBuilder("Queue contents: ");
	            if (rear >= front) {
	                for (int i = front; i <= rear; i++) {
	                    result.append(queue[i]).append(" ");
	                }
	            } else {
	                for (int i = front; i < size; i++) {
	                    result.append(queue[i]).append(" ");
	                }
	                for (int i = 0; i <= rear; i++) {
	                    result.append(queue[i]).append(" ");
	                }
	            }
	            displayArea.setText(result.toString());
	        }
	    }
	    
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueueFrame frame = new CircularQueueFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
