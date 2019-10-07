package lamarrulla.com.SEMAFOROV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lamarrulla.com.DataBase.DbAcces;
import lamarrulla.com.Model.tbDatosGeneraRutas;
import lamarrulla.com.Model.tbPasos;
import lamarrulla.com.Model.tbRutas;
import lamarrulla.com.Model.tbUsuarios;

public class Inserts {

	JsonObject jso;
	int id;
	boolean ultimoRegistro;
	DbAcces dbAcces = new DbAcces();
	List<tbRutas> listTbRutas;
	List<tbDatosGeneraRutas> listDatosGeneraRutas;
	List<tbPasos> listPasos;
	FileWriter csvWriter;
	BufferedWriter bw = null;

	public boolean isUltimoRegistro() {
		return ultimoRegistro;
	}

	public void setUltimoRegistro(boolean ultimoRegistro) {
		this.ultimoRegistro = ultimoRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<tbPasos> getListPasos() {
		return listPasos;
	}

	public void setListPasos(List<tbPasos> listPasos) {
		this.listPasos = listPasos;
	}

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
			if (rs != null) {
				boolean isL = false;
				while (!isL) {
					tbDatosGeneraRutas dgr = new tbDatosGeneraRutas(rs.getString(2),
							rs.getBigDecimal(3).setScale(7, RoundingMode.HALF_UP),
							rs.getBigDecimal(4).setScale(14, RoundingMode.HALF_UP),
							rs.getBigDecimal(5).setScale(7, RoundingMode.HALF_UP),
							rs.getBigDecimal(6).setScale(14, RoundingMode.HALF_UP), rs.getString(7), rs.getString(8));
					listDatosGeneraRutas.add(dgr);
					if (rs.isLast()) {
						isL = true;
					} else {
						rs.next();
					}
					;
					// System.out.println();
				}
			}
			dbAcces.disconnectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectPasos() {
		try {
			listPasos = new ArrayList<tbPasos>();
			dbAcces.connectDatabase();
			dbAcces.setStrQuery("select * from tbPasos");
			dbAcces.execQry();
			ResultSet rs = dbAcces.getRs();
			if (rs.next() == false) { 
				System.out.println("ResultSet in empty in Java"); 
			} 
			else { 
				do { 
					tbPasos tp = new tbPasos(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3), 
							rs.getInt(4), 
							rs.getString(5), 
							rs.getInt(6), 
							rs.getBigDecimal(7), 
							rs.getBigDecimal(8), 
							rs.getBigDecimal(9), 
							rs.getBigDecimal(10), 
							rs.getString(11)
							);
					listPasos.add(tp); 
				} while (rs.next()); 
			}
			
//			if (rs != null) {
//				boolean isL = false;
//				while (!isL) {
//					tbPasos tp = new tbPasos(
//							rs.getInt(1),
//							rs.getInt(2),
//							rs.getString(3), 
//							rs.getInt(4), 
//							rs.getString(5), 
//							rs.getInt(6), 
//							rs.getBigDecimal(7), 
//							rs.getBigDecimal(8), 
//							rs.getBigDecimal(9), 
//							rs.getBigDecimal(10), 
//							rs.getString(11)
//							);
//					listPasos.add(tp);
//					if (rs.isLast()) {
//						isL = true;
//					} else {
//						rs.next();
//					}
//				}
//			}
		} catch (Exception ex) {
			System.out.println("error select pasos: " + ex.getMessage());
		}
	}

