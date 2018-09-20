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
	private ContadorTiempo tiempo;
	
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private JFrame frame;
	private JPanel panel;
	private Juego juego;
	private PositionList<Enemigo> listaEnemigos;
	private Jugador jugador;
	private int puntaje;
	
	private KeyAdapter comienzoConEspacio, botonera;
	private JLabel instruccion, lvl, puntuacion;
	
	
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
	
	
	public GUI() throws InterruptedException {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		


		frame.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), (int) (Xmax*0.6), (int) (Ymax*0.9));


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 210, 0));
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lvl = new JLabel();
		lvl.setForeground(new Color(255,255,255));
		lvl.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lvl.setBackground(new Color(255,255,255));
		lvl.setBounds((int) (frame.getWidth() * 0.83), (int) (frame.getHeight() * 0.02), 100, 23);
		
		puntuacion = new JLabel();
		puntuacion.setForeground(new Color(255,255,255));
		puntuacion.setFont(new Font("Sitka Text", Font.BOLD, 18));
		puntuacion.setBackground(new Color(255,255,255));

		puntuacion.setBounds((int) (frame.getWidth() * 0.08) + 20, (int) (frame.getHeight() * 0.02), (int) (frame.getWidth() * 0.3), 23);

		
		instruccion = new JLabel();
		instruccion.setForeground(new Color(225,0,0));
		instruccion.setFont(new Font("Sitka Text", Font.BOLD, (int) (frame.getWidth() * 0.026)));
		instruccion.setBackground(new Color(225,0,0));
		instruccion.setBounds((int) (frame.getWidth() * 0.245), (int) (frame.getHeight() * 0.48), (int) (frame.getWidth() * 0.6), 23);
		
		puntaje = 0;
		
		nivel(2);
		
	}
	
	
	
	protected void nivel(int dificultad) {
		JPanel trinchera = new JPanel();
		
		trinchera.setBackground(new Color(200, 100, 0));
		trinchera.setBounds(0, (int) (Ymax*0.67), frame.getWidth(), (int) (Ymax*0.04));
		panel.add(trinchera);
		trinchera.setLayout(null);
		
		lvl.setText("Nivel: " + dificultad);
		panel.add(lvl);
		
		puntuacion.setText("Puntaje: " + puntaje);
		panel.add(puntuacion);
		
		juego = new Juego(dificultad);
		tiempo = new ContadorTiempo(juego);
		
		
		listaEnemigos = juego.getListaEnems();
		for (Position<Enemigo> pos : listaEnemigos.positions())
			panel.add(pos.element().getGrafico());
		
		panel.add(juego.getObstaculo(0).getGrafico());
		panel.add(juego.getObstaculo(1).getGrafico());
		panel.add(juego.getObstaculo(2).getGrafico());

		jugador = juego.getJugador();
		panel.add(jugador.getGrafico());
		
		instruccion.setText("PRESIONE ESPACIO PARA COMENZAR");
		panel.add(instruccion);
		
		comienzoConEspacio = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				int barraEspaciadora = arg0.getKeyCode();
				
				if (barraEspaciadora == KeyEvent.VK_SPACE) {
					comenzarJuego();
				    tiempo.start();
				}
			}
		};
		
		frame.addKeyListener(comienzoConEspacio);
	}
	
	
	
		protected void comenzarJuego() {
			frame.removeKeyListener(comienzoConEspacio);
			instruccion.setText("");
			
			botonera = new KeyAdapter() {
				public void keyPressed(KeyEvent arg0) {
					int direction = arg0.getKeyCode();
					
					jugador.getGrafico().setSize(75, 90);
					
					if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_A) {
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png"));
						if (jugador.getPos().x - 5 > 0)
							jugador.getPos().x -= jugador.getVel();
					}
					if (direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_D) {
						jugador.getGrafico().setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Derecha.png"));
						if (jugador.getPos().x < frame.getWidth()*0.9)
							jugador.getPos().x += jugador.getVel();
					}
					
					jugador.getGrafico().setLocation(jugador.getPos());
				}
				
				public void keyReleased(KeyEvent arg0) {
					int direction = arg0.getKeyCode();
					
					if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_A || direction == KeyEvent.VK_D)
						jugador.getGrafico().setIcon(new ImageIcon("bin/ImageIcons/Jugador - Estándar.png"));
					
					if (direction == KeyEvent.VK_K && !listaEnemigos.isEmpty()) {
						try {
							puntaje += listaEnemigos.first().element().morir();
							panel.add(listaEnemigos.first().element().getGrafico());
							listaEnemigos.remove(listaEnemigos.first());
							puntuacion.setText("Puntaje: " + puntaje);
						}
						catch (EmptyListException | InvalidPositionException exc) {
							System.out.println(exc.getMessage() + "\n");
							exc.printStackTrace();
						}
					}
					
						
				}
			};
			
			frame.addKeyListener(botonera);
		}
}
