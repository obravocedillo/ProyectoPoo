import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements Runnable {
	Vehicule vehicule;
	private boolean gameActive, isPressed;
	
	
	public PanelJuego(Vehicule vehicule){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		this.setBackground(Color.BLACK);
		
		
		
		
		
		this.vehicule = vehicule;
		this.gameActive = true;
		
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1250, 1500);
		g.setColor(Color.CYAN);
		
		g.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 30, 30);
		g.setColor(Color.WHITE);
		
	}

	@Override
	public void run() {
		try {
			while(gameActive){
				this.vehicule.setVelocity(this.vehicule.getX());
				this.vehicule.setVelocityY(this.vehicule.getY());
				
				
				if(this.vehicule.getVelocity()>1250) {
					this.vehicule.setVelocity(-1280);
				}
				else if(this.vehicule.getVelocityY()>800) {
					this.vehicule.setVelocityY(-830);
				}
				else if(this.vehicule.getVelocityY()<0) {
					this.vehicule.setVelocityY(830);
				}
				else if(this.vehicule.getVelocity()<0) {
					this.vehicule.setVelocity(1280);
				}
				this.repaint();
				Thread.sleep(30);
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
