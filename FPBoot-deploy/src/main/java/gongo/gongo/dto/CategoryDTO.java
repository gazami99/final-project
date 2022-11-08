package gongo.gongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class CategoryDTO {
    
    private int id;

    private String name;

    private String type;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" 고유번호 : ");
		builder.append(id);
        builder.append(" 부품분류 : ");
		builder.append(name);
        builder.append(" 타입 : ");
		builder.append(type);
        
        return builder.toString();
    }
    
    // public Category toEntity() {
    //     return Category.builder().catId(catId).partCat(partCat).build();
    // }
}
