package com.varshini.spring.boot.web.thriftcart.model;



import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Products")
	public class Product {
	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private double price;
	    private String description;
	    private String category;
	    private String image;
	    @Embedded
	    private Rating rating;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		@Override
		public String toString() {
			return "Product [id=" + getId() + ", title=" + title + ", price=" + price + ", description=" + description
					+ ", category=" + category + ", image=" + image + ", rating=" + rating + "]";
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Rating getRating() {
			return rating;
		}
		public void setRating(Rating rating) {
			this.rating = rating;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

	    // Getters and setters
	}


