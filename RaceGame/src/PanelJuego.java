import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import sun.audio.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements Runnable {
	Vehicule vehicule;
	MyTrail myTrail;
	private boolean gameActive;
	private Image fondo;
	
	
	
	public PanelJuego(Vehicule vehicule){
		super();
		this.setPreferredSize(new Dimension(1250, 800));
		
		//this.setBackground(Color.BLACK);
		
		this.myTrail = new MyTrail(vehicule);
		this.vehicule = vehicule;
		this.gameActive = true;
		this.setImage("/Users/alejandroparra/Documents/ISC/ProyectoPoo/RaceGame/src/images/Tron+Grid.png");
		
		String archivoMusica = "/Users/alejandroparra/Documents/ISC/ProyectoPoo/RaceGame/src/images/music.mp3";
		InputStream in = null;
		try {
			 in= new FileInputStream(archivoMusica);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		AudioStream audioStream;
		try {
			audioStream = new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	  
	    
		
		
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.BLACK);}
		//g.fillRect(0, 0, 1250, 1500);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0+this.vehicule.getVelocity(), 0+this.vehicule.getVelocityY(), 15, 15);
		g2d.setColor(Color.CYAN);
		myTrail.Draw(g);
		
		
	}
	
	public void setImage(String text) {
		File pathToFile = new File(text);
		try {
			this.fondo = ImageIO.read(pathToFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error");
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
