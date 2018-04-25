import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



class MyTrail{
   
    int life;
    int x;
    int y;
    Vehicule vehicule;
    Color color;
    ArrayList <Puntos> trail; 
    public MyTrail(Vehicule vehicule) {
    	this.vehicule = vehicule;
        this.color = Color.CYAN;  
        trail = new ArrayList<>();
    }
    public void Draw(Graphics g2) {
    	for(int i=0;i<trail.size();i++){
    		if(trail.get(i).life < 0){
             trail.remove(i);   
            }
    		g2.setColor(trail.get(i).getColor());
    		g2.fillRect(trail.get(i).getX(), trail.get(i).getY(), 15, 15);
    		
    	}
        
    }
    public void Update(){


    	 for(int i=0; i<trail.size();i++){
         	trail.get(i).setLife(trail.get(i).getLife()-15);;
         }
    	 
    	trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),Color.CYAN));
    	
        
    }
}