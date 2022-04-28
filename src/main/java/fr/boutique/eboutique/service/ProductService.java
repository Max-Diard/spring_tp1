package fr.boutique.eboutique.service;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product save(Product product);

    public boolean isProductAvailable(Product product, int quantity);

    public void removeProduct(Product product, int quantity) throws StockException;

    public String delete(Long productId);
}
