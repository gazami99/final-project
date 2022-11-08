package gongo.gongo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gongo.gongo.dto.ProductDTO;
import gongo.gongo.service.ProductService;

@RestController
@RequestMapping("search")
public class ListRestController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/productAll")
    public ArrayList<ProductDTO> productAll() throws Exception {
        return productService.getProductList();    
    }

    @GetMapping("/brandAll")
    public ArrayList<ProductDTO> brandAll(String brand) throws Exception {
        return productService.getProductByBrand(brand);
    }

    @GetMapping("/categoryAll")
    public ArrayList<ProductDTO> categoryAll(String cat) throws Exception {
        return productService.getProductByCat(cat);
    }

    @GetMapping("/nameAll")
    public ArrayList<ProductDTO> nameAll(String name) throws Exception {
        return productService.getProductByName(name);
    }
}
