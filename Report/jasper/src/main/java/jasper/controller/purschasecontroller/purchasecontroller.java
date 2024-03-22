package jasper.controller.purschasecontroller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jasper.entity.product.Product;
import jasper.entity.user.User;
import jasper.repo.productrepo.productrepo;
import jasper.repo.purchaserepo.purchaserepo;

@Controller
public class purchasecontroller {

    @Autowired
    private purchaserepo purchaseService;

    @Autowired
    private productrepo productrrepo;
    

    @GetMapping("/report")
    public String getUsersWithMultiplePurchases(@RequestParam(required = false) Long productId, Model model) {
        if (productId != null) {
            Product product = productrrepo.getProductById(productId);
            if (product != null) {
                Map<User, Integer> usersWithPurchases = purchaseService.getUsersWithMultiplePurchasesOfProduct(product);
                model.addAttribute("usersWithPurchases", usersWithPurchases);
            } else {
                // Handle the case where the product with the given ID is not found
                model.addAttribute("errorMessage", "Product with ID " + productId + " not found.");
            }
        } else {
            // Handle the case where the productId parameter is not provided
            model.addAttribute("errorMessage", "Product ID parameter is not provided.");
        }
        return "report";
    }
  
       
    }

    
