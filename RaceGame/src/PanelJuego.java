
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
	Vehicule vehicule,vehicule2;
	MyTrail myTrail,myTrail2;
	private boolean gameActive;
	private ArrayList <Puntos> yaRecorrido,yaRecorrido2;
	private Image fondo,nave1,nave2,nave3,nave4;
	private Image moto;
	private Listener listener;

	Color choque;
	Clip clip;
	AudioInputStream audioIn;
	private Thread thread;
	
	
	public PanelJuego(Vehicule vehicule,Vehicule vehicule2, Listener listener){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		
		//this.setBackground(Color.BLACK);
		
		
		this.vehicule = vehicule;
		this.vehicule2= vehicule2;
		this.myTrail = new MyTrail(this.vehicule);
		this.myTrail2= new MyTrail(this.vehicule2);
		this.gameActive = true;
		this.fondo = new ImageIcon("Tron+Grid.png").getImage();
		this.nave1=new ImageIcon("ShipR.png").getImage();
		this.nave2=new ImageIcon("ShipD.png").getImage();
		this.nave3=new ImageIcon("ShipU.png").getImage();
		
		this.reproducirMusica();
		this.listener = listener;
		
		this.thread = new Thread(this);
		thread.start();
		//this.vehicule.setX(10);
	
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(),this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 15, 15);
		
		g2d.fillRect(0+this.vehicule2.getVelocity(), 0+this.vehicule2.getVelocityY(), 15, 15);
		//g.drawImage(this.nave1, 0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 30, 15,this);
		g2d.setColor(Color.CYAN);
		myTrail.Draw(g);
		myTrail.Update(this.listener);
		
		myTrail2.Draw(g);
		myTrail2.Update(this.listener);
		
		
		
		
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
	
	public void checarColision(Vehicule vehicule, MyTrail trail) {
		ArrayList <Puntos> yaRecorrido= new ArrayList<>();
		
		vehicule.setVelocity(vehicule.getX());
		vehicule.setVelocityY(vehicule.getY());
		
		if(trail.getColor()==Color.CYAN) {
			this.yaRecorrido=trail.getTrail();
			yaRecorrido=this.yaRecorrido;
		}
		else if(trail.getColor()==Color.ORANGE) {
			this.yaRecorrido2=trail.getTrail();
			yaRecorrido2=this.yaRecorrido2;
		}
		
		for(int i=0;i<this.yaRecorrido.size();i++) {
			if(this.vehicule.getVelocity()==this.yaRecorrido.get(i).getX() && this.vehicule.getVelocityY()==this.yaRecorrido.get(i).getY()) {
				this.gameActive = false;
				this.thread.stop();
				this.clip.stop();
			}
			else if(this.vehicule.getVelocity()==this.yaRecorrido.get(i).getX2() && this.vehicule.getVelocityY()==this.yaRecorrido.get(i).getY2()) {
				this.gameActive = false;
				this.thread.stop();
				this.clip.stop();
				
				
			}
		}
	}

	

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			while(this.gameActive){
				this.checarColision(this.vehicule, this.myTrail);
				this.checarColision(this.vehicule2, this.myTrail2);
				
				
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
				
			
				
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
		
}
