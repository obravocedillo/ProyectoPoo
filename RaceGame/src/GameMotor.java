import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameMotor extends JFrame{
	
	private PanelJuego pj;
	private Vehicule vehicule,vehicule2;
	private Listener listener;
	
	
	public GameMotor(){
		super("Race Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.vehicule = new Vehicule(0,0);
		this.vehicule2 = new Vehicule(0,300);
		this.listener = new Listener(this.vehicule,this.vehicule2);
		this.addKeyListener(this.listener);
		this.pj = new PanelJuego(this.vehicule,this.vehicule2,this.listener);
		this.add(pj);
		this.pack();
		this.setVisible(true);
		
		
	}
		
	public static void main(String[] args){
			GameMotor gm = new GameMotor();
			
	}
	
}
