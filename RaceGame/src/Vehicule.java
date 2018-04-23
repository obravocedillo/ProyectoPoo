import java.awt.Graphics;

public class Vehicule {
	private int velocity;
	int turn;
	int height;
	int width;
	
	
	public Vehicule(){
		this.velocity = 50;
		this.turn = 0;
		this.width = 100;
		this.height = 100;
	}
	
	
	
	public void setVelocity(int velocity){
		this.velocity = velocity;
	}
	
	public int getVelocity(){
		return velocity;
	}
	
}
