package ing.arturo.exchangeapp.modelos;

public record ApiResponse(String result, String time_last_update, String base_code, Conversion conversion_rates) {
}
