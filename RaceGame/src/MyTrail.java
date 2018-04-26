import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


class MyTrail{
   
    private int life;
    private Vehicule vehicule;
    private Color color;
    private ArrayList <Puntos> trail; 
    
    public MyTrail(Vehicule vehicule) {
    	this.vehicule = vehicule;
        this.color = Color.CYAN;  
        trail = new ArrayList<>();
    }
    
    
    
    
    public ArrayList<Puntos> getTrail() {
		return trail;
	}






	public void Draw(Graphics g2) {
    	for(int i=0;i<trail.size();i++){
    		if(this.trail.get(i).life < 0){
             this.trail.remove(i);   
            }
    		g2.setColor(this.trail.get(i).getColor());
    		g2.fillRect(this.trail.get(i).getX(), this.trail.get(i).getY(), 15, 15);
    		
    	}
        
    }
    public void Update(Listener listener){
    		
    for(int i=0; i<trail.size();i++){
         	trail.get(i).setLife(trail.get(i).getLife()-15);
    }

    	if(listener.getCode()==KeyEvent.VK_RIGHT) {
    		this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),this.vehicule.getVelocity(),this.vehicule.getVelocityY()-15,Color.GREEN));
    	}
    	else if(listener.getCode()==KeyEvent.VK_LEFT) {
    		this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),this.vehicule.getVelocity(),this.vehicule.getVelocityY()-15,Color.GREEN));
    	}
    	
    	else if(listener.getCode()==KeyEvent.VK_UP) {
    		this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),this.vehicule.getVelocity()+15,this.vehicule.getVelocityY(),Color.GREEN));
    	}
    	else if(listener.getCode()==KeyEvent.VK_DOWN) {
    		this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),this.vehicule.getVelocity()-15,this.vehicule.getVelocityY(),Color.GREEN));
    	}
    
        
    }
    
    
    
}