// ================================================================================
//   ONLINE STORE CART & ORDER PIPELINE
//   Intermediate-level Spring Boot Java Project
//   Complete Source Code
// ================================================================================

// HOW TO USE THIS FILE
// --------------------
// 1. Create a Maven project with the package structure shown below.
// 2. Copy each file into the correct path.
// 3. Run: mvn spring-boot:run
// 4. Server starts at http://localhost:8080

// PROJECT STRUCTURE
// -----------------
// online-store/
// ├── pom.xml
// ├── README.md
// └── src/main/
//     ├── resources/
//     │   └── application.properties
//     └── java/com/onlinestore/
//         ├── OnlineStoreApplication.java
//         ├── config/
//         │   └── DataInitializer.java
//         ├── entity/
//         │   ├── User.java
//         │   ├── Category.java
//         │   ├── Product.java
//         │   ├── Cart.java
//         │   ├── CartItem.java
//         │   ├── OrderStatus.java
//         │   ├── Order.java
//         │   └── OrderItem.java
//         ├── repository/
//         │   ├── UserRepository.java
//         │   ├── CategoryRepository.java
//         │   ├── ProductRepository.java
//         │   ├── CartRepository.java
//         │   └── OrderRepository.java
//         ├── service/
//         │   ├── UserService.java
//         │   ├── ProductService.java
//         │   ├── CartService.java
//         │   └── OrderService.java
//         ├── controller/
//         │   ├── UserController.java
//         │   ├── ProductController.java
//         │   ├── CartController.java
//         │   └── OrderController.java
//         └── exception/
//             ├── ResourceNotFoundException.java
//             ├── BusinessException.java
//             └── GlobalExceptionHandler.java


// ================================================================================
// FILE: pom.xml
// ================================================================================

// <?xml version="1.0" encoding="UTF-8"?>
// <project xmlns="http://maven.apache.org/POM/4.0.0"
//          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
//          https://maven.apache.org/xsd/maven-4.0.0.xsd">
//     <modelVersion>4.0.0</modelVersion>

//     <parent>
//         <groupId>org.springframework.boot</groupId>
//         <artifactId>spring-boot-starter-parent</artifactId>
//         <version>3.2.0</version>
//         <relativePath/>
//     </parent>

//     <groupId>com.onlinestore</groupId>
//     <artifactId>online-store-cart-order</artifactId>
//     <version>1.0.0</version>
//     <name>Online Store Cart &amp; Order Pipeline</name>
//     <description>Intermediate level e-commerce cart and order management system</description>

//     <properties>
//         <java.version>17</java.version>
//     </properties>

//     <dependencies>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-web</artifactId>
//         </dependency>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-data-jpa</artifactId>
//         </dependency>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-validation</artifactId>
//         </dependency>
//         <dependency>
//             <groupId>com.h2database</groupId>
//             <artifactId>h2</artifactId>
//             <scope>runtime</scope>
//         </dependency>
//         <dependency>
//             <groupId>org.projectlombok</groupId>
//             <artifactId>lombok</artifactId>
//             <optional>true</optional>
//         </dependency>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-test</artifactId>
//             <scope>test</scope>
//         </dependency>
//     </dependencies>

//     <build>
//         <plugins>
//             <plugin>
//                 <groupId>org.springframework.boot</groupId>
//                 <artifactId>spring-boot-maven-plugin</artifactId>
//                 <configuration>
//                     <excludes>
//                         <exclude>
//                             <groupId>org.projectlombok</groupId>
//                             <artifactId>lombok</artifactId>
//                         </exclude>
//                     </excludes>
//                 </configuration>
//             </plugin>
//         </plugins>
//     </build>
// </project>


// ================================================================================
// FILE: src/main/resources/application.properties
// ================================================================================

// spring.application.name=online-store-cart-order

// # H2 in-memory database (easy for demo / learning)
// spring.datasource.url=jdbc:h2:mem:onlinestore;DB_CLOSE_DELAY=-1
// spring.datasource.driverClassName=org.h2.Driver
// spring.datasource.username=sa
// spring.datasource.password=

// spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.show-sql=true
// spring.jpa.properties.hibernate.format_sql=true

// # H2 Console (open at http://localhost:8080/h2-console)
// spring.h2.console.enabled=true
// spring.h2.console.path=/h2-console

