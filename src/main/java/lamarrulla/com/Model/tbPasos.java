package lamarrulla.com.Model;

import java.math.BigDecimal;

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

	public String getFcPolyLine() {
		return fcPolyLine;
	}

	public void setFcPolyLine(String fcPolyLine) {
		this.fcPolyLine = fcPolyLine;
	}

	public String getQryStringInsert() {
		return qryStringInsert;
	}

	public void setQryStringInsert(String qryStringInsert) {
		this.qryStringInsert = qryStringInsert;
	}	

	public int getFiIdRuta() {
		return fiIdRuta;
	}

	public void setFiIdRuta(int fiIdRuta) {
		this.fiIdRuta = fiIdRuta;
	}	

	public int getFiIdPaso() {
		return fiIdPaso;
	}

	public void setFiIdPaso(int fiIdPaso) {
		this.fiIdPaso = fiIdPaso;
	}

	private int fiIdPaso;
	private int fiIdRuta;
	private String fcDistancia;
	private int fiDistancia;
	private String fcDuracion;
	private int fiDuracion;
	private BigDecimal fdoEndLocationLat;
	private BigDecimal fdoEndLocationLng;
	private BigDecimal fdoStartLocationLat;
	private BigDecimal fdoStartLocationLng;
	private String fcPolyLine;
	private String qryStringInsert;

	public tbPasos() {}
	
	public tbPasos(
			int fiIdPaso,
			int fiIdRuta,
			String fcDistancia, 
			int fiDistancia, 
			String fcDuracion, 
			int fiDuracion, 
			BigDecimal fdoEndLocationLat, 
			BigDecimal fdoEndLocationLng,
			BigDecimal fdoStartLocationLat,
			BigDecimal fdoStartLocationLng,
			String fcPolyLine) {
		this.fiIdPaso = fiIdPaso;
		this.fiIdRuta = fiIdRuta;
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
	
	public void tbPasosInsert(
			int fiIdRuta,
			String fcDistancia, 
			int fiDistancia, 
			String fcDuracion, 
			int fiDuracion, 
			BigDecimal fdoEndLocationLat, 
			BigDecimal fdoEndLocationLng,
			BigDecimal fdoStartLocationLat,
			BigDecimal fdoStartLocationLng,
			String fcPolyLine) {
		qryStringInsert = String.format("insert into tbPasos (fiIdRuta, fcDistancia, fiDistancia, fcDuracion, fiDuracion, fdoEndLocationLat, fdoEndLocationLng, fdoStartLocationLat, fdoStartLocationLng, fcPolyLine)values(%d, '%s', %d,'%s', %d, %f, %f, %f, %f,'%s');",  
				fiIdRuta,
				fcDistancia, 
				fiDistancia,
				fcDuracion,
				fiDuracion,
				fdoEndLocationLat,
				fdoEndLocationLng,
				fdoStartLocationLat,
				fdoStartLocationLng,
				fcPolyLine);
	}	
}