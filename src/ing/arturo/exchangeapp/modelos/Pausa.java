package ing.arturo.exchangeapp.modelos;

import java.io.IOException;

public class Pausa {
    public static void Pausa() {
        System.out.println("Presiona una tecla para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

