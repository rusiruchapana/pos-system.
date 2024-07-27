package com.rusiruchapana.pos.system.service.impl;

import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;
import com.rusiruchapana.pos.system.entity.Customer;
import com.rusiruchapana.pos.system.repository.CustomerRepo;
import com.rusiruchapana.pos.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setName(customerRequestDTO.getName());
        customer.setAdress(customerRequestDTO.getAdress());
        customer.setSalary(customerRequestDTO.getSalary());
        customer.setContactNumbers(customerRequestDTO.getContactNumbers());
        customer.setNic(customerRequestDTO.getNic());
        customer.setActiveStatus(customerRequestDTO.getActiveStatus());

        customerRepo.save(customer);

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setAdress(customer.getAdress());
        customerResponseDTO.setSalary(customer.getSalary());
        customerResponseDTO.setContactNumbers(customer.getContactNumbers());
        customerResponseDTO.setNic(customer.getNic());
        customerResponseDTO.setActiveStatus(customer.getActiveStatus());

        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        
        return null;
    }
}
