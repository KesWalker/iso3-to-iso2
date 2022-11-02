import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String lines = "";
        try {
            lines = Files.readString(Paths.get("countries.json"));
            for (Locale locale : Locale.getAvailableLocales()) {
                try{
                    lines = lines.replace(locale.getISO3Country(),locale.getCountry());
                }catch (Exception e){}
            }
            System.out.println(lines);
            Files.writeString(Paths.get("countries.json"),lines);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getCountryCode(String countryName) {

        // Get all country codes in a string array.
        String[] isoCountryCodes = Locale.getISOCountries();
        String countryCode = "";
        // Iterate through all country codes:
        for (String code : isoCountryCodes) {
            // Create a locale using each country code
            Locale locale = new Locale("", code);
            // Get country name for each code.
            String name = locale.getDisplayCountry();
            if (name.equals(countryName)) {
                countryCode = code;
                break;
            }
        }
        return countryCode;
    }
}
