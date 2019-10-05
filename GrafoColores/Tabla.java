

public class Tabla {
    
    private char [][] mapa;
    

    public Tabla(int fila, int columna) {
        mapa = new char[fila][columna];
        inicializar();
    }
    
    private void inicializar(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = ' ';
            }
        }
    }
    public char [][] getMapa(){
        return mapa;
    }
}
