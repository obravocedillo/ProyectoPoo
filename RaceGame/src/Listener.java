import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Listener implements KeyListener {
		Vehicule vehicule;
		ArrayList <Puntos> yaRecorrido;
	public Listener(Vehicule vehicule){
		this.yaRecorrido = new ArrayList<>();
		this.vehicule = vehicule;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		 int code = e.getKeyCode();
		 	
	     if (code == KeyEvent.VK_DOWN) {
	    	 System.out.println("abajo");
	    	 this.vehicule.setTurn(180);
	    	 this.vehicule.setY(10);
	    	 this.vehicule.setX(0);
	    	 
	    	 
	    } else if (code == KeyEvent.VK_UP) {
	    	System.out.println("arriba");
	    	this.vehicule.setTurn(0);
	    	 this.vehicule.setY(-10);
	    	 this.vehicule.setX(0);

	     }else if (code == KeyEvent.VK_LEFT) {
	    	 System.out.println("izquierda");
	    	 this.vehicule.setTurn(240);
	    	 this.vehicule.setX(-10);
	    	 this.vehicule.setY(0);
	               
	     }else if (code == KeyEvent.VK_RIGHT) {
	    	 System.out.println("derecha");
	    	 this.vehicule.setTurn(90);
	    	 this.vehicule.setX(10);
	    	 this.vehicule.setY(0);
	       }
	         
	    }
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