// server.port=8080


// ================================================================================
// FILE: src/main/java/com/onlinestore/OnlineStoreApplication.java
// ================================================================================

// package com.onlinestore;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class OnlineStoreApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(OnlineStoreApplication.class, args);
//         System.out.println("\n========================================");
//         System.out.println("  Online Store Cart & Order Pipeline");
//         System.out.println("  Server running at http://localhost:8080");
//         System.out.println("  H2 Console   : http://localhost:8080/h2-console");
//         System.out.println("========================================\n");
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/User.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true, length = 50)
//     private String username;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String password;   // plain text for demo only – never do this in real apps

//     @Column(nullable = false, length = 20)
//     private String role = "CUSTOMER";   // CUSTOMER or ADMIN

//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() {
//         createdAt = LocalDateTime.now();
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/Category.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Table(name = "categories")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Category {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true, length = 100)
//     private String name;

//     private String description;
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/Product.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;

// @Entity
// @Table(name = "products")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Product {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, length = 150)
//     private String name;

//     @Column(length = 500)
//     private String description;

//     @Column(nullable = false, precision = 10, scale = 2)
//     private BigDecimal price;

//     @Column(nullable = false)
//     private Integer stockQuantity;

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "category_id")
//     private Category category;

//     private boolean active = true;
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/Cart.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// @Entity
// @Table(name = "carts")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Cart {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "user_id", nullable = false, unique = true)
//     private User user;

//     @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//     @Builder.Default
//     private List<CartItem> items = new ArrayList<>();

//     private LocalDateTime updatedAt;

//     @PrePersist
//     @PreUpdate
//     protected void onUpdate() {
//         updatedAt = LocalDateTime.now();
//     }

//     // Helper methods (common in intermediate code)
//     public void addItem(CartItem item) {
//         items.add(item);
//         item.setCart(this);
//     }

//     public void removeItem(CartItem item) {
//         items.remove(item);
//         item.setCart(null);
//     }

//     public void clearItems() {
//         items.forEach(item -> item.setCart(null));
//         items.clear();
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/CartItem.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;

// @Entity
// @Table(name = "cart_items")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class CartItem {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "cart_id", nullable = false)
//     private Cart cart;

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "product_id", nullable = false)
//     private Product product;

//     @Column(nullable = false)
//     private Integer quantity;

//     // Convenience method to calculate line total
//     public BigDecimal getLineTotal() {
//         if (product == null || product.getPrice() == null || quantity == null) {
//             return BigDecimal.ZERO;
//         }
//         return product.getPrice().multiply(BigDecimal.valueOf(quantity));
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/OrderStatus.java
// ================================================================================

// package com.onlinestore.entity;

// public enum OrderStatus {
//     PLACED,
//     CONFIRMED,
//     SHIPPED,
//     DELIVERED,
//     CANCELLED
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/Order.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// @Entity
// @Table(name = "orders")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Order {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true, length = 30)
//     private String orderNumber;

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//     @Builder.Default
//     private List<OrderItem> items = new ArrayList<>();

//     @Column(nullable = false, precision = 12, scale = 2)
//     private BigDecimal totalAmount;

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false, length = 20)
//     private OrderStatus status;

//     private LocalDateTime createdAt;
//     private LocalDateTime updatedAt;

//     @PrePersist
//     protected void onCreate() {
//         createdAt = LocalDateTime.now();
//         updatedAt = LocalDateTime.now();
//         if (status == null) {
//             status = OrderStatus.PLACED;
//         }
//     }

//     @PreUpdate
//     protected void onUpdate() {
//         updatedAt = LocalDateTime.now();
//     }

//     public void addItem(OrderItem item) {
//         items.add(item);
//         item.setOrder(this);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/entity/OrderItem.java
// ================================================================================

// package com.onlinestore.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;

// @Entity
// @Table(name = "order_items")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class OrderItem {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "order_id", nullable = false)
//     private Order order;

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "product_id", nullable = false)
//     private Product product;

//     @Column(nullable = false)
//     private Integer quantity;

//     // Price at the time of order (important – product price can change later)
//     @Column(nullable = false, precision = 10, scale = 2)
//     private BigDecimal unitPrice;

