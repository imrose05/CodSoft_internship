import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.close();
        
        try {
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate");
        }
    }
    
    private static double getExchangeRate(String base, String target) throws Exception {
        String urlString = "https://api.exchangerate-api.com/v4/latest/" + base;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.toString());
        return jsonNode.get("rates").get(target).asDouble();
    }
}
