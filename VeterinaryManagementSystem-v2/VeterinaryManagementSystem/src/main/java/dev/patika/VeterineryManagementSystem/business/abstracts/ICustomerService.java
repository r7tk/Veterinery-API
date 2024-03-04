package dev.patika.VeterineryManagementSystem.business.abstracts;

import dev.patika.VeterineryManagementSystem.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer getById(Long id);

    void delete(Long id);

    List<Customer> findAll();

    Page<Customer> cursor(int page, int pageSize);

    public List<Customer> getFilteredCustomerByName(String name);


}