//     public BigDecimal getLineTotal() {
//         return unitPrice.multiply(BigDecimal.valueOf(quantity));
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/repository/UserRepository.java
// ================================================================================

// package com.onlinestore.repository;

// import com.onlinestore.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByUsername(String username);
//     Optional<User> findByEmail(String email);
//     boolean existsByUsername(String username);
//     boolean existsByEmail(String email);
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/repository/CategoryRepository.java
// ================================================================================

// package com.onlinestore.repository;

// import com.onlinestore.entity.Category;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface CategoryRepository extends JpaRepository<Category, Long> {
//     Optional<Category> findByName(String name);
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/repository/ProductRepository.java
// ================================================================================

// package com.onlinestore.repository;

// import com.onlinestore.entity.Product;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface ProductRepository extends JpaRepository<Product, Long> {

//     List<Product> findByActiveTrue();

//     List<Product> findByCategoryIdAndActiveTrue(Long categoryId);

//     @Query("SELECT p FROM Product p WHERE p.active = true AND " +
//            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//     List<Product> searchByName(@Param("keyword") String keyword);
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/repository/CartRepository.java
// ================================================================================

// package com.onlinestore.repository;

// import com.onlinestore.entity.Cart;
// import com.onlinestore.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface CartRepository extends JpaRepository<Cart, Long> {
//     Optional<Cart> findByUser(User user);
//     Optional<Cart> findByUserId(Long userId);
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/repository/OrderRepository.java
// ================================================================================

// package com.onlinestore.repository;

// import com.onlinestore.entity.Order;
// import com.onlinestore.entity.OrderStatus;
// import com.onlinestore.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// @Repository
// public interface OrderRepository extends JpaRepository<Order, Long> {
//     List<Order> findByUserOrderByCreatedAtDesc(User user);
//     List<Order> findByUserIdOrderByCreatedAtDesc(Long userId);
//     List<Order> findByStatus(OrderStatus status);
//     Optional<Order> findByOrderNumber(String orderNumber);
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/exception/ResourceNotFoundException.java
// ================================================================================

// package com.onlinestore.exception;

// public class ResourceNotFoundException extends RuntimeException {
//     public ResourceNotFoundException(String message) {
//         super(message);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/exception/BusinessException.java
// ================================================================================

// package com.onlinestore.exception;

// public class BusinessException extends RuntimeException {
//     public BusinessException(String message) {
//         super(message);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/exception/GlobalExceptionHandler.java
// ================================================================================

// package com.onlinestore.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
//         return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
//     }

//     @ExceptionHandler(BusinessException.class)
//     public ResponseEntity<Map<String, Object>> handleBusiness(BusinessException ex) {
//         return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
//         return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + ex.getMessage());
//     }

//     private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
//         Map<String, Object> body = new HashMap<>();
//         body.put("timestamp", LocalDateTime.now().toString());
//         body.put("status", status.value());
//         body.put("error", status.getReasonPhrase());
//         body.put("message", message);
//         return new ResponseEntity<>(body, status);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/service/UserService.java
// ================================================================================

// package com.onlinestore.service;

// import com.onlinestore.entity.User;
// import com.onlinestore.exception.BusinessException;
// import com.onlinestore.exception.ResourceNotFoundException;
// import com.onlinestore.repository.UserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @Service
// @RequiredArgsConstructor
// public class UserService {

//     private final UserRepository userRepository;

//     @Transactional
//     public User register(String username, String email, String password) {
//         if (userRepository.existsByUsername(username)) {
//             throw new BusinessException("Username already taken: " + username);
//         }
//         if (userRepository.existsByEmail(email)) {
//             throw new BusinessException("Email already registered: " + email);
//         }

//         User user = User.builder()
//                 .username(username)
//                 .email(email)
//                 .password(password)   // demo only
//                 .role("CUSTOMER")
//                 .build();

//         return userRepository.save(user);
//     }

//     public User findById(Long id) {
//         return userRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
//     }

//     public User findByUsername(String username) {
//         return userRepository.findByUsername(username)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
//     }

//     // Simple login check (no real security)
//     public User login(String username, String password) {
//         User user = findByUsername(username);
//         if (!user.getPassword().equals(password)) {
//             throw new BusinessException("Invalid password");
//         }
//         return user;
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/service/ProductService.java
// ================================================================================

