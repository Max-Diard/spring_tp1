package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.repository.ProductRepository;
import fr.boutique.eboutique.service.interfaceService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService {

    private final List<Product> allProducts = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Le produit n'existe pas"));
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        return false;
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        int quantityProduct = product.getQuantity() - quantity;
        if(quantityProduct < 0){
            throw new StockException("Marche pas ailleurs");
        }else {
            product.setQuantity(quantityProduct);
            productRepository.save(product);
        }
    }

    @Override
    public String delete(Long productId) {
        try{
            Product product = this.getProductById(productId);
            productRepository.delete(product);
        } catch (ResourceNotFoundException e){
            return e.getMessage();
        }
        return "Produit Supprimé.";
    }

}
