
import java.awt.AWTException;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private ArrayList <Puntos> yaRecorrido;
	private Image fondo;
	private Image moto;
	private Listener listener;
	Robot robot;
	Color choque;
	Clip clip;
	AudioInputStream audioIn;
	private Thread thread;
	
	
	public PanelJuego(Vehicule vehicule,Listener listener){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		
		//this.setBackground(Color.BLACK);
		
		this.myTrail = new MyTrail(vehicule);
		this.vehicule = vehicule;
		this.gameActive = true;
		this.fondo = new ImageIcon("Tron+Grid.png").getImage();
		this.reproducirMusica();
		this.listener = listener;
		
		this.thread = new Thread(this);
		thread.start();
		this.vehicule.setX(10);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(),this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 15, 15);
		g2d.setColor(Color.CYAN);
		myTrail.Draw(g);
		myTrail.Update(this.listener);
		
		
		
		
	}
	
	
	
	public void reproducirMusica() {
			try {
				audioIn = AudioSystem.getAudioInputStream(this.getClass().getResource("song1.wav"));
				clip = AudioSystem.getClip();
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
				
				this.yaRecorrido=this.myTrail.getTrail();
				for(int i=0;i<this.yaRecorrido.size();i++) {
					if(this.vehicule.getVelocity()==this.yaRecorrido.get(i).getX() && this.vehicule.getVelocityY()==this.yaRecorrido.get(i).getY()) {
						this.thread.stop();
					}
					else if(this.vehicule.getVelocity()==this.yaRecorrido.get(i).getX2() && this.vehicule.getVelocityY()==this.yaRecorrido.get(i).getY2()) {
						this.thread.stop();
					}
				}
				
				
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
				if(Thread.interrupted()){
					clip.stop();
				}
			
				
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