// package com.onlinestore.service;

// import com.onlinestore.entity.Category;
// import com.onlinestore.entity.Product;
// import com.onlinestore.exception.BusinessException;
// import com.onlinestore.exception.ResourceNotFoundException;
// import com.onlinestore.repository.CategoryRepository;
// import com.onlinestore.repository.ProductRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.math.BigDecimal;
// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class ProductService {

//     private final ProductRepository productRepository;
//     private final CategoryRepository categoryRepository;

//     public List<Product> getAllActiveProducts() {
//         return productRepository.findByActiveTrue();
//     }

//     public Product getProductById(Long id) {
//         return productRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
//     }

//     public List<Product> searchProducts(String keyword) {
//         return productRepository.searchByName(keyword);
//     }

//     public List<Product> getByCategory(Long categoryId) {
//         return productRepository.findByCategoryIdAndActiveTrue(categoryId);
//     }

//     @Transactional
//     public Product addProduct(String name, String description, BigDecimal price,
//                               Integer stock, Long categoryId) {
//         if (price.compareTo(BigDecimal.ZERO) <= 0) {
//             throw new BusinessException("Price must be greater than zero");
//         }
//         if (stock < 0) {
//             throw new BusinessException("Stock cannot be negative");
//         }

//         Category category = null;
//         if (categoryId != null) {
//             category = categoryRepository.findById(categoryId)
//                     .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
//         }

//         Product product = Product.builder()
//                 .name(name)
//                 .description(description)
//                 .price(price)
//                 .stockQuantity(stock)
//                 .category(category)
//                 .active(true)
//                 .build();

//         return productRepository.save(product);
//     }

//     @Transactional
//     public Product updateStock(Long productId, int quantityChange) {
//         Product product = getProductById(productId);
//         int newStock = product.getStockQuantity() + quantityChange;
//         if (newStock < 0) {
//             throw new BusinessException("Insufficient stock for product: " + product.getName());
//         }
//         product.setStockQuantity(newStock);
//         return productRepository.save(product);
//     }

//     @Transactional
//     public Category createCategory(String name, String description) {
//         Category category = Category.builder()
//                 .name(name)
//                 .description(description)
//                 .build();
//         return categoryRepository.save(category);
//     }

//     public List<Category> getAllCategories() {
//         return categoryRepository.findAll();
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/service/CartService.java
// ================================================================================

// package com.onlinestore.service;

// import com.onlinestore.entity.*;
// import com.onlinestore.exception.BusinessException;
// import com.onlinestore.exception.ResourceNotFoundException;
// import com.onlinestore.repository.CartRepository;
// import com.onlinestore.repository.ProductRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.math.BigDecimal;
// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class CartService {

//     private final CartRepository cartRepository;
//     private final ProductRepository productRepository;
//     private final UserService userService;

//     // Get or create cart for a user
//     @Transactional
//     public Cart getOrCreateCart(Long userId) {
//         User user = userService.findById(userId);
//         Optional<Cart> existing = cartRepository.findByUser(user);
//         if (existing.isPresent()) {
//             return existing.get();
//         }

//         Cart cart = Cart.builder()
//                 .user(user)
//                 .build();
//         return cartRepository.save(cart);
//     }

//     public Cart getCart(Long userId) {
//         return cartRepository.findByUserId(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id: " + userId));
//     }

//     @Transactional
//     public Cart addToCart(Long userId, Long productId, int quantity) {
//         if (quantity <= 0) {
//             throw new BusinessException("Quantity must be at least 1");
//         }

//         Cart cart = getOrCreateCart(userId);
//         Product product = productRepository.findById(productId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

//         if (!product.isActive()) {
//             throw new BusinessException("Product is not available: " + product.getName());
//         }
//         if (product.getStockQuantity() < quantity) {
//             throw new BusinessException("Only " + product.getStockQuantity() + " units available for " + product.getName());
//         }

//         // Check if product already in cart → update quantity
//         Optional<CartItem> existingItem = cart.getItems().stream()
//                 .filter(item -> item.getProduct().getId().equals(productId))
//                 .findFirst();

