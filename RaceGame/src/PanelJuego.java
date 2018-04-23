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
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				isPressed = false;
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(vehicule.getVelocity());
				isPressed = true;
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(this.vehicule.getVelocity(), 100, 100, 100);
		
		
	}

	@Override
	public void run() {
		try {
			while(gameActive){
				if(this.isPressed==true) {
					this.vehicule.setVelocity(100);
					Thread.sleep(100);
					
				}
				else {
					this.vehicule.setVelocity(0);
				}
				
				this.repaint();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
