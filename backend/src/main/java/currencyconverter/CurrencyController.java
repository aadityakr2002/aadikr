package currencyconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    // Home endpoint
    @GetMapping("/")
    public String home() {
        return "Currency Converter is running!";
    }

    // Endpoint to convert currencies
    @GetMapping("/convert")
    public String convertCurrency(
            @RequestParam double amount,
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency) {
        // Example conversion logic
        double conversionRate = getConversionRate(fromCurrency, toCurrency); // Stub function
        double convertedAmount = amount * conversionRate;

        return String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
    }

    // Stub method for conversion rate (replace with real API logic)
    private double getConversionRate(String fromCurrency, String toCurrency) {
        // Example: Mocked conversion rates
        if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            return 74.50;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            return 0.013;
        } else {
            return 1.0; // Default 1:1 rate
        }
    }
}
