import cn.com.webxml.*;

public class Main {
    public static void main(String[] args) {
        WeatherWebService ws = new WeatherWebService();
        WeatherWebServiceSoap wss = ws.getWeatherWebServiceSoap();

        ArrayOfString arr = wss.getWeatherbyCityName("青岛");
        if(arr != null){
            for(String msg:arr.getString()){
                System.out.println(msg);
            }
        }
    }
}
