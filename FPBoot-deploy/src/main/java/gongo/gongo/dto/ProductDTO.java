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

public class ProductDTO {
    
    private Long id;

    private String name;

    private String price;

    private String imageUrl;

    private String link;

    
    public ProductDTO(String name, String price, String imageUrl, String link) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.link = link;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 고유번호 : ");
		builder.append(id);
        builder.append(" 이름 : ");
		builder.append(name);
        builder.append(" 가격 : ");
		builder.append(price);
        builder.append(" 이미지 : ");
		builder.append(imageUrl);
        builder.append(" 링크 : ");
		builder.append(link);
        
        return builder.toString();
    }

}
