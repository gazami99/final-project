package kr.pe.cshop.model.domain;

import kr.pe.cshop.model.entity.Ssd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SsdDTO {
    
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

    public Ssd toEntity() {
        return Ssd.builder().sn(sn).brand(brand).name(name).price(price).build();
    }

}
