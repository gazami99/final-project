package gongo.gongo.dto;

import java.util.HashSet;
import java.util.Set;

public class WishListDTO {
    private Long id;
    
    private MemberDTO name;
    
    private Set<ListProductDTO> wishList = new HashSet<>();


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" id : ");
		builder.append(id);
        builder.append(" name: ");
		builder.append(name);
        builder.append(" wishList : ");
		builder.append(wishList);
        
        return builder.toString();
    }

}
