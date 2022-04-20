package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.eenum.EnumPosition.PsName;

public class Position implements Serializable {
	@Entity
	@Table(name = "Position", catalog = "testing_system_1")
	public class Account implements Serializable {
		@Column(name = "PositionId")
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
		private int id;

		@Column(name = "PositionName", length = 50, nullable = false, unique = true)
		private String positionName;
		
		@Column(name = "PositionName", nullable = false )
		@Enumerated(EnumType.STRING)
		private PsName psName;

		public PsName getPsName() {
			return psName;
		}

		public void setPsName(PsName psName) {
			this.psName = psName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPositionName() {
			return positionName;
		}

		public void setPositionName(String positionName) {
			this.positionName = positionName;
		}

	}
}
