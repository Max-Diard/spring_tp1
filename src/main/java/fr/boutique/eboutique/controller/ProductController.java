package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.interfaceService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = { "", "/" })
    public String getProducts(Model model) {
        System.out.println("/products : get all products");
        model.addAttribute("products", productService.getAllProducts());
        return "productFile/products";
    }

    @GetMapping("/{productId}")
    public String getProductById(Model model, @PathVariable("productId") Long id) {
        System.out.println("/products/id : get product by id (" + id + ")");
        model.addAttribute("product", productService.getProductById(id));
        return "productFile/product";
    }

    @GetMapping("/add")
    public String addProductByForm(Model model){
        model.addAttribute("product", new Product());
        return "productFile/addProduct";
    }

    @RequestMapping(method = RequestMethod.POST,
                    value="/createByForm",
                    consumes = "application/x-www-form-urlencoded")
    public String submitForm(Product product,
                             Model model,
                             BindingResult result) {
        System.out.println(product);

        if(result.hasErrors()){
            return "productFile/addProduct";
        }

        productService.save(product);
        model.addAttribute("products", productService.getAllProducts());
        return "productFile/products";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/products";
    }

}
