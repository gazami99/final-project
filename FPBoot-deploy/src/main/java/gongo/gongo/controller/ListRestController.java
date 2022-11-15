package gongo.gongo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gongo.gongo.dto.ProductDTO;
import gongo.gongo.service.MLService;
import gongo.gongo.service.ProductService;

@RestController
@RequestMapping("/search")
public class ListRestController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private MLService mlService;

    @GetMapping("/all/{page}/{size}")
    public ArrayList<ProductDTO> productAll(@PathVariable("page") int page, @PathVariable("size") int size) throws Exception {
        return productService.getProductList(page, size);    
    }

    // @GetMapping("/brandAll")
    // public ArrayList<ProductDTO> brandAll(String brand) throws Exception {
    //     return productService.getProductByBrand(brand);
    // }

    @GetMapping("/categoryAll/{page}/{size}")
    public ArrayList<ProductDTO> categoryAll(@PathVariable("page") int page, @PathVariable("size") int size, String cat) throws Exception {
        System.out.println(page+size);
        return productService.getProductByCat(page, size, cat);
    }

    @GetMapping("/searchName/{page}/{size}")
    public ArrayList<ProductDTO> nameAll(@PathVariable("page") int page, @PathVariable("size") int size, String input) throws Exception {
        System.out.println(input);
        return productService.getProductByInput(page, size, input);
    }

    @GetMapping("/keyword/{purpose}/{price}")
    public String keyworldMLSearching(@PathVariable("purpose") String purpose,@PathVariable("price") String price) throws Exception {
        System.out.println(purpose+price);
        return mlService.keywordSearching(purpose,price);
    }
}