//         if (existingItem.isPresent()) {
//             CartItem item = existingItem.get();
//             int newQty = item.getQuantity() + quantity;
//             if (product.getStockQuantity() < newQty) {
//                 throw new BusinessException("Not enough stock. Available: " + product.getStockQuantity());
//             }
//             item.setQuantity(newQty);
//         } else {
//             CartItem newItem = CartItem.builder()
//                     .product(product)
//                     .quantity(quantity)
//                     .build();
//             cart.addItem(newItem);
//         }

//         return cartRepository.save(cart);
//     }

//     @Transactional
//     public Cart updateItemQuantity(Long userId, Long productId, int newQuantity) {
//         if (newQuantity <= 0) {
//             return removeFromCart(userId, productId);
//         }

//         Cart cart = getCart(userId);
//         CartItem item = findCartItem(cart, productId);

//         Product product = item.getProduct();
//         if (product.getStockQuantity() < newQuantity) {
//             throw new BusinessException("Only " + product.getStockQuantity() + " units available");
//         }

//         item.setQuantity(newQuantity);
//         return cartRepository.save(cart);
//     }

//     @Transactional
//     public Cart removeFromCart(Long userId, Long productId) {
//         Cart cart = getCart(userId);
//         CartItem item = findCartItem(cart, productId);
//         cart.removeItem(item);
//         return cartRepository.save(cart);
//     }

//     @Transactional
//     public Cart clearCart(Long userId) {
//         Cart cart = getCart(userId);
//         cart.clearItems();
//         return cartRepository.save(cart);
//     }

//     public BigDecimal calculateTotal(Cart cart) {
//         return cart.getItems().stream()
//                 .map(CartItem::getLineTotal)
//                 .reduce(BigDecimal.ZERO, BigDecimal::add);
//     }

//     private CartItem findCartItem(Cart cart, Long productId) {
//         return cart.getItems().stream()
//                 .filter(item -> item.getProduct().getId().equals(productId))
//                 .findFirst()
//                 .orElseThrow(() -> new ResourceNotFoundException("Product not found in cart"));
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/service/OrderService.java
// ================================================================================

// package com.onlinestore.service;

// import com.onlinestore.entity.*;
// import com.onlinestore.exception.BusinessException;
// import com.onlinestore.exception.ResourceNotFoundException;
// import com.onlinestore.repository.OrderRepository;
// import com.onlinestore.repository.ProductRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.concurrent.atomic.AtomicInteger;

// @Service
// @RequiredArgsConstructor
// public class OrderService {

//     private final OrderRepository orderRepository;
//     private final ProductRepository productRepository;
//     private final CartService cartService;
//     private final UserService userService;

//     // Simple sequence for order numbers (in real apps use DB sequence or UUID)
//     private static final AtomicInteger orderCounter = new AtomicInteger(1000);

//     @Transactional
//     public Order placeOrder(Long userId) {
//         Cart cart = cartService.getCart(userId);

//         if (cart.getItems() == null || cart.getItems().isEmpty()) {
//             throw new BusinessException("Cannot place order. Cart is empty.");
//         }

//         User user = userService.findById(userId);

//         // Validate stock for every item before creating order
//         for (CartItem cartItem : cart.getItems()) {
//             Product product = cartItem.getProduct();
//             if (product.getStockQuantity() < cartItem.getQuantity()) {
//                 throw new BusinessException("Insufficient stock for: " + product.getName()
//                         + ". Available: " + product.getStockQuantity());
//             }
//         }

//         // Create order
//         String orderNumber = generateOrderNumber();
//         Order order = Order.builder()
//                 .orderNumber(orderNumber)
//                 .user(user)
//                 .status(OrderStatus.PLACED)
//                 .totalAmount(BigDecimal.ZERO)
//                 .build();

//         BigDecimal total = BigDecimal.ZERO;

//         // Convert cart items → order items + deduct stock
//         for (CartItem cartItem : cart.getItems()) {
//             Product product = cartItem.getProduct();

//             // Deduct stock
//             product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
//             productRepository.save(product);

//             OrderItem orderItem = OrderItem.builder()
//                     .product(product)
//                     .quantity(cartItem.getQuantity())
//                     .unitPrice(product.getPrice())   // snapshot of price
//                     .build();

//             order.addItem(orderItem);
//             total = total.add(orderItem.getLineTotal());
//         }

