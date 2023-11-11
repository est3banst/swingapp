package skysystempack;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame implements ActionListener {
	
	JButton crear, volver;
	JTextField textname, apellido, email, textpassport, textusuario, textpass, textanswer;
	Choice seguridad;
	Registro() {
		setBounds(350, 200, 800, 500);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JPanel pan1 = new JPanel();
		pan1.setBackground(new Color(230, 180, 76));
		pan1.setBounds(0, 0, 450, 500);
		pan1.setLayout(null);
		add(pan1);
		
		JLabel labelname = new JLabel("Nombre: ");
		labelname.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelname.setBounds(40, 30, 125, 25);
		pan1.add(labelname);
		
		textname = new JTextField();
		textname.setBounds(160, 30, 130, 25);
		textname.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(textname);
		
		JLabel labelape = new JLabel("Apellido: ");
		labelape.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelape.setBounds(40, 70, 125, 25);
		pan1.add(labelape);
		
		apellido = new JTextField();
		apellido.setBounds(160, 70, 130, 25);
	    apellido.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(apellido);
		
		JLabel labelemail = new JLabel("Correo: ");
		labelemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelemail.setBounds(40, 110, 125, 25);
		pan1.add(labelemail);
		
		email = new JTextField();
		email.setBounds(160, 110, 130, 25);
	    email.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(email);
		
		JLabel passport = new JLabel("N° Pasaporte: ");
		passport.setFont(new Font("Tahoma", Font.BOLD, 12));
		passport.setBounds(40, 150, 125, 25);
		pan1.add(passport);
		
		textpassport = new JTextField();
		textpassport.setBounds(160, 150, 130, 25);
	    textpassport.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(textpassport);
		
		JLabel labelusuario = new JLabel("Usuario: ");
		labelusuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelusuario.setBounds(40, 190, 125, 25);
		pan1.add(labelusuario);
		
		textusuario = new JTextField();
		textusuario.setBounds(160, 190, 130, 25);
		textusuario.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(textusuario);
		
		JLabel labelcontra = new JLabel("Contraseña: ");
		labelcontra.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcontra.setBounds(40, 230, 125, 25);
		pan1.add(labelcontra);
		
		textpass = new JTextField();
		textpass.setBounds(160, 230, 130, 25);
		textpass.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(textpass);
		
		JLabel labelsecure = new JLabel("Pregunta de seguridad: ");
		labelsecure.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelsecure.setBounds(40, 270, 130, 25);
		pan1.add(labelsecure);
		
		seguridad = new Choice();
		seguridad.add("El nombre de tu pelicula o serie favorita");
		seguridad.add("Nombre de tu mejor amigo de la infancia");
		seguridad.add("Tu numero de la suerte");
		seguridad.add("Tu heróe de la infancia");
		seguridad.add("Nombre de la calle donde creciste");
		seguridad.setBounds(160, 270, 165, 20);
		pan1.add(seguridad);
		
		JLabel labelanswer = new JLabel("Respuesta: ");
		labelanswer.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelanswer.setBounds(40, 310, 125, 25);
		pan1.add(labelanswer);
		
		textanswer = new JTextField();
		textanswer.setBounds(160, 310, 130, 25);
		textanswer.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(textanswer);
		
		crear = new JButton("Crear cuenta");
		crear.setBounds(230, 380, 120, 25);
		crear.setFont(new Font("Tahoma", Font.BOLD, 12));
		crear.setBackground(new Color(220, 190, 87));
		crear.setForeground(Color.WHITE);
		pan1.add(crear); 
		crear.addActionListener(this);
		
		volver = new JButton("Volver");
		volver.setBounds(80, 380, 120, 25);
		volver.setFont(new Font("Tahoma", Font.BOLD, 12));
		volver.setBackground(new Color(220, 190, 127));
		volver.setForeground(Color.WHITE);
		pan1.add(volver);
		volver.addActionListener(this);
		
		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("imagess/signup.png"));
		Image im2 = im1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel image = new JLabel(im3);
		image.setBounds(450, 20, 300, 360);
		add(image);
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == crear) {
		
		 String username = textusuario.getText();
	     String name = textname.getText();
	     String lname = apellido.getText();
	     String mail = email.getText();
	     String pasaporte = textpassport.getText();
	     String passwor = textpass.getText();
	     String secure = seguridad.getSelectedItem(); 
	     String answer = textanswer.getText();
	     
	     
	     String query = "INSERT INTO cuentas values ('"+ pasaporte+"','"+name+"' ,'"+ lname+"', '"+mail+"', '"+ username+"', '"+ passwor +"', '"+ secure+"', '"+answer+"')";
	     
	     try {
	    	 conedb c = new conedb();
	    	 c.stm.executeUpdate(query);
	    	 JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
	    	 setVisible(false);
	    	 new Login();
	     }
	      catch (Exception o) {
	    	  o.printStackTrace();
	      }
	     
		} else if (e.getSource() == volver) {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new Registro();
	}

	
}
