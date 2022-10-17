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
public class Gpu {
    
    @Id
    private String sn;

    private String brand;

    private String model;

    private String price;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 고유번호 : ");
		builder.append(sn);
        builder.append(" 제조사 : ");
		builder.append(brand);
        builder.append(" 모델명 : ");
		builder.append(model);
        builder.append(" 가격 : ");
		builder.append(price);
        
        return builder.toString();
    }

    public static Object builder() {
        return null;
    }
}