//         order.setTotalAmount(total);
//         Order savedOrder = orderRepository.save(order);

//         // Clear the cart after successful order
//         cartService.clearCart(userId);

//         return savedOrder;
//     }

//     public Order getOrderById(Long orderId) {
//         return orderRepository.findById(orderId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
//     }

//     public Order getOrderByNumber(String orderNumber) {
//         return orderRepository.findByOrderNumber(orderNumber)
//                 .orElseThrow(() -> new ResourceNotFoundException("Order not found: " + orderNumber));
//     }

//     public List<Order> getOrdersByUser(Long userId) {
//         return orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
//     }

//     public List<Order> getOrdersByStatus(OrderStatus status) {
//         return orderRepository.findByStatus(status);
//     }

//     @Transactional
//     public Order updateStatus(Long orderId, OrderStatus newStatus) {
//         Order order = getOrderById(orderId);
//         OrderStatus current = order.getStatus();

//         // Simple state transition rules
//         if (current == OrderStatus.CANCELLED || current == OrderStatus.DELIVERED) {
//             throw new BusinessException("Cannot change status of a " + current + " order");
//         }

//         if (newStatus == OrderStatus.CANCELLED) {
//             restoreStock(order);
//         }

//         order.setStatus(newStatus);
//         return orderRepository.save(order);
//     }

//     @Transactional
//     public Order cancelOrder(Long orderId) {
//         return updateStatus(orderId, OrderStatus.CANCELLED);
//     }

//     private void restoreStock(Order order) {
//         for (OrderItem item : order.getItems()) {
//             Product product = item.getProduct();
//             product.setStockQuantity(product.getStockQuantity() + item.getQuantity());
//             productRepository.save(product);
//         }
//     }

//     private String generateOrderNumber() {
//         String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//         int seq = orderCounter.getAndIncrement();
//         return "ORD-" + timestamp + "-" + seq;
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/controller/UserController.java
// ================================================================================

// package com.onlinestore.controller;

// import com.onlinestore.entity.User;
// import com.onlinestore.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/users")
// @RequiredArgsConstructor
// public class UserController {

