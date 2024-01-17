package com.mphasis.interview.rbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    ShoppingCart shoppingCart = null;
    
    private static final Double PEN_PRICE = 5.0;
    private static final Double BOOK_PRICE = 10.0;
    private static final Double PENCIL_PRICE = 2.0;
    
    private static final Integer PEN_QTY = 10;
    private static final Integer BOOK_QTY = 5;
    private static final Integer PENCIL_QTY = 3;
    
    Product Pen = null;
    Product Book = null;
    Product Pencil = null;

    @BeforeEach
    public void setup() {
	shoppingCart = new ShoppingCart();
	Pen = new Product("Pen", PEN_PRICE, PEN_QTY);
	Book = new Product("Book", BOOK_PRICE, BOOK_QTY);
	Pencil = new Product("Pencil", PENCIL_PRICE, PENCIL_QTY);
    }

    @Test
    @Order(1)
    @DisplayName("Check all entries of products empty before adding them")
    public void ShoppingCartUnitTest() {
	assertFalse(shoppingCart.contains(Pen));
	assertFalse(shoppingCart.contains(Book));
	assertFalse(shoppingCart.contains(Pencil));
    }
    
    @Test
    @Order(2)
    @DisplayName("Check price of product items after adding them")
    public void ShoppingCartPriceTest() {
	shoppingCart.addProduct(Pen);
	assertTrue(shoppingCart.contains(Pen));
	assertEquals(PEN_PRICE*PEN_QTY, shoppingCart.findPriceOfProductByName("Pen"), "Total price of Pen is: "+shoppingCart.findPriceOfProductByName("Pen"));

	shoppingCart.addProduct(Book);
	assertTrue(shoppingCart.contains(Book));
	assertEquals(BOOK_PRICE*BOOK_QTY, shoppingCart.findPriceOfProductByName("Book"), "Total price of Pen is: "+shoppingCart.findPriceOfProductByName("Book"));

	shoppingCart.addProduct(Pencil);
	assertTrue(shoppingCart.contains(Pencil));
	assertEquals(PENCIL_PRICE*PENCIL_QTY, shoppingCart.findPriceOfProductByName("Pencil"), "Total price of Pen is: "+shoppingCart.findPriceOfProductByName("Pencil"));
	
	assertEquals(PEN_PRICE*PEN_QTY+BOOK_PRICE*BOOK_QTY+PENCIL_PRICE*PENCIL_QTY, shoppingCart.findTotalPriceOfAllProducts(), "Total of all products is: "+shoppingCart.findTotalPriceOfAllProducts());
	System.out.println("Expected:"+(PEN_PRICE*PEN_QTY+BOOK_PRICE*BOOK_QTY+PENCIL_PRICE*PENCIL_QTY)+" Actual: "+shoppingCart.findTotalPriceOfAllProducts());
    }
    
    @Test
    @Order(3)
    @DisplayName("Check exception message while finding wrong product them")
    public void ShoppingCartNotFoundExceptionTest() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
	    shoppingCart.findPriceOfProductByName("xxxyyyzzz");
	});
	assertEquals("Product not found with name: "+"xxxyyyzzz", ex.getMessage());
    }

}

class ShoppingCart {
    
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
	products.add(product);
    }

    public boolean contains(Product product) {
	return products.contains(product);
    }

    public Double findPriceOfProductByName(String name) {
	Optional<Product> productOptional =  products.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
	if(productOptional.isPresent()) {
	    return productOptional.get().getTotalPrice();
	}
	throw new IllegalArgumentException("Product not found with name: "+name);
    }
    
    public Double findTotalPriceOfAllProducts() {
//	return products.stream().map(p -> p.getTotalPrice()).reduce(0.0,  (a,b)-> (a+b));
	return products.stream().map(p -> p.getTotalPrice()).reduce(Double::sum).get();
    }
}

class Product {
    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
	this.name = name;
	this.price = price;
	this.quantity = quantity;
    }

    public String getName() {
	return this.name;
    }

    public Double getTotalPrice() {
	return this.quantity * this.price;
    }
}