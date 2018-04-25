import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameMotor extends JFrame{
	
	PanelJuego pj;
	Vehicule vehicule;
	
	
	public GameMotor(){
		super("Race Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.vehicule = new Vehicule();
		Listener listener = new Listener(vehicule);
		this.addKeyListener(listener);
		this.pj = new PanelJuego(vehicule,listener);
		this.add(pj);
		this.pack();
		this.setVisible(true);
		
		
	}
		
	public static void main(String[] args){
			GameMotor gm = new GameMotor();
			
	}
	
}
