package lamarrulla.com.SEMAFOROV;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lamarrulla.com.Model.tbPasos;
import lamarrulla.com.Model.tbRutas;

public class Inserts {
	
	JsonObject jso;
	int id;
	
	public JsonObject getJso() {
		return jso;
	}

	public void setJso(JsonObject jso) {
		this.jso = jso;
	}

	public void InsertRutas() {
		
		/*	prepara rutas	*/
		
		if(jso.has("routes")) {
			JsonArray jsaRoutes = jso.getAsJsonArray("routes");		
			JsonObject jsoRoutes = (JsonObject) jsaRoutes.get(0);
			JsonObject jsoLegs = (JsonObject) jsoRoutes.getAsJsonArray("legs").get(0);
			JsonObject jsoDistance = jsoLegs.get("distance").getAsJsonObject();
			JsonObject jsoDuration = jsoLegs.get("duration").getAsJsonObject();
			JsonObject jsoEndLocation = jsoLegs.get("end_location").getAsJsonObject();
			JsonObject jsoStartLocation = jsoLegs.get("start_location").getAsJsonObject();
			/*tbRutas tbrutas = new tbRutas(
					jsoDistance.get("text").getAsString(), 
					jsoDistance.get("value").getAsInt(), 
					jsoDuration.get("text").getAsString(), 
					jsoDuration.get("value").getAsInt(), 
					jsoLegs.get("end_address").getAsString(), 
					jsoEndLocation.get("lat").getAsDouble(), 
					jsoEndLocation.get("lng").getAsDouble(), 
					jsoLegs.get("start_address").getAsString(), 
					jsoStartLocation.get("lat").getAsDouble(), 
					jsoStartLocation.get("lng").getAsDouble());*/
			
			tbRutas tbrutas = new tbRutas();
			tbrutas.tbRutasInsert(jsoDistance.get("text").getAsString(), 
					jsoDistance.get("value").getAsInt(), 
					jsoDuration.get("text").getAsString(), 
					jsoDuration.get("value").getAsInt(), 
					jsoLegs.get("end_address").getAsString(), 
					jsoEndLocation.get("lat").getAsDouble(), 
					jsoEndLocation.get("lng").getAsDouble(), 
					jsoLegs.get("start_address").getAsString(), 
					jsoStartLocation.get("lat").getAsDouble(), 
					jsoStartLocation.get("lng").getAsDouble());						
			
			/*	insert rutas	*/
			
			DbAcces dbAcces = new DbAcces();
    		dbAcces.connectDatabase();
    		dbAcces.setStrQuery(tbrutas.getQryInsert());
    		dbAcces.Insert();
    		id = dbAcces.getIdReturned();
    		dbAcces.disconnectDatabase();
    		
    		/*	insert rutas	*/
    		
    		/*	prepara steps	*/
    		
    		JsonArray lsaSteps = jsoLegs.getAsJsonArray("steps");
			
			/* List<tbPasos> listTbPasos = new ArrayList<tbPasos>(); */
			
			for(JsonElement jStep : lsaSteps) {
				JsonObject jsoStep = jStep.getAsJsonObject();
				JsonObject jsoDistanceStep = jsoStep.get("distance").getAsJsonObject();
				JsonObject jsoDurationStep = jsoStep.get("duration").getAsJsonObject();
				JsonObject jsoEndLocationStep = jsoStep.getAsJsonObject().getAsJsonObject("end_location");
				JsonObject jsoStartLocationStep = jsoStep.getAsJsonObject().getAsJsonObject("start_location");
				
				tbPasos tbpasos = new tbPasos();
				tbpasos.tbPasosInsert(
						id,
						jsoDistanceStep.get("text").getAsString(), 
						jsoDistanceStep.get("value").getAsInt(), 
						jsoDurationStep.get("text").getAsString(), 
						jsoDurationStep.get("value").getAsInt(), 
						jsoEndLocationStep.get("lat").getAsDouble(),
						jsoEndLocationStep.get("lng").getAsDouble(),
						jsoStartLocationStep.get("lat").getAsDouble(),
						jsoStartLocationStep.get("lng").getAsDouble(), 
						jsoStep.get("polyline").getAsJsonObject().get("points").getAsString());
								
	    		dbAcces.connectDatabase();
	    		dbAcces.setStrQuery(tbpasos.getQryStringInsert());
	    		dbAcces.Insert();
	    		dbAcces.disconnectDatabase();
				
				/*
				 * tbPasos tbpasos = new tbPasos( jsoDistanceStep.get("text").getAsString(),
				 * jsoDistanceStep.get("value").getAsInt(),
				 * jsoDurationStep.get("text").getAsString(),
				 * jsoDurationStep.get("value").getAsInt(),
				 * jsoEndLocationStep.get("lat").getAsDouble(),
				 * jsoEndLocationStep.get("lng").getAsDouble(),
				 * jsoStartLocationStep.get("lat").getAsDouble(),
				 * jsoStartLocationStep.get("lng").getAsDouble(),
				 * jsoStep.get("polyline").getAsJsonObject().get("points").getAsString());
				 * 
				 * listTbPasos.add(tbpasos);
				 */
			  System.out.println(jsoStartLocation.toString()); 
			}			 
		}
	}
}