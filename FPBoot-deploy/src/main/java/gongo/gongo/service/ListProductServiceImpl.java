package gongo.gongo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gongo.gongo.dto.ListProductDTO;
import gongo.gongo.entity.ListProduct;
import gongo.gongo.repository.ListProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListProductServiceImpl implements ListProductService {

    @Autowired
    private final ListProductRepository lpRepo;

    public ArrayList <ListProductDTO> getMyWishlist(Long wishlistId) throws Exception {
        ArrayList<ListProduct> all = lpRepo.findListProductByWishlist(wishlistId);
        ArrayList<ListProductDTO> allDTO = new ArrayList<ListProductDTO>();

        for (ListProduct i : all) {
            allDTO.add(ListProductDTO.builder().id(i.getId()).wishlistId(i.getWishlistId().getId()).productId(i.getProductId().getId()).build());
        }
        return allDTO;
    }

}
