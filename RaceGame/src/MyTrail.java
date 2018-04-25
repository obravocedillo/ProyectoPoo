import java.awt.Color;
import java.awt.Graphics;
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
    public void Update(){
    		
    for(int i=0; i<trail.size();i++){
         	trail.get(i).setLife(trail.get(i).getLife()-30);
    }

    	 
    this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),Color.GREEN));
    	
        
    }
    
    
    
}