package com.example.firstjavafxproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController {
    public Label temp_min;
    public Label temp_max;
    public Label humidity;
    public Label cur_loc;
    public Label max_temp1;
    public Label max_temp2;
    public Label max_temp3;
    public Label max_temp4;
    public Label max_temp5;
    public Label min_temp5;
    public Label min_temp4;
    public Label min_temp3;
    public Label min_temp2;
    public Label min_temp1;
    public Label date_1;
    public Label date_2;
    public Label date_3;
    public Label date_4;




    @FXML
    public Label  name_descrip ;
    public TextField enter_loc;
    public  TextField user_pref;
    public Label name_descrip1;
    public Label Min_temp5;
     AlertMessage alert;
    public void initialize () throws SQLException {

        alert=new AlertMessage();
      databaseConnection db = new databaseConnection();
        //Scanner input = new Scanner(System.in);
//        // SQL query to retrieve data
//        db.currentStatus("formatdate");
//        db.avg("temp",8);
        System.out.println("hi");
        ApiConnection Api = null;
        try {
           Api = new ApiConnection();
        }
        catch (Exception e){
            alert.errorMessage("Please Enter the City Correct");
        }

        try {
            String jsonData = Api.setApiKey();

            ObjectMapper objectMapper = new ObjectMapper();
            WeatherData weatherData = objectMapper.readValue(jsonData, WeatherData.class);
            db.insert(weatherData);
            //db.avg("temp",5,"coimbatore");
            db.currentStatus("temp");
            String l = String.valueOf(db.tempreturre_min()+" k");
           temp_min.setText(l);
           temp_max.setText(String.valueOf(db.tempreturre_max())+ " K");
           humidity.setText(String.valueOf(db.humidity()));
            name_descrip.setText(String.valueOf(db.weather_descriptions()));
            cur_loc.setText(String.valueOf( db.cur_locs()));
            ArrayList<Float> pastdays= new ArrayList<>(db.pastfivedays());
            ArrayList<Float> pastdaysmin= new ArrayList<>(db.mindata());
            for (Float i : pastdays){
                System.out.println(i);
            }
            max_temp5.setText(String.valueOf(pastdays.get(5)));
            max_temp4.setText(String.valueOf(pastdays.get(4)));
            max_temp3.setText(String.valueOf(pastdays.get(3)));
            max_temp2.setText(String.valueOf(pastdays.get(2)));
            max_temp1.setText(String.valueOf(pastdays.get(1)));

            min_temp5.setText(String.valueOf(pastdays.get(5)));
            min_temp4.setText(String.valueOf(pastdays.get(4)));
            min_temp3.setText(String.valueOf(pastdays.get(3)));
            min_temp2.setText(String.valueOf(pastdays.get(2)));
            min_temp1.setText(String.valueOf(pastdays.get(1)));

            ArrayList <String> date =new ArrayList<>(db.date());

            date_1.setText(String.valueOf(date.get(5)));
            date_2.setText(String.valueOf(date.get(4)));
            date_3.setText(String.valueOf(date.get(3)));
            date_4.setText(String.valueOf(date.get(2)));

            for (String i : date){
                System.out.println(i);
            }



            // Now you can use the Weather
            // herData object
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getResult(ActionEvent event) throws SQLException {
        String  loc = null;
        int no_day = 0;
        try {
            loc =enter_loc.getText();
            System.out.print(loc);
             no_day = Integer.parseInt(user_pref.getText());
        }catch (Exception E){
            alert.errorMessage("Input is Wrong");
            return ;
        }
        System.out.print(no_day);
        ApiConnection Api = null;
        try {
            Api = new ApiConnection();
            databaseConnection db = new databaseConnection();
            String avg= String.valueOf(db.avg("temp",no_day,loc));

            if(avg!="0.0"){
                name_descrip1.setText(String.valueOf(avg+" k"));
            }
            else{
                name_descrip1.setText("Retry");
                alert.errorMessage("Please Enter the City Correct");
            }
        }
        catch (Exception e){
            alert.errorMessage("Please Enter the City Correct");
        }


    }
}

