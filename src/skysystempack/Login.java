package skysystempack;


import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {
	
	JButton registrate, login;
	JTextField textusern, textcontrasea;
	Login() {
		setSize(500, 600);
		setLocation(300, 200);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel pan1 = new JPanel();

		pan1.setBackground(new Color(250,250,250 ));
		pan1.setBounds(50, 0, 400, 200);
		add(pan1);
		
		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("imagess/login.png"));
		Image im2 = im1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel image = new JLabel(im3);
		image.setBounds(0, 0, 200, 200);
		pan1.add(image);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(null);
		pan2.setBounds(0, 0, 600, 600);
		add(pan2);
		
		JLabel lblusern = new JLabel("Usuario: ");
		lblusern.setBounds(50, 240, 120, 30);
		lblusern.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
		pan2.add(lblusern);
		
		textusern = new JTextField();
		textusern.setBounds(180, 240, 150, 30);
		textusern.setBorder(BorderFactory.createEmptyBorder());
		pan2.add(textusern);
		
		JLabel lcontrasea = new JLabel("Contraseña: ");
		lcontrasea.setBounds(50, 290, 120, 30);
		lcontrasea.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
		pan2.add(lcontrasea);
		
		textcontrasea = new JTextField();
		textcontrasea.setBounds(180, 290, 150, 30);
		textcontrasea.setBorder(BorderFactory.createEmptyBorder());
		pan2.add(textcontrasea);
		
		JCheckBox recordar = new JCheckBox("Recordarme");
		recordar.setBounds(250, 345, 120, 20);
		pan2.add(recordar);
		
		login = new JButton("Inicia sesión");
		login.setBounds(240, 380, 120, 30);
		login.setBackground(new Color(250, 180, 70));
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setBorder(new LineBorder(new Color(250, 180, 70)));
		pan2.add(login);
		
		JLabel regis = new JLabel("No tienes una cuenta?");
		regis.setBounds(70, 350, 130, 10);
		pan2.add(regis);
		
		registrate = new JButton("Regístrate");
		registrate.setBounds(80, 380, 120, 30);
		registrate.setBackground(new Color(250, 180, 70));
		registrate.setForeground(Color.WHITE);
		registrate.addActionListener(this);
		registrate.setBorder(new LineBorder(new Color(250, 180, 70)));
		pan2.add(registrate);
		
		JButton passwd = new JButton("Olvidé mi contraseña");
		passwd.setBounds(140, 430, 160, 25);
		passwd.setBackground(new Color(240, 210, 80));
		pan2.add(passwd);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e ) {
		if (e.getSource() == login ) {
			String usern = textusern.getText();
			String pswd = textcontrasea.getText();
			
			try {
				if (usern != null && pswd != null) {
				conedb c = new conedb();
				String query = "SELECT * from skysys.cuentas Where username= '"+usern+"' AND password='"+pswd+"'";
				ResultSet results = c.stm.executeQuery(query);
				if (results.next()) {
					JOptionPane.showMessageDialog(null,"Iniciando..");
					setVisible(false);
					new Inicio();
				} else {
					JOptionPane.showMessageDialog(null, "Error al iniciar sesion");				
					}
				
				}
			} catch (Exception eo) {
				eo.printStackTrace();
			
			}
			
		} else if (e.getSource() == registrate ) {
			setVisible(false);
			new Registro();
		}
	}

	public static void main(String[] args) {
		new Login();

	}
	

}