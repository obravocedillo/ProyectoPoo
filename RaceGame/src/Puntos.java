import java.awt.Color;

public class Puntos {
	int x;
	int y;
	int life;
	Color color;
	
	public Puntos(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
		this.life = 3500;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	 
	
	
}
