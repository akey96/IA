import java.util.*;
public class RatonBFS{
    private int cont = 0;
    public Queue <Punto> q = new LinkedList<Punto>();
    private int[][] laberinto = new int[][] 
           /*{{1,0,1,1,1,1,0,0,0,1},           //PRIMER LABERINTO
            {1,0,1,0,1,0,1,0,0,0},
            {0,0,1,0,0,0,1,0,1,1},
            {0,0,0,0,1,1,0,0,0,1},
            {0,0,1,0,0,0,0,0,1,0},
            {0,0,1,0,1,1,1,0,1,1},
            {1,0,1,0,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,0,1,0},
            {1,0,0,0,0,0,0,5,0,0},
            {1,0,0,0,1,0,0,0,1,0}
        }; */  
            /*{{1,0,1,1,1,1,0,0,0,1},            //SEGUNDO LABERINTO
            {1,0,1,1,1,0,1,0,0,0},
            {0,0,0,0,0,0,1,0,1,1},
            {0,0,0,0,1,1,0,0,0,1},
            {0,0,1,0,0,0,0,0,1,0},
            {0,0,1,0,1,1,1,0,0,0},
            {1,0,1,0,1,0,0,0,1,0},
            {1,0,1,0,1,1,1,0,0,0},
            {1,0,0,0,0,0,1,5,0,0},
            {1,0,0,0,1,0,1,0,1,0}
        };*/
           {{0,0,1,0,0,0,1,1,1,1},           //TERCER LABERINTO
            {1,0,1,0,1,0,0,0,0,0},
            {0,0,0,1,0,1,0,1,0,0},
            {0,0,0,0,0,1,1,0,0,0},
            {0,0,0,1,1,1,1,0,1,0},
            {0,0,0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,1,1,0,0},
            {0,1,0,0,0,0,0,1,5,0},
            {0,0,0,0,1,1,1,1,1,0},
            {1,0,0,0,0,0,0,0,0,0},
        };
    public Punto getCaminoBfs(int x, int y){
        q.add(new Punto(x,y, null));
        while(!q.isEmpty()){
            Punto p = q.remove();
            if(laberinto[p.getX()][p.getY()] == 5){
                System.out.println("¡Queso encontrado!");
                return p;
            }
            if(estaLibre(p.getX()+1,p.getY())) {
                laberinto[p.getX()][p.getY()] = -1;
                Punto nextP = new Punto(p.getX()+1,p.getY(), p);
                q.add(nextP);
            }
            if(estaLibre(p.getX()-1,p.getY())) {
                laberinto[p.getX()][p.getY()] = -1;
                Punto nextP = new Punto(p.getX()-1,p.getY(), p);
                q.add(nextP);
            }
            if(estaLibre(p.getX(),p.getY()+1)) {
                laberinto[p.getX()][p.getY()] = -1;
                Punto nextP = new Punto(p.getX(),p.getY()+1, p);
                q.add(nextP);
            }
             if(estaLibre(p.getX(),p.getY()-1)) {
                laberinto[p.getX()][p.getY()] = -1;
                Punto nextP = new Punto(p.getX(),p.getY()-1, p);
                q.add(nextP);
            }
        }
        return null;
    }
    public boolean estaLibre(int x, int y) {
        if((x>=0 && x<laberinto.length) && (y>=0 && y<laberinto[x].length)&&(laberinto[x][y]==0 || laberinto[x][y]==5)){
            return true;
        }
        return false;
    }
    public void getBFS(){
        Punto p = getCaminoBfs(0,0);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                laberinto[i][j] = 0;
            }
        }
        while(p.getPadre() != null){
            laberinto[p.getX()][p.getY()] = 2;
            cont++; //System.out.println(p);
            p = p.getPadre();
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(" "+laberinto[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\nRecorrido: "+ cont +" movimientos");
    }
    public void getLaberinto(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(" "+ laberinto[i][j] +" ");
            }
            System.out.println();
        }
    }
}