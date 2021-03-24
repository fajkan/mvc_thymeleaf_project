package sel.exicon.mvc_thymeleaf_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sel.exicon.mvc_thymeleaf_project.dto.ProductDto;
import sel.exicon.mvc_thymeleaf_project.dto.ProductDetailsDto;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductManagementController {
    private List<ProductDto> productDtoList;


    @PostConstruct
    public void init(){
        if(productDtoList == null) productDtoList = new ArrayList<>();

        ProductDto productDto= new ProductDto();
        productDto.setId(1);
        productDto.setPrice(20);
        productDto.setName("OCA Book");

        ProductDetailsDto productDetailsDto= new ProductDetailsDto();
        productDetailsDto.setId(1);
        productDetailsDto.setName("Test");
        productDetailsDto.setDescription("Test description");

        productDto.setProductDetailsDto(productDetailsDto);

        productDtoList.add(productDto);

    }

    @GetMapping("/list")
    public String getAllProducts(Model model){
        model.addAttribute("productDtoList",productDtoList);
        return "productList";
    }
}