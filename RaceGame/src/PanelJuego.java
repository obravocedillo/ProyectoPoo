
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements Runnable {
	Vehicule vehicule;
	MyTrail myTrail;
	private boolean gameActive;
	private Image fondo;
	private Image moto;
	AudioInputStream audioIn;
	
	
	public PanelJuego(Vehicule vehicule){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		
		//this.setBackground(Color.BLACK);
		
		this.myTrail = new MyTrail(vehicule);
		this.vehicule = vehicule;
		this.gameActive = true;
		this.fondo = new ImageIcon("Tron+Grid.png").getImage();
		this.reproducirMusica();
		
		Thread thread = new Thread(this);
		thread.start();
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(),this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 15, 15);
		g2d.setColor(Color.CYAN);
		myTrail.Draw(g);
		
		
	}
	
	
	
	public void reproducirMusica() {
			try {
				audioIn = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource("song1.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				System.out.println("error" + e);
				e.printStackTrace();
			}
			
	}


	@Override
	public void run() {
		try {
			while(gameActive){
				this.vehicule.setVelocity(this.vehicule.getX());
				this.vehicule.setVelocityY(this.vehicule.getY());
				
				
				if(this.vehicule.getVelocity()>1250) {
					this.vehicule.setVelocity(-1265);
				}
				else if(this.vehicule.getVelocityY()>800) {
					this.vehicule.setVelocityY(-815);
				}
				else if(this.vehicule.getVelocityY()<0) {
					this.vehicule.setVelocityY(815);
				}
				else if(this.vehicule.getVelocity()<0) {
					this.vehicule.setVelocity(1265);
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
