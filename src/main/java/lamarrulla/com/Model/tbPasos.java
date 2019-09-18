package lamarrulla.com.Model;

public class tbPasos {
	
	public String getFcDistancia() {
		return fcDistancia;
	}

	public void setFcDistancia(String fcDistancia) {
		this.fcDistancia = fcDistancia;
	}

	public int getFiDistancia() {
		return fiDistancia;
	}

	public void setFiDistancia(int fiDistancia) {
		this.fiDistancia = fiDistancia;
	}

	public String getFcDuracion() {
		return fcDuracion;
	}

	public void setFcDuracion(String fcDuracion) {
		this.fcDuracion = fcDuracion;
	}

	public int getFiDuracion() {
		return fiDuracion;
	}

	public void setFiDuracion(int fiDuracion) {
		this.fiDuracion = fiDuracion;
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

	public String getFcPolyLine() {
		return fcPolyLine;
	}

	public void setFcPolyLine(String fcPolyLine) {
		this.fcPolyLine = fcPolyLine;
	}

	private String fcDistancia;
	private int fiDistancia;
	private String fcDuracion;
	private int fiDuracion;
	private double fdoEndLocationLat;
	private double fdoEndLocationLng;
	private double fdoStartLocationLat;
	private double fdoStartLocationLng;
	private String fcPolyLine;
	
	public tbPasos() {}
	
	public tbPasos(String fcDistancia, 
			int fiDistancia, 
			String fcDuracion, 
			int fiDuracion, 
			double fdoEndLocationLat, 
			double fdoEndLocationLng,
			double fdoStartLocationLat,
			double fdoStartLocationLng,
			String fcPolyLine) {
		this.fcDistancia = fcDistancia;
		this.fiDistancia = fiDistancia;
		this.fcDuracion = fcDuracion;
		this.fiDuracion = fiDuracion;
		this.fdoEndLocationLat = fdoEndLocationLat;
		this.fdoEndLocationLng = fdoEndLocationLng;
		this.fdoStartLocationLat = fdoStartLocationLat;
		this.fdoStartLocationLng = fdoStartLocationLng;
		this.fcPolyLine = fcPolyLine;
	}	
}
