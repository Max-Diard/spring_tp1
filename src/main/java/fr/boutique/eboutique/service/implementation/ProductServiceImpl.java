package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("products")
public class ProductServiceImpl implements ProductService {

    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = null;

        for(Product p : allProducts){
            if(Objects.equals(p.getId(), id)){
                product = p;
                break;
            }
        }

        if(product != null){
            return product;
        } else {
            throw new ResourceNotFoundException("Le produit n'existe pas");
        }
    }

    @Override
    public Product save(Product product) {
        allProducts.add(product);
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
            throw new StockException("MArche pas ailleurs");
        }else {
            product.setQuantity(quantityProduct);
        }
    }

}
