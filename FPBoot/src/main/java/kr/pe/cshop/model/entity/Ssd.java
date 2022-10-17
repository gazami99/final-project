package kr.pe.cshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class Ssd {
    @Id
    private String sn;

    private String brand;

    private String name;
    
    private String price;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 고유번호 : ");
		builder.append(sn);
        builder.append(" 제조사 : ");
		builder.append(brand);
        builder.append(" 제품명 : ");
		builder.append(name);
        builder.append(" 가격 : ");
		builder.append(price);
        
        return builder.toString();
    }

}