//     private final UserService userService;

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody Map<String, String> body) {
//         User user = userService.register(
//                 body.get("username"),
//                 body.get("email"),
//                 body.get("password")
//         );
//         // Don't return password in real apps
//         user.setPassword(null);
//         return ResponseEntity.status(HttpStatus.CREATED).body(user);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<User> login(@RequestBody Map<String, String> body) {
//         User user = userService.login(body.get("username"), body.get("password"));
//         user.setPassword(null);
//         return ResponseEntity.ok(user);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUser(@PathVariable Long id) {
//         User user = userService.findById(id);
//         user.setPassword(null);
//         return ResponseEntity.ok(user);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/controller/ProductController.java
// ================================================================================

// package com.onlinestore.controller;

// import com.onlinestore.entity.Category;
// import com.onlinestore.entity.Product;
// import com.onlinestore.service.ProductService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.math.BigDecimal;
// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/products")
// @RequiredArgsConstructor
// public class ProductController {

//     private final ProductService productService;

//     @GetMapping
//     public ResponseEntity<List<Product>> getAllProducts() {
//         return ResponseEntity.ok(productService.getAllActiveProducts());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Product> getProduct(@PathVariable Long id) {
//         return ResponseEntity.ok(productService.getProductById(id));
//     }

//     @GetMapping("/search")
//     public ResponseEntity<List<Product>> search(@RequestParam String keyword) {
//         return ResponseEntity.ok(productService.searchProducts(keyword));
//     }

//     @GetMapping("/category/{categoryId}")
//     public ResponseEntity<List<Product>> byCategory(@PathVariable Long categoryId) {
//         return ResponseEntity.ok(productService.getByCategory(categoryId));
//     }

//     @PostMapping
//     public ResponseEntity<Product> addProduct(@RequestBody Map<String, Object> body) {
//         Product product = productService.addProduct(
//                 (String) body.get("name"),
//                 (String) body.get("description"),
//                 new BigDecimal(body.get("price").toString()),
//                 Integer.parseInt(body.get("stock").toString()),
//                 body.get("categoryId") != null ? Long.parseLong(body.get("categoryId").toString()) : null
//         );
//         return ResponseEntity.status(HttpStatus.CREATED).body(product);
//     }

//     // Category endpoints under products for simplicity
//     @PostMapping("/categories")
//     public ResponseEntity<Category> createCategory(@RequestBody Map<String, String> body) {
//         Category category = productService.createCategory(body.get("name"), body.get("description"));
//         return ResponseEntity.status(HttpStatus.CREATED).body(category);
//     }

//     @GetMapping("/categories")
//     public ResponseEntity<List<Category>> getCategories() {
//         return ResponseEntity.ok(productService.getAllCategories());
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/controller/CartController.java
// ================================================================================

// package com.onlinestore.controller;

// import com.onlinestore.entity.Cart;
// import com.onlinestore.service.CartService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.math.BigDecimal;
// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/cart")
// @RequiredArgsConstructor
// public class CartController {

//     private final CartService cartService;

//     @GetMapping("/{userId}")
//     public ResponseEntity<Map<String, Object>> viewCart(@PathVariable Long userId) {
//         Cart cart = cartService.getOrCreateCart(userId);
//         BigDecimal total = cartService.calculateTotal(cart);

//         Map<String, Object> response = new HashMap<>();
//         response.put("cartId", cart.getId());
//         response.put("userId", userId);
//         response.put("items", cart.getItems());
//         response.put("totalAmount", total);
//         response.put("itemCount", cart.getItems().size());
//         return ResponseEntity.ok(response);
//     }

//     @PostMapping("/{userId}/add")
//     public ResponseEntity<Cart> addToCart(
//             @PathVariable Long userId,
//             @RequestParam Long productId,
//             @RequestParam(defaultValue = "1") int quantity) {
//         Cart cart = cartService.addToCart(userId, productId, quantity);
//         return ResponseEntity.ok(cart);
//     }

//     @PutMapping("/{userId}/update")
//     public ResponseEntity<Cart> updateQuantity(
//             @PathVariable Long userId,
//             @RequestParam Long productId,
//             @RequestParam int quantity) {
//         Cart cart = cartService.updateItemQuantity(userId, productId, quantity);
//         return ResponseEntity.ok(cart);
//     }

//     @DeleteMapping("/{userId}/remove")
//     public ResponseEntity<Cart> removeItem(
//             @PathVariable Long userId,
//             @RequestParam Long productId) {
//         Cart cart = cartService.removeFromCart(userId, productId);
//         return ResponseEntity.ok(cart);
//     }

//     @DeleteMapping("/{userId}/clear")
//     public ResponseEntity<String> clearCart(@PathVariable Long userId) {
//         cartService.clearCart(userId);
//         return ResponseEntity.ok("Cart cleared successfully");
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/controller/OrderController.java
// ================================================================================

// package com.onlinestore.controller;

// import com.onlinestore.entity.Order;
// import com.onlinestore.entity.OrderStatus;
// import com.onlinestore.service.OrderService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/orders")
// @RequiredArgsConstructor
// public class OrderController {

//     private final OrderService orderService;

//     // Place order from cart
//     @PostMapping("/place/{userId}")
//     public ResponseEntity<Order> placeOrder(@PathVariable Long userId) {
//         Order order = orderService.placeOrder(userId);
//         return ResponseEntity.status(HttpStatus.CREATED).body(order);
//     }

//     @GetMapping("/{orderId}")
//     public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
//         return ResponseEntity.ok(orderService.getOrderById(orderId));
//     }

//     @GetMapping("/number/{orderNumber}")
//     public ResponseEntity<Order> getByOrderNumber(@PathVariable String orderNumber) {
//         return ResponseEntity.ok(orderService.getOrderByNumber(orderNumber));
//     }

//     @GetMapping("/user/{userId}")
//     public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
//         return ResponseEntity.ok(orderService.getOrdersByUser(userId));
//     }

//     @GetMapping("/status/{status}")
//     public ResponseEntity<List<Order>> getByStatus(@PathVariable OrderStatus status) {
//         return ResponseEntity.ok(orderService.getOrdersByStatus(status));
//     }

//     @PutMapping("/{orderId}/status")
//     public ResponseEntity<Order> updateStatus(
//             @PathVariable Long orderId,
//             @RequestBody Map<String, String> body) {
//         OrderStatus newStatus = OrderStatus.valueOf(body.get("status").toUpperCase());
//         Order order = orderService.updateStatus(orderId, newStatus);
//         return ResponseEntity.ok(order);
//     }

//     @PutMapping("/{orderId}/cancel")
//     public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
//         Order order = orderService.cancelOrder(orderId);
//         return ResponseEntity.ok(order);
//     }
// }


// ================================================================================
// FILE: src/main/java/com/onlinestore/config/DataInitializer.java
// ================================================================================

// package com.onlinestore.config;

// import com.onlinestore.entity.Category;
// import com.onlinestore.entity.Product;
// import com.onlinestore.entity.User;
// import com.onlinestore.repository.CategoryRepository;
// import com.onlinestore.repository.ProductRepository;
// import com.onlinestore.repository.UserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import java.math.BigDecimal;

// @Component
// @RequiredArgsConstructor
// public class DataInitializer implements CommandLineRunner {

//     private final UserRepository userRepository;
//     private final CategoryRepository categoryRepository;
//     private final ProductRepository productRepository;

//     @Override
//     public void run(String... args) {
//         // Only load if DB is empty
//         if (userRepository.count() > 0) {
//             return;
//         }

//         System.out.println("Loading sample data...");

//         // Users
//         User customer = User.builder()
//                 .username("john")
//                 .email("john@example.com")
//                 .password("pass123")
//                 .role("CUSTOMER")
//                 .build();
//         userRepository.save(customer);

//         User admin = User.builder()
//                 .username("admin")
//                 .email("admin@example.com")
//                 .password("admin123")
//                 .role("ADMIN")
//                 .build();
//         userRepository.save(admin);

//         // Categories
//         Category electronics = categoryRepository.save(
//                 Category.builder().name("Electronics").description("Gadgets and devices").build());
//         Category clothing = categoryRepository.save(
//                 Category.builder().name("Clothing").description("Apparel and fashion").build());
//         Category books = categoryRepository.save(
//                 Category.builder().name("Books").description("Books and stationery").build());

//         // Products
//         productRepository.save(Product.builder()
//                 .name("Wireless Mouse")
//                 .description("Ergonomic wireless mouse with USB receiver")
//                 .price(new BigDecimal("29.99"))
//                 .stockQuantity(50)
//                 .category(electronics)
//                 .active(true)
//                 .build());

//         productRepository.save(Product.builder()
//                 .name("Mechanical Keyboard")
//                 .description("RGB backlit mechanical keyboard")
//                 .price(new BigDecimal("89.99"))
//                 .stockQuantity(30)
//                 .category(electronics)
//                 .active(true)
//                 .build());

//         productRepository.save(Product.builder()
//                 .name("Cotton T-Shirt")
//                 .description("Comfortable 100% cotton t-shirt")
//                 .price(new BigDecimal("19.99"))
//                 .stockQuantity(100)
//                 .category(clothing)
//                 .active(true)
//                 .build());

//         productRepository.save(Product.builder()
//                 .name("Java Programming Book")
//                 .description("Complete guide to Java for intermediate developers")
//                 .price(new BigDecimal("45.50"))
//                 .stockQuantity(25)
//                 .category(books)
//                 .active(true)
//                 .build());

//         productRepository.save(Product.builder()
//                 .name("USB-C Hub")
//                 .description("7-in-1 USB-C multiport adapter")
//                 .price(new BigDecimal("39.99"))
//                 .stockQuantity(40)
//                 .category(electronics)
//                 .active(true)
//                 .build());

//         System.out.println("Sample data loaded successfully!");
//         System.out.println("Test users → john / pass123  |  admin / admin123");
//     }
// }


// ================================================================================
// END OF SOURCE CODE
// ================================================================================

// QUICK START REMINDER
// --------------------
// 1. Create Maven project (Java 17)
// 2. Copy files into matching package structure
// 3. Run: mvn spring-boot:run
// 4. Open: http://localhost:8080

// Sample users:
//   john  / pass123   (CUSTOMER)
//   admin / admin123  (ADMIN)

// Typical flow:
//   GET  /api/products
//   POST /api/cart/1/add?productId=1&quantity=2
//   GET  /api/cart/1
//   POST /api/orders/place/1
//   GET  /api/orders/user/1
