import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de regiones que van desde 16 a 30: ");
        int a = sc.nextInt();
        System.out.println(" Ingrese el numero de colores uqe va de 1 a 25: ");
        int b = sc.nextInt();
        
        GenerarMapaColoreado as= new GenerarMapaColoreado(a,b);
        
        GrafoColores asd= new GrafoColores(as);
        asd.busquedaPorAnchura();
        asd.datosAnchura();
        
        GrafoColores asd1= new GrafoColores(as);
        asd1.busquedaPrimeroEnProfundidad();
        asd1.datosProfundidad();
    }
}
