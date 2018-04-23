import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameMotor extends JFrame  implements Runnable{
	
	static double FPS = 30.0;
	PanelJuego pj;
	Vehicule vehicule;
	boolean gameActive;
	boolean isPressed;
	
	public GameMotor(){
		super("Race Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.vehicule = new Vehicule();
		this.gameActive = true;
		this.pj = new PanelJuego(vehicule);
		this.add(pj);
		this.pack();
		this.setVisible(true);
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
		
	
	
	@Override
	public void run() {
		try {
			while(gameActive){
				System.out.println(isPressed);
				Thread.sleep(100);
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
			GameMotor gm = new GameMotor();
			
	}
	
}
