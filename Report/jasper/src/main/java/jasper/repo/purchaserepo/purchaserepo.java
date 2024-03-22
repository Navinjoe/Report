package jasper.repo.purchaserepo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jasper.entity.product.Product;
import jasper.entity.purchase.Purchase;
import jasper.entity.user.User;


@Repository
public interface purchaserepo extends JpaRepository<Purchase, Long> {
    List<Purchase> findByProduct(Product product);

    @Query("SELECT p.user, COUNT(p) FROM Purchase p WHERE p.product = :product GROUP BY p.user HAVING COUNT(p) > 1")
    Map<User, Integer> getUsersWithMultiplePurchasesOfProduct(@Param("product") Product product);
}
