package entity;

public class CongNhan extends CanBo {

	private int bac;

	public CongNhan() {
		super();
	}

	public CongNhan(String hoTen, int tuoi, int bac) {
		super(hoTen, tuoi);
		this.bac = bac;
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}
	
	@Override
	public String toString() {
		return "CongNhan [HoTen =" + getHoTen() + ", Tuoi=" + getTuoi() + ", bac=" + bac + "]";
	}
	
}
