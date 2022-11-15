package gongo.gongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListProductDTO {

    private Long id;
    
    private Long wishlistId;

    private Long productId;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" id : ");
		builder.append(id);
        builder.append(" wishList: ");
		builder.append(wishlistId);
        builder.append(" product : ");
		builder.append(productId);
        
        return builder.toString();
    }
}
