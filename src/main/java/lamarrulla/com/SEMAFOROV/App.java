package lamarrulla.com.SEMAFOROV;

import java.io.IOException;
import java.net.URL;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import lamarrulla.com.APIRest.API;
import lamarrulla.com.Utils.ValidaGcloudAcces;
/**
 * Hello world!
 *
 */
public class App 
{	
	static API api = new API();
//	static JsonObject jso = new JsonObject();
	static URL urlGlobal;
//	static String P1Latitude = "19.4950119";
//	static String P1Longitude = "-99.11960449999998";
//	static String P2Latitude = "19.2800339";
//	static String P2Longitude = "-99.17037160000001";
//	static String yEk = "AIzaSyDkeEm6iunIM2P4qFZbYmxaxhItMUsY_h0";
		
	static ValidaGcloudAcces vgca = new ValidaGcloudAcces();
	static SaveRutasPasos srp = new SaveRutasPasos();
	
    public static void main( String[] args )
    {       	 
    	
    	// Instantiates a client
        //Storage storage = StorageOptions.getDefaultInstance().getService();

        // The name for the new bucket
        //String bucketName = args[0];  // "my-new-bucket";

        // Creates the new bucket
        //Bucket bucket = storage.create(BucketInfo.of(bucketName));

        //System.out.printf("Bucket %s created.%n", bucket.getName());
    	
    	try {
			vgca.authExplicit("C:\\Users\\daver\\Documents\\cuentasServicioGCLOUD\\semaforov-258100-7aa9fbe26f59.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	srp.generaDatosForRutas();
    	srp.generaDatosForUsers();
    	
//    	try {    		
//			//URL url = new URL("https://maps.googleapis.com/maps/api/js/DirectionsService.Route?5m4&1m3&1m2&1d19.4950119&2d-99.11960449999998&5m4&1m3&1m2&1d19.2800339&2d-99.17037160000001&6e0&12ses-MX&23e1&callback=_xdc_._ft28bq&key=AIzaSyAndp8rBJEaJnxjKdLJV5rfxE8guaZH3Ic&token=106168");
//			URL url = new URL("https://maps.googleapis.com/maps/api/js/DirectionsService.Route?5m4&1m3&1m2&1d" + P1Latitude + "&2d" + P1Longitude + "&5m4&1m3&1m2&1d" + P2Latitude + "&2d" + P2Longitude + "&6e0&12ses-MX&23e1&callback=_xdc_._ft28bq&key=" + yEk + "&token=9160");
//			api.setUrl(url);
//			api.get();
//			arreglaSalidaMaps(api.getSalida());
//			if(jso.has("routes")) {
//				JsonArray jsaRoutes = jso.getAsJsonArray("routes");		
//				JsonObject jsoRoutes = (JsonObject) jsaRoutes.get(0);
//				JsonObject jsoLegs = (JsonObject) jsoRoutes.getAsJsonArray("legs").get(0);
//				JsonArray lsaSteps = jsoLegs.getAsJsonArray("steps");
//				for(JsonElement jsoStep : lsaSteps) {
//					JsonObject jsoStartLocation = jsoStep.getAsJsonObject().getAsJsonObject("start_location");
//					JsonObject jsoEndLocation = jsoStep.getAsJsonObject().getAsJsonObject("end_location");
//					//System.out.println(jsoStartLocation.toString());
//					urlGlobal = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=" + jsoStartLocation.get("lat").getAsString() + "&left=" + jsoStartLocation.get("lng").getAsString() + "&ma=0&mj=0&mu=400&right=" + jsoEndLocation.get("lng").getAsString() + "&top=" + jsoEndLocation.get("lat").getAsString() + "&types=alerts%2Ctraffic%2Cusers");
//					ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//			    	executor.scheduleAtFixedRate(helloRunnable, 0, 60, TimeUnit.SECONDS);
//				}
//			}			
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}    	
    }
    
//    private static void arreglaSalidaMaps(String salida) {
//		// TODO Auto-generated method stub
//    	if(salida.length()>0) {
//    		salida = salida.replace("/**/_xdc_._ft28bq && _xdc_._ft28bq(", "")
//    				.replace("\\u003cb\\u003e", "");
//    			salida = salida.substring(0, salida.length()-1);
//    			jso = new JsonParser().parse(salida).getAsJsonObject();
//    			System.out.println(jso.toString());
//    			Inserts ins = new Inserts();
//    			ins.setJso(jso);
//    			ins.InsertRutas();
//    	}
//	}
    
	static Runnable helloRunnable = new Runnable() {
	    public void run() {
	        //System.out.println("GetDatos");	   
	    	
			//URL url = new URL("https://www.waze.com/row-rtserver/web/TGeoRSS?bottom=19.51304459775636&left=-99.28868293762208&ma=0&mj=0&mu=400&right=-99.09092903137207&top=19.55468708780126&types=alerts%2Ctraffic%2Cusers");
//			api.setUrl(urlGlobal);
//			api.get();
			//System.out.println(netClientGet.getJso().toString());
			//System.out.println(netClientGet.salida);	    		
//			JsonObject jsoWaze = new JsonParser().parse(api.getSalida()).getAsJsonObject();
//			JsonArray jsaUsers = jsoWaze.get("users").getAsJsonArray();		
//			for(JsonElement jUser: jsaUsers) {
//				JsonObject jsoUser = jUser.getAsJsonObject();
//				JsonObject latlng =  jsoUser.get("location").getAsJsonObject();
//				System.out.println(jsoUser.get("id").getAsString() + "|" + jsoUser.get("speed").getAsString() + "|" + latlng.get("x").toString() + "|" + latlng.get("y").getAsString());
//			}
			
	    }
	};
}