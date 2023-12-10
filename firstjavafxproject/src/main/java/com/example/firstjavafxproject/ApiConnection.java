package com.example.firstjavafxproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {

    public String setApiKey() throws Exception {
        String apiKey = "85b1861ce63d879f3c852ee41f6c591b";
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the city name : ");
        Locations name = new Locations();
        String city = name.city();



            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse the JSON response here and extract the weather information
            System.out.println(response.toString());
            return response.toString();


    }

}
