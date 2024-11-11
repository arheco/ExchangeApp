package ing.arturo.exchangeapp.modelos;

import com.google.gson.annotations.SerializedName;

public class ConversionRates {
    @SerializedName("MXN")
    private String mxn;
    @SerializedName("USD")
    private String usd;
    @SerializedName("ARS")
    private String ars;
    @SerializedName("CAD")
    private String cad;
    @SerializedName("EUR")
    private String eur;

    public String getMxn() {
        return mxn;
    }

    public void setMxn(String mxn) {
        this.mxn = mxn;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getArs() {
        return ars;
    }

    public void setArs(String ars) {
        this.ars = ars;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }
}

