package com.example.firstjavafxproject;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.function.Function;

class databaseConnection extends HelloController {

    //this constructor use to estabilse the connection to database
    String jdbcUrl = "jdbc:mysql://localhost:3306/weather";
    String username = "root";
    String password = "root";

    Connection connection;

    databaseConnection() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, username, password);

    }

    Function<String, ResultSet> execute = (queryString) -> {
        // Implementation of the apply method
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(queryString);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("hi.................");
            e.printStackTrace();
            // You might want to handle the exception or return null in case of an error
            return null;
        }
};


    public void currentStatus(String querystatement) {

        String query = String.format("SELECT %s FROM weatherdata order by id desc limit 1", querystatement);
        ResultSet resultSet = execute.apply(query);
        System.out.println("hi");
        if (resultSet != null) {
            // Process the ResultSet here
            try {
                System.out.println("hi");
                while (resultSet.next()) {
                    // Process each row of data
                    System.out.println(resultSet.getString(querystatement));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public float tempreturre_min () {

        String query = String.format("SELECT temp_min FROM weatherdata order by id desc  limit 1");
        System.out.print("hi");
         String resultSet1=  "i" ;
         float tem_mins=0;
        if (resultSet1 != null) {

            // Process the ResultSet here
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet= preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process each row of data
                    tem_mins= Float.parseFloat(resultSet.getString("temp_min"));
                    System.out.println(resultSet.getString("temp_min"));
                }
                //float value = 19.5475f;
                DecimalFormat df = new DecimalFormat("0.0");
               // System.out.println("Value: " + df.format(value)); // Value: 19.55

                System.out.print(df.format(tem_mins));
                return tem_mins;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tem_mins;

    }
    public float tempreturre_max () {

        String query = String.format("SELECT temp_max FROM weatherdata order by id desc  limit 1");
        System.out.print("hi");
        String resultSet1=  "i" ;
        float tem_mins=0;
        if (resultSet1 != null) {

            // Process the ResultSet here
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet= preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process each row of data
                    tem_mins= Float.parseFloat(resultSet.getString("temp_max"));
                    System.out.println(resultSet.getString("temp_max"));
                }
                //float value = 19.5475f;
                DecimalFormat df = new DecimalFormat("0.0");
                // System.out.println("Value: " + df.format(value)); // Value: 19.55

                System.out.print(df.format(tem_mins));
                return tem_mins;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tem_mins;

    }
    public float humidity() {

        String query = String.format("SELECT humidity FROM weatherdata order by id desc  limit 1");
        System.out.print("hi");
        String resultSet1=  "i" ;
        float tem_mins=0;
        if (resultSet1 != null) {

            // Process the ResultSet here
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet= preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process each row of data
                    tem_mins= Float.parseFloat(resultSet.getString("humidity"));
                    System.out.println(resultSet.getString("humidity"));
                }
                //float value = 19.5475f;
                DecimalFormat df = new DecimalFormat("0.0");
                // System.out.println("Value: " + df.format(value)); // Value: 19.55

                System.out.print(df.format(tem_mins));
                return tem_mins;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tem_mins;

    }
    public String weather_descriptions() {

        String query = String.format("SELECT weather_description FROM weatherdata order by id desc  limit 1");
        System.out.print("hi");
        String resultSet1=  "i" ;
        String weather_description =null;
        if (resultSet1 != null) {

            // Process the ResultSet here
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet= preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process each row of data
                    weather_description= String.valueOf(resultSet.getString("weather_description"));
                    System.out.println(resultSet.getString("weather_description"));
                }
                //float value = 19.5475f;
                DecimalFormat df = new DecimalFormat("0.0");
                // System.out.println("Value: " + df.format(value)); // Value: 19.55


                return weather_description;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return weather_description;

    }
    public String cur_locs() {

        String query = String.format("SELECT name FROM weatherdata order by id desc  limit 1");
        System.out.print("hi");
        String resultSet1=  "i" ;
        String cur_loc =null;
        if (resultSet1 != null) {

            // Process the ResultSet here
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet= preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Process each row of data
                    cur_loc= String.valueOf(resultSet.getString("name"));
                    System.out.println(resultSet.getString("name"));
                }
                //float value = 19.5475f;
               // DecimalFormat df = new DecimalFormat("0.0");
                // System.out.println("Value: " + df.format(value)); // Value: 19.55


                return cur_loc;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cur_loc;

    }

    public float avg(String querystatement, int no_days, String name) {
        //System.out.print("jjjj");
        int count = 0;
        String query = String.format("SELECT COUNT(name) AS name_count FROM weatherdata WHERE name = '%s' order by id desc", name);
        ResultSet resultSet = execute.apply(query);
        System.out.print(resultSet);
        if (resultSet != null) {

            try {
                   while(resultSet.next()) {
                       System.out.println(resultSet.getString("name_count"));
                       count = Integer.parseInt(resultSet.getString("name_count"));

                   }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.print(count);
        float avg = 0.0F;
        System.out.println("wertyuiop");
        if (count < no_days) {
            no_days = count;
        }
        if (no_days==0){

        }
        //System.out.print(no_days);

       query = String.format("SELECT avg(%s) as average FROM weatherdata where name= '%s' order by id desc limit %d", querystatement, name, no_days);
        resultSet = execute.apply(query);
        if (resultSet != null) {

            try {
                while (resultSet.next()) {

                    System.out.println(resultSet.getString("average"));
                    avg= Float.parseFloat(resultSet.getString("average"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return avg;
        }
        return avg;


}
public ArrayList<Float> pastfivedays(){
    ArrayList<Float> past5days_max=new ArrayList<>();
    ArrayList<Float> past5days_min=new ArrayList<>();
              String query ="select * from (SELECT AVG(temp_min) AS temp_min, AVG(temp_max) AS temp_max,cur_date FROM weatherdata\n" +
                      "GROUP BY cur_date) as datas order by datas.cur_date desc limit 6";
               ResultSet resultSet = execute.apply(query);
               System.out.println("wwwwww");
    try {
        while (resultSet.next()) {

            //System.out.println(resultSet.getString("average"));
            past5days_max.add(Float.parseFloat(resultSet.getString("temp_max")));
            //past5days_min.add(Float.parseFloat(resultSet.getString("temp_min")));
        }
//        for (Float i : pastdays){
//            System.out.println(i);
//        }



    } catch (SQLException e) {
        e.printStackTrace();
    }
    return past5days_max;



}

    public ArrayList<Float> mindata(){
        ArrayList<Float> past5days_max=new ArrayList<>();
        ArrayList<Float> past5days_min=new ArrayList<>();
        String query ="select * from (SELECT AVG(temp_min) AS temp_min, AVG(temp_max) AS temp_max,cur_date FROM weatherdata\n" +
                "GROUP BY cur_date) as datas order by datas.cur_date desc limit 6";
        ResultSet resultSet = execute.apply(query);
        System.out.println("wwwwww");
        try {
            while (resultSet.next()) {

                //System.out.println(resultSet.getString("average"));
                //past5days_max.add(Float.parseFloat(resultSet.getString("temp_max")));
                past5days_min.add(Float.parseFloat(resultSet.getString("temp_min")));
            }
//        for (Float i : pastdays){
//            System.out.println(i);
//        }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return past5days_min;



    }
    public ArrayList<String> date(){
        String query ="select * from (SELECT cur_date FROM weatherdata " +
                "GROUP BY cur_date) as datas order by datas.cur_date desc limit 6";
        ResultSet resultSet = execute.apply(query);
        ArrayList<String> date=new ArrayList<>();
        try {
            while (resultSet.next()) {

                //System.out.println(resultSet.getString("average"));
                //past5days_max.add(Float.parseFloat(resultSet.getString("temp_max")));
                date.add(String.valueOf(resultSet.getString("cur_date")));
            }
//        for (Float i : pastdays){
//            System.out.println(i);
          } catch (SQLException e) {
              e.printStackTrace();
        }
         return date;


    }




    public void insert(WeatherData weatherData){
        String query = "INSERT INTO weatherdata ( name, lon, lat, weather_id, weather_main, weather_description, " +
                "weather_icon, base, temp, feels_like, temp_min, temp_max, pressure, humidity, visibility, " +
                "wind_speed, wind_deg, rain_1h, clouds_all, dt, sys_type, sys_id, sys_country, sys_sunrise, " +
                "sys_sunset, timezone, cod,cur_date,cur_time) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,curdate(),current_time())";



            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {



                preparedStatement.setString(1, weatherData.getName());

                preparedStatement.setDouble(2, weatherData.getCoord().getLon());

                preparedStatement.setDouble(3, weatherData.getCoord().getLat());

                preparedStatement.setInt(4, weatherData.getWeather().get(0).getId());
                preparedStatement.setString(5, weatherData.getWeather().get(0).getMain());

                preparedStatement.setString(6, weatherData.getWeather().get(0).getDescription());

                preparedStatement.setString(7, weatherData.getWeather().get(0).getIcon());

                preparedStatement.setString(8, weatherData.getBase());

                preparedStatement.setDouble(9, weatherData.getMain().getTemp());

                preparedStatement.setDouble(10, weatherData.getMain().getFeels_like());

                preparedStatement.setDouble(11, weatherData.getMain().getTemp_min());

                preparedStatement.setDouble(12, weatherData.getMain().getTemp_max());

                preparedStatement.setInt(13, weatherData.getMain().getPressure());
                preparedStatement.setInt(14, weatherData.getMain().getHumidity());
                preparedStatement.setInt(15, weatherData.getVisibility());

                preparedStatement.setDouble(16, weatherData.getWind().getSpeed());
                preparedStatement.setInt(17, weatherData.getWind().getDeg());
                Rain rain = weatherData.getRain();
                if (rain != null) {
                    preparedStatement.setDouble(18, rain.getRain1h());
                } else {
                    preparedStatement.setDouble(18, 0.0); // Set a default value or handle it accordingly
                }

                preparedStatement.setInt(19, weatherData.getClouds().getAll());
                preparedStatement.setLong(20, weatherData.getDt());
                preparedStatement.setInt(21, weatherData.getSys().getType());
                preparedStatement.setInt(22, weatherData.getSys().getId());
                preparedStatement.setString(23, weatherData.getSys().getCountry());
                preparedStatement.setLong(24, weatherData.getSys().getSunrise());
                preparedStatement.setLong(25, weatherData.getSys().getSunset());
                preparedStatement.setInt(26, weatherData.getTimezone());
                preparedStatement.setInt(27, weatherData.getCod());
                System.out.println("welcome       ");
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
    }

}
