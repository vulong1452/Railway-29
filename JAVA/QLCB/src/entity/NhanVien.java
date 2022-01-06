package entity;

public class NhanVien extends CanBo {
	private String congViec;

	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, int tuoi, String congViec) {
		super(hoTen, tuoi);
		this.congViec = congViec;
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "NhanVien [Tên =" + getHoTen() + ", Tuoi=" + getTuoi() + ", congViec=" + congViec + "]";
	}

}
