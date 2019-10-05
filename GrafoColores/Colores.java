
public class Colores {
    
    private char [] listaColor;
    protected char[]seleccionados;
    
    public Colores(int n) {
        listaColor=new char[26];
        ini();
        inicializarSeleccionados(n);
    }
    
    private void ini(){
        listaColor[0]='a';listaColor[1]='r';listaColor[2]='e';listaColor[3]='t';
        listaColor[4]='c';listaColor[5]='p';listaColor[6]='m';listaColor[7]='q';
        listaColor[8]='w';listaColor[9]='y';listaColor[10]='u';listaColor[11]='i';
        listaColor[12]='o';listaColor[13]='s';listaColor[14]='d';listaColor[15]='f';
        listaColor[16]='g';listaColor[17]='h';listaColor[18]='j';listaColor[19]='k';
        listaColor[20]='l';listaColor[21]='z';listaColor[22]='x';listaColor[23]='v';
        listaColor[24]='b';listaColor[25]='n';    
    }
  
    private void inicializarSeleccionados(int n){
        seleccionados = new char[n];
        for (int i = 0; i < seleccionados.length; i++) {
            seleccionados[i]=listaColor[i];
        }
    }
    protected char[] getlistaColores(){
        return seleccionados;
    }
}
