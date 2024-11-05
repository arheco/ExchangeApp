package ing.arturo.exchangeapp.principal;

import ing.arturo.exchangeapp.modelos.MenuSelector;
import ing.arturo.exchangeapp.modelos.ValidaSalida;

public class Main {
    public static void main(String[] args) {

        ValidaSalida salida = new ValidaSalida();

        salida.setValidaSalida(false);
        while (salida.isValidaSalida() == false) {
            System.out.println("""
                Menú principal\
                
                 1. MXN -> USD           6. CAD -> MXN\
                
                 2. USD -> MXN           7. MXN -> ARG\
                
                 3. MXN -> EUR           8. ARG -> MXN\
                
                 4. EUR -> MXN           9. USD -> EUR\
                
                 5. MXN -> CAD          10. EUR -> USD\
                
                 11. Salir del programa.\s""");
            MenuSelector entrada = new MenuSelector();
            switch (entrada.getOpcion()){
                case 1:
                    System.out.println("Convertir MXN a USD");
                    break;
                case 2:
                    System.out.println("Convertir USD a MXN");
                    break;
                case 3:
                    System.out.println("Convertir MXN a EUR");
                    break;
                case 4:
                    System.out.println("Convertir EUR a MXN");
                    break;
                case 5:
                    System.out.println("Convertir MXN a CAD");
                    break;
                case 6:
                    System.out.println("Convertir CAD a MXN");
                    break;
                case 7:
                    System.out.println("Convertir MXN a ARG");
                    break;
                case 8:
                    System.out.println("Convertir ARG a MXN");
                    break;
                case 9:
                    System.out.println("Convertir USD a EUR");
                    break;
                case 10:
                    System.out.println("Convertir EUR a USD");
                    break;
                case 11:
                    salida.setValidaSalida(true);
                    System.out.println("Gracias por usar este programa.");
                    break;
                default:
                    System.out.println("ERROR!!: Opción invalida, intente de nuevo");
            }
        }
    }
}
