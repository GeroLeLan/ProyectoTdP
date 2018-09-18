package PaqueteJuego;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteObjetosImplementados.*;

public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	private Juego juego;
	private PositionList<Enemigo> listaEnemigos;
	private Jugador jugador;
	
	private KeyAdapter comienzoConEspacio;
	private JLabel instruccion;
	
	
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
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(500, 10, 1000, 825);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	       
		panel = new JPanel();
		panel.setBackground(new Color(0, 210, 0));
		panel.setBounds(0, 0, 1000, 800);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		nivel();
		
		instruccion = new JLabel("PRESIONE ESPACIO PARA COMENZAR");
		instruccion.setForeground(new Color(225,0,0));
		instruccion.setFont(new Font("Sitka Text", Font.BOLD, 30));
		instruccion.setBackground(new Color(225,0,0));
		instruccion.setBounds(200, 350, 700, 23);
		
		panel.add(instruccion);
		
		comienzoConEspacio = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				int barraEspaciadora = arg0.getKeyCode();
				
				if (barraEspaciadora == KeyEvent.VK_SPACE)
					comenzarJuego();
			}
		};
		
		frame.addKeyListener(comienzoConEspacio);
	}
	
	
	
	protected void nivel() {
		JPanel trinchera = new JPanel();
		trinchera.setBackground(new Color(200, 100, 0));
		trinchera.setBounds(0, 600, 1000, 50);
		panel.add(trinchera);
		trinchera.setLayout(null);
		
		juego = new Juego();
		
		listaEnemigos = juego.getListaEnems();
		for (Position<Enemigo> pos : listaEnemigos.positions())
			panel.add(pos.element().getGrafico());
		
		panel.add(juego.getObstaculo(0).getGrafico());
		panel.add(juego.getObstaculo(1).getGrafico());

		jugador = juego.getJugador();
		panel.add(jugador.getGrafico());
	}
	
	
	
	protected void comenzarJuego() {
		frame.removeKeyListener(comienzoConEspacio);
		instruccion.setText("");
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int direction = arg0.getKeyCode();
				
				jugador.getGrafico().setSize(75, 90);
				
				switch (direction) {
					case KeyEvent.VK_LEFT : //Izquierda
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png"));
						if (jugador.getPos().x - 5 > 0)
							jugador.getPos().x -= jugador.getVel();
						break;
					case KeyEvent.VK_RIGHT : //Derecha
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Derecha.png"));
						if (jugador.getPos().x + 100 < 1000)
							jugador.getPos().x += jugador.getVel();
						break;
					case KeyEvent.VK_A : //Izquierda
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png"));
						if (jugador.getPos().x - 5 > 0)
							jugador.getPos().x -= jugador.getVel();
						break;
					case KeyEvent.VK_D : //Derecha
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Derecha.png"));
						if (jugador.getPos().x + 100 < 1000)
							jugador.getPos().x += jugador.getVel();
						break;
				}
				
				jugador.getGrafico().setLocation(jugador.getPos());
			}
			
			public void keyReleased(KeyEvent arg0) {
				int direction = arg0.getKeyCode();
				
				if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_A || direction == KeyEvent.VK_D)
					jugador.getGrafico().setIcon(new ImageIcon("bin/ImageIcons/Jugador - Estándar.png"));
			}
		});
	}
}
