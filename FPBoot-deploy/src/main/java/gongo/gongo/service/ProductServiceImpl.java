package gongo.gongo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import gongo.gongo.dto.ProductDTO;
import gongo.gongo.entity.Product;
import gongo.gongo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepo;


    public ArrayList <ProductDTO> getProductList(int page, int size) throws Exception {
        Page <Product> all = productRepo.findAll(PageRequest.of(page, size));
        ArrayList <ProductDTO> allDTO = new ArrayList <ProductDTO>();
        for (Product i : all) {
            allDTO.add(ProductDTO.builder().id(i.getId()).name(i.getName().getName()).price(i.getPrice()).imageUrl(i.getImageUrl()).build());
        }
        return allDTO;
    }

    // 머신러닝 브랜드 feature 추가시 activate
    // public ArrayList <ProductDTO> getProductByBrand(String brand) throws Exception {
    //     ArrayList <Product> all = productRepo.findProductByBrand(brand);
    //     ArrayList <ProductDTO> allDTO = new ArrayList <ProductDTO>();
        
    //     for (Product i : all) {
    //             allDTO.add(ProductDTO.builder().id(i.getId()).name(i.getName().getName()).price(i.getPrice()).imageUrl(i.getImageUrl()).build());
    //      }
        
    //     return allDTO;
        
    // }

    public ArrayList <ProductDTO> getProductByInput(int page, int size, String input) throws Exception {
        ArrayList<Product> all = productRepo.findProductByInput(PageRequest.of(page, size), input);
        ArrayList<ProductDTO> allDTO = new ArrayList<ProductDTO>();
        System.out.println(all);
        for (Product i : all) {
            allDTO.add(ProductDTO.builder().id(i.getId()).name(i.getName().getName()).price(i.getPrice()).imageUrl(i.getImageUrl()).build());
        }
        return allDTO;
    }

    public ArrayList <ProductDTO> getProductByCat(int page, int size, String cat) throws Exception {
        ArrayList<Product> all = productRepo.findProductByCat(PageRequest.of(page, size), cat);
        ArrayList <ProductDTO> allDTO = new ArrayList <ProductDTO>();
        
        for (Product i : all) {
            allDTO.add(ProductDTO.builder().id(i.getId()).name(i.getName().getName()).price(i.getPrice()).imageUrl(i.getImageUrl()).build());
        }    
        return allDTO;
        
    }




}