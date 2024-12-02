import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataStructures extends JFrame {
    public DataStructures() {
        // Set up the frame
        setTitle("Data Structure Application");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Add title label
        JLabel lblTitle = new JLabel("Choose your DS");
        lblTitle.setBounds(170, 20, 100, 25);
        getContentPane().add(lblTitle);

        // Add buttons
        JButton btnArray = new JButton("Array");
        btnArray.setBounds(170, 60, 100, 25);
        getContentPane().add(btnArray);
        
        JButton btnStack = new JButton("Stack");
        btnStack.setBounds(170, 100, 100, 25);
        getContentPane().add(btnStack);

        JButton btnQueue = new JButton("Queue");
        btnQueue.setBounds(170, 140, 100, 25);
        getContentPane().add(btnQueue);

        JButton btnCircularQueue = new JButton("Circular Queue");
        btnCircularQueue.setBounds(170, 180, 100, 25);
        getContentPane().add(btnCircularQueue);

        JButton btnLinkedList = new JButton("Linked List");
        btnLinkedList.setBounds(170, 220, 100, 25);
        getContentPane().add(btnLinkedList);

        // Add action listeners
        btnArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayFrame arrayFrame = new ArrayFrame();
                arrayFrame.setVisible(true);
            }
        });
        
        btnStack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StackFrame stackFrame= new StackFrame();
                stackFrame.setVisible(true);
            }
        });
        
       btnQueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QueueFrame queueFrame = new QueueFrame();
                queueFrame.setVisible(true);
            }
        });
       
       btnLinkedList.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               LinkedListFrame linkedlistFrame = new LinkedListFrame();
               linkedlistFrame.setVisible(true);
           }
       });
       
       btnCircularQueue.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               CircularQueueFrame circularqueueFrame = new CircularQueueFrame();
               circularqueueFrame.setVisible(true);
           }
       });
       
       

        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DataStructures frame = new DataStructures();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


