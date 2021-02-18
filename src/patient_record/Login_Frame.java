package patient_record;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Login_Frame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -4645719597505810952L;
	private JLabel l2,l3,l1;
	private JTextField t1;
	private JPasswordField pf1;
	private JButton b1;
	public static Connection con;
	public static PreparedStatement ps;
	private JButton b2;
	
	
	public static void main(String[] args) {
		new Login_Frame();
	}
	public Login_Frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,150,1366,768);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		l2=new JLabel("Username");
		l2.setBounds(589,274,100,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("BOLD",20,20));
		
		l3=new JLabel("Password");
		l3.setBounds(596,354,100,30);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("BOLD",20,20));
		
		t1=new JTextField();
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t1.setBounds(785,279,173,30);
		
		pf1=new JPasswordField();
		pf1.setBounds(785,359,173,30);
		
		b1=new JButton("Login");
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(658,472,90,30);
		b1.addActionListener(this);
		
		getContentPane().add(l2);getContentPane().add(l3);getContentPane().add(t1);getContentPane().add(pf1);getContentPane().add(b1);

		
		b2 = new JButton("Close");
		b2.setBackground(Color.WHITE);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you want to close the application?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setBounds(829, 473, 90, 28);
		getContentPane().add(b2);
		
		l1 = new JLabel("New label");
		l1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\login Background final.PNG"));
		l1.setBounds(0, -11, 1366, 768);
		getContentPane().add(l1);
		setVisible(true);
		
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
	    String value=b1.getActionCommand();
	    int c=0;
	    if(value.equals("Login"))
	    {
	    	con=DBUtil.getDBConnection();
	    	String user =t1.getText();
	    	String pass=pf1.getText();
	    	try
	    	{
	    	ps=con.prepareStatement("SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?");
	    	ps.setString(1,user );
	    	ps.setString(2, pass);
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next())
	    	{
	    		c++;
	    	}
	    	if(c==1)
	    	{
	    		
	    		dispose();
	    		new HomePage();
	    		
	    	}
	    	else
	    	{
	    		
	    		JOptionPane.showMessageDialog(null,"Invalid credentials. Please try again");
	    		t1.setText("");
	    		pf1.setText("");
	    	}
	    	}
	    	catch(SQLException e1)
	    	{
	    		System.out.println("Exception "+e1.getMessage());
	    	}
	    	
	    }
		
	}

}
