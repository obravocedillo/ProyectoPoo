import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PanelJuego extends JPanel {
	Vehicule vehicule;
	
	public PanelJuego(Vehicule vehicule){
		super();
		this.vehicule = new Vehicule();
		this.setPreferredSize(new Dimension(1000, 1000));
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.fillRect(this.vehicule.getVelocity(), 100, 100, 100);
		
		
	}
		
}
