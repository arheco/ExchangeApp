package ing.arturo.exchangeapp.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ing.arturo.exchangeapp.modelos.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        ValidaSalida salida = new ValidaSalida();
        HttpService uriDivisaOrigen = new HttpService();
        HttpService uriDivisaDestino = new HttpService();
        HttpService uriDivisaDoble = new HttpService();
        salida.setValidaSalida(false);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting().create();


        try {
            while (!salida.isValidaSalida()) {
             ;   System.out.println("""
                        Menú principal\
                        
                         1. MXN -> USD           6. CAD -> MXN\
                        
                         2. USD -> MXN           7. MXN -> ARS\
                        
                         3. MXN -> EUR           8. ARS -> MXN\
                        
                         4. EUR -> MXN           9. USD -> EUR\
                        
                         5. MXN -> CAD          10. EUR -> USD\
                        
                         11. Salir del programa.\s""");
                MenuSelector entrada = new MenuSelector();
                switch (entrada.getOpcion()) {
                    case 1:
                        System.out.println("Convertir MXN a USD");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("MXN");
                        uriDivisaDestino.setUri("USD");

                        // Crea la URI para solicitar meidante API la tasa de conversion.
                        CreadorUriPair uriPair = new CreadorUriPair(uriDivisaOrigen.getUri(), uriDivisaDestino.getUri());

                        // Recibe la respuesta de la solicitud API de la divisa individualmente
                        String responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        String responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        // Recibe la respuesta de la solicitud API de la tasa de conversión.
                        String responseTasa = uriDivisaDoble.enviarGet(String.valueOf(uriPair));

                        // Imprime la salida Json Ugly *******************
                        // Remover al avance del proyecto*****************
                        System.out.println("Tasa: " + responseTasa);
                        System.out.println("Origen: " + responseOrigen);
                        System.out.println("Destino: " + responseDestino);
                        // Remover****************************************

                        DivisaApi divisaOrigen = gson.fromJson(responseOrigen, DivisaApi.class) ;
                        DivisaApi divisaDestino = gson.fromJson(responseDestino, DivisaApi.class);
                        ConversionAPI targetRate = gson.fromJson(responseTasa, ConversionAPI.class);
                        System.out.println(divisaOrigen);
                        System.out.println(divisaDestino);
                        System.out.println(targetRate);
                        Pausa.Pausa();
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
