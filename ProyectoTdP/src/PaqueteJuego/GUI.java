package PaqueteJuego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import PaqueteContadores.Contador;
import PaqueteContadores.ContadorTDisparo;
import PaqueteContadores.ContadorTiempo;
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
	private JLabel[] drops, highScores;
	private Juego juego;
	private PositionList<Enemigo> listaEnemigos;
	private Personaje jugador;
	private int puntaje;
	private int frameWidth, frameHeight;
	private String nombre;
	private Inicializador inicializador;
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
		
		inicializador = new Inicializador(frameWidth, frameHeight);
		lvl = inicializador.setearLvl();
		vida = inicializador.setearVida();
		puntuacion = inicializador.setearPuntuacion();
		instruccion = inicializador.setearInstruccion();
		nombrePersonaje = inicializador.setearNombrePersonaje();
		fondo = inicializador.setearFondo();
		drops = inicializador.setearDrops();
		highScores = inicializador.setearHighScores();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setearFondoYPanel(fondo);
		
		puntaje = 0;
		nombre = "";
		
		nivel(1);
		
	}
	
	
	private void nivel(int dificultad) {
		if (dificultad == 1) {
			for(int i = 0; i < highScores.length; i++)
				panel.add(highScores[i]);
		}
		
		lvl.setText("Nivel: " + dificultad);
		panel.add(lvl);
		
		puntuacion.setText("Puntaje: " + puntaje);
		panel.add(puntuacion);
		
		for(int i = 0; i < drops.length; i++)
			panel.add(drops[i]);
		
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
						if (nombre.equals(""))
							nombre = inicializador.obtenerNombre(nombrePersonaje);
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
			for(int i = 0; i < highScores.length; i++)
				highScores[i].setVisible(false);
			frame.removeKeyListener(comienzoConEspacio);
			instruccion.setText("");
			
			botonera = new AccionTeclado(this, juego);
			
			frame.addKeyListener(botonera);
		}
		
		public JLabel grafico(Objeto o) { return o.getGrafico(); }
		public Contador getTiempo() { return tiempo; }
		public Contador getTDisparo() { return tiempoDisparo; }
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
		
		public void mostrarIconoDrop(int tipo,ImageIcon image) {
			drops[tipo].setIcon(image);
		}
		public void actualizarIconoEscudo() {
			mostrarIconoDrop(0, new ImageIcon("./bin/ImageIcons/iconoDropEscudo_Deshabilitado.png"));
		}
		
		public void setearFondoYPanel(JLabel nuevoFondo) {
			frame.setContentPane(nuevoFondo);
			frame.getContentPane().setLayout(new BorderLayout());
			frame.setVisible(true);
			panel = frame.getContentPane();
			panel.setBounds(0, 0, frameWidth, frameHeight);
			panel.setLayout(null);
		}
}
