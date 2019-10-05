
import java.util.ArrayList;


public class GrafoColores {

    
    private char [] colores;
    
    private char [][] auxiliar;
    private char ayuda; 
    private int fila,columna;
    
    private ArrayList<char[][]> coleccionDeMapasAnchura, coleccionDeMapaProfundidad;
    private ArrayList<Integer> rangos;
    private int tamaño, posicion;
    
    private GenerarNumeroAleatorio random;
    public GrafoColores(GenerarMapaColoreado mapa){
        random=new GenerarNumeroAleatorio();
        fila=mapa.fila;
        columna=mapa.columna;
        colores = mapa.getListaColores();
        auxiliar=mapa.getMapaColoreado();
        
        coleccionDeMapasAnchura=new ArrayList<char[][]>();
        rangos=new ArrayList<Integer>();
        coleccionDeMapaProfundidad=new ArrayList<char[][]>();
    }
    
    
    private char[][] copia(char [][] a){
        char[][] res= new char[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                res[i][j]=a[i][j];
            }
        }
        return res;
    }
    
    public boolean busquedaPorAnchura(){
        boolean res=false;
        coleccionDeMapasAnchura.clear();
        res=prueba(auxiliar);
        tamaño=coleccionDeMapasAnchura.size();
        rangos.add(tamaño);
        for(int i=0; i<coleccionDeMapasAnchura.size() && res==true;i++){
            if(i==tamaño-1){
                tamaño=coleccionDeMapasAnchura.size();
                rangos.add(tamaño);
            }
            auxiliar = coleccionDeMapasAnchura.get(i);
            res=prueba(auxiliar);            
            posicion+=1;
            
        }
        return res;
    }
    public boolean busquedaPrimeroEnProfundidad(){
        boolean res=false;
        coleccionDeMapaProfundidad.clear();
        coleccionDeMapasAnchura.clear();
        res=prueba(auxiliar);
        for(int i=0; i<coleccionDeMapasAnchura.size() && res==true;i++){
            tamaño=coleccionDeMapasAnchura.size();
            if(i==0){
                auxiliar = coleccionDeMapasAnchura.get(i);
                coleccionDeMapaProfundidad.add(copia(auxiliar));
                coleccionDeMapasAnchura.clear();
                res=prueba(auxiliar);            
                posicion+=1;
            }
            i--;
        }
        return res;
    }
    
    public void datosAnchura(){
        String res="La matriz Objetivo es: "+"\n";
        int a=coleccionDeMapasAnchura.size();
        if(a!=0){   
            res+= mostrar(coleccionDeMapasAnchura.get(a-1));
        }
        res+="Costo Ruta: "+rangos.size()+"\n";
        res+="Costo Búsqueda: "+ posicion+"\n";
        System.out.println(res);
    }
    public void datosProfundidad(){
        String res="La matriz Objetivo es: "+"\n";
        int a=coleccionDeMapaProfundidad.size();
        if(a!=0){
            res+= mostrar(coleccionDeMapaProfundidad.get(a-1));
        }
        res+="Costo Ruta: "+a+"\n";
        System.out.println(res);
    }
    
    private String mostrar(char[][] aux){
        String res="";
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[0].length; j++) {
                res+=aux[i][j]+" ";
            }
            res+="\n";
        }
        return res;
    }
    
    private char color(char a,char b){
        char res =' ';
        for (int i = 0; i < colores.length && res==' '; i++) {
            if(a != colores[i] && b!= colores[i]){
                res = colores[i];
            }
        }
        if(res == ' '){
            res = colores[random.numeroRandom(colores.length)-1];
        }
        return res;
    }
    private char color(char a,char b,char c){
        char res =' ';
        for (int i = 0; i < colores.length && res==' '; i++) {
            if(a != colores[i] && b!= colores[i] && c!= colores[i]){
                res = colores[i];
            }
        }
        if(res == ' '){
            res = colores[random.numeroRandom(colores.length)-1];
        }
        return res;
    }
    private char color(char a,char b,char c,char d){
        char res =' ';
        for (int i = 0; i < colores.length && res==' '; i++) {
            if(a != colores[i] && b!= colores[i] && c!= colores[i] && d!= colores[i]){
                res = colores[i];
            }
        }
        if(res == ' '){
            res = colores[random.numeroRandom(colores.length)-1];
        }
        return res;
    }
    private char color(char a){
        char res =' ';
        for (int i = 0; i < colores.length && res==' '; i++) {
            if(a != colores[i]){
                res = colores[i];
            }
        }
        if(res == ' '){
            res = colores[random.numeroRandom(colores.length)-1];
        }
        return res;
    }
    
    private char[][] cambioMapa(char[][] aux,int i, int j){
        char[][] res= copia(auxiliar);
        res[i][j]=color(ayuda);
        return res;
    }
    private char[][] cambioMapa2Ad(char[][] aux,int i, int j,char a, char b){
        char[][] res= copia(auxiliar);
        res[i][j]=color(a,b);
        return res;
    }
    private char[][] cambioMapa3Ad(char[][] aux,int i, int j,char a, char b, char c){
        char[][] res= copia(auxiliar);
        res[i][j]=color(a,b,c);
        return res;
    }
    private char[][] cambioMapa4Ad(char[][] aux,int i, int j,char a, char b, char c,char d){
        char[][] res= copia(auxiliar);
        res[i][j]=color(a,b,c,d);
        return res;
    }
    
    private boolean esquinaSuperiorIzquierda(char[][] aux,int i , int j){
        boolean res = false;
        if(j==0){
            if((aux[i][j]== aux[i][j+1]) && (aux[i][j]== aux[i+1][j])){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux, i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i][j+1])){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i][j+1], aux[i+1][j]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i+1][j])){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i][j+1], aux[i+1][j]));
                        aux[i][j]=ayuda;
                        res= true;
                    }
                }
            }
        }
        return res;
    }
    private boolean esquinaSuperiorDerecha(char[][] aux,int i , int j){
        boolean res=false;
        if(j==aux[0].length-1){
            if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i+1][j])){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i][j-1])){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i][j-1], aux[i+1][j]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i+1][j])){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i][j-1], aux[i+1][j]));
                        aux[i][j]=ayuda;
                        res= true;
                    }
                }
            }
        }
        return res;
    }
    private boolean esquinaInferiorIzquierda(char[][] aux,int i , int j){
        boolean res=false;
        if(j==0){
            if(aux[i][j]==aux[i-1][j] && aux[i][j]==aux[i][j+1]){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if(aux[i][j]==aux[i-1][j]){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i-1][j], aux[i][j+1]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if(aux[i][j]==aux[i][j+1]){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i-1][j], aux[i][j+1]));
                        aux[i][j]=ayuda;
                        res= true;
                    }
                }
            }
        }
        return res;
    }
    private boolean esquinaInferiorDerecha(char[][] aux,int i , int j){
        boolean res=false;
        if(j==aux[0].length-1){
            if(aux[i][j]==aux[i-1][j] && aux[i][j]==aux[i][j-1]){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if(aux[i][j]==aux[i-1][j]){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i-1][j], aux[i][j-1]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if(aux[i][j]==aux[i][j-1] && aux[i][j] != '#'){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa2Ad(aux,i, j, aux[i-1][j], aux[i][j-1]));
                        aux[i][j]=ayuda;
                        res= true;
                    }
                }
            }
        }
        return res;
    }
    
    private boolean entreIzquierdaYDerechaSuperior(char[][] aux,int i , int j){
        boolean res=false;
        if(j>0 && j<aux[0].length-1){
            if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i][j+1]))){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i+1][j]) ){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i][j-1]) && ((aux[i][j]== aux[i][j+1]))){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                        aux[i][j]=ayuda;
                        res= true;
                    }else{
                        if((aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i][j+1]))){
                            ayuda=aux[i][j];
                            coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                            aux[i][j]=ayuda;
                            res= true;
                        }else{
                            if((aux[i][j]== aux[i][j-1])){
                                ayuda=aux[i][j];
                                coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                                aux[i][j]=ayuda;
                                res= true;
                            }else{
                                if((aux[i][j]== aux[i+1][j])){
                                    ayuda=aux[i][j];
                                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                                    aux[i][j]=ayuda;
                                    res= true;
                                }else{
                                    if((aux[i][j]== aux[i][j+1])){
                                        ayuda=aux[i][j];
                                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i+1][j], aux[i][j+1]));
                                        aux[i][j]=ayuda;
                                        res= true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean entreSuperiorEInferiorIzquierda(char[][] aux,int i , int j){
        boolean res=false;
        if(j==0 && i>0 && i<aux.length-1){
            if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j+1]) && ((aux[i][j]== aux[i+1][j]))){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j+1]) ){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i+1][j]))){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                        aux[i][j]=ayuda;
                        res= true;
                    }else{
                        if((aux[i][j]== aux[i][j+1]) && ((aux[i][j]== aux[i+1][j]))){
                            ayuda=aux[i][j];
                            coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                            aux[i][j]=ayuda;
                            res= true;
                        }else{
                            if((aux[i][j]== aux[i-1][j])){
                                ayuda=aux[i][j];
                                coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                aux[i][j]=ayuda;
                                res= true;
                            }else{
                                if((aux[i][j]== aux[i][j+1])){
                                    ayuda=aux[i][j];
                                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                    aux[i][j]=ayuda;
                                    res= true;
                                }else{
                                    if((aux[i][j]== aux[i+1][j])){
                                        ayuda=aux[i][j];
                                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                        aux[i][j]=ayuda;
                                        res= true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean entreSuperiorEInferiorDerecha(char[][] aux,int i , int j){
        boolean res=false;
        if(j==aux[0].length-1 && i>0 && i<aux.length-1){
            if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j-1]) && ((aux[i][j]== aux[i+1][j]))){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j-1]) ){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i+1][j]))){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                        aux[i][j]=ayuda;
                        res= true;
                    }else{
                        if((aux[i][j]== aux[i][j-1]) && ((aux[i][j]== aux[i+1][j]))){
                            ayuda=aux[i][j];
                            coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                            aux[i][j]=ayuda;
                            res= true;
                        }else{
                            if((aux[i][j]== aux[i-1][j])){
                                ayuda=aux[i][j];
                                coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                                aux[i][j]=ayuda;
                                res= true;  
                            }else{
                                if((aux[i][j]== aux[i][j-1])){
                                    ayuda=aux[i][j];
                                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                                    aux[i][j]=ayuda;
                                    res= true;
                                }else{
                                    if((aux[i][j]== aux[i+1][j])){
                                        ayuda=aux[i][j];
                                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i-1][j], aux[i][j-1], aux[i+1][j]));
                                        aux[i][j]=ayuda;
                                        res= true;  
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean entreIzquierdaYDerechaInferior(char[][] aux,int i , int j){
        boolean res=false;
        if(j>0 && j<aux[0].length-1){
            if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j+1]))){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i-1][j]) ){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i][j-1]) && ((aux[i][j]== aux[i][j+1]))){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                        aux[i][j]=ayuda;
                        res= true;
                    }else{
                        if((aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j+1]))){
                            ayuda=aux[i][j];
                            coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                            aux[i][j]=ayuda;
                            res= true;
                        }else{
                            if((aux[i][j]== aux[i][j-1])){
                                ayuda=aux[i][j];
                                coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                                aux[i][j]=ayuda;
                                res= true;
                            }else{
                                if((aux[i][j]== aux[i-1][j])){
                                    ayuda=aux[i][j];
                                    coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                                    aux[i][j]=ayuda;
                                    res= true;
                                }else{
                                    if((aux[i][j]== aux[i][j+1]) && aux[i][j] != '#'){
                                        ayuda=aux[i][j];
                                        coleccionDeMapasAnchura.add(cambioMapa3Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1]));
                                        aux[i][j]=ayuda;
                                        res= true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean todoCentro(char[][] aux,int i , int j){
        boolean res=false;
        if(i>0 && i< aux.length-1 && j>0 && j<aux[0].length-1){
            if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j+1])) && ((aux[i][j]== aux[i+1][j]))){
                ayuda=aux[i][j];
                coleccionDeMapasAnchura.add(cambioMapa(aux,i, j));
                aux[i][j]=ayuda;
                res= true;
            }else{
                if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j-1]) && ((aux[i][j]== aux[i+1][j]))){
                    ayuda=aux[i][j];
                    coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                    aux[i][j]=ayuda;
                    res= true;
                }else{
                    if((aux[i][j]== aux[i-1][j]) && (aux[i][j]== aux[i][j+1]) && ((aux[i][j]== aux[i+1][j]))){
                        ayuda=aux[i][j];
                        coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                        aux[i][j]=ayuda;
                        res= true;
                    }else{
                        if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j+1]))){
                            ayuda=aux[i][j];
                            coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                            aux[i][j]=ayuda;
                            res= true;
                        }else{
                            if((aux[i][j]== aux[i][j-1]) && (aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i][j+1]))){
                                ayuda=aux[i][j];
                                coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                aux[i][j]=ayuda;
                                res= true;
                            }else{
                                if((aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j+1]))){
                                    ayuda=aux[i][j];
                                    coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                    aux[i][j]=ayuda;
                                    res= true;
                                }else{
                                    if((aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i][j+1]))){
                                        ayuda=aux[i][j];
                                        coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                        aux[i][j]=ayuda;
                                        res= true;
                                    }else{
                                        if((aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i][j-1]))){
                                            ayuda=aux[i][j];
                                            coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                            aux[i][j]=ayuda;
                                            res= true;
                                        }else{
                                            if((aux[i][j]== aux[i-1][j]) && ((aux[i][j]== aux[i][j-1]))){
                                                ayuda=aux[i][j];
                                                coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                aux[i][j]=ayuda;
                                                res= true;
                                            }else{
                                                if((aux[i][j]== aux[i+1][j]) && ((aux[i][j]== aux[i-1][j]))){
                                                    ayuda=aux[i][j];
                                                    coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                    aux[i][j]=ayuda;
                                                    res= true;
                                                }else{
                                                    if((aux[i][j]== aux[i][j+1]) && ((aux[i][j]== aux[i][j-1]))){
                                                        ayuda=aux[i][j];
                                                        coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                        aux[i][j]=ayuda;
                                                        res= true;
                                                    }else{
                                                        if(aux[i][j] == aux[i-1][j]){
                                                            ayuda=aux[i][j];
                                                            coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                            aux[i][j]=ayuda;
                                                            res= true;
                                                        }else{
                                                            if(aux[i][j] == aux[i][j-1]){
                                                                ayuda=aux[i][j];
                                                                coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                                aux[i][j]=ayuda;
                                                                res= true;
                                                            }else{
                                                                if(aux[i][j] == aux[i+1][j]){
                                                                    ayuda=aux[i][j];
                                                                    coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                                    aux[i][j]=ayuda;
                                                                    res= true;
                                                                }else{
                                                                    if(aux[i][j] == aux[i][j+1]){
                                                                        ayuda=aux[i][j];
                                                                        coleccionDeMapasAnchura.add(cambioMapa4Ad(aux,i, j, aux[i][j-1], aux[i-1][j], aux[i][j+1], aux[i+1][j]));
                                                                        aux[i][j]=ayuda;
                                                                        res= true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private boolean prueba(char [][] aux){
        boolean res = false;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[0].length; j++) {
                if(i==0){
                    res|=esquinaSuperiorIzquierda(aux, i, j);
                    res|=esquinaSuperiorDerecha(aux, i, j);
                    res|=entreIzquierdaYDerechaSuperior(aux, i, j);
                }
                res|=entreSuperiorEInferiorIzquierda(aux, i, j);
                res|=entreSuperiorEInferiorDerecha(aux, i, j);
                if(i==aux.length-1){
                    res|=esquinaInferiorIzquierda(aux, i, j);
                    res|=esquinaInferiorDerecha(aux, i, j);
                    res|=entreIzquierdaYDerechaInferior(aux, i, j);
                }
                res|=todoCentro(aux, i, j);
                
            }
        }
        return res;
    }
    
}
