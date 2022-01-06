package entity;

public class KySu extends CanBo {
	private String nganhDaoTao;

	public KySu() {
		super();
	}

	public KySu(String hoTen, int tuoi, String nganhDaoTao) {
		super(hoTen, tuoi);
		this.nganhDaoTao = nganhDaoTao;
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "KySu [HoTen =" + getHoTen() + ", Tuoi =" + getTuoi() + ", nganhDaoTao=" + getNganhDaoTao() + "]";
	}

}
