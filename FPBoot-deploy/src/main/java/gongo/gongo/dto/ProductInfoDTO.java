package gongo.gongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder

public class ProductInfoDTO {
    private Long id;
    
    private String name;
    
    private CategoryDTO category;
        
    private String brand;

    private String detail;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 제품명 : ");
		builder.append(name);
        builder.append(" 카테고리: ");
		builder.append(category);
        builder.append(" 브랜드 : ");
		builder.append(brand);
        builder.append(" 상세 정보 : ");
		builder.append(detail);
        
        return builder.toString();
    }
    
}
