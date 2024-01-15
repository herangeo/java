import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Mainframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField ageField;
    private JTextField NameField;
    private JTextField weightField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainframe frame = new Mainframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Mainframe() {
        setTitle("MainFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(37, 33, 45, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Age");
        lblNewLabel_1.setBounds(37, 75, 45, 13);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Weight");
        lblNewLabel_2.setBounds(37, 119, 45, 13);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Gender");
        lblNewLabel_3.setBounds(37, 158, 45, 13);
        contentPane.add(lblNewLabel_3);

        ageField = new JTextField();
        ageField.setBounds(116, 72, 96, 19);
        contentPane.add(ageField);
        ageField.setColumns(10);

        NameField = new JTextField();
        NameField.setBounds(116, 33, 96, 19);
        contentPane.add(NameField);
        NameField.setColumns(10);

        weightField = new JTextField();
        weightField.setBounds(116, 116, 96, 19);
        contentPane.add(weightField);
        weightField.setColumns(10);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBounds(109, 154, 103, 21);
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
        rdbtnNewRadioButton_1.setBounds(109, 177, 103, 21);
        contentPane.add(rdbtnNewRadioButton_1);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = NameField.getText();
                String weight = weightField.getText();
                String age = ageField.getText();
                if(name.isEmpty())
                {
                	JOptionPane.showMessageDialog(Mainframe.this,"please enter valid name","validation  error",JOptionPane.ERROR_MESSAGE);
                	return;
                }
                
                int ageStr;
                try {
                	ageStr=Integer.parseInt(age);
                	if(ageStr<18)
                	{
                		JOptionPane.showMessageDialog(Mainframe.this,"Age  Should be above 18","You are not eligible to be a member", JOptionPane.ERROR_MESSAGE);
                		return;
                	}

                	
                }
                catch(NumberFormatException ex){
            		JOptionPane.showMessageDialog(Mainframe.this,"Enter a Valid Age","Validation error", JOptionPane.ERROR_MESSAGE);
            		return;
            		

                }
                int weightStr;
                try {
                    weightStr = Integer.parseInt(weight);
                    if (weightStr >= 0 && weightStr <= 300) {
                        
                    } else {
                        JOptionPane.showMessageDialog(Mainframe.this, "Weight should be between 0 and 300", "Validation error", JOptionPane.ERROR_MESSAGE);
                        return;
                         // Stop further processing if validation fails
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Mainframe.this, "Enter a Valid Weight", "Validation error", JOptionPane.ERROR_MESSAGE);
                    return;
                     // Stop further processing if validation fails
                }


                String gender="";
                if(rdbtnNewRadioButton.isSelected())
                {
                	gender="Male";
                }
                else if(rdbtnNewRadioButton_1.isSelected())
                {
                	gender="Female";
                }
                String message = "Name: " + name + "\n"
                        + "Age: " + age + "\n"
                        + "Weight: " + weight + "\n"
                        + "Gender: " + gender;
                JOptionPane.showMessageDialog(Mainframe.this, message,"Data Submitted",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        submitButton.setBounds(159, 217, 85, 21);
        contentPane.add(submitButton);
    }
}
