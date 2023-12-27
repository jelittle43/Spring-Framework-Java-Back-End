package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long customerCount = customerRepository.count();
        if (customerCount <6) {
            Customer noah = new Customer("Noah", "Kaye", "12659 Izzy Mule Lane", "37932", "865-291-8960", 17L);
            customerRepository.save(noah);

            Customer julia = new Customer("Julia", "Little", "12659 Izzy Mule Lane", "37932", "865-291-8972", 17L);
            customerRepository.save(julia);

            Customer scott = new Customer("Scott", "Little", "661 Ponder Lane", "37311", "865-555-8972", 17L);
            customerRepository.save(scott);

            Customer leslie = new Customer("Leslie", "Matthews", "566 Crazy Lane", "37311", "865-555-7264", 17L);
            customerRepository.save(leslie);

            Customer maria = new Customer("Maria", "Owen", "987 Little Lane", "37311", "865-222-3749", 17L);
            customerRepository.save(maria);
        }
    }
}
