import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements Runnable {
	Vehicule vehicule;
	MyTrail myTrail;
	private boolean gameActive;
	
	
	public PanelJuego(Vehicule vehicule){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		
		//this.setBackground(Color.BLACK);
		
<<<<<<< HEAD
		
		
		
=======
		this.myTrail = new MyTrail(vehicule);
>>>>>>> f72a5e71077c17fee4ad0c4a072a65d5743200f9
		this.vehicule = vehicule;
		this.gameActive = true;
		
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
<<<<<<< HEAD
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1250, 1500);
		g.setColor(Color.CYAN);
		
		g.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 30, 30);
		g.setColor(Color.WHITE);
=======
		Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.BLACK);}
		//g.fillRect(0, 0, 1250, 1500);
		g2d.setColor(Color.CYAN);
		g2d.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 30, 30);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0+this.vehicule.getLineX(),0+this.vehicule.getLineY(),30,30);
		myTrail.Draw(g);
		
>>>>>>> f72a5e71077c17fee4ad0c4a072a65d5743200f9
		
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
				myTrail.Update();
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
