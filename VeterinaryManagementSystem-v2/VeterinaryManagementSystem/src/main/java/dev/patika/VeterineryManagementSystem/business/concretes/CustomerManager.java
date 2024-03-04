package dev.patika.VeterineryManagementSystem.business.concretes;

import dev.patika.VeterineryManagementSystem.dao.ICustomerRepo;
import dev.patika.VeterineryManagementSystem.entities.Customer;
import dev.patika.VeterineryManagementSystem.business.abstracts.ICustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {
    private final ICustomerRepo customerRepo;
    private final EntityManager entityManager;

    public CustomerManager(ICustomerRepo customerRepo, EntityManager entityManager) {
        this.customerRepo = customerRepo;
        this.entityManager = entityManager;
    }

    @Override
    public Customer save(Customer customer) {
        List<Customer> customers = customerRepo.checkCustomerInfo(customer.getMail(), customer.getPhone());
        if (customers.size() > 0) {
            throw new RuntimeException("Bu bilgilere sahip müşteri daha önce eklendi.");
        } else {
            return this.customerRepo.save(customer);
        }
    }

    @Override
    public Customer update(Customer customer) {
        getById(customer.getId());
        return this.customerRepo.save(customer);


    }

    @Override
    public Customer getById(Long id) {
        Customer customer = this.customerRepo.findById(id).orElse(null);
        if (customer == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return customer;
        }
    }

    @Override
    public void delete(Long id) {
       getById(id);
       this.customerRepo.deleteById(id);

    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page ,pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override  // kontrol edildi düzeltildi.
    public List<Customer> getFilteredCustomerByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT c FROM Customer c WHERE c.name ILIKE :customer_name";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customer_name", "%" + name + "%");

        return query.getResultList();
    }
}
