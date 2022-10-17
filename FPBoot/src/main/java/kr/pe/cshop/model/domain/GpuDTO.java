package kr.pe.cshop.model.domain;

import javax.annotation.Generated;

import kr.pe.cshop.model.entity.Gpu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GpuDTO {
    
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

    public Gpu toEntity() {
		return Gpu.builder().sn(sn).brand(brand).model(model).price(price).build();
	}

}
