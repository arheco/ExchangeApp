package ing.arturo.exchangeapp.modelos;

public class RespuestaAPI {
    private String result;
    private String time_last_update;
    private String base_code;
    private ConversionRates conversion_rates;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime_last_update() {
        return time_last_update;
    }

    public void setTime_last_update(String time_last_update) {
        this.time_last_update = time_last_update;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public ConversionRates getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(ConversionRates conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
