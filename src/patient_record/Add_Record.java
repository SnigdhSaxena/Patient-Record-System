package patient_record;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Add_Record extends JFrame{

	
	private static final long serialVersionUID = 5996288393460485740L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public static Connection con;
	public static PreparedStatement ps;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Record frame = new Add_Record ();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Add_Record() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(480, 120, 886, 835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		JLabel l1 = new JLabel("Patient ID");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1.setBounds(119, 30, 225, 35);
		frame.getContentPane().add(l1);
		
		JLabel l1_1 = new JLabel("Name");
		l1_1.setForeground(Color.WHITE);
		l1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_1.setBounds(119, 110, 225, 35);
		frame.getContentPane().add(l1_1);
		
		JLabel l1_2 = new JLabel("Age");
		l1_2.setForeground(Color.WHITE);
		l1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_2.setBounds(119, 190, 225, 35);
		frame.getContentPane().add(l1_2);
		
		JLabel l1_3 = new JLabel("Contact No.");
		l1_3.setForeground(Color.WHITE);
		l1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_3.setBounds(119, 270, 225, 35);
		frame.getContentPane().add(l1_3);
		
		JLabel l1_4 = new JLabel("Gender");
		l1_4.setForeground(Color.WHITE);
		l1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_4.setBounds(119, 350, 225, 35);
		frame.getContentPane().add(l1_4);
		
		JLabel l1_5 = new JLabel("Blood Group");
		l1_5.setForeground(Color.WHITE);
		l1_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_5.setBounds(119, 430, 225, 35);
		frame.getContentPane().add(l1_5);
		
		JLabel l1_6 = new JLabel("Any Major Disease Suffered Earlier");
		l1_6.setForeground(Color.WHITE);
		l1_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_6.setBounds(119, 510, 286, 35);
		frame.getContentPane().add(l1_6);
		
		JLabel l1_7 = new JLabel("Address");
		l1_7.setForeground(Color.WHITE);
		l1_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_7.setBounds(119, 590, 225, 35);
		frame.getContentPane().add(l1_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField.setBounds(538, 40, 248, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(538, 110, 248, 25);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(538, 190, 248, 25);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(538, 270, 248, 25);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(538, 430, 248, 25);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(538, 510, 248, 25);
		frame.getContentPane().add(textField_5);
		
		String[] names= {"Male","Female","Transgender"};
		JComboBox comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setBounds(538, 350, 248, 30);
		comboBox.setSelectedIndex(-1);
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textArea.setBounds(538, 590, 248, 113);
		frame.getContentPane().add(textArea);
		
		JButton b1 = new JButton("Save");
		b1.setBackground(Color.WHITE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=DBUtil.getDBConnection();
				try {
					ps=con.prepareStatement("insert into record values(?,?,?,?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(textField.getText()));
					ps.setString(2, textField_1.getText());
					ps.setInt(3,Integer.parseInt(textField_2.getText()));
					ps.setString(4,textField_3.getText());
					ps.setObject(5, comboBox.getSelectedItem());//combo
					ps.setString(6, textField_4.getText());
					ps.setString(7, textField_5.getText());
					ps.setString(8, textArea.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data saved");
					frame.dispose();
					new Add_Record();


				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Please enter the data correctly");
					e1.printStackTrace();
				}
			}
		});
		b1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-save-48.png"));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(179, 734, 131, 41);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("Close");
		b2.setBackground(Color.WHITE);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null,"Do you want to close?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					frame.dispose();
			}
		});
		b2.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-close-window-48.png"));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setBounds(508, 734, 150, 41);
		frame.getContentPane().add(b2);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon icon=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\texture.jpg");
		Image img=icon.getImage().getScaledInstance(886, 835, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 886, 835);
		frame.getContentPane().add(lblNewLabel);
		
		
				
				
	}
}
