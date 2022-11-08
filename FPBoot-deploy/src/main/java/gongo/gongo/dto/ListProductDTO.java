package gongo.gongo.dto;

public class ListProductDTO {

    private int id;
    
    private WishListDTO wishList;

    private ProductDTO product;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" id : ");
		builder.append(id);
        builder.append(" wishList: ");
		builder.append(wishList);
        builder.append(" product : ");
		builder.append(product);
        
        return builder.toString();
    }
}
