import java.awt.Graphics;

public class Vehicule {
	private int positionX;
	private int positionY;
	private int x;
	private int y;
	private int turn;
	private int height;
	private int width;
	private int lineX,lineY;
	
	
	public Vehicule(){
		this.positionX = 0;
		this.positionY = 0;
		this.turn = 0;
		this.width = 20;
		this.height = 20;
	}
	
	public void setLineX(int lineX) {
		this.lineX+=lineX;
	}
	
	public int getLineX() {
		return this.lineX;
	}
	
	public void setLineY(int lineY) {
		this.lineY+=lineY;
	}
	
	public int getLineY() {
		return this.lineY;
	}
	
	
	
	public void setVelocity(int velocity){
		this.positionX += velocity;
	}
	
	public int getVelocity(){
		return this.positionX;
	}
	
	public void setTurn(int turn) {
		this.turn=turn;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void setVelocityY(int velocityY){
		this.positionY += velocityY;
	}
	
	public int getVelocityY(){
		return this.positionY;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	

	 
	
	
	
}