	public void selectRutas() {
		try {
			listTbRutas = new ArrayList<tbRutas>();
			dbAcces.connectDatabase();
			dbAcces.setStrQuery("select * from tbrutas");
			dbAcces.execQry();
			ResultSet rs = dbAcces.getRs();
			if (rs != null) {
				while (rs.next()) {
					tbRutas tbruta = new tbRutas(rs.getString(2), 
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
					// System.out.println();
				}
			}
			dbAcces.disconnectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardaCSVUsuarios() {
		try {
			if(jso.has("users")) {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now)); 

				JsonArray jsaUsers = jso.get("users").getAsJsonArray();		
				for(JsonElement jUser: jsaUsers) {
					JsonObject jsoUser = jUser.getAsJsonObject();
					JsonObject latlng =  jsoUser.get("location").getAsJsonObject();
					
					bw = new BufferedWriter(new FileWriter("SEMAFOROV.csv", true));
					bw.write(String.valueOf(id));
					bw.write(",");
					bw.write(jsoUser.get("fleet").getAsString());
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("magvar").getAsInt()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("inscale").getAsBoolean()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("mood").getAsInt()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("addon").getAsInt()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("ping").getAsInt()));
					bw.write(",");
					bw.write(String.valueOf(latlng.get("x").getAsBigDecimal()));
					bw.write(",");
					bw.write(String.valueOf(latlng.get("y").getAsBigDecimal()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("id").getAsString()));
					bw.write(",");
					bw.write(jsoUser.get("userName").getAsString());
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("speed").getAsBigDecimal()));
					bw.write(",");
					bw.write(String.valueOf(jsoUser.get("ingroup").getAsBoolean()));
					bw.newLine();
					bw.flush();
					
//						csvWriter.append(String.valueOf(id));
//						csvWriter.append(",");
//						csvWriter.append(jsoUser.get("fleet").getAsString());
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("magvar").getAsInt()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("inscale").getAsBoolean()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("mood").getAsInt()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("addon").getAsInt()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("ping").getAsInt()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(latlng.get("x").getAsBigDecimal()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(latlng.get("y").getAsBigDecimal()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("id").getAsString()));
//						csvWriter.append(",");
//						csvWriter.append(jsoUser.get("userName").getAsString());
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("speed").getAsBigDecimal()));
//						csvWriter.append(",");
//						csvWriter.append(String.valueOf(jsoUser.get("ingroup").getAsBoolean()));
//						csvWriter.append("\n");
									
				}
				//csvWriter.flush();
				if(ultimoRegistro) {
					//csvWriter.close();
					bw.close();
				}				
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void insertUsuarios() {
		if(jso.has("users")) {
			//System.out.println(jso.toString());
			//JsonObject jsoWaze = new JsonParser().parse(jso).getAsJsonObject();
			String qryAll = "";
			JsonArray jsaUsers = jso.get("users").getAsJsonArray();		
			for(JsonElement jUser: jsaUsers) {
				JsonObject jsoUser = jUser.getAsJsonObject();
				JsonObject latlng =  jsoUser.get("location").getAsJsonObject();
				tbUsuarios tu = new tbUsuarios();
				tu.setFiIdPaso(id); // validar id paso
				tu.setFcFleet(jsoUser.get("fleet").getAsString());
				tu.setFiMagvar(jsoUser.get("magvar").getAsInt());
				tu.setFnInscale(jsoUser.get("inscale").getAsBoolean());
				tu.setFiMod(jsoUser.get("mood").getAsInt());
				tu.setFiAddon(jsoUser.get("addon").getAsInt());
				tu.setFiPing(jsoUser.get("ping").getAsInt());
				tu.setFdoLocationLat(latlng.get("x").getAsBigDecimal());
				tu.setFdoLocationLng(latlng.get("y").getAsBigDecimal());
				tu.setFcId(jsoUser.get("id").getAsString());
				tu.setFcUserName(jsoUser.get("userName").getAsString());
				tu.setFdoSpeed(jsoUser.get("speed").getAsBigDecimal());
				tu.setFnIngroup(jsoUser.get("ingroup").getAsBoolean());
				tu.tbUsuariosInsert();
				qryAll += tu.getQryStringInsert();
				//System.out.println(tu.getQryStringInsert());
				
				//System.out.println(jsoUser.get("id").getAsString() + "|" + jsoUser.get("speed").getAsString() + "|" + latlng.get("x").toString() + "|" + latlng.get("y").getAsString());
				//tbUsuarios tbusuarios = new tbUsuarios();
			}
			System.out.println(qryAll);
			dbAcces.connectDatabase();
			dbAcces.setStrQuery(qryAll);
			dbAcces.execQry();
			dbAcces.disconnectDatabase();
		}
	}

	public void insertRutas() {

		/* prepara rutas */

		if (jso.has("routes")) {
			JsonArray jsaRoutes = jso.getAsJsonArray("routes");
			JsonObject jsoRoutes = (JsonObject) jsaRoutes.get(0);
			JsonObject jsoLegs = (JsonObject) jsoRoutes.getAsJsonArray("legs").get(0);
			JsonObject jsoDistance = jsoLegs.get("distance").getAsJsonObject();
			JsonObject jsoDuration = jsoLegs.get("duration").getAsJsonObject();
			JsonObject jsoEndLocation = jsoLegs.get("end_location").getAsJsonObject();
			JsonObject jsoStartLocation = jsoLegs.get("start_location").getAsJsonObject();
			/*
			 * tbRutas tbrutas = new tbRutas( jsoDistance.get("text").getAsString(),
			 * jsoDistance.get("value").getAsInt(), jsoDuration.get("text").getAsString(),
			 * jsoDuration.get("value").getAsInt(),
			 * jsoLegs.get("end_address").getAsString(),
			 * jsoEndLocation.get("lat").getAsDouble(),
			 * jsoEndLocation.get("lng").getAsDouble(),
			 * jsoLegs.get("start_address").getAsString(),
			 * jsoStartLocation.get("lat").getAsDouble(),
			 * jsoStartLocation.get("lng").getAsDouble());
			 */

			tbRutas tbrutas = new tbRutas();
			tbrutas.tbRutasInsert(jsoDistance.get("text").getAsString(), jsoDistance.get("value").getAsInt(),
					jsoDuration.get("text").getAsString(), jsoDuration.get("value").getAsInt(),
					jsoLegs.get("end_address").getAsString(), jsoEndLocation.get("lat").getAsDouble(),
					jsoEndLocation.get("lng").getAsDouble(), jsoLegs.get("start_address").getAsString(),
					jsoStartLocation.get("lat").getAsDouble(), jsoStartLocation.get("lng").getAsDouble());

			/* insert rutas */

			dbAcces.connectDatabase();
			dbAcces.setStrQuery(tbrutas.getQryInsert());
			dbAcces.execQry();
			id = dbAcces.getIdReturned();
			dbAcces.disconnectDatabase();

			/* insert rutas */

			/* prepara steps */

			JsonArray lsaSteps = jsoLegs.getAsJsonArray("steps");

			/* List<tbPasos> listTbPasos = new ArrayList<tbPasos>(); */

			for (JsonElement jStep : lsaSteps) {
				JsonObject jsoStep = jStep.getAsJsonObject();
				JsonObject jsoDistanceStep = jsoStep.get("distance").getAsJsonObject();
				JsonObject jsoDurationStep = jsoStep.get("duration").getAsJsonObject();
				JsonObject jsoEndLocationStep = jsoStep.getAsJsonObject().getAsJsonObject("end_location");
				JsonObject jsoStartLocationStep = jsoStep.getAsJsonObject().getAsJsonObject("start_location");

				tbPasos tbpasos = new tbPasos();
				tbpasos.tbPasosInsert(id, 
						jsoDistanceStep.get("text").getAsString(),
						jsoDistanceStep.get("value").getAsInt(), 
						jsoDurationStep.get("text").getAsString(),
						jsoDurationStep.get("value").getAsInt(), 
						jsoEndLocationStep.get("lat").getAsBigDecimal(),
						jsoEndLocationStep.get("lng").getAsBigDecimal(),
						jsoStartLocationStep.get("lat").getAsBigDecimal(),
						jsoStartLocationStep.get("lng").getAsBigDecimal(),
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