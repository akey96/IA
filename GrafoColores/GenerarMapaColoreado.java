 

import java.util.Random;


public class GenerarMapaColoreado {

    private Tabla mapa;
    private Colores lista;
    protected int fila,columna;
    private int regiones,colores;
    
    private char [][] mapaColoreado;
    private char [] listaColores;
    
    private int sumRegiones;
    protected GenerarNumeroAleatorio random;
    
    public GenerarMapaColoreado(int numRegiones, int colores) {
        
        regiones =numRegiones;
        this.colores=colores;
        random=new GenerarNumeroAleatorio();
        darValores();
        mapa = new Tabla( fila, columna);
        lista = new Colores(colores);
        mapaColoreado= mapa.getMapa();
        listaColores=lista.seleccionados;
        generarMapa();
        mostrar();
        if(colores==1){
            System.out.println("La cantidad de colores debe ser mayor a 1");
        }
    }
    public void generarMapa(){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                sumRegiones++;
                if(sumRegiones<=regiones){
                    mapaColoreado[i][j]=listaColores[random.numeroRandom(colores)-1];
                }else{
                    mapaColoreado[i][j]='#';
                }
            }
        }
        sumRegiones=0;
    }
    protected char[][] getMapaColoreado(){
        return mapaColoreado;
    }
    
    private void mostrar(){
        String res="La matriz que ingresamos es: "+"\n";
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                res+=mapaColoreado[i][j]+" ";
            }
            res+="\n";
        }
        System.out.print(res);
    }
    private void darValores(){
        switch(regiones){
            case 16: fila=4;columna=4;break;case 17: fila=3;columna=6;break;
            case 18: fila=3;columna=6;break;case 19: fila=4;columna=5;break;
            case 20: fila=4;columna=5;break;case 21: fila=3;columna=7;break;
            case 22: fila=4;columna=6;break;case 23: fila=4;columna=6;break;
            case 24: fila=4;columna=6;break;case 25: fila=5;columna=5;break;
            case 26: fila=3;columna=9;break;case 27: fila=3;columna=9;break;
            case 28: fila=4;columna=7;break;case 29: fila=5;columna=6;break;
            case 30: fila=5;columna=6;break;
            
        }
    }
    protected char[] getListaColores(){
        return listaColores;
    }
}
