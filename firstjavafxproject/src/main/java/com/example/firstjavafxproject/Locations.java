package com.example.firstjavafxproject;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Locations {

    public String city() {
        String city = null;
        try {
            String ipAddress = getPublicIpAddress();
            System.out.print(ipAddress);
            String location = getLocationByIp(ipAddress);

            // Parse the JSON response to extract specific details
            city = extractCityFromJson(location);
            String country = extractCountryFromJson(location);

            // Print the formatted output
            System.out.println("Location: " + city + ", " + country);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return city;
    }

    private static String extractCityFromJson(String json) {
        JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
        return jsonObject.getString("city");
    }

    private static String extractCountryFromJson(String json) {
        JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
        return jsonObject.getString("country_name");
    }

    private static String getLocationByIp(String ipAddress) throws IOException {
        System.out.print(ipAddress);
        String apiUrl = "https://ipapi.co/" + ipAddress + "/json/";

        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        return response.toString();
}

    private static String getPublicIpAddress() throws IOException {
        URL whatismyip = new URL("https://checkip.amazonaws.com/");
        System.out.println(whatismyip);
        System.out.println(whatismyip.openConnection());
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        System.out.println(in);
        String ipAddress = in.readLine();

        in.close();

        return ipAddress;
    }
}