package dev.patika.VeterineryManagementSystem.api;

import dev.patika.VeterineryManagementSystem.business.abstracts.ICustomerService;
import dev.patika.VeterineryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.VeterineryManagementSystem.core.result.ResultData;
import dev.patika.VeterineryManagementSystem.core.utilies.ResultHelper;
import dev.patika.VeterineryManagementSystem.dto.response.CursorResponse;
import dev.patika.VeterineryManagementSystem.dto.response.customer.CustomerResponse;
import dev.patika.VeterineryManagementSystem.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Hayvan sahiplerini kaydetme, bilgilerini güncelleme, görüntüleme ve silme
@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;
    private final IModelMapperService modelmapper;



    // Değerlendirme formu 10
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Customer update (@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.customerService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable("id") Long id) {
        return this.customerService.getById(id);

    }


    // Değerlendirme formu 17
    @GetMapping("/getFilteredCustomerByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getFilteredCustomerByName(@PathVariable("name") String name) {
        return this.customerService.getFilteredCustomerByName(name);
    }

    @GetMapping("/getAllCursor")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CustomerResponse>> cursor(
            @RequestParam(name = "page", required = false , defaultValue = "0")int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize
    ){
        Page<Customer> customerPage = this.customerService.cursor(page,pageSize);
        Page<CustomerResponse> customerResponsePage = customerPage
                .map(customer -> this.modelmapper.forRequest().map(customer, CustomerResponse.class));
        return ResultHelper.cursor(customerResponsePage);
    }
}

