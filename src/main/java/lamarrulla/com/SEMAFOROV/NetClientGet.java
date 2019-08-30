package lamarrulla.com.SEMAFOROV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetClientGet {	
	public void getLocation() {
        try {
            URL url = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=19.51304459775636&left=-99.28868293762208&ma=0&mj=0&mu=400&right=-99.09092903137207&top=19.55468708780126&types=alerts%2Ctraffic%2Cusers");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Referer", " https://www.waze.com/es/livemap?utm_source=waze_website&utm_campaign=waze_website");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}
