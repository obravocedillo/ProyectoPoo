import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

<<<<<<< HEAD


=======
>>>>>>> 82f06df78fe2c36dd1b7def521d3e97a74753f26
class MyTrail{
   
    private int life;
    private int x;
    private int y;
    private Vehicule vehicule;
    private Color color;
    private ArrayList <Puntos> trail; 
    
    public MyTrail(Vehicule vehicule) {
    	this.vehicule = vehicule;
        this.color = Color.CYAN;  
        trail = new ArrayList<>();
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
<<<<<<< HEAD


    	 for(int i=0; i<trail.size();i++){
         	trail.get(i).setLife(trail.get(i).getLife()-15);;
=======
    	 for(int i=0; i<this.trail.size();i++){
         	this.trail.get(i).setLife(this.trail.get(i).getLife()-15);;
>>>>>>> 82f06df78fe2c36dd1b7def521d3e97a74753f26
         }
    	 
    this.trail.add(new Puntos(this.vehicule.getVelocity(),this.vehicule.getVelocityY(),Color.CYAN));
    	
        
    }
}