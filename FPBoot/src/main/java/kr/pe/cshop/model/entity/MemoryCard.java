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
public class MemoryCard {

	@Id
	private String sn;

	private String brand;

	private String mcName;

	private String price512GB;

	private String price256GB;

	private String price128GB;

	private String price64GB;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 고유번호 : ");
		builder.append(sn);
		builder.append(" 제조사 : ");
		builder.append(brand);
		builder.append(" 제품명 : ");
		builder.append(mcName);
		builder.append(" price512GB : ");
		builder.append(price512GB);
		builder.append(" price256GB : ");
		builder.append(price256GB);
		builder.append(" price128GB : ");
		builder.append(price128GB);
		builder.append(" price64GB : ");
		builder.append(price64GB);
		
		return builder.toString();
	}
}
