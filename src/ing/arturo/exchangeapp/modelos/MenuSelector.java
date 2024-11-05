package ing.arturo.exchangeapp.modelos;

import java.util.Scanner;

public class MenuSelector {
    private Scanner teclado;
    private int opcion;

    public MenuSelector() {
        System.out.println("Selecciona una opción");
        this.teclado = new Scanner(System.in);
        opcion = this.teclado.nextInt();
    }

    public int getOpcion() {
        return opcion;
    }
}
