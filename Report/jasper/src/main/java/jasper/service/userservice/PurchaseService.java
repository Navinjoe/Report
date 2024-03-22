package jasper.service.userservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jasper.entity.product.Product;
import jasper.entity.purchase.Purchase;
import jasper.entity.user.User;
import jasper.repo.purchaserepo.purchaserepo;

@Service
public class PurchaseService {

    @Autowired
    private purchaserepo purchaseRepository;
    
    

    public PurchaseService(purchaserepo purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}


	public Map<User, Integer> getUsersWithMultiplePurchasesOfProduct(Product product) {
           Map<User, Integer> userPurchaseCounts = new HashMap<>();
           List<Purchase> purchases = purchaseRepository.findByProduct(product);
        
        for (Purchase purchase : purchases) {
             User user = purchase.getUser();
            userPurchaseCounts.put(user, userPurchaseCounts.getOrDefault(user, 0) + 1);
        }
        
        // Filter users with multiple purchases
        return userPurchaseCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}
