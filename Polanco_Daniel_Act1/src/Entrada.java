import java.sql.SQLOutput;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Introduce tu apuesta");
        int apuesta = scanner.nextInt();
        System.out.println("Introduce el número de intentos que prevé que salga el bingo");
        int intentos = scanner.nextInt();
        int numeroAleatorio;
        boolean estaNumero;

        //carton -> array
        //Rellenar el carton de forma aleatoria
        //Generamos los 10 numeros del carton
        int [] carton = new int[10];
        for (int i = 0; i < carton.length; i++) {
            //Math.random()*99 [0-98]+1 -> Hay que sumarle 1 para que vayan del 1 al 99
            do {
                numeroAleatorio = (int) (Math.random() * 99) + 1;
                estaNumero = false;
                for (int j = 0; j < i; j++){
                    if (carton[j] == numeroAleatorio) {
                        estaNumero = true;
                        break;
                    }
                }
            } while (estaNumero);
            carton[i] = numeroAleatorio;
        }
        System.out.println("tu carton es:");
        for (int item: carton) {
            System.out.println("\t" + item);
        }

        //Sacar las bolas del bingo
        int [] sorteo = new int[99];
        int [] bolaSorteo = new int[99];
        int paraLinea = 0;
        int paraBingo = 0;
        int intentoLinea = 0;
        int intentoBingo = 0;
        boolean control;

        for (int e = 0; e < sorteo.length && paraBingo < 10; e++){
            control = false;

            do {
                control = false;
                bolaSorteo[e] = (int) ((Math.random() * 99) +1);
                for (int x = 0; x < e; x++) {
                    if (bolaSorteo[x] == bolaSorteo[e]) {
                        control = true;
                        break;
                    }
                }
            } while (control);

            sorteo[e] = bolaSorteo[e];

            for (int j=0; j< carton.length; j++) {
                if (carton[j] == bolaSorteo[e]){
                    paraLinea++;
                    if (paraLinea == 5){
                        intentoLinea = e;
                    }
                    paraBingo++;
                    if (paraBingo == 10){
                        intentoBingo = e;
                        break;
                    }
                }
            }
        }
        System.out.println("\n" + "sorteo");
        for (int c=0; c<sorteo.length; c++) {
            System.out.print(sorteo[c] + "\t");
        }

        System.out.println();

        System.out.println("intentos de línea:" + intentoLinea);
        System.out.println("intentos de bingo:" + intentoBingo);
        if (intentoBingo == intentos) {
            System.out.println("Has ganado la apuesta. El premio es:" +apuesta*10);
        } else {
            System.out.println("No has ganado la apuesta");
        }

    }

}
