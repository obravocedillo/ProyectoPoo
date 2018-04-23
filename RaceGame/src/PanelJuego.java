import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements Runnable {
	Vehicule vehicule;
	private boolean gameActive, isPressed;
	
	
	public PanelJuego(){
		super();
		this.vehicule = new Vehicule();
		this.setPreferredSize(new Dimension(1000, 1000));
		
		
		this.vehicule = new Vehicule();
		this.gameActive = true;
		
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(0+this.vehicule.getVelocity(), 100, 100, 100);
		
		
	}

	@Override
	public void run() {
		try {
			while(gameActive){
				this.vehicule.setVelocity(20);
				this.repaint();
				Thread.sleep(30);
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
