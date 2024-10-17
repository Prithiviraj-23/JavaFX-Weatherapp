
# Weather Application - JavaFX

This is a JavaFX-based weather application that fetches weather information based on the user's location using IP and stores the historical weather data in a MySQL database. The application retrieves the weather data for the past five days using the OpenWeather API and presents it to the user.

## Features
- Fetches the user's location based on their IP address.
- Retrieves weather data (temperature, humidity, wind speed, etc.) for the past 5 days using the OpenWeather API.
- Stores the historical weather data in a MySQL database for future reference.
- Displays weather information using a simple and clean JavaFX interface designed with Java Scene Builder.

## Tools & Technologies Used
- **JavaFX**: For building the user interface.
- **Java Scene Builder**: For creating and designing the GUI.
- **MySQL**: For storing historical weather data.
- **OpenWeather API**: For fetching weather data.
- **IP-based Location Service**: For identifying the user's location based on their IP address.

## Setup Instructions

### Prerequisites
- Java 11 or higher
- JavaFX SDK
- MySQL Server
- OpenWeather API Key (Get one from [OpenWeather](https://openweathermap.org/))
- Maven (for managing dependencies)
- Java Scene Builder (optional but recommended for designing the GUI)
- Intellij (***recommended***)


### Getting Started

1. **Clone the Repository :**
   ```bash
   git clone https://github.com/YourUsername/WeatherApp.git
   ```
2. **Change Drictory :**
   ```
   cd WeatherApp 
   ```
 3. ****Install Dependencies :****
     ```
      mvn clean install
      ```
 4. **Run the Project :**
     ```
    mvn javafx:run
    ```

 
   
