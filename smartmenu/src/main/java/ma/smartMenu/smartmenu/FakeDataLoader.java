package ma.smartMenu.smartmenu;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import ma.smartMenu.smartmenu.enums.OrderState;
import ma.smartMenu.smartmenu.enums.OrderType;
import ma.smartMenu.smartmenu.model.*;
import ma.smartMenu.smartmenu.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class FakeDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductCategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final IngredientRepository ingredientRepository;
    private final OrderRepository orderRepository;

    private final Faker faker = new Faker();

    @Override
    public void run(String... args) {
        // Create Users
        List<User> users = createUsers(10);

        // Create Sellers
        List<Seller> sellers = createSellers(users);

        // Create Categories
        List<ProductCategory> categories = createCategories(5);

        // Create Ingredients
        List<Ingredient> ingredients = createIngredients(10);

        // Create Products
        List<Product> products = createProducts(categories, sellers, ingredients);

        // Create Orders
        createOrders(users, products);

        System.out.println("Fake data loaded successfully!");
    }

    private List<User> createUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress(),
                    faker.address().streetAddress(),
                    UUID.randomUUID().toString(),
                    faker.internet().password(),
                    faker.options().option("Male", "Female"),
                    faker.date().birthday()
            );
            users.add(userRepository.save(user));
        }
        return users;
    }

    private List<Seller> createSellers(List<User> users) {
        List<Seller> sellers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Seller seller = Seller.builder()
                    .sellerName(faker.company().name())
                    .lat(faker.address().latitude())
                    .lang(faker.address().longitude())
                    .user(users.get(faker.random().nextInt(users.size())))
                    .build();
            sellers.add(sellerRepository.save(seller));
        }
        return sellers;
    }

    private List<ProductCategory> createCategories(int count) {
        List<ProductCategory> categories = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ProductCategory category = ProductCategory.builder()
                    .name(faker.commerce().department())
                    .icon(faker.internet().avatar())
                    .description(faker.lorem().sentence())
                    .ref(UUID.randomUUID())
                    .build();
            categories.add(categoryRepository.save(category));
        }
        return categories;
    }

    private List<Ingredient> createIngredients(int count) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ingredient ingredient = Ingredient.builder()
                    .name(faker.food().ingredient())
                    .description(faker.lorem().sentence())
                    .icon(faker.internet().avatar())
                    .build();
            ingredients.add(ingredientRepository.save(ingredient));
        }
        return ingredients;
    }

    private List<Product> createProducts(List<ProductCategory> categories, List<Seller> sellers, List<Ingredient> ingredients) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Product product = Product.builder()
                    .name(faker.commerce().productName())
                    .description(faker.lorem().sentence())
                    .sku(faker.number().digits(10))
                    .ref(UUID.randomUUID())
                    .price(Float.parseFloat(faker.commerce().price()))
                    .state(faker.bool().bool())
                    .category(categories.get(faker.random().nextInt(categories.size())))
                    .seller(sellers.get(faker.random().nextInt(sellers.size())))
                    .ingredients(new HashSet<>(ingredients.subList(0, faker.random().nextInt(ingredients.size()))))
                    .build();
            products.add(productRepository.save(product));
        }
        return products;
    }

    private void createOrders(List<User> users, List<Product> products) {
        for (int i = 0; i < 10; i++) {
            Order order = Order.builder()
                    .uuid(UUID.randomUUID())
                    .user(users.get(faker.random().nextInt(users.size())))
                    .proceedBy(users.get(faker.random().nextInt(users.size())))
                    .totalAmount(faker.number().randomDouble(2, 50, 500))
                    .orderType(faker.options().option(OrderType.IN_STORE, OrderType.IN_STORE))
                    .orderState(faker.options().option(OrderState.CREATED, OrderState.CREATED, OrderState.CREATED))
                    .products(new HashSet<>(products.subList(0, faker.random().nextInt(products.size()))))
                    .build();
            orderRepository.save(order);
        }
    }
}