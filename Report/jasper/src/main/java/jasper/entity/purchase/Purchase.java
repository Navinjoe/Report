package jasper.entity.purchase;

import jakarta.persistence.*;
import jasper.entity.product.Product;
import jasper.entity.user.User;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase(User user, Product product) {
		super();
		this.user = user;
		this.product = product;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
