import java.awt.Graphics;

public class Vehicule {
	private int velocity;
	private int velocityY;
	private int turn;
	private int height;
	private int width;
	
	
	public Vehicule(){
		this.velocity = 0;
		this.velocityY = 0;
		this.turn = 0;
		this.width = 100;
		this.height = 100;
	}
	
	
	
	public void setVelocity(int velocity){
		this.velocity += velocity;
	}
	
	public int getVelocity(){
		return this.velocity;
	}
	
	public void setTurn(int turn) {
		this.turn=turn;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void setVelocityY(int velocityY){
		this.velocityY += velocityY;
	}
	
	public int getVelocityY(){
		return this.velocityY;
	}
	
	 
	
	
	
}
