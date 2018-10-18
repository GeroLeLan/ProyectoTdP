package PaqueteJuego;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteGenericos.Objeto;
import PaquetePersonajes.Personaje;

public class GUI {
	private ContadorTiempo tiempo;
	private ContadorTDisparo tiempoDisparo;
	
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private JFrame frame;
	private Container panel;
	private JLabel fondo;
	private Juego juego;
	private PositionList<Enemigo> listaEnemigos;
	private Personaje jugador;
	private int puntaje;
	private int frameWidth, frameHeight;
	private String nombre;
	
	private KeyAdapter comienzoConEspacio, botonera;
	private JLabel instruccion, lvl, puntuacion, nombrePersonaje, vida;
	
	
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
		super();
		
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.setResizable(false);
		
		frameWidth = (int) (Xmax*0.6);
		frameHeight = (int) (Ymax*0.9);
		
		frame.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), frameWidth, frameHeight);
		
		fondo = new JLabel();
		fondo.setSize(frameWidth, frameHeight);
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Gif de Fondo.gif");
		ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(frameWidth, frameHeight, java.awt.Image.SCALE_DEFAULT));
		fondo.setIcon(iconoEscala);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(fondo);
		frame.getContentPane().setLayout(new BorderLayout());
		
		panel = frame.getContentPane();
		panel.setBounds(0, 0, frameWidth, frameHeight);
		panel.setLayout(null);
		
		lvl = new JLabel();
		lvl.setForeground(new Color(255,255,255));
		lvl.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lvl.setBackground(new Color(255,255,255));
		lvl.setBounds((int) (frameWidth * 0.83), (int) (frameHeight * 0.02), 100, 23);
		
		vida = new JLabel();
		vida.setForeground(new Color(255,255,255));
		vida.setFont(new Font("Sitka Text", Font.BOLD, 18));
		vida.setBackground(new Color(255,255,255));
		vida.setBounds((int) (frameWidth * 0.08) + 20, (int) (frameHeight * 0.05), (int) (frameWidth * 0.3), 23);
		
		puntuacion = new JLabel();
		puntuacion.setForeground(new Color(255,255,255));
		puntuacion.setFont(new Font("Sitka Text", Font.BOLD, 18));
		puntuacion.setBackground(new Color(255,255,255));
		puntuacion.setBounds((int) (frameWidth * 0.08) + 20, (int) (frameHeight * 0.02), (int) (frameWidth * 0.3), 23);

		
		instruccion = new JLabel();
		instruccion.setForeground(new Color(225,0,0));
		instruccion.setFont(new Font("Sitka Text", Font.BOLD, (int) (frameWidth * 0.026)));
		instruccion.setBackground(new Color(225,0,0));
		instruccion.setBounds((int) (frameWidth * 0.245), (int) (frameHeight * 0.46), (int) (frameWidth * 0.6), 23);
		
		puntaje = 0;
		nombre = "";
		
		nombrePersonaje = new JLabel();
		nombrePersonaje.setForeground(new Color(255,255,255));
		nombrePersonaje.setFont(new Font("Sitka Text", Font.BOLD, (int) (frameWidth * 0.026)));
		nombrePersonaje.setBackground(new Color(255,0,0));
		
		nivel(1);
		
	}
	
	
	
	private void nivel(int dificultad) {
		lvl.setText("Nivel: " + dificultad);
		panel.add(lvl);
		
		puntuacion.setText("Puntaje: " + puntaje);
		panel.add(puntuacion);
		

		juego = new Juego(dificultad, this);

		tiempo = new ContadorTiempo(juego);
		tiempoDisparo= new ContadorTDisparo(juego);
		
		listaEnemigos = juego.getListaEnems();
		for (Position<Enemigo> pos : listaEnemigos.positions())
			panel.add(grafico(pos.element()));
		
		panel.add(grafico(juego.getObstaculo(0)));
		panel.add(grafico(juego.getObstaculo(1)));
		panel.add(grafico(juego.getObstaculo(2)));

		jugador = juego.getPersonaje();
		panel.add(grafico(jugador));
		
		vida.setText("Vida: " + jugador.getVida());
		panel.add(vida);
		
		instruccion.setText("PRESIONE ESPACIO PARA COMENZAR");
		panel.add(instruccion);
		
		comienzoConEspacio = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				int barraEspaciadora = arg0.getKeyCode();
				
				if (barraEspaciadora == KeyEvent.VK_SPACE) {
					try {
						if (nombre.equals("")) { //Contempla qué nivel se está creando. Si el nivel es superior a 1, este paso no se ejecutará.
							boolean valido = false;
							while (!valido) {
								nombre = JOptionPane.showInputDialog(null, "Ingrese un Nombre para el Personaje:");
								if (nombre != null && !nombre.equals("") && nombre.length() <= 8)
									valido = true;
								else
									JOptionPane.showMessageDialog(null, "Debe ingresarse un nombre de longitud mayor que 0 y menor o igual que 8.", "Ingreso Inválido", JOptionPane.ERROR_MESSAGE);
							}
							nombrePersonaje.setBounds((int) (frameWidth * 0.5 - nombre.length() * 10), (int) (frameHeight * 0.02), (int) (frameWidth * 0.6), 25);
							nombrePersonaje.setText(nombre.toUpperCase());
							
							/*
							 * MOSTRAR HIGH SCORES.
							 */
							
						}
						panel.add(nombrePersonaje);
						comenzarJuego();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				    tiempo.start();
				    tiempoDisparo.start();
				}
			}
		};
		
		frame.addKeyListener(comienzoConEspacio);
	}
	
	
		
		private void comenzarJuego() throws InterruptedException {
			frame.removeKeyListener(comienzoConEspacio);
			instruccion.setText("");
			
			botonera = new AccionTeclado(this, juego);
			
			frame.addKeyListener(botonera);
		}
		
		public JLabel grafico(Objeto o) {
			return o.getGrafico();
		}
		
		public Personaje getPersonaje() { return jugador; }
		public PositionList<Enemigo> getListaEnemigos() { return listaEnemigos;	}
		public int getFrameWidth() { return frameWidth;	}
		public int getFrameHeight() { return frameHeight; }
		public Container getPanel() { return panel; }
		
		public JLabel getPuntuacion() { return puntuacion; }
		public JLabel getVida() { return vida; }
		public JLabel getNombrePersonaje() { return nombrePersonaje; }
		public JLabel getLvl() { return lvl; }
		public int getPuntaje() { return puntaje; }
		public void setPuntaje(int p) {	puntaje = p; }
}
