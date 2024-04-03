package ma.emsi.schoolapp;

import ma.emsi.schoolapp.Repository.ProductRepository;
import ma.emsi.schoolapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SchoolAppApplication implements CommandLineRunner {
    @Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(SchoolAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smartphone",3200,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("***************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("***********");
        System.out.println("----------------");

        List<Product> productList = productRepository.findByNameContains("C" );
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("---------");
        List<Product> productList1 =productRepository.search("%C%");
        productList1.forEach((p->{
            System.out.println(p);
        }));
        System.out.println("--------------");
        List<Product> productList2 =productRepository.findByPriceGreaterThan(3000);
        productList2.forEach((p->{
            System.out.println(p);
        }));
    }

}
