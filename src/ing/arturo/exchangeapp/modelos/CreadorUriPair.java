package ing.arturo.exchangeapp.modelos;

public class CreadorUriPair {

    private String uriOrigen;
    private String uriDestino;
    private String apiKey = "93a0811d6c7ed1c8189cad54";
    private String uriOK;

    public CreadorUriPair(String uriOrigen, String uriDestino) {
        uriOK = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + uriOrigen + "/" + uriDestino;
    }

    @Override
    public String toString(){
        return uriOK;
    }

    public void setUriOrigen(String uriOrigen) {
        this.uriOrigen = uriOrigen;
    }

    public void setUriDestino(String uriDestino) {
        this.uriDestino = uriDestino;
    }
}

