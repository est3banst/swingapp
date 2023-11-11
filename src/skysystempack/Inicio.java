package skysystempack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder; 

public class Inicio extends JFrame implements Runnable, ActionListener {
 Thread thread;
	Inicio() {
		setSize(800, 800);
		setLocation(200, 50);
		
		ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("imagess/VOLAR.png"));
		Image im2 = im1.getImage().getScaledInstance(400, 800, Image.SCALE_DEFAULT);
		ImageIcon im3 = new ImageIcon(im2);
		JLabel image = new JLabel(im3);
		image.setBounds(0, 0, 400, 800);
		add(image);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.setBounds(0, 0, 300, 400);
		add(pan1);
		
		JLabel vuelos = new JLabel("Origen: ");
		vuelos.setBounds(500, 200, 150, 30);
		vuelos.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
		pan1.add(vuelos);
		
		JTextField vuelosfield = new JTextField();
		vuelosfield.setBounds(500, 260, 150, 30);
		vuelosfield.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(vuelosfield);
		
		JLabel destino = new JLabel("Destino: ");
		destino.setBounds(500, 350, 150, 30);
		destino.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
		pan1.add(destino);
		
		JTextField destfield = new JTextField();
		destfield.setBounds(500, 410, 150, 30);
		destfield.setBorder(BorderFactory.createEmptyBorder());
		pan1.add(destfield);
		
		JButton search = new JButton("Buscar");
		search.setBounds(500, 520, 150, 40);
		search.setBackground(new Color(250, 180, 70));
		search.setFont(new Font("SANS SERIF",Font.PLAIN, 24));
		search.setForeground(Color.WHITE);
		search.addActionListener(this);
		search.setBorder(new LineBorder(new Color(250, 180, 70)));
		pan1.add(search);
		
		setVisible(true);
		thread = new Thread(this);
		
	}
	public void run() {
		try {
			Thread.sleep(7000);
			//new Login();
			setVisible(false);
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		Inicio frame = new Inicio();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Vuelos();
		
	}



}
