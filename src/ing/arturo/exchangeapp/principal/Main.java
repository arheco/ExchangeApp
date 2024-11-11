package ing.arturo.exchangeapp.principal;

import com.google.gson.Gson;
import ing.arturo.exchangeapp.modelos.*;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ValidaSalida salida = new ValidaSalida();
        HttpService uriDivisaOrigen = new HttpService();
        HttpService uriDivisaDestino = new HttpService();
        salida.setValidaSalida(false);
        Scanner teclado = new Scanner(System.in);
        Gson gson = new Gson();
        RespuestaAPI divisaOrigen;
        RespuestaAPI divisaDestino;
        double valorOrigenJson;
        String actualizacionOrigenJson;
        String codigoOrigenJson;
        String responseOrigen;
        String responseDestino;
        double cantidadConvertir;
        double cantidadFinal;

        try {
            while (!salida.isValidaSalida()) {
                System.out.println("""
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

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getMxn());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getMxn());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getMxn());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 2:
                        System.out.println("Convertir USD a MXN");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("USD");
                        uriDivisaDestino.setUri("MXN");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getUsd());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getUsd());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getUsd());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 3:
                        System.out.println("Convertir MXN a EUR");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("MXN");
                        uriDivisaDestino.setUri("EUR");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getMxn());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getMxn());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getMxn());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 4:
                        System.out.println("Convertir EUR a MXN");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("EUR");
                        uriDivisaDestino.setUri("MXN");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getEur());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getEur());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getEur());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 5:
                        System.out.println("Convertir MXN a CAD");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("MXN");
                        uriDivisaDestino.setUri("CAD");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getCad());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getCad());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getCad());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();

                        break;
                    case 6:
                        System.out.println("Convertir CAD a MXN");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("CAD");
                        uriDivisaDestino.setUri("MXN");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getMxn());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getMxn());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getMxn());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 7:
                        System.out.println("Convertir MXN a ARG");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("MXN");
                        uriDivisaDestino.setUri("ARS");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getMxn());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getMxn());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getMxn());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();

                        break;
                    case 8:
                        System.out.println("Convertir ARG a MXN");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("ARS");
                        uriDivisaDestino.setUri("MXN");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getArs());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getArs());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getArs());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 9:
                        System.out.println("Convertir USD a EUR");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("USD");
                        uriDivisaDestino.setUri("EUR");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getUsd());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getUsd());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getUsd());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
                        break;
                    case 10:
                        System.out.println("Convertir EUR a USD");
                        // Crea la URI para solicitar mediante API de la divisa individualmente,
                        uriDivisaOrigen.setUri("EUR");
                        uriDivisaDestino.setUri("USD");

                        // Recibe la respuesta de la solicitud API de la divisa individualmente

                        responseOrigen = uriDivisaOrigen.enviarGet(uriDivisaOrigen.getUriOK());
                        responseDestino = uriDivisaDestino.enviarGet((uriDivisaDestino.getUriOK()));

                        //Convierte el Json(String) recibido y crea los objetos correspondientes.
                        divisaOrigen = gson.fromJson(responseOrigen, RespuestaAPI.class);
                        divisaDestino = gson.fromJson(responseDestino, RespuestaAPI.class);

                        // Selecciona los valores correctos de la deserialización
                        codigoOrigenJson = divisaOrigen.getBase_code();
                        actualizacionOrigenJson = divisaOrigen.getTime_last_update_utc();
                        valorOrigenJson = Double.parseDouble(divisaOrigen.getConversion_rates().getEur());


                        // Muestra los resultados desde el json recibido.
                        System.out.println("Divisa de Origen:" + codigoOrigenJson);
                        System.out.println("Actualizado el: " + actualizacionOrigenJson);
                        System.out.println("Valor actual de la divisa de Origen: " + valorOrigenJson);
                        System.out.println("Valor actual de la divisa de destino: " + divisaDestino.getConversion_rates().getEur());

                        // Solicita el monto que se desea convertir.
                        System.out.println("Ingresa la cantidad de " + divisaOrigen.getBase_code() + " que deseas convertir a " + divisaDestino.getBase_code() + ".");
                        cantidadConvertir = teclado.nextDouble();

                        // Realiza la operación de conversión
                        cantidadFinal = cantidadConvertir / Double.parseDouble(divisaDestino.getConversion_rates().getEur());
                        System.out.println("La conversión es un total de: " + cantidadFinal + " " + divisaDestino.getBase_code());
                        Pausa.Pausa();
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
