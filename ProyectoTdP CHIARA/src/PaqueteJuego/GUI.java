package PaqueteJuego;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import TDAListaDE.*;
import PaqueteEnemigos.*;

public class GUI {
	
	private JFrame frame;
	private Juego juego;
	private PositionList<Enemigo> listaEnemigos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() {
		initialize();
	}
	
	
	protected void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(500, 10, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	       
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 210, 0));
		panel.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		juego = new Juego();
		listaEnemigos = juego.getListaEnems();
		for (Position<Enemigo> pos : listaEnemigos.positions()) {
			pos.element().getGrafico().setVisible(true);
			pos.element().getGrafico().setBounds(pos.element().getX(), pos.element().getY(), 75, 75);
			panel.add(pos.element().getGrafico());
		}
		
		juego.getObstaculo(0).getGrafico().setBounds(juego.getObstaculo(0).getX(), juego.getObstaculo(0).getY(), 250, 75);
		panel.add(juego.getObstaculo(0).getGrafico());
		
		juego.getObstaculo(1).getGrafico().setBounds(juego.getObstaculo(1).getX(), juego.getObstaculo(1).getY(), 250, 75);
		panel.add(juego.getObstaculo(1).getGrafico());
	}
}
