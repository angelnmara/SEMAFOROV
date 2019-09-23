package lamarrulla.com.Model;

import java.math.BigDecimal;

public class tbUsuarios {
	
	
	
	public int getFiIdUsuario() {
		return fiIdUsuario;
	}
	public void setFiIdUsuario(int fiIdUsuario) {
		this.fiIdUsuario = fiIdUsuario;
	}
	public int getFiIdPaso() {
		return fiIdPaso;
	}
	public void setFiIdPaso(int fiIdPaso) {
		this.fiIdPaso = fiIdPaso;
	}
	public String getFcFleet() {
		return fcFleet;
	}
	public void setFcFleet(String fcFleet) {
		this.fcFleet = fcFleet;
	}
	public int getFiMagvar() {
		return fiMagvar;
	}
	public void setFiMagvar(int fiMagvar) {
		this.fiMagvar = fiMagvar;
	}
	public boolean isFnInscale() {
		return fnInscale;
	}
	public void setFnInscale(boolean fnInscale) {
		this.fnInscale = fnInscale;
	}
	public int getFiMod() {
		return fiMod;
	}
	public void setFiMod(int fiMod) {
		this.fiMod = fiMod;
	}
	public int getFiAddon() {
		return fiAddon;
	}
	public void setFiAddon(int fiAddon) {
		this.fiAddon = fiAddon;
	}
	public int getFiPing() {
		return fiPing;
	}
	public void setFiPing(int fiPing) {
		this.fiPing = fiPing;
	}
	public BigDecimal getFdoLocationLat() {
		return fdoLocationLat;
	}
	public void setFdoLocationLat(BigDecimal fdoLocationLat) {
		this.fdoLocationLat = fdoLocationLat;
	}
	public BigDecimal getFdoLocationLng() {
		return fdoLocationLng;
	}
	public void setFdoLocationLng(BigDecimal fdoLocationLng) {
		this.fdoLocationLng = fdoLocationLng;
	}
	public String getFcId() {
		return fcId;
	}
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}
	public String getFcUserName() {
		return fcUserName;
	}
	public void setFcUserName(String fcUserName) {
		this.fcUserName = fcUserName;
	}
	public BigDecimal getFdoSpeed() {
		return fdoSpeed;
	}
	public void setFdoSpeed(BigDecimal fdoSpeed) {
		this.fdoSpeed = fdoSpeed;
	}
	public boolean isFnIngroup() {
		return fnIngroup;
	}
	public void setFnIngroup(boolean fnIngroup) {
		this.fnIngroup = fnIngroup;
	}	
	
	public String getQryStringInsert() {
		return qryStringInsert;
	}
	public void setQryStringInsert(String qryStringInsert) {
		this.qryStringInsert = qryStringInsert;
	}

	private int fiIdUsuario;
	private int fiIdPaso;
	private String fcFleet;
	private int fiMagvar;
	private boolean fnInscale;
	private int fiMod;
	private int fiAddon;
	private int fiPing;
	private BigDecimal fdoLocationLat;
	private BigDecimal fdoLocationLng;
	private String fcId;
	private String fcUserName;
	private BigDecimal fdoSpeed;
	private boolean fnIngroup;
	private String qryStringInsert;
	
	public tbUsuarios() {}
	public tbUsuarios(int fiIdUsuario, 
			int fiIdPaso, 
			String fcFleet, 
			int fiMagvar,
			boolean fnInscale, 
			int fiMod, 
			int fiAddon, 
			int fiPing, 
			BigDecimal fdoLocationLat,
			BigDecimal fdoLocationLng, 
			String fcId, 
			String fcUserName, 
			BigDecimal fdoSpeed,
			boolean fnIngroup) {
		this.fiIdUsuario = fiIdUsuario;
		this.fiIdPaso = fiIdPaso;
		this.fcFleet =fcFleet;
		this.fiMagvar = fiMagvar;
		this.fnInscale = fnInscale;
		this.fiMod = fiMod;
		this.fiAddon = fiAddon;
		this.fiPing = fiPing;
		this.fdoLocationLat = fdoLocationLat;
		this.fdoLocationLng = fdoLocationLng;
		this.fcId = fcId;
		this.fcUserName = fcUserName;
		this.fdoSpeed = fdoSpeed;
		this.fnIngroup = fnIngroup;
	}
	public void tbUsuariosInsert() {
		qryStringInsert = String.format("insert into tbUsuarios(fiIdPaso,fcFleet,fiMagvar,fnInscale,fiMod,fiAddon,fiPing,fdoLocationLat,fdoLocationLng,fcId,fcUserName,fdoSpeed,fnIngroup) values (%d,'%s',%d,%s,%d,%d,%d,%f,%f,'%s','%s',%f,%s);", 				
				fiIdPaso,
				fcFleet,
				fiMagvar,
				fnInscale,
				fiMod,
				fiAddon,
				fiPing,
				fdoLocationLat,
				fdoLocationLng,
				fcId,
				fcUserName,
				fdoSpeed,
				fnIngroup);
	}
}
