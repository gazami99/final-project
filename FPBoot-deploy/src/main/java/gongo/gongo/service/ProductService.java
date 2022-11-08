package gongo.gongo.service;

import java.util.ArrayList;

import gongo.gongo.dto.ProductDTO;

public interface ProductService {
    ArrayList<ProductDTO> getProductList() throws Exception;
    
    ArrayList<ProductDTO> getProductByBrand(String brand) throws Exception;
    
    ArrayList<ProductDTO> getProductByCat(String cat) throws Exception;

    ArrayList<ProductDTO> getProductByName(String name) throws Exception;
}
