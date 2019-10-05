
public class Comparacion{
    private static RatonBFS mbfs = new RatonBFS();
    private static RatonDFS mdfs = new RatonDFS();
    public static void main(String [] args){
        System.out.println("  LABERINTO INICIAL: \n");
        mbfs.getLaberinto();
        System.out.println();
        System.out.println("  RECORRIDO  POR  AMPLITUD \n");
        mbfs.getBFS();
        System.out.println();
        System.out.println("  RECORRIDO  POR  PROFUNDIDAD \n");
        mdfs.getDFS();
    }
}
