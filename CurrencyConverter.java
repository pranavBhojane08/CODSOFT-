import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Get base and target currency
            System.out.print("Enter Base Currency (e.g., USD, EUR, INR): ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter Target Currency (e.g., USD, EUR, INR): ");
            String target = sc.next().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            // Step 2: Call API to get exchange rate
            String urlStr = "https://api.frankfurter.app/latest?from=" + base + "&to=" + target;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner reader = new Scanner(url.openStream());

                while (reader.hasNext()) {
                    inline.append(reader.nextLine());
                }
                reader.close();

                // Step 3: Parse JSON
                JSONObject json = new JSONObject(inline.toString());
                double exchangeRate = json.getJSONObject("rates").getDouble(target);

                // Step 4: Convert
                double convertedAmount = amount * exchangeRate;

                // Step 5: Display
                System.out.println("\n===== 💱 Conversion Result =====");
                System.out.println(amount + " " + base + " = " + convertedAmount + " " + target);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        sc.close();
    }
}
