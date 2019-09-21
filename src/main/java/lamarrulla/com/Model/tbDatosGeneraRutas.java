package lamarrulla.com.Model;

import java.math.BigDecimal;

public class tbDatosGeneraRutas {	

	public String getFcDescDatosGeneraRutas() {
		return fcDescDatosGeneraRutas;
	}

	public void setFcDescDatosGeneraRutas(String fcDescDatosGeneraRutas) {
		this.fcDescDatosGeneraRutas = fcDescDatosGeneraRutas;
	}

	public BigDecimal getFdoEndLocationLat() {
		return fdoEndLocationLat;
	}

	public void setFdoEndLocationLat(BigDecimal fdoEndLocationLat) {
		this.fdoEndLocationLat = fdoEndLocationLat;
	}

	public BigDecimal getFdoEndLocationLng() {
		return fdoEndLocationLng;
	}

	public void setFdoEndLocationLng(BigDecimal fdoEndLocationLng) {
		this.fdoEndLocationLng = fdoEndLocationLng;
	}

	public BigDecimal getFdoStartLocationLat() {
		return fdoStartLocationLat;
	}

	public void setFdoStartLocationLat(BigDecimal fdoStartLocationLat) {
		this.fdoStartLocationLat = fdoStartLocationLat;
	}

	public BigDecimal getFdoStartLocationLng() {
		return fdoStartLocationLng;
	}

	public void setFdoStartLocationLng(BigDecimal fdoStartLocationLng) {
		this.fdoStartLocationLng = fdoStartLocationLng;
	}

	public String getFcYek() {
		return fcYek;
	}

	public void setFcYek(String fcYek) {
		this.fcYek = fcYek;
	}

	public String getFcToken() {
		return fcToken;
	}

	public void setFcToken(String fcToken) {
		this.fcToken = fcToken;
	}

	private String fcDescDatosGeneraRutas;
	private BigDecimal fdoEndLocationLat;
	private BigDecimal fdoEndLocationLng;
	private BigDecimal fdoStartLocationLat;
	private BigDecimal fdoStartLocationLng;
	private String fcYek;
	private String fcToken;
	
	public tbDatosGeneraRutas() {}
	
	public tbDatosGeneraRutas(String fcDescDatosGeneraRutas, BigDecimal fdoEndLocationLat, BigDecimal fdoEndLocationLng, 
			BigDecimal fdoStartLocationLat,
			BigDecimal fdoStartLocationLng,
			String fcYek,
			String fcToken) {
		this.fcDescDatosGeneraRutas = fcDescDatosGeneraRutas;
		this.fdoEndLocationLat = fdoEndLocationLat;
		this.fdoEndLocationLng = fdoEndLocationLng;
		this.fdoStartLocationLat = fdoStartLocationLat;
		this.fdoStartLocationLng = fdoStartLocationLng;
		this.fcYek = fcYek;
		this.fcToken = fcToken;
	}
	
}