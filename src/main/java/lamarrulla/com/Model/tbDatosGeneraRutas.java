package lamarrulla.com.Model;

public class tbDatosGeneraRutas {
	
	public String getFcDescDatosGeneraRutas() {
		return fcDescDatosGeneraRutas;
	}

	public void setFcDescDatosGeneraRutas(String fcDescDatosGeneraRutas) {
		this.fcDescDatosGeneraRutas = fcDescDatosGeneraRutas;
	}

	public double getFdoEndLocationLat() {
		return fdoEndLocationLat;
	}

	public void setFdoEndLocationLat(double fdoEndLocationLat) {
		this.fdoEndLocationLat = fdoEndLocationLat;
	}

	public double getFdoEndLocationLng() {
		return fdoEndLocationLng;
	}

	public void setFdoEndLocationLng(double fdoEndLocationLng) {
		this.fdoEndLocationLng = fdoEndLocationLng;
	}

	public double getFdoStartLocationLat() {
		return fdoStartLocationLat;
	}

	public void setFdoStartLocationLat(double fdoStartLocationLat) {
		this.fdoStartLocationLat = fdoStartLocationLat;
	}

	public double getFdoStartLocationLng() {
		return fdoStartLocationLng;
	}

	public void setFdoStartLocationLng(double fdoStartLocationLng) {
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
	private double fdoEndLocationLat;
	private double fdoEndLocationLng;
	private double fdoStartLocationLat;
	private double fdoStartLocationLng;
	private String fcYek;
	private String fcToken;
	
	public tbDatosGeneraRutas() {}
	
	public tbDatosGeneraRutas(String fcDescDatosGeneraRutas, double fdoEndLocationLat, double fdoEndLocationLng, 
			double fdoStartLocationLat,
			double fdoStartLocationLng,
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