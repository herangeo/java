import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtNumber;
	private JTextField txtEmail;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\91918\\Downloads\\360_F_511529094_PISGWTmlfmBu1g4nocqdVKaHBnzMDWrN.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(24, 38, 59, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(24, 73, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PhNo.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(24, 106, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(24, 139, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(24, 175, 59, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(24, 207, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		txtName = new JTextField();
		txtName.setBounds(140, 41, 96, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(140, 70, 96, 19);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(140, 103, 96, 19);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(140, 136, 96, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(140, 172, 96, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.BLACK);
		rdbtnNewRadioButton.setBounds(140, 203, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);
		rdbtnNewRadioButton_1.setBounds(140, 226, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton regsiterButton = new JButton("Register");
		regsiterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","hirangeo@13");
					String query="insert into registration values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setInt(2, Integer.parseInt(txtAge.getText()));
					ps.setLong(3, Long.parseLong(txtNumber.getText()));
					ps.setString(4, txtEmail.getText());
					ps.setString(5, txtPassword.getText());
					if(rdbtnNewRadioButton.isSelected())
					{
						ps.setString(6, rdbtnNewRadioButton.getText());
					}
					else
					{
						ps.setString(6, rdbtnNewRadioButton_1.getText());

					}
					
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(regsiterButton,i+"Record has been added successfully");
					ps.close();
					con.close();
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		regsiterButton.setBounds(97, 272, 85, 21);
		contentPane.add(regsiterButton);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtNumber.setText("");
		        rdbtnNewRadioButton.setSelected(false);
		        rdbtnNewRadioButton_1.setSelected(false);
			}
		});
		resetBtn.setBounds(210, 272, 85, 21);
		contentPane.add(resetBtn);
		
		JLabel lblNewLabel_6 = new JLabel("Registration");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(168, 10, 109, 13);
		contentPane.add(lblNewLabel_6);
	}

}
