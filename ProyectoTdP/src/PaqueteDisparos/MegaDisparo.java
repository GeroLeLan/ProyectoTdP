package PaqueteDisparos;

import javax.swing.ImageIcon;

public class MegaDisparo extends Disparo {

	public MegaDisparo(int x, int y, int d) {
		super(x, y, d*2);
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/MegaDisparo.jpg"));
	}
	protected void setGrafico() {
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.03),(int) (Ymax*0.05));
		grafico.setLocation(pos);
	}

}
