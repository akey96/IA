import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
public class RatonDFS{
    private static int cont = 0;
    private Punto[][] ant;
    private int tamX;
    private int tamY;    
    private Punto ultNodo;
    Stack <Punto> pila = new Stack <>();
    private int [][] laberinto =
            /* {{1,0,1,1,1,1,0,0,0,1},          //PRIMER LABERINTO
                {1,0,1,0,1,0,1,0,0,0},
                {0,0,1,0,0,0,1,0,1,1},
                {0,0,0,0,1,1,0,0,0,1},
                {0,0,1,0,0,0,0,0,1,0},
                {0,0,1,0,1,1,1,0,1,1},
                {1,0,1,0,1,0,0,0,1,1},
                {1,0,1,0,1,1,1,0,1,0},
                {1,0,0,0,0,0,0,8,0,0},
                {1,0,0,0,1,0,0,0,1,0}
            };*/   
               /*{{1,0,1,1,1,1,0,0,0,1},          //SEGUNDO LABERINTO
                {1,0,1,1,1,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,1,1},
                {0,0,0,0,1,1,0,0,0,1},
                {0,0,1,0,0,0,0,0,1,0},
                {0,0,1,0,1,1,1,0,0,0},
                {1,0,1,0,1,0,0,0,1,0},
                {1,0,1,0,1,1,1,0,0,0},
                {1,0,0,0,0,0,1,8,0,0},
                {1,0,0,0,1,0,1,0,1,0}
            };*/  
               {{0,0,1,0,0,0,1,1,1,1},          //TERCER LABERINTO
                {1,0,1,0,1,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0},
                {0,0,0,0,0,1,1,0,0,0},
                {0,0,0,1,1,1,1,0,1,0},
                {0,0,0,0,0,1,0,0,0,1},
                {0,1,0,0,1,1,1,1,0,0},
                {0,1,0,0,0,0,0,1,8,0},
                {0,0,0,0,1,1,1,1,1,0},
                {1,0,0,0,0,0,0,0,0,0},
            };        
    RatonDFS(){}
    RatonDFS(int[][] laberinto, int tamY, int tamX){
        this.laberinto = laberinto;
        this.tamY = tamY;
        this.tamX = tamX;
        ant = new Punto[tamY][tamX];
    }
    private boolean enLimiteX(int num){
        return num >= 0 && num < tamX;
    }
    private boolean enLimiteY(int num){
        return num >= 0 && num < tamY;
    }
    public void resolver(Punto nInicio){
        HashSet <Punto> visitado = new HashSet<>();
        pila.push(nInicio);
        while(!pila.isEmpty()){
            Punto temp = pila.pop();
            visitado.add(temp);
            if(laberinto[temp.getY()][temp.getX()] == 8){
                System.out.println("¡Queso encontrado!");
                ultNodo = temp;
                break;
            }
            for(Punto nodo : this.getAristasAdy(temp)){
                if(!visitado.contains(nodo)){
                    pila.push(nodo);
                    ant[nodo.getY()][nodo.getX()] = temp;
                }
            }
        }
    }
    public void llenarCamino(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                laberinto[i][j] = 0;
            }
        }
        if(ultNodo == null){
            System.out.println("No hay camino para el laberinto");
        }else{
            for(;;){
                ultNodo = ant[ultNodo.getY()][ultNodo.getX()];
                if(ultNodo == null){
                    break;
                }
                laberinto[ultNodo.getY()][ultNodo.getX()] = 2;
                cont++;
            }
        }
    }
    private List <Punto> getAristasAdy(Punto temp) {
        List <Punto> nVecinos = new ArrayList <Punto>();
        if(this.enLimiteX(temp.getX()+1)){
            if(this.laberinto[temp.getY()][temp.getX()+1] != 1){
                nVecinos.add(new Punto(temp.getX()+1, temp.getY()));
            }
        }
        if(this.enLimiteX(temp.getX()-1)){
            if(this.laberinto[temp.getY()][temp.getX()-1] != 1){
                nVecinos.add(new Punto(temp.getX()-1, temp.getY()));
            }
        }
        if(this.enLimiteY(temp.getY()+1)){
            if(this.laberinto[temp.getY()+1][temp.getX()] != 1){
                nVecinos.add(new Punto(temp.getX(), temp.getY()+1));
            }
        }
        if(this.enLimiteY(temp.getY()-1)){
            if(this.laberinto[temp.getY()-1][temp.getX()] != 1){
                nVecinos.add(new Punto(temp.getX(), temp.getY()-1));
            }
        }
        return nVecinos;
    }
    public void getDFS(){
        RatonDFS m = new RatonDFS(laberinto, 10, 10);
        m.resolver(new Punto(1,1));
        m.llenarCamino();
        for(int i = 0; i < laberinto.length; i++){
            for(int j = 0; j < laberinto[i].length; j++){
                System.out.print(" " + laberinto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nRecorrido: "+ cont +" movimientos");
    }
}