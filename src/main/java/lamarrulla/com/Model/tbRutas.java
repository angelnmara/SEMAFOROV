package lamarrulla.com.Model;

public class tbRutas {
		
	public String getFcDistance() {
		return fcDistance;
	}

	public void setFcDistance(String fcDistance) {
		this.fcDistance = fcDistance;
	}

	public int getFiDistance() {
		return fiDistance;
	}

	public void setFiDistance(int fiDistance) {
		this.fiDistance = fiDistance;
	}

	public String getFcDuration() {
		return fcDuration;
	}

	public void setFcDuration(String fcDuration) {
		this.fcDuration = fcDuration;
	}

	public int getFiDuration() {
		return fiDuration;
	}

	public void setFiDuration(int fiDuration) {
		this.fiDuration = fiDuration;
	}

	public String getFcEndAddress() {
		return fcEndAddress;
	}

	public void setFcEndAddress(String fcEndAddress) {
		this.fcEndAddress = fcEndAddress;
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

	public String getFcStartAddres() {
		return fcStartAddres;
	}

	public void setFcStartAddres(String fcStartAddres) {
		this.fcStartAddres = fcStartAddres;
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
	
	public String getQryInsert() {
		return qryStringInsert;
	}

	public void setQryInsert(String qryInsert) {
		this.qryStringInsert = qryInsert;
	}

	private String fcDistance;
	private int fiDistance;
	private String fcDuration;
	private int fiDuration;
	private String fcEndAddress;
	private double fdoEndLocationLat;
	private double fdoEndLocationLng;
	private String fcStartAddres;
	private double fdoStartLocationLat;
	private double fdoStartLocationLng;
	private String qryStringInsert;

	public tbRutas() {}
	
	public tbRutas(
			String fcDistance,
			int fiDistance,
			String fcDuration,
			int fiDuration,
			String fcEndAddress, 
			double fdoEndLocationLat,
			double fdoEndLocationLng,
			String fcStartAddres,
			double fdoStartLocationLat,
			double fdoStartLocationLng) {
		this.fiDistance = fiDistance;
		this.fcDistance = fcDistance;
		this.fcDuration = fcDuration;
		this.fiDuration = fiDuration;
		this.fcEndAddress = fcEndAddress;
		this.fdoEndLocationLat = fdoEndLocationLat;
		this.fdoEndLocationLng = fdoEndLocationLng;
		this.fcStartAddres = fcStartAddres;
		this.fdoStartLocationLat = fdoStartLocationLat;
		this.fdoStartLocationLng = fdoStartLocationLng;
	}
	public void tbRutasInsert(
			String fcDistance,
			int fiDistance,
			String fcDuration,
			int fiDuration,
			String fcEndAddress, 
			double fdoEndLocationLat,
			double fdoEndLocationLng,
			String fcStartAddres,
			double fdoStartLocationLat,
			double fdoStartLocationLng) {		
		qryStringInsert = String.format("insert into tbRutas (fcDistance, fiDistance, fcDuration, fiDuration, fcEndAddress, fdoEndLocationLat, fdoEndLocationLng, fcStartAddress, fdoStartLocationLat, fdoStartLocationLng)values('%s', %d, '%s', %d, '%s', %f, %f, '%s', %f, %f) returning fiIdRuta; ",
				fcDistance,
				fiDistance,
				fcDuration,
				fiDuration,
				fcEndAddress,
				fdoEndLocationLat,
				fdoEndLocationLng,
				fcStartAddres,
				fdoStartLocationLat,
				fdoStartLocationLng);		
	}
}
