package com.example.crmpointprojectv1.services;

import com.example.crmpointprojectv1.model.Customer;
import com.example.crmpointprojectv1.repository.CustomerRepository;
import com.example.crmpointprojectv1.specifications.CustomerDatatableFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Page<Customer> getCustomersForDatatable(String queryString, Pageable pageable) {

        CustomerDatatableFilter customerDatatableFilter = new CustomerDatatableFilter();

        return customerRepository.findAll(customerDatatableFilter, pageable);
    }
}
