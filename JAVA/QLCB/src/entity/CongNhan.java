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

	public String getHoTen() {
		return "Ten cong nhan la : " + super.getHoTen();
	}
	
	@Override
	public String toString() {
		return "CongNhan [HoTen =" + getHoTen() + ", Tuoi=" + getTuoi() + ", bac=" + bac + "]";
	}
	
}
