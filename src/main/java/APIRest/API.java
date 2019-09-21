package APIRest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;

public class API {
	JsonObject jso;
	String salida="";
	URL url;
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public JsonObject getJso() {
		return jso;
	}
	public void setJso(JsonObject jso) {
		this.jso = jso;
	}
	
	public void get() {
        try {        	
            //URL url = new URL("https://maps.googleapis.com/maps/api/js/DirectionsService.Route?5m4&1m3&1m2&1d19.4950119&2d-99.11960449999998&5m4&1m3&1m2&1d19.2800339&2d-99.17037160000001&6e0&12ses-MX&23e1&callback=_xdc_._ft28bq&key=AIzaSyAndp8rBJEaJnxjKdLJV5rfxE8guaZH3Ic&token=106168");//your url i.e fetch data from .
            //URL url = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=19.51304459775636&left=-99.28868293762208&ma=0&mj=0&mu=400&right=-99.09092903137207&top=19.55468708780126&types=alerts%2Ctraffic%2Cusers");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Referer", "https://www.waze.com/es/livemap?utm_source=waze_website&utm_campaign=waze_website");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output= "";
            salida = "";
            while ((output = br.readLine()) != null) {            	
            	salida += output;          
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}
