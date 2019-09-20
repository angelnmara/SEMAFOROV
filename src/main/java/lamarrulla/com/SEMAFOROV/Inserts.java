package lamarrulla.com.SEMAFOROV;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import DataBase.DbAcces;
import lamarrulla.com.Model.tbDatosGeneraRutas;
import lamarrulla.com.Model.tbPasos;
import lamarrulla.com.Model.tbRutas;

public class Inserts {
	
	JsonObject jso;
	int id;
	DbAcces dbAcces = new DbAcces();
	List<tbRutas> listTbRutas;
	List<tbDatosGeneraRutas> listDatosGeneraRutas;
	
	public List<tbRutas> getListTbRutas() {
		return listTbRutas;
	}

	public void setListTbRutas(List<tbRutas> listTbRutas) {
		this.listTbRutas = listTbRutas;
	}

	public JsonObject getJso() {
		return jso;
	}

	public void setJso(JsonObject jso) {
		this.jso = jso;
	}
	
	public List<tbDatosGeneraRutas> getListDatosGeneraRutas() {
		return listDatosGeneraRutas;
	}

	public void setListDatosGeneraRutas(List<tbDatosGeneraRutas> listDatosGeneraRutas) {
		this.listDatosGeneraRutas = listDatosGeneraRutas;
	}

	public void selectGeneraDatosForRutas() {		
			try {
				listDatosGeneraRutas = new ArrayList<tbDatosGeneraRutas>(); 
				dbAcces.connectDatabase();
				dbAcces.setStrQuery("select * from tbDatosGeneraRutas");
				dbAcces.execQry();
				ResultSet rs = dbAcces.getRs();
				if(rs!=null) {
					boolean isL = false;
					while(!isL) {
						tbDatosGeneraRutas dgr = new tbDatosGeneraRutas(
								rs.getString(2), 
								rs.getBigDecimal(3).doubleValue(),
								rs.getBigDecimal(4).doubleValue(), 
								rs.getBigDecimal(5).doubleValue(), 
								rs.getBigDecimal(6).doubleValue(), 
								rs.getString(7), 
								rs.getString(8));
						listDatosGeneraRutas.add(dgr);
						if(rs.isLast()) {
							isL = true;
						}else{
							rs.next();
						};
						//System.out.println();
					}
				}				
				dbAcces.disconnectDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public void selectRutas() {
		try {
			listTbRutas = new ArrayList<tbRutas>();
			dbAcces.connectDatabase();
			dbAcces.setStrQuery("select * from tbrutas");
			dbAcces.execQry();
			ResultSet rs = dbAcces.getRs();
			if(rs!=null) {
				while(rs.next()) {
					tbRutas tbruta = new tbRutas(
							rs.getString(2), 
							rs.getInt(3), 
							rs.getString(4), 
							rs.getInt(5), 
							rs.getString(6), 
							rs.getDouble(7), 
							rs.getDouble(8), 
							rs.getString(9), 
							rs.getDouble(10), 
							rs.getDouble(11));
					listTbRutas.add(tbruta);
					//System.out.println();
				}
			}
			dbAcces.disconnectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

	public void insertRutas() {
		
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
						
    		dbAcces.connectDatabase();
    		dbAcces.setStrQuery(tbrutas.getQryInsert());
    		dbAcces.execQry();
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
	    		dbAcces.execQry();
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