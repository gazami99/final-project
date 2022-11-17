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
    
    private String category;
        
    private String brand;

    private String link;

    private String imageUrl;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 제품명 : ");
		builder.append(name);
        builder.append(" 카테고리: ");
		builder.append(category);
        builder.append(" 브랜드 : ");
		builder.append(brand);
        builder.append(" 링크 : ");
		builder.append(link);
        builder.append(" 이미지 : ");
		builder.append(imageUrl);
        
        return builder.toString();
    }
    
}
