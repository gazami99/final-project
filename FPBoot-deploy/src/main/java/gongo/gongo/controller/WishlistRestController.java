package gongo.gongo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gongo.gongo.dto.ListProductDTO;
import gongo.gongo.service.ListProductService;
import gongo.gongo.service.MemberService;

@RestController
@RequestMapping("freelancer/wishlist")
public class WishlistRestController {
    
    @Autowired
    private ListProductService lpService;
    
    @Autowired
    private MemberService mService;

    @GetMapping("/{memberId}")
    public ArrayList<ListProductDTO> productAll(@PathVariable("mermberId") String memberId) throws Exception {
        
        Long wlId = mService.getWishlistId(memberId);

        return lpService.getMyWishlist(wlId);    
    }
}
