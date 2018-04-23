import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
		Vehicule vehicule;
	public Listener(Vehicule vehicule){
		this.vehicule = vehicule;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		 int code = e.getKeyCode();
		 	
	     if (code == KeyEvent.VK_DOWN) {
	    	 System.out.println("abajo");
	    	 this.vehicule.setTurn(180);
	    	 this.vehicule.setVelocityY(20);
	    	 this.vehicule.setVelocity(0);
	    	 
	    	 
	    } else if (code == KeyEvent.VK_UP) {
	    	System.out.println("arriba");
	    	this.vehicule.setTurn(0);
	    	 this.vehicule.setVelocityY(-20);
	    	 this.vehicule.setVelocity(0);

	     }else if (code == KeyEvent.VK_LEFT) {
	    	 System.out.println("izquierda");
	    	 this.vehicule.setTurn(240);
	    	 this.vehicule.setVelocity(-20);
	    	 this.vehicule.setVelocityY(0);
	               
	     }else if (code == KeyEvent.VK_RIGHT) {
	    	 System.out.println("derecha");
	    	 this.vehicule.setTurn(90);
	    	 this.vehicule.setVelocity(20);
	    	 this.vehicule.setVelocityY(0);
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