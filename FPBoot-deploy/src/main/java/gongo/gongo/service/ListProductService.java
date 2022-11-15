package gongo.gongo.service;

import java.util.ArrayList;

import gongo.gongo.dto.ListProductDTO;

public interface ListProductService {
    
    ArrayList <ListProductDTO> getMyWishlist(Long wishlistId) throws Exception;

}
