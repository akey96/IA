 
import java.util.Random;


public class GenerarNumeroAleatorio {
    
    public int numeroRandom(int numero){
        Random num = new Random();
        int a = num.nextInt(numero)+1;
        return a;
    }
}
