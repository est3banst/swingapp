package skysystempack;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Vuelos extends JFrame {

	Vuelos() {
		
		setSize(600, 750);
		setLocation(200, 0);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panelone = new JPanel();
		panelone.setBackground(new Color(250,250,250 ));
		panelone.setBounds(0, 150, 600, 750);
		add(panelone);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 0, 600, 600);
		add(panel2);
		
		JPanel panelbutton = new JPanel();
		panelbutton.setLayout(null);
		panelbutton.setBounds(0, 600, 600, 200);
		panelbutton.setBackground(new Color(182, 123, 231));
		add(panelbutton);
		
		
		JButton reservar = new JButton("Reservar");
		reservar.setBounds(200, 50, 200, 50);
		reservar.setFont(new Font("SANS SERIF",Font.PLAIN, 20));
		reservar.setBorder(new LineBorder(new Color(250, 180, 70)));
		reservar.setBackground(new Color(250, 190, 61));
		panelbutton.add(reservar);
		
		JLabel origen = new JLabel("Origen");
		origen.setBounds(40, 60, 80, 30);
		origen.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
		panel2.add(origen);
		
		JLabel destino = new JLabel("Destino");
		destino.setBounds(140, 60, 80, 30);
		destino.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
		panel2.add(destino);
		
		JLabel fechas = new JLabel("Fecha de salida");
		fechas.setBounds(230, 60, 130, 30);
		fechas.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
		panel2.add(fechas);
		
		JLabel fechal = new JLabel("Fecha de llegada");
		fechal.setBounds(380, 60, 130, 30);
		fechal.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
		panel2.add(fechal);
		
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new Vuelos();

	}

}
