package kr.pe.cshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cpu {

	@Id
	private String sn;

	private String brand;

	private String series;

	private String hz;

	private String core;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 고유번호 : ");
		builder.append(sn);
		builder.append(" 제조사 : ");
		builder.append(brand);
		builder.append(" 시리즈 : ");
		builder.append(series);
		builder.append(" 속도 : ");
		builder.append(hz);
		builder.append(" 코어 개수 : ");
		builder.append(core);
	
		return builder.toString();
	}
}
