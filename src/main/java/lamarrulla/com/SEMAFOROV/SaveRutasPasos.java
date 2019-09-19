package lamarrulla.com.SEMAFOROV;

import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import APIRest.API;

public class SaveRutasPasos {
	static API api = new API();
	
	static JsonObject jso = new JsonObject();
	static String P1Latitude = "19.4950119";
	static String P1Longitude = "-99.11960449999998";
	static String P2Latitude = "19.2800339";
	static String P2Longitude = "-99.17037160000001";
	static String yEk = "AIzaSyDkeEm6iunIM2P4qFZbYmxaxhItMUsY_h0";
	static String Token = "9160";
	
	public void SaveRutas() {
		
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/js/DirectionsService.Route?5m4&1m3&1m2&1d" + P1Latitude + "&2d" + P1Longitude + "&5m4&1m3&1m2&1d" + P2Latitude + "&2d" + P2Longitude + "&6e0&12ses-MX&23e1&callback=_xdc_._ft28bq&key=" + yEk + "&token=" + Token);
			api.setUrl(url);
			api.get();
			arreglaSalidaMaps(api.getSalida());
			/*
			 * if(jso.has("routes")) { JsonArray jsaRoutes = jso.getAsJsonArray("routes");
			 * JsonObject jsoRoutes = (JsonObject) jsaRoutes.get(0); JsonObject jsoLegs =
			 * (JsonObject) jsoRoutes.getAsJsonArray("legs").get(0); JsonArray lsaSteps =
			 * jsoLegs.getAsJsonArray("steps"); for(JsonElement jsoStep : lsaSteps) {
			 * JsonObject jsoStartLocation =
			 * jsoStep.getAsJsonObject().getAsJsonObject("start_location"); JsonObject
			 * jsoEndLocation = jsoStep.getAsJsonObject().getAsJsonObject("end_location");
			 * //System.out.println(jsoStartLocation.toString()); urlGlobal = new
			 * URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=" +
			 * jsoStartLocation.get("lat").getAsString() + "&left=" +
			 * jsoStartLocation.get("lng").getAsString() + "&ma=0&mj=0&mu=400&right=" +
			 * jsoEndLocation.get("lng").getAsString() + "&top=" +
			 * jsoEndLocation.get("lat").getAsString() + "&types=alerts%2Ctraffic%2Cusers");
			 * ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			 * executor.scheduleAtFixedRate(helloRunnable, 0, 60, TimeUnit.SECONDS); } }
			 */
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	} 
	
	private static void arreglaSalidaMaps(String salida) {
		// TODO Auto-generated method stub
    	if(salida.length()>0) {
    		salida = salida.replace("/**/_xdc_._ft28bq && _xdc_._ft28bq(", "")
    				.replace("\\u003cb\\u003e", "");
    			salida = salida.substring(0, salida.length()-1);
    			jso = new JsonParser().parse(salida).getAsJsonObject();
    			System.out.println(jso.toString());
    			Inserts ins = new Inserts();
    			ins.setJso(jso);
    			ins.InsertRutas();
    	}
	}
}