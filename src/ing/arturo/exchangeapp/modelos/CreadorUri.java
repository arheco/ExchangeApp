package ing.arturo.exchangeapp.modelos;


public class CreadorUri {

    private String uri;
    private String apiKey = "93a0811d6c7ed1c8189cad54";
    private String uriOK;
    private String uriPairOk;

    public String getUri() {
        return uri;
    }

    public String getUriOK() {
        uriOK = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + this.uri;
        return uriOK;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}