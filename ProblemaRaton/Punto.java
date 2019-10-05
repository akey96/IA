public class Punto{
    private int x;
    private int y;
    
    Punto padre;
    
    public Punto(int x, int y, Punto padre){
        this.x = x;
        this.y = y;
        this.padre = padre;
    }
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Punto getPadre(){
        return this.padre;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    @Override
    public int hashCode(){
        return this.getX() + this.getY();//+31;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false; 
        }
        Punto tmp = (Punto) obj; 
        return tmp.getX() == this.getX() && this.getY() == tmp.getY();
    }
    public String toString(){
        return "x = " + x + " y = " + y;
    }
}