package PaqueteDisparos;

import javax.swing.ImageIcon;

public class DisparoInstaKill extends Disparo {

	public DisparoInstaKill(int x, int y, int d) {
		super(x, y, d);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/disparoSkull.png"));
		grafico.setSize(grafico.getIcon().getIconHeight(),grafico.getIcon().getIconWidth());
	}

}
