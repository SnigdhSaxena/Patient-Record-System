package patient_record;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Update_Record extends JFrame{

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	public static Connection con;
	public static PreparedStatement ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Record window = new Update_Record();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Update_Record() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(480, 120, 886, 835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Patient ID");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1.setBounds(39, 30, 225, 35);
		frame.getContentPane().add(l1);
		
		JLabel l1_1 = new JLabel("Name");
		l1_1.setForeground(Color.WHITE);
		l1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_1.setBounds(39, 110, 225, 35);
		frame.getContentPane().add(l1_1);
		
		JLabel l1_2 = new JLabel("Age");
		l1_2.setForeground(Color.WHITE);
		l1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_2.setBounds(39, 190, 225, 35);
		frame.getContentPane().add(l1_2);
		
		JLabel l1_3 = new JLabel("Contact No.");
		l1_3.setForeground(Color.WHITE);
		l1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_3.setBounds(39, 270, 225, 35);
		frame.getContentPane().add(l1_3);
		
		JLabel l1_4 = new JLabel("Gender");
		l1_4.setForeground(Color.WHITE);
		l1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_4.setBounds(39, 350, 225, 35);
		frame.getContentPane().add(l1_4);
		
		JLabel l1_5 = new JLabel("Blood Group");
		l1_5.setForeground(Color.WHITE);
		l1_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_5.setBounds(39, 430, 225, 35);
		frame.getContentPane().add(l1_5);
		
		JLabel l1_6 = new JLabel("Any Major Disease Suffered Earlier");
		l1_6.setForeground(Color.WHITE);
		l1_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_6.setBounds(39, 502, 286, 35);
		frame.getContentPane().add(l1_6);
		
		JLabel l1_7 = new JLabel("Address");
		l1_7.setForeground(Color.WHITE);
		l1_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1_7.setBounds(39, 590, 225, 35);
		frame.getContentPane().add(l1_7);
		
		t1 = new JTextField();
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t1.setBounds(412, 35, 248, 25);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t2.setColumns(10);
		t2.setBounds(412, 110, 248, 25);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t3.setColumns(10);
		t3.setBounds(412, 190, 248, 25);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t4.setColumns(10);
		t4.setBounds(412, 270, 248, 25);
		frame.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t5.setBounds(412, 352, 248, 30);
		frame.getContentPane().add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t6.setColumns(10);
		t6.setBounds(412, 430, 248, 25);
		frame.getContentPane().add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t7.setColumns(10);
		t7.setBounds(412, 507, 248, 25);
		frame.getContentPane().add(t7);
		
		JTextArea a1 = new JTextArea();
		a1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		a1.setBounds(412, 590, 248, 113);
		frame.getContentPane().add(a1);
		
		JButton b1 = new JButton("Search");
		b1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\search.png"));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=DBUtil.getDBConnection();
				try {
					ps=con.prepareStatement("select * from record where Id=?");
					ps.setObject(1,t1.getText() );
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
						a1.setText(rs.getString(8));
						t1.setEditable(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Patient ID does not exist");
						t1.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(686, 35, 127, 25);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=DBUtil.getDBConnection();
				try {
					String str="update record set NAME=?,AGE=?,CONTACT_NO=?,GENDER=?,BLOOD_GROUP=?,EARLIER_DISEASE=?,ADDRESS=? where Id=?";
					ps=con.prepareStatement(str);
					ps.setObject(1, t2.getText());
					ps.setObject(2, t3.getText());
					ps.setObject(3, t4.getText());
					ps.setObject(4, t5.getText());
					ps.setObject(5, t6.getText());
					ps.setObject(6, t7.getText());
					ps.setObject(7, a1.getText());
					ps.setObject(8, t1.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated Successfully");
					frame.dispose();
					new Update_Record();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b2.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\save-icon--1.png"));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setBounds(103, 763, 120, 25);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("Close");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you want to close?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				frame.dispose();
				
			}
		});
		b3.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\Close.png"));
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3.setBounds(594, 763, 120, 25);
		frame.getContentPane().add(b3);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon icon=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\texture.jpg");
		Image img=icon.getImage().getScaledInstance(886, 835, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 886, 835);
		frame.getContentPane().add(lblNewLabel);
		
	}

}
