package jasper.repo.productrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jasper.entity.product.Product;
@Repository
public interface productrepo extends JpaRepository<Product, Long> {

	Product getProductById(Long productId);
}