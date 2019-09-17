package lamarrulla.com.SEMAFOROV;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lamarrulla.com.SEMAFOROV.NetClientGet;
/**
 * Hello world!
 *
 */
public class App 
{	
	static NetClientGet netClientGet = new NetClientGet();
	static JsonObject jso = new JsonObject();
	static URL urlGlobal;
		
    public static void main( String[] args )
    {    	
    	try {
			URL url = new URL("https://maps.googleapis.com/maps/api/js/DirectionsService.Route?5m4&1m3&1m2&1d19.4950119&2d-99.11960449999998&5m4&1m3&1m2&1d19.2800339&2d-99.17037160000001&6e0&12ses-MX&23e1&callback=_xdc_._ft28bq&key=AIzaSyAndp8rBJEaJnxjKdLJV5rfxE8guaZH3Ic&token=106168");
			netClientGet.setUrl(url);
			netClientGet.getLocation();
			arreglaSalidaMaps(netClientGet.salida);
			JsonArray jsaRoutes = jso.getAsJsonArray("routes");		
			JsonObject jsoRoutes = (JsonObject) jsaRoutes.get(0);
			JsonObject jsoLegs = (JsonObject) jsoRoutes.getAsJsonArray("legs").get(0);
			JsonArray lsaSteps = jsoLegs.getAsJsonArray("steps");
			for(JsonElement jsoStep : lsaSteps) {
				JsonObject jsoStartLocation = jsoStep.getAsJsonObject().getAsJsonObject("start_location");
				JsonObject jsoEndLocation = jsoStep.getAsJsonObject().getAsJsonObject("end_location");
				//System.out.println(jsoStartLocation.toString());
				urlGlobal = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=" + jsoStartLocation.get("lat").getAsString() + "&left=" + jsoStartLocation.get("lng").getAsString() + "&ma=0&mj=0&mu=400&right=" + jsoEndLocation.get("lng").getAsString() + "&top=" + jsoEndLocation.get("lat").getAsString() + "&types=alerts%2Ctraffic%2Cusers");
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		    	executor.scheduleAtFixedRate(helloRunnable, 0, 60, TimeUnit.SECONDS);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    private static void arreglaSalidaMaps(String salida) {
		// TODO Auto-generated method stub
		salida = salida.replace("/**/_xdc_._ft28bq && _xdc_._ft28bq(", "")
			.replace("\\u003cb\\u003e", "");
		salida = salida.substring(0, salida.length()-1);
		jso = new JsonParser().parse(salida).getAsJsonObject();
		
	}
	static Runnable helloRunnable = new Runnable() {
	    public void run() {
	        //System.out.println("GetDatos");	   
	    	
			//URL url = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=19.51304459775636&left=-99.28868293762208&ma=0&mj=0&mu=400&right=-99.09092903137207&top=19.55468708780126&types=alerts%2Ctraffic%2Cusers");
			netClientGet.setUrl(urlGlobal);
			netClientGet.getLocation();
			//System.out.println(netClientGet.getJso().toString());
			//System.out.println(netClientGet.salida);	    		
			JsonObject jsoWaze = new JsonParser().parse(netClientGet.salida).getAsJsonObject();
			JsonArray jsaUsers = jsoWaze.get("users").getAsJsonArray();		
			for(JsonElement jUser: jsaUsers) {
				JsonObject jsoUser = jUser.getAsJsonObject();
				JsonObject latlng =  jsoUser.get("location").getAsJsonObject();
				System.out.println(jsoUser.get("id").getAsString() + "|" + jsoUser.get("speed").getAsString() + "|" + latlng.get("x").toString() + "|" + latlng.get("y").getAsString());
			}
			
	    }
	};
}