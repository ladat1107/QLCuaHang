package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ProductID;
	
	@Column(columnDefinition = "nvarchar(MAX)")
	private String ProductName;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String Description;
	
	
	private int Price;
	private String imageLink;
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category Category;
	
	private int SellerID;
	private int Amount;
	private int stoke;
	
	public Product(int productID, String productName, String description, int price, String imageLink,
			Category category, int sellerID, int amount, int stoke) {
		super();
		ProductID = productID;
		ProductName = productName;
		Description = description;
		Price = price;
		this.imageLink = imageLink;
		Category = category;
		SellerID = sellerID;
		Amount = amount;
		this.stoke = stoke;
	}

	public Product() {
		super();
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public int getSellerID() {
		return SellerID;
	}

	public void setSellerID(int sellerID) {
		SellerID = sellerID;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}


	
	
	
	

}
